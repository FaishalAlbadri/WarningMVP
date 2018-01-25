package com.faishalbadri.hijab.ui.news.fragment.news;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
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
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.ui.detail.news.DetailNewsActivity;
import com.faishalbadri.hijab.util.Singleton.LoadingStatus;
import com.faishalbadri.hijab.util.server.Server;
import java.util.List;

/**
 * Created by faishal on 04/01/18.
 */

public class NewsAdapter extends Adapter<ViewHolder> {

  private static final int ITEM = 0;
  private static final int LOADING = 1;
  private Context context;
  private List<NewsBean> data;
  private NewsFragment newsFragment;
  private String error;

  public NewsAdapter(Context context,
      List<NewsBean> data, NewsFragment newsFragment) {
    this.context = context;
    this.data = data;
    this.newsFragment = newsFragment;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewHolder viewHolder = null;
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
  private ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
    ViewHolder viewHolder;
    View viewItem = inflater.inflate(R.layout.item_news, parent, false);
    viewHolder = new ViewHolderItem(viewItem);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {

    NewsBean datalist = data.get(position);

    switch (getItemViewType(position)) {
      case ITEM:
        ViewHolderItem viewHolderItem = (ViewHolderItem) holder;
        RequestOptions options = new RequestOptions().fitCenter()
            .format(DecodeFormat.PREFER_ARGB_8888)
            .override(200, 200);
        Glide.with(context)
            .load(Server.BASE_ASSETS + datalist.getNews_images())
            .apply(options)
            .into(viewHolderItem.imageviewNewsItem);
        viewHolderItem.textviewTitleNewsItem.setText(datalist.getNews_title());
        viewHolderItem.cardviewNewsFragmentNews.setForeground(getSelectedItemDrawable());
        viewHolderItem.cardviewNewsFragmentNews.setClickable(true);
        viewHolderItem.cardviewNewsFragmentNews.setOnClickListener(v -> {
          v.getContext().startActivity(new Intent(v.getContext(), DetailNewsActivity.class)
              .putExtra("news_id", datalist.getNews_id())
              .putExtra("news_image", datalist.getNews_images())
              .putExtra("news_description", datalist.getNews_description()));
          ((Activity) context)
              .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
        });
        break;
      case LOADING:
        ViewHolderLoading viewHolderLoading = (ViewHolderLoading) holder;
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
          newsFragment.getData();
        });
        break;
    }
  }


  @Override
  public int getItemViewType(int position) {
    return (position == data.size() - 1) ? LOADING : ITEM;
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

  protected class ViewHolderItem extends ViewHolder {

    @BindView(R.id.imageview_news_item)
    ImageView imageviewNewsItem;
    @BindView(R.id.textview_title_news_item)
    TextView textviewTitleNewsItem;
    @BindView(R.id.cardview_news_fragment_news)
    CardView cardviewNewsFragmentNews;

    public ViewHolderItem(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);

    }
  }

  protected class ViewHolderLoading extends ViewHolder {

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
