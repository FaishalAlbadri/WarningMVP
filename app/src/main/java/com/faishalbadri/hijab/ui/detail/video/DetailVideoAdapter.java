package com.faishalbadri.hijab.ui.detail.video;

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
import com.faishalbadri.hijab.ui.detail.video.DetailVideoAdapter.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.ArrayList;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoAdapter extends Adapter<ViewHolder> {

  private Context context;
  private ArrayList<PojoVideo.VideosBean> list_data;

  public DetailVideoAdapter(DetailVideoActivity detailVideoActivity,
      ArrayList<PojoVideo.VideosBean> resultItem) {
    context = detailVideoActivity;
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
    final PojoVideo.VideosBean listitem = list_data.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_IMG_YT + listitem.getVideo_url() + Server.IMG_YT_FORMAT)
        .apply(options)
        .into(holder.imageviewDetailVideoGrid);
    holder.txtTitleDetailVideoGrid.setText(listitem.getVideo_title());
    holder.imageviewDetailVideoGrid.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), DetailVideoActivity.class);
      i.putExtra("videos_title", listitem.getVideo_title());
      i.putExtra("videos_url", listitem.getVideo_url());
      i.putExtra("videos_description", listitem.getVideo_description());
      i.putExtra("videos_duration", listitem.getVideo_duration());
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
