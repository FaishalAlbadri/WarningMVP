package com.faishalbadri.hijab.ui.news.fragment.category;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
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
import com.faishalbadri.hijab.data.categories.CategoriesItem;
import com.faishalbadri.hijab.ui.news.fragment.category.NewsCategoryAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.news_by_category.NewsByCategoryActivity;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsCategoryAdapter extends Adapter<ViewHolder> {

  private Context context;
  private List<CategoriesItem> data;


  public NewsCategoryAdapter(Context context,
      List<CategoriesItem> data) {
    this.context = context;
    this.data = data;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_category_grid, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final CategoriesItem list_item = data.get(position);
    setImage(holder.imageviewItem,
        "categories_" + list_item.getCategoryName().toLowerCase().replace(" ", ""));
    holder.textviewItem.setText(list_item.getCategoryName());
    holder.constrainItem.setOnClickListener(v -> {
      context.startActivity(new Intent(context, NewsByCategoryActivity.class)
          .putExtra("category_id", list_item.getCategoryId())
          .putExtra("category_title", list_item.getCategoryName()));
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
    return data.size();
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
