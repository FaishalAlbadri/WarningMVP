package com.faishalbadri.hijab.ui.search_ebook;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.ui.search_ebook.SearchEbookAdapter.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEbookAdapter extends Adapter<ViewHolder> {

  Context context;
  List<EbookBean> list_data;

  public SearchEbookAdapter(SearchEbookActivity searchEbookActivity,
      ArrayList<EbookBean> resultItem) {
    context = searchEbookActivity;
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
    final EbookBean listitem = list_data.get(position);
    holder.txtCategoryVideo.setText(listitem.getJudul_ebook());
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
