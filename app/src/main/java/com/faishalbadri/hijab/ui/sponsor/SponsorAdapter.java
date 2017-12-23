package com.faishalbadri.hijab.ui.sponsor;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoSponsor;
import com.faishalbadri.hijab.data.PojoSponsor.SponsorBean;
import com.faishalbadri.hijab.ui.sponsor.SponsorAdapter.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.List;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorAdapter extends Adapter<ViewHolder> {

  List<SponsorBean> data;
  Context context;


  public SponsorAdapter(List<SponsorBean> data, Context context) {
    this.data = data;
    this.context = context;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_grid_voting, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final PojoSponsor.SponsorBean datalist = data.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(150, 150);
    Glide.with(context)
        .load(Server.BASE_API + datalist.getSponsor_image())
        .apply(options)
        .into(holder.imageviewVotingGrid);
    holder.imageviewVotingGrid.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        String url = datalist.getSponsor_link();
        if (datalist.getSponsor_link().startsWith("http://") || datalist.getSponsor_link()
            .startsWith("https://")) {
          Intent i = new Intent(Intent.ACTION_VIEW);
          i.setData(Uri.parse(url));
          context.startActivity(i);
        } else if (datalist.getSponsor_link().startsWith("www.")) {
          Intent i = new Intent(Intent.ACTION_VIEW);
          i.setData(Uri.parse("http://" + url));
          context.startActivity(i);
        } else {
          Intent i = new Intent(Intent.ACTION_VIEW);
          i.setData(Uri.parse("http://www." + url));
          context.startActivity(i);
        }
      }
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

    @BindView(R.id.imageview_voting_grid)
    ImageView imageviewVotingGrid;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
