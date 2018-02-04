package com.faishalbadri.hijab.ui.ebook_by_category;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.ui.detail.ebook.DetailEbookScrollingActivity;
import com.faishalbadri.hijab.ui.ebook_by_category.EbookByCategoryAdapter.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookByCategoryAdapter extends Adapter<ViewHolder> {

  private Context context;
  private List<EbookBean> list_data;

  public EbookByCategoryAdapter(EbookByCategoryActivity ebookByCategoryActivity,
      ArrayList<EbookBean> resultItem) {
    context = ebookByCategoryActivity;
    list_data = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_grid_ebook, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final EbookBean listitem = list_data.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_ASSETS + listitem.getEbook_image())
        .apply(options)
        .into(holder.imageviewEbookGrid);
    holder.txtEbookGrid.setText(listitem.getEbook_title());
    holder.imageviewEbookGrid.setOnClickListener(view -> {
      view.getContext()
          .startActivity(new Intent(view.getContext(), DetailEbookScrollingActivity.class)
          .putExtra("ebook_name", listitem.getEbook_title())
          .putExtra("ebook_image", listitem.getEbook_image())
          .putExtra("ebook_description", listitem.getEbook_description())
          .putExtra("ebook_url", listitem.getEbook_link())
          .putExtra("ebook_publisher", listitem.getEbook_publisher())
          .putExtra("ebook_writer", listitem.getEbook_writer())
          .putExtra("ebook_time", listitem.getEbook_release_date()));
      ((Activity) context)
          .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
    });
  }

  @Override
  public int getItemCount() {
    return list_data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_ebook_grid)
    ImageView imageviewEbookGrid;
    @BindView(R.id.txt_ebook_grid)
    TextView txtEbookGrid;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
