package com.faishalbadri.hijab.ui.video.fragment.category_video;

import android.content.Context;
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
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CategoryVideoAdapter.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoAdapter extends Adapter<ViewHolder> {

  Context context;
  List<EbookBean> list_category_video;

  public CategoryVideoAdapter(FragmentActivity activity, ArrayList<EbookBean> resultItem) {
    this.context = activity;
    this.list_category_video = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.category_video_item, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final EbookBean listitem = list_category_video.get(position);
    holder.txtCategoryVideo.setText(listitem.getJudul_ebook());
    holder.constrantVideoCategoryItem.setOnClickListener(v -> {
//      Intent i = new Intent(v.getContext(), VideoActivity.class);
//      i.putExtra("id", listitem.getId_kategori());
//      i.putExtra("kategori", listitem.getKategori_nama());
    });
  }

  @Override
  public int getItemCount() {
    return list_category_video.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_category_video)
    TextView txtCategoryVideo;
    @BindView(R.id.constrant_video_category_item)
    ConstraintLayout constrantVideoCategoryItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this,itemView);
    }
  }
}
