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
import com.faishalbadri.hijab.data.PojoVideo;
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
  private List<PojoVideo.VideosBean> list;

  public VideoByCategoryAdapter(VideoByCategoryActivity perkatActivity,
      ArrayList<PojoVideo.VideosBean> resultItem) {
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
    final PojoVideo.VideosBean listitem = list.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_IMG_YT + listitem.getVideo_url() + Server.IMG_YT_FORMAT)
        .apply(options)
        .into(holder.imgListVideo);
    holder.txtJudulListVideo.setText(listitem.getVideo_title());
    holder.txtJudulListVideo.setMaxLines(3);
    holder.txtDurationVideo.setText(listitem.getVideo_duration().toString());
    holder.cardViewVideoItem.setClickable(true);
    holder.cardViewVideoItem.setOnClickListener(v -> {
      v.getContext().startActivity(new Intent(v.getContext(), DetailVideoActivity.class)
          .putExtra("videos_title", listitem.getVideo_title())
          .putExtra("videos_url", listitem.getVideo_url())
          .putExtra("videos_description", listitem.getVideo_description())
          .putExtra("videos_duration", listitem.getVideo_duration()));
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
