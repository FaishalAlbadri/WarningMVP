package com.faishalbadri.hijab.ui.ebook.fragment.ebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
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
import com.faishalbadri.hijab.ui.detail.ebook.DetailEbookActivity;
import com.faishalbadri.hijab.ui.ebook.fragment.ebook.EbookAdapter.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookAdapter extends Adapter<ViewHolder> {

  Context context;
  List<EbookBean> list_ebook;

  public EbookAdapter(FragmentActivity ebookActivity, ArrayList<EbookBean> resultItem) {
    this.context = ebookActivity;
    this.list_ebook = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_grid_ebook, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final EbookBean listitem = list_ebook.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_API + listitem.getEbook_image())
        .apply(options)
        .into(holder.imageViewEbookGrid);
    holder.txtEbookGrid.setText(listitem.getEbook_title());
    holder.constraintItemGrid.setBackground(getSelectedItemDrawable());
    holder.constraintItemGrid.setOnClickListener(view -> {
      view.getContext().startActivity(new Intent(view.getContext(), DetailEbookActivity.class)
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

    @BindView(R.id.imageview_ebook_grid)
    ImageView imageViewEbookGrid;
    @BindView(R.id.txt_ebook_grid)
    TextView txtEbookGrid;
    @BindView(R.id.constraint_item_grid)
    ConstraintLayout constraintItemGrid;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
