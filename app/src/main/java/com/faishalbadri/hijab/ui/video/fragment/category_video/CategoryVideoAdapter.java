package com.faishalbadri.hijab.ui.video.fragment.category_video;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCategory.CategoriesBean;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CategoryVideoAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.video_by_category.VideoByCategoryActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoAdapter extends Adapter<ViewHolder> {

  private Context context;
  private List<CategoriesBean> list_category_video;

  public CategoryVideoAdapter(FragmentActivity activity,
      ArrayList<CategoriesBean> resultItem) {
    this.context = activity;
    this.list_category_video = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_category_grid, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final CategoriesBean listitem = list_category_video.get(position);
    setImage(holder.imageviewItem,
        "categories_" + listitem.getCategory_name().toLowerCase().replace(" ",
            "_"));
    holder.textviewItem.setText(listitem.getCategory_name());
    holder.constrainItem.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), VideoByCategoryActivity.class);
      i.putExtra("category_id", listitem.getCategory_id());
      i.putExtra("category_title", listitem.getCategory_name());
      v.getContext().startActivity(i);
    });
  }

  private void setImage(ImageView imageView, String image) {
    int id = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
    try {
      imageView.setImageResource(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public int getItemCount() {
    return list_category_video.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_item)
    ImageView imageviewItem;
    @BindView(R.id.textview_item)
    TextView textviewItem;
    @BindView(R.id.constrain_item)
    ConstraintLayout constrainItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
