package com.faishalbadri.hijab.ui.news.fragment.news;

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
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.ui.detail.news.DetailNewsActivity;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsAdapter extends Adapter<ViewHolder> {

  Context context;
  List<IsiBean> data;

  public NewsAdapter(Context context,
      List<IsiBean> data) {
    this.context = context;
    this.data = data;
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

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final PojoNews.IsiBean listitem = data.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_IMG + listitem.getIsi_gambar())
        .apply(options)
        .into(holder.imageviewNewsItem);
    holder.textviewTitleNewsItem.setText(listitem.getIsi_judul());
    holder.cardviewNewsFragmentNews.setForeground(getSelectedItemDrawable());
    holder.cardviewNewsFragmentNews.setClickable(true);
    holder.cardviewNewsFragmentNews.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), DetailNewsActivity.class);
      i.putExtra("title", listitem.getIsi_judul());
      i.putExtra("image", listitem.getIsi_gambar());
      i.putExtra("desc", listitem.getIsi_keterangan());
      v.getContext().startActivity(i);
    });
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = ((Activity) context).obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }
}
