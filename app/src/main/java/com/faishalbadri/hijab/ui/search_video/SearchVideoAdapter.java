package com.faishalbadri.hijab.ui.search_video;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.faishalbadri.hijab.ui.search_video.SearchVideoAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoAdapter extends Adapter<ViewHolder> {

  Context context;
  List<VideoBean> list_data;
  String video;

  public SearchVideoAdapter(SearchVideoActivity searchVideoActivity,
      ArrayList<VideoBean> resultItem) {
    context = searchVideoActivity;
    list_data = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
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
        .into(holder.imageviewNewsItem);
    holder.textviewTitleNewsItem.setText(listitem.getJudul_video());
    holder.cardviewNewsFragmentNews.setClickable(true);
    holder.cardviewNewsFragmentNews.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(v.getContext(), DetailVideoActivity.class);
        i.putExtra("title", listitem.getJudul_video());
        i.putExtra("video", video);
        i.putExtra("description", listitem.getDescription());
        i.putExtra("duration", listitem.getDuration());
        v.getContext().startActivity(i);
      }
    });
  }

  @Override
  public int getItemCount() {
    return list_data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_news_item)
    ImageView imageviewNewsItem;
    @BindView(R.id.textview_title_news_item)
    TextView textviewTitleNewsItem;
    @BindView(R.id.cardview_news_fragment_news)
    CardView cardviewNewsFragmentNews;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
