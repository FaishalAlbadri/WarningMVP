package com.faishalbadri.hijab.ui.search_news;

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
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.ui.detail.news.DetailNewsActivity;
import com.faishalbadri.hijab.ui.search_news.SearchNewsAdapter.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsAdapter extends Adapter<ViewHolder> {

  Context context;
  List<NewsBean> list_data;


  public SearchNewsAdapter(SearchNewsActivity seaerchNewsActivity, ArrayList<NewsBean> resultItem) {
    context = seaerchNewsActivity;
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
    final NewsBean listitem = list_data.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_API + listitem.getNews_images())
        .apply(options)
        .into(holder.imageviewNewsItem);
    holder.textviewTitleNewsItem.setText(listitem.getNews_title());
    holder.cardviewNewsFragmentNews.setForeground(getSelectedItemDrawable());
    holder.cardviewNewsFragmentNews.setClickable(true);
    holder.cardviewNewsFragmentNews.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), DetailNewsActivity.class);
      i.putExtra("id_isi", listitem.getNews_id());
      i.putExtra("title", listitem.getNews_title());
      i.putExtra("image", listitem.getNews_images());
      i.putExtra("desc", listitem.getNews_description());
      v.getContext().startActivity(i);
    });
  }

  @Override
  public int getItemCount() {
    return list_data.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = context.obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
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
