package com.faishalbadri.hijab.ui.home.fragment.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
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
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.DataHomeFragment;
import com.faishalbadri.hijab.ui.ebook.activity.EbookActivity;
import com.faishalbadri.hijab.ui.event.activity.EventActivity;
import com.faishalbadri.hijab.ui.home.fragment.home.HomeFragmentAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.news.activity.NewsActivity;
import com.faishalbadri.hijab.ui.video.activity.VideoActivity;
import com.faishalbadri.hijab.ui.voting.VotingActivity;
import java.util.List;

/**
 * Created by faishal on 10/30/17.
 */

public class HomeFragmentAdapter extends Adapter<ViewHolder> {

  private Context context;
  private List<DataHomeFragment> dataList;
  private String event, ebook, news, voting, video, community;


  public HomeFragmentAdapter(Context context,
      List<DataHomeFragment> dataList) {
    this.context = context;
    this.dataList = dataList;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    final DataHomeFragment dataHomeFragment = dataList.get(position);

    news = context.getResources().getString(R.string.text_pinky_hijab_news);
    voting = context.getResources().getString(R.string.text_pinky_hijab_voting);
    video = context.getResources().getString(R.string.text_pinky_hijab_video);
    community = context.getResources().getString(R.string.text_pinky_hijab_community);
    event = context.getResources().getString(R.string.text_pinky_hijab_event);
    ebook = context.getResources().getString(R.string.text_pinky_hijab_ebook);

    holder.textviewTitleFragmentHome.setText(dataHomeFragment.getJudulDetail());

    Glide.with(context).load(dataHomeFragment.getGambar()).into(new SimpleTarget<Drawable>() {
      @Override
      public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
        holder.imageViewNewsFragmentHome.setImageDrawable(resource);
      }
    });

    holder.imageViewTitleFragmentHome.setImageResource(dataHomeFragment.getTitleImage());

    holder.cardviewNewsFragmentHome.setForeground(getSelectedItemDrawable());
    holder.cardviewNewsFragmentHome.setClickable(true);
    holder.cardviewNewsFragmentHome.setOnClickListener(v -> {
      if (dataHomeFragment.getJudul().equalsIgnoreCase(news)) {
        context.startActivity(new Intent(context, NewsActivity.class));
        ((Activity) context).finish();
      } else if (dataHomeFragment.getJudul().equalsIgnoreCase(voting)) {
        context.startActivity(new Intent(context, VotingActivity.class));
        ((Activity) context).finish();
      } else if (dataHomeFragment.getJudul().equalsIgnoreCase(video)) {
        context.startActivity(new Intent(context, VideoActivity.class));
        ((Activity) context).finish();
      } else if (dataHomeFragment.getJudul().equalsIgnoreCase(community)) {

      } else if (dataHomeFragment.getJudul().equalsIgnoreCase(event)) {
        context.startActivity(new Intent(context, EventActivity.class));
        ((Activity) context).finish();
      } else if (dataHomeFragment.getJudul().equalsIgnoreCase(ebook)) {
        context.startActivity(new Intent(context, EbookActivity.class));
        ((Activity) context).finish();
      }
    });

  }

  @Override
  public int getItemCount() {
    return dataList.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = context.obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cardview_news_fragment_home)
    CardView cardviewNewsFragmentHome;
    @BindView(R.id.constraint_item_home)
    ConstraintLayout constraintItemHome;
    @BindView(R.id.image_view_news_fragment_home)
    ImageView imageViewNewsFragmentHome;
    @BindView(R.id.image_view_title_fragment_home)
    ImageView imageViewTitleFragmentHome;
    @BindView(R.id.textview_title_fragment_home)
    TextView textviewTitleFragmentHome;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);

    }
  }

}
