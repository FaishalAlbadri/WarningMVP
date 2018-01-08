package com.faishalbadri.hijab.ui.news_by_category;

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
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.ui.detail.news.DetailNewsActivity;
import com.faishalbadri.hijab.ui.news_by_category.NewsByCategoryAdapter.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsByCategoryAdapter extends Adapter<ViewHolder> {

  Context context;
  List<NewsBean> data;


  public NewsByCategoryAdapter(Context context,
      List<NewsBean> data) {
    this.context = context;
    this.data = data;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final NewsBean listitem = data.get(position);
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
      v.getContext().startActivity(new Intent(v.getContext(), DetailNewsActivity.class)
          .putExtra("news_id", listitem.getNews_id())
          .putExtra("news_title", listitem.getNews_title())
          .putExtra("news_image", listitem.getNews_images())
          .putExtra("news_description", listitem.getNews_description()));
      ((Activity) context)
          .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
    });
  }

  @Override
  public int getItemCount() {
    return data.size();
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
