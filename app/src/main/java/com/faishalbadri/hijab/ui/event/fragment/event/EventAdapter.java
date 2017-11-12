package com.faishalbadri.hijab.ui.event.fragment.event;

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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEvent;
import com.faishalbadri.hijab.data.PojoEvent.EventBean;
import com.faishalbadri.hijab.ui.detail.ebook.DetailEbookActivity;
import com.faishalbadri.hijab.ui.detail.event.DetailEventActivity;
import com.faishalbadri.hijab.ui.event.fragment.event.EventAdapter.ViewHolder;
import com.faishalbadri.hijab.util.Server;
import java.util.List;

public class EventAdapter extends Adapter<ViewHolder> {

  Context context;
  List<EventBean> data;


  public EventAdapter(Context context,
      List<EventBean> data) {
    this.context = context;
    this.data = data;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final PojoEvent.EventBean listitem = data.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_IMG + listitem.getEvent_image())
        .apply(options)
        .into(holder.imageviewEventItemEvent);
    holder.textviewPlaceTimeEventItem
        .setText(listitem.getCity_event() + ", " + listitem.getEvent_time());
    holder.textviewTitleEventItem.setText(listitem.getEvent_title());
    holder.cardViewEventItem.setForeground(getSelectedItemDrawable());
    holder.cardViewEventItem.setClickable(true);
    holder.cardViewEventItem.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(view.getContext(), DetailEventActivity.class);
        i.putExtra("title", listitem.getEvent_title());
        i.putExtra("image", listitem.getEvent_image());
        i.putExtra("desc", listitem.getEvent_detail());
        i.putExtra("link", listitem.getEvent_link());
        i.putExtra("place", listitem.getCity_event());
        i.putExtra("time", listitem.getEvent_time());
        view.getContext().startActivity(i);
      }
    });
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_event_item_event)
    ImageView imageviewEventItemEvent;
    @BindView(R.id.textview_title_event_item)
    TextView textviewTitleEventItem;
    @BindView(R.id.textview_place_time_event_item)
    TextView textviewPlaceTimeEventItem;
    @BindView(R.id.card_view_event_item)
    CardView cardViewEventItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = ((Activity) context).obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }
}
