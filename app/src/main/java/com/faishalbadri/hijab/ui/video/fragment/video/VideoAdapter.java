package com.faishalbadri.hijab.ui.video.fragment.video;

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
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideo.VideoBean;
import com.faishalbadri.hijab.ui.detail.video.DetailVideoActivity;
import com.faishalbadri.hijab.ui.video.fragment.video.VideoAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoAdapter extends Adapter<ViewHolder> {

  Context context;
  List<VideoBean> list_video;
  String video;

  public VideoAdapter(FragmentActivity activity, ArrayList<VideoBean> resultItem) {
    this.context = activity;
    this.list_video = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);

    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final VideoBean listitem = list_video.get(position);

    if (listitem.getVideo().startsWith("https://www.youtube.com/watch?v=") || listitem.getVideo()
        .startsWith("https://youtu.be/") || listitem.getVideo()
        .startsWith("www.youtube.com/watch?v=")) {

      if (listitem.getVideo().startsWith("https://www.youtube.com/watch?v=")) {
        video = listitem.getVideo().substring(32, listitem.getVideo().length());
      } else if (listitem.getVideo().startsWith("https://youtu.be/")) {
        video = listitem.getVideo().substring(17, listitem.getVideo().length());
      } else if (listitem.getVideo().startsWith("www.youtube.com/watch?v=")) {
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
    holder.cardViewVideoItem.setForeground(getSelectedItemDrawable());
    holder.txtDurationVideo.setText(listitem.getDuration().toString());
    holder.cardViewVideoItem.setClickable(true);
    holder.cardViewVideoItem.setOnClickListener(v -> {

      if (listitem.getVideo().startsWith("https://www.youtube.com/watch?v=")) {
        video = listitem.getVideo().substring(32, listitem.getVideo().length());
      } else if (listitem.getVideo().startsWith("https://youtu.be/")) {
        video = listitem.getVideo().substring(17, listitem.getVideo().length());
      } else if (listitem.getVideo().startsWith("www.youtube.com/watch?v=")) {
        video = listitem.getVideo().substring(24, listitem.getVideo().length());
      }

      context.startActivity(new Intent(context, DetailVideoActivity.class)
          .putExtra("title", listitem.getJudul_video())
          .putExtra("video", video)
          .putExtra("description", listitem.getDescription())
          .putExtra("duration", listitem.getDuration()));
      ((Activity) context)
          .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
    });
  }

  @Override
  public int getItemCount() {
    return list_video.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = context.obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
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
