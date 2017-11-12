package com.faishalbadri.hijab.ui.ebook.fragment.ebook_all;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.faishalbadri.hijab.data.PojoEbook;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.ui.detail.ebook.DetailEbookActivity;
import com.faishalbadri.hijab.ui.ebook.fragment.ebook_all.EbookAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
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
        .load(Server.BASE_IMG + listitem.getGambar_ebook())
        .apply(options)
        .into(holder.imageViewEbookGrid);
    holder.txtEbookGrid.setText(listitem.getJudul_ebook());
    holder.imageViewEbookGrid.setOnClickListener(view -> {
      Intent i = new Intent(view.getContext(), DetailEbookActivity.class);
      i.putExtra("name", listitem.getJudul_ebook());
      i.putExtra("image", listitem.getGambar_ebook());
      i.putExtra("description", listitem.getDescription());
      i.putExtra("link", listitem.getLink());
      i.putExtra("publisher", listitem.getPenerbit_ebook());
      i.putExtra("writer", listitem.getPenulis_ebook());
      i.putExtra("time", listitem.getTanggal_terbit_ebook());
      view.getContext().startActivity(i);
    });
  }

  @Override
  public int getItemCount() {
    return list_ebook.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_ebook_grid)
    ImageView imageViewEbookGrid;
    @BindView(R.id.txt_ebook_grid)
    TextView txtEbookGrid;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
