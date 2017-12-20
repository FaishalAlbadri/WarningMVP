package com.faishalbadri.hijab.revamp.ui.detail.news;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.revamp.ui.detail.news.DetailNewsAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import java.util.ArrayList;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsAdapter extends Adapter<ViewHolder> {

  Context context;
  ArrayList<IsiBean> list_data;

  public DetailNewsAdapter(DetailNewsActivity detailNewsActivity,
      ArrayList<IsiBean> resultItem) {
    context = detailNewsActivity;
    list_data = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context)
        .inflate(R.layout.item_grid_detail_video, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);

    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final IsiBean listitem = list_data.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_IMG + listitem.getIsi_gambar())
        .apply(options)
        .into(holder.imageviewDetailVideoGrid);
    holder.txtTitleDetailVideoGrid.setText(listitem.getIsi_judul());
    holder.imageviewDetailVideoGrid.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), DetailNewsActivity.class);
      i.putExtra("id_isi", listitem.getId_isi());
      i.putExtra("title", listitem.getIsi_judul());
      i.putExtra("image", listitem.getIsi_gambar());
      i.putExtra("desc", listitem.getIsi_keterangan());
      v.getContext().startActivity(i);
      ((Activity) context).finish();
    });
  }

  @Override
  public int getItemCount() {
    return list_data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_detail_video_grid)
    ImageView imageviewDetailVideoGrid;
    @BindView(R.id.txt_title_detail_video_grid)
    TextView txtTitleDetailVideoGrid;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
