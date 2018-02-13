package com.faishalbadri.hijab.ui.ebook.fragment.ebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbookWithCategory.DataBean.EbookBean;
import com.faishalbadri.hijab.ui.detail.ebook.DetailEbookScrollingActivity;
import com.faishalbadri.hijab.ui.ebook.fragment.ebook.EbookAdapterItem.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.List;

/**
 * Created by faishal on 02/02/18.
 */

public class EbookAdapterItem extends Adapter<ViewHolder> {

  private Context context;
  private List<EbookBean> list_data;

  public EbookAdapterItem() {
  }

  public void setData(Context context, List<EbookBean> list_data) {
    this.context = context;
    this.list_data = null;
    this.list_data = list_data;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context)
        .inflate(R.layout.item_ebook_recycler_item, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.textviewEbookRecyclerItem.setText(list_data.get(position).getEbook_title());
    RequestOptions options = new RequestOptions()
        .transform(new RoundedCorners(10))
        .format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_ASSETS + "assets/ebook_images/" + list_data.get(position)
            .getEbook_image())
        .apply(options)
        .into(holder.imageviewEbookRecyclerItem);
    holder.layoutItemEbookRecyclerItem.setOnClickListener(view -> {
      view.getContext()
          .startActivity(new Intent(view.getContext(), DetailEbookScrollingActivity.class)
              .putExtra("ebook_name", list_data.get(position).getEbook_title())
              .putExtra("ebook_image", "assets/ebook_images/" + list_data.get(position)
                  .getEbook_image())
              .putExtra("ebook_description", list_data.get(position).getEbook_description())
              .putExtra("ebook_url", "assets/ebook_files/" + list_data.get(position)
                  .getEbook_link())
              .putExtra("ebook_publisher", list_data.get(position).getEbook_publisher())
              .putExtra("ebook_writer", list_data.get(position).getEbook_writer())
              .putExtra("ebook_time", list_data.get(position).getEbook_released()));
      ((Activity) context)
          .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
    });
  }

  @Override
  public int getItemCount() {
    if (list_data == null) {
      return 0;
    } else {
      return list_data.size();
    }
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_ebook_recycler_item)
    ImageView imageviewEbookRecyclerItem;
    @BindView(R.id.textview_ebook_recycler_item)
    TextView textviewEbookRecyclerItem;
    @BindView(R.id.layout_item_ebook_recycler_item)
    ConstraintLayout layoutItemEbookRecyclerItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
