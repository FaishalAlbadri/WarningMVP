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
import com.faishalbadri.hijab.ui.detail_activity.video.DetailVideoActivity;
import com.faishalbadri.hijab.ui.video.fragment.video.VideoAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import com.google.android.youtube.player.YouTubeThumbnailView;
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
