package com.faishalbadri.hijab.ui.home.fragment.home;

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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.DataHomeFragment;
import com.faishalbadri.hijab.ui.ebook.EbookActivity;
import com.faishalbadri.hijab.ui.home.fragment.home.HomeFragmentAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.news.activity.NewsActivity;
import com.faishalbadri.hijab.ui.voting.VotingActivity;
import java.util.List;

/**
 * Created by faishal on 10/30/17.
 */

public class HomeFragmentAdapter extends Adapter<ViewHolder> {

  Context context;
  List<DataHomeFragment> dataList;
  String event, ebook, news, voting, video, community;


  public HomeFragmentAdapter(Context context,
      List<DataHomeFragment> dataList) {
    this.context = context;
    this.dataList = dataList;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_fragment_home_adapter)
    ImageView imageviewFragmentHomeAdapter;
    @BindView(R.id.textview_title_fragment_home_adapter)
    TextView textviewTitleFragmentHomeAdapter;
    @BindView(R.id.textview_title_detail_fragment_home_adapter)
    TextView textviewTitleDetailFragmentHomeAdapter;
    @BindView(R.id.cardview_news_fragment_home)
    CardView cardviewNewsFragmentHome;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);

    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    final DataHomeFragment dataHomeFragment = dataList.get(position);

    news = ((Activity) context).getResources().getString(R.string.text_pinky_hijab_news);
    voting = ((Activity) context).getResources().getString(R.string.text_pinky_hijab_voting);
    video = ((Activity) context).getResources().getString(R.string.text_pinky_hijab_video);
    community = ((Activity) context).getResources().getString(R.string.text_pinky_hijab_community);
    event = ((Activity) context).getResources().getString(R.string.text_pinky_hijab_event);
    ebook = ((Activity) context).getResources().getString(R.string.text_pinky_hijab_ebook);


    holder.textviewTitleFragmentHomeAdapter.setText(dataHomeFragment.getJudul());
    holder.textviewTitleDetailFragmentHomeAdapter.setText(dataHomeFragment.getJudulDetail());
    Glide.with(context).load(dataHomeFragment.getGambar())
        .into(holder.imageviewFragmentHomeAdapter);
    holder.cardviewNewsFragmentHome.setForeground(getSelectedItemDrawable());
    holder.cardviewNewsFragmentHome.setClickable(true);
    holder.cardviewNewsFragmentHome.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (dataHomeFragment.getJudul().equalsIgnoreCase(news)) {
          ((Activity)context).startActivity(new Intent(context, NewsActivity.class));
          ((Activity)context).finish();
        } else if (dataHomeFragment.getJudul().equalsIgnoreCase(voting)) {
          ((Activity)context).startActivity(new Intent(context, VotingActivity.class));
          ((Activity)context).finish();
        } else if (dataHomeFragment.getJudul().equalsIgnoreCase(video)) {

        } else if (dataHomeFragment.getJudul().equalsIgnoreCase(community)) {

        } else if (dataHomeFragment.getJudul().equalsIgnoreCase(event)) {

        } else if (dataHomeFragment.getJudul().equalsIgnoreCase(ebook)) {
          ((Activity)context).startActivity(new Intent(context, EbookActivity.class));
          ((Activity)context).finish();
        }
      }
    });

  }

  @Override
  public int getItemCount() {
    return dataList.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = ((Activity) context).obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

}
