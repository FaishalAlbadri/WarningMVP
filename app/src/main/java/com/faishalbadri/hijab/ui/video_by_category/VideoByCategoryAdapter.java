package com.faishalbadri.hijab.ui.video_by_category;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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
import com.faishalbadri.hijab.data.videos.VideosItem;
import com.faishalbadri.hijab.ui.detail.video.DetailVideoActivity;
import com.faishalbadri.hijab.ui.video_by_category.VideoByCategoryAdapter.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoByCategoryAdapter extends Adapter<ViewHolder> {

  private Context context;
  private List<VideosItem> list;

  public VideoByCategoryAdapter(VideoByCategoryActivity perkatActivity,
      ArrayList<VideosItem> resultItem) {
    context = perkatActivity;
    list = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final VideosItem listitem = list.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_IMG_YT + listitem.getVideoUrl() + Server.IMG_YT_FORMAT)
        .apply(options)
        .into(holder.imgListVideo);
    holder.txtJudulListVideo.setText(listitem.getVideoTitle());
    holder.txtJudulListVideo.setMaxLines(3);
    holder.txtDurationVideo.setText(listitem.getVideoDuration().toString());
    holder.cardViewVideoItem.setClickable(true);
    holder.cardViewVideoItem.setOnClickListener(v -> {
      v.getContext().startActivity(new Intent(v.getContext(), DetailVideoActivity.class)
          .putExtra("videos_title", listitem.getVideoTitle())
          .putExtra("videos_url", listitem.getVideoUrl())
          .putExtra("videos_description", listitem.getVideoDescription())
          .putExtra("videos_duration", listitem.getVideoDuration()));
      ((Activity) context)
          .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
    });
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_list_video)
    ImageView imgListVideo;
    @BindView(R.id.txtJudulListVideo)
    TextView txtJudulListVideo;
    @BindView(R.id.txt_duration_video)
    TextView txtDurationVideo;
    @BindView(R.id.card_view_video_item)
    CardView cardViewVideoItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
