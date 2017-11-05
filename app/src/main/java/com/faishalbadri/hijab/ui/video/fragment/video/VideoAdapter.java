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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideo.VideoBean;
import com.faishalbadri.hijab.ui.detail_activity.video.DetailVideoActivity;
import com.faishalbadri.hijab.ui.video.fragment.video.VideoAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailLoader.ErrorReason;
import com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.YouTubeThumbnailView.OnInitializedListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoAdapter extends Adapter<ViewHolder> {

  Context context;
  List<VideoBean> list_video;

  public VideoAdapter(FragmentActivity activity, ArrayList<VideoBean> resultItem) {
    this.context = activity;
    this.list_video = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_video_full, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);

    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final VideoBean listitem = list_video.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(500, 500);
    Glide.with(context)
        .load(Server.BASE_IMG_YT + listitem.getVideo() + Server.IMG_YT_FORMAT)
        .apply(options)
        .into(holder.thumbnailViewVideoItem);
//    final YouTubeThumbnailLoader.OnThumbnailLoadedListener onThumbnailLoadedListener = new OnThumbnailLoadedListener() {
//      @Override
//      public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
//        youTubeThumbnailView.setVisibility(View.VISIBLE);
//      }
//
//      @Override
//      public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView,
//          ErrorReason errorReason) {
//
//      }
//    };
//    holder.thumbnailViewVideoItem.initialize(Server.YT_CODE, new OnInitializedListener() {
//      @Override
//      public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
//        youTubeThumbnailLoader.setVideo(listitem.getVideo());
//        youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
//      }
//
//      @Override
//      public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
//        Toast.makeText(context, "Check your internet", Toast.LENGTH_SHORT).show();
//      }
//    });
    holder.txtTitleItemVideo.setText(listitem.getJudul_video());
    holder.txtDurationItemVideo.setText(listitem.getDuration());
    holder.thumbnailViewVideoItem.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) context, Server.YT_CODE, listitem.getVideo(), 3000, true, false);
        context.startActivity(intent);
      }
    });
  }

  @Override
  public int getItemCount() {
    return list_video.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.thumbnail_view_video_item)
    YouTubeThumbnailView thumbnailViewVideoItem;
    @BindView(R.id.txt_title_item_video)
    TextView txtTitleItemVideo;
    @BindView(R.id.txt_duration_item_video)
    TextView txtDurationItemVideo;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }



  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = ((Activity) context).obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }
}
