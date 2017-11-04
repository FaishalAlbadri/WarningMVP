package com.faishalbadri.hijab.ui.video.fragment.category_video;

import android.app.Activity;
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
import com.faishalbadri.hijab.data.PojoCategory.KategoriBean;
import com.faishalbadri.hijab.ui.video_by_category.VideoByCategoryActivity;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CategoryVideoAdapter.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoAdapter extends Adapter<ViewHolder> {

  Context context;
  List<KategoriBean> list_category_video;

  public CategoryVideoAdapter(FragmentActivity activity, ArrayList<KategoriBean> resultItem) {
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
    final KategoriBean listitem = list_category_video.get(position);
    holder.textviewTitleCategoryItem.setText(listitem.getKategori_nama());
    holder.cardViewCategoryItem.setForeground(getSelectedItemDrawable());
    holder.cardViewCategoryItem.setClickable(true);
    holder.cardViewCategoryItem.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), VideoByCategoryActivity.class);
      i.putExtra("id", listitem.getId_kategori());
      i.putExtra("kategori", listitem.getKategori_nama());
      v.getContext().startActivity(i);
      ((Activity)context).finish();
    });
  }

  @Override
  public int getItemCount() {
    return list_category_video.size();
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

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = ((Activity) context).obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }
}
