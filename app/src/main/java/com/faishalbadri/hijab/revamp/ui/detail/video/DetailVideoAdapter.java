package com.faishalbadri.hijab.revamp.ui.detail.video;

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
import com.faishalbadri.hijab.data.PojoVideo.VideoBean;
import com.faishalbadri.hijab.revamp.ui.detail.video.DetailVideoAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import java.util.ArrayList;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoAdapter extends Adapter<ViewHolder> {

  Context context;
  ArrayList<VideoBean> list_data;
  String video;

  public DetailVideoAdapter(DetailVideoActivity detailVideoActivity,
      ArrayList<VideoBean> resultItem) {
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
    final VideoBean listitem = list_data.get(position);
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
        .into(holder.imageviewDetailVideoGrid);
    holder.txtTitleDetailVideoGrid.setText(listitem.getJudul_video());
    holder.imageviewDetailVideoGrid.setOnClickListener(v -> {

      if (listitem.getVideo().startsWith("https://www.youtube.com/watch?v=")) {
        video = listitem.getVideo().substring(32, listitem.getVideo().length());
      } else if (listitem.getVideo().startsWith("https://youtu.be/")) {
        video = listitem.getVideo().substring(17, listitem.getVideo().length());
      } else if (listitem.getVideo().startsWith("www.youtube.com/watch?v=")) {
        video = listitem.getVideo().substring(24, listitem.getVideo().length());
      }

      Intent i = new Intent(v.getContext(), DetailVideoActivity.class);
      i.putExtra("title", listitem.getJudul_video());
      i.putExtra("video", video);
      i.putExtra("description", listitem.getDescription());
      i.putExtra("duration", listitem.getDuration());
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
