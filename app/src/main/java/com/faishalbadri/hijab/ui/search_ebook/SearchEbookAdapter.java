package com.faishalbadri.hijab.ui.search_ebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
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
import com.faishalbadri.hijab.data.ebook.EbookItem;
import com.faishalbadri.hijab.ui.detail.ebook.DetailEbookScrollingActivity;
import com.faishalbadri.hijab.ui.search_ebook.SearchEbookAdapter.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faishal on 01/02/18.
 */

public class SearchEbookAdapter extends Adapter<ViewHolder> {

  private Context context;
  private List<EbookItem> list_ebook;

  public SearchEbookAdapter(FragmentActivity ebookActivity, ArrayList<EbookItem> resultItem) {
    this.context = ebookActivity;
    this.list_ebook = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context)
        .inflate(R.layout.item_ebook_with_cardview, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final EbookItem listitem = list_ebook.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_ASSETS + listitem.getEbookImage())
        .apply(options)
        .into(holder.imageviewEbookItem);
    holder.textviewEbookItem.setText(listitem.getEbookTitle());
    holder.cardviewItemEbook.setForeground(getSelectedItemDrawable());
    holder.cardviewItemEbook.setOnClickListener(view -> {
      view.getContext()
          .startActivity(new Intent(view.getContext(), DetailEbookScrollingActivity.class)
              .putExtra("ebook_name", listitem.getEbookTitle())
              .putExtra("ebook_image", listitem.getEbookImage())
              .putExtra("ebook_description", listitem.getEbookDescription())
              .putExtra("ebook_url", listitem.getEbookLink())
              .putExtra("ebook_publisher", listitem.getEbookPublisher())
              .putExtra("ebook_writer", listitem.getEbookWriter())
              .putExtra("ebook_time", listitem.getEbookReleaseDate()));
      ((Activity) context)
          .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
    });
  }

  @Override
  public int getItemCount() {
    return list_ebook.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = context.obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_ebook_item)
    ImageView imageviewEbookItem;
    @BindView(R.id.textview_ebook_item)
    TextView textviewEbookItem;
    @BindView(R.id.cardview_item_ebook)
    CardView cardviewItemEbook;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}

