package com.faishalbadri.hijab.ui.ebook.fragment.category;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbookCategory.KategoriEbookBean;
import com.faishalbadri.hijab.ui.ebook.fragment.category.EbookCategoryAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.ebook_by_category.EbookByCategoryActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookCategoryAdapter extends Adapter<ViewHolder> {

  Context context;
  List<KategoriEbookBean> list_data;

  public EbookCategoryAdapter(FragmentActivity activity, ArrayList<KategoriEbookBean> resultItem) {
    context = activity;
    list_data = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_category_video, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final KategoriEbookBean listitem = list_data.get(position);
    holder.txtCategoryVideo.setText(listitem.getNama_kategori());
    holder.constrantVideoCategoryItem.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), EbookByCategoryActivity.class);
      i.putExtra("id_category_ebook", listitem.getId_kategori_ebook());
      i.putExtra("title", listitem.getNama_kategori());
      v.getContext().startActivity(i);
    });
  }

  @Override
  public int getItemCount() {
    return list_data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_category_video)
    TextView txtCategoryVideo;
    @BindView(R.id.constrant_video_category_item)
    ConstraintLayout constrantVideoCategoryItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
