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
import com.faishalbadri.hijab.ui.detail.ebook.DetailEbookActivity;
import com.faishalbadri.hijab.ui.ebook_by_category.EbookByCategoryAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookByCategoryAdapter extends Adapter<ViewHolder> {

  Context context;
  List<EbookBean> list_data;

  public EbookByCategoryAdapter(EbookByCategoryActivity ebookByCategoryActivity, ArrayList<EbookBean> resultItem) {
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
        .load(Server.BASE_IMG + listitem.getGambar_ebook())
        .apply(options)
        .into(holder.imageviewEbookGrid);
    holder.txtEbookGrid.setText(listitem.getJudul_ebook());
    holder.imageviewEbookGrid.setOnClickListener(view -> {
      view.getContext().startActivity(new Intent(view.getContext(), DetailEbookActivity.class)
      .putExtra("name", listitem.getJudul_ebook())
      .putExtra("image", listitem.getGambar_ebook())
      .putExtra("description", listitem.getDescription())
      .putExtra("publisher", listitem.getPenerbit_ebook())
      .putExtra("writer", listitem.getPenulis_ebook())
      .putExtra("time", listitem.getTanggal_terbit_ebook())
      .putExtra("link", listitem.getLink()));
      ((Activity)context).overridePendingTransition(R.anim.slide_from_right,R.anim.slide_from_right);
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
