package com.faishalbadri.hijab.ui.video.fragment.category_video;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.revamp.data.PojoCategory;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CategoryVideoAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.video_by_category.VideoByCategoryActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoAdapter extends Adapter<ViewHolder> {

  Context context;
  List<PojoCategory.CategoriesBean> list_category_video;

  public CategoryVideoAdapter(FragmentActivity activity,
      ArrayList<PojoCategory.CategoriesBean> resultItem) {
    this.context = activity;
    this.list_category_video = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final PojoCategory.CategoriesBean listitem = list_category_video.get(position);
    holder.textviewTitleCategoryItem.setText(listitem.getCategory_name());
    holder.cardViewCategoryItem.setForeground(getSelectedItemDrawable());
    holder.cardViewCategoryItem.setClickable(true);
    holder.cardViewCategoryItem.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), VideoByCategoryActivity.class);
      i.putExtra("id", listitem.getCategory_id());
      i.putExtra("kategori", listitem.getCategory_name());
      v.getContext().startActivity(i);
    });
  }

  @Override
  public int getItemCount() {
    return list_category_video.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = context.obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textview_title_category_item)
    TextView textviewTitleCategoryItem;
    @BindView(R.id.card_view_category_item)
    CardView cardViewCategoryItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
