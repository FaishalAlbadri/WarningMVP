package com.faishalbadri.hijab.ui.search_video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import com.faishalbadri.hijab.data.PojoVideo.VideosBean;
import com.faishalbadri.hijab.ui.detail.video.DetailVideoActivity;
import com.faishalbadri.hijab.util.server.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 05/01/18.
 */

public class SearchVideoAdapter extends Adapter<SearchVideoAdapter.ViewHolder> {

  Context context;
  List<VideosBean> list_video;

  public SearchVideoAdapter(SearchVideoActivity searchVideoActivity,
      ArrayList<VideosBean> resultItem) {
    context = searchVideoActivity;
    list_video = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final PojoVideo.VideosBean listitem = list_video.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_IMG_YT + listitem.getVideo_url() + Server.IMG_YT_FORMAT)
        .apply(options)
        .into(holder.imgListVideo);
    holder.txtJudulListVideo.setText(listitem.getVideo_title());
    holder.txtJudulListVideo.setMaxLines(3);
    holder.cardViewVideoItem.setForeground(getSelectedItemDrawable());
    holder.txtDurationVideo.setText(listitem.getVideo_duration().toString());
    holder.cardViewVideoItem.setClickable(true);
    holder.cardViewVideoItem.setOnClickListener(v -> {
      context.startActivity(new Intent(context, DetailVideoActivity.class)
          .putExtra("title", listitem.getVideo_title())
          .putExtra("video", listitem.getVideo_url())
          .putExtra("description", listitem.getVideo_description())
          .putExtra("duration", listitem.getVideo_duration()));
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
