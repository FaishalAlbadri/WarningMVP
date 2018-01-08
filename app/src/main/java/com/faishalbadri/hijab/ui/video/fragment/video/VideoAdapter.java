package com.faishalbadri.hijab.ui.video.fragment.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.ui.detail.video.DetailVideoActivity;
import com.faishalbadri.hijab.util.Singleton.LoadingStatus;
import com.faishalbadri.hijab.util.server.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoAdapter extends Adapter<RecyclerView.ViewHolder> {

  private static final int ITEM = 0;
  private static final int LOADING = 1;
  Context context;
  List<PojoVideo.VideosBean> list_video;
  VideoFragment videoFragment;
  private String error;

  public VideoAdapter(VideoFragment videoFragment,FragmentActivity activity, ArrayList<PojoVideo.VideosBean> resultItem) {
    this.context = activity;
    this.list_video = resultItem;
    this.videoFragment = videoFragment;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder viewHolder = null;
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());

    switch (viewType) {
      case ITEM:
        viewHolder = getViewHolder(parent, inflater);
        break;
      case LOADING:
        View viewLoading = inflater.inflate(R.layout.item_loading, parent, false);
        viewHolder = new ViewHolderLoading(viewLoading);
        break;
    }
    return viewHolder;
  }

  @NonNull
  private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
    RecyclerView.ViewHolder viewHolder;
    View viewItem = inflater.inflate(R.layout.item_video, parent, false);
    viewHolder = new ViewHolder(viewItem);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    final PojoVideo.VideosBean listitem = list_video.get(position);

    switch (getItemViewType(position)) {
      case ITEM:
        ViewHolder viewHolderItem = (ViewHolder) holder;
        RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
            .override(200, 200);
        Glide.with(context)
            .load(Server.BASE_IMG_YT + listitem.getVideo_url() + Server.IMG_YT_FORMAT)
            .apply(options)
            .into(viewHolderItem.imgListVideo);
        viewHolderItem.txtJudulListVideo.setText(listitem.getVideo_title());
        viewHolderItem.txtJudulListVideo.setMaxLines(3);
        viewHolderItem.cardViewVideoItem.setForeground(getSelectedItemDrawable());
        viewHolderItem.txtDurationVideo.setText(listitem.getVideo_duration().toString());
        viewHolderItem.cardViewVideoItem.setClickable(true);
        viewHolderItem.cardViewVideoItem.setOnClickListener(v -> {
          context.startActivity(new Intent(context, DetailVideoActivity.class)
              .putExtra("videos_title", listitem.getVideo_title())
              .putExtra("videos_url", listitem.getVideo_url())
              .putExtra("videos_description", listitem.getVideo_description())
              .putExtra("videos_duration", listitem.getVideo_duration()));
          ((Activity) context)
              .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
        });
        break;
      case LOADING:
        VideoAdapter.ViewHolderLoading viewHolderLoading = (VideoAdapter.ViewHolderLoading) holder;
        error = LoadingStatus.getInstance().getStatus();
        if (error != null) {
          viewHolderLoading.buttonLoadData.setVisibility(View.GONE);
          viewHolderLoading.progressLoadData.setVisibility(View.GONE);
          viewHolderLoading.textviewThanksItemLoading.setVisibility(View.VISIBLE);
        } else {
          viewHolderLoading.buttonLoadData.setVisibility(View.VISIBLE);
          viewHolderLoading.progressLoadData.setVisibility(View.GONE);
        }
        viewHolderLoading.buttonLoadData.setOnClickListener(v -> {
          viewHolderLoading.buttonLoadData.setVisibility(View.GONE);
          viewHolderLoading.progressLoadData.setVisibility(View.VISIBLE);
          videoFragment.getDataVideo();
        });
        break;
    }
  }

  @Override
  public int getItemViewType(int position) {
    return (position == list_video.size() - 1) ? LOADING : ITEM;
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

  protected class ViewHolder extends RecyclerView.ViewHolder {

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
  protected class ViewHolderLoading extends RecyclerView.ViewHolder {

    @BindView(R.id.button_load_data)
    ImageButton buttonLoadData;
    @BindView(R.id.progress_load_data)
    ProgressBar progressLoadData;
    @BindView(R.id.constraint_item_loading)
    ConstraintLayout constraintItemLoading;
    @BindView(R.id.textview_thanks_item_loading)
    TextView textviewThanksItemLoading;

    public ViewHolderLoading(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
