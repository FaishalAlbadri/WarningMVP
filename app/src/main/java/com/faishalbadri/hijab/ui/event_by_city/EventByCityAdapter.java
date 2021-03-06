package com.faishalbadri.hijab.ui.event_by_city;

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
import com.faishalbadri.hijab.data.event.EventItem;
import com.faishalbadri.hijab.ui.detail.event.DetailEventActivity;
import com.faishalbadri.hijab.ui.event_by_city.EventByCityAdapter.ViewHolder;
import com.faishalbadri.hijab.util.server.Server;
import java.util.List;

public class EventByCityAdapter extends Adapter<ViewHolder> {

  private Context context;
  private List<EventItem> data;


  public EventByCityAdapter(Context context,
      List<EventItem> data) {
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
    final EventItem listitem = data.get(position);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_ASSETS + listitem.getEventImage())
        .apply(options)
        .into(holder.imageviewEventItemEvent);
    holder.textviewPlaceTimeEventItem
        .setText(listitem.getEventCityName() + ", " + listitem.getEventDate());
    holder.textviewTitleEventItem.setText(listitem.getEventTitle());
    holder.cardViewEventItem.setForeground(getSelectedItemDrawable());
    holder.cardViewEventItem.setClickable(true);
    holder.cardViewEventItem.setOnClickListener(view -> {
      view.getContext().startActivity(new Intent(view.getContext(), DetailEventActivity.class)
          .putExtra("title", listitem.getEventTitle())
          .putExtra("image", listitem.getEventImage())
          .putExtra("desc", listitem.getEventDetail())
          .putExtra("link", listitem.getEventLink())
          .putExtra("place", listitem.getEventCityName())
          .putExtra("time", listitem.getEventDate()));
      ((Activity) context)
          .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
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
}
