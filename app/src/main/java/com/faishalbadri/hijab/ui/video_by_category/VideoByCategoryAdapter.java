package com.faishalbadri.hijab.ui.video_by_category;

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
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.ui.detail.video.DetailVideoActivity;
import com.faishalbadri.hijab.ui.video_by_category.VideoByCategoryAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoByCategoryAdapter extends Adapter<ViewHolder> {

  Context context;
  List<PojoVideo.VideoBean> list;
  String video;

  public VideoByCategoryAdapter(VideoByCategoryActivity perkatActivity, ArrayList<PojoVideo.VideoBean> resultItem) {
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
    final PojoVideo.VideoBean listitem = list.get(position);
    if (listitem.getVideo().startsWith("https://www.youtube.com/watch?v=") || listitem.getVideo()
        .startsWith("https://youtu.be/") || listitem.getVideo()
        .startsWith("www.youtube.com/watch?v=")) {

      if (listitem.getVideo().startsWith("https://www.youtube.com/watch?v=")) {
        video = listitem.getVideo().substring(32, listitem.getVideo().length());
      }

      if (listitem.getVideo().startsWith("https://youtu.be/")) {
        video = listitem.getVideo().substring(17, listitem.getVideo().length());
      }

      if (listitem.getVideo().startsWith("www.youtube.com/watch?v=")) {
        video = listitem.getVideo().substring(24, listitem.getVideo().length());
      }
    }
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_IMG_YT + video + Server.IMG_YT_FORMAT)
        .apply(options)
        .into(holder.imgListVideo);
    holder.txtJudulListVideo.setText(listitem.getJudul_video());
    holder.txtJudulListVideo.setMaxLines(3);
    holder.txtDurationVideo.setText(listitem.getDuration().toString());
    holder.cardViewVideoItem.setClickable(true);
    holder.cardViewVideoItem.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), DetailVideoActivity.class);
      i.putExtra("title", listitem.getJudul_video());
      i.putExtra("video", video);
      i.putExtra("description", listitem.getDescription());
      i.putExtra("duration", listitem.getDuration());
      v.getContext().startActivity(i);
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
      ButterKnife.bind(this,itemView);
    }
  }
}
