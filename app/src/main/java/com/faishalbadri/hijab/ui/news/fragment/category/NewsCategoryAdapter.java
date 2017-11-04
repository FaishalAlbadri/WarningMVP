package com.faishalbadri.hijab.ui.news.fragment.category;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCategory;
import com.faishalbadri.hijab.data.PojoCategory.KategoriBean;
import com.faishalbadri.hijab.ui.news.fragment.category.NewsCategoryAdapter.ViewHolder;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsCategoryAdapter extends Adapter<ViewHolder> {

  Context context;
  List<KategoriBean> data;


  public NewsCategoryAdapter(Context context,
      List<KategoriBean> data) {
    this.context = context;
    this.data = data;
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

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final KategoriBean list_item = data.get(position);
    holder.textviewTitleCategoryItem.setText(list_item.getKategori_nama());
    holder.cardViewCategoryItem.setForeground(getSelectedItemDrawable());
    holder.cardViewCategoryItem.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(context, list_item.getId_kategori(), Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = ((Activity) context).obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

}
