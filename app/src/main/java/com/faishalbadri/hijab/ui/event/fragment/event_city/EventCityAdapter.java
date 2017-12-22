package com.faishalbadri.hijab.ui.event.fragment.event_city;

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
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCityEvent.EventCityBean;
import com.faishalbadri.hijab.ui.event.fragment.event_city.EventCityAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.event_by_city.EventByCityActivity;
import java.util.List;


public class EventCityAdapter extends Adapter<ViewHolder> {

  Context context;
  List<EventCityBean> data;


  public EventCityAdapter(Context context,
      List<EventCityBean> data) {
    this.context = context;
    this.data = data;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final EventCityBean listitem = data.get(position);
    holder.textviewTitleCategoryItem.setText(listitem.getEvent_city_name());
    holder.cardViewCategoryItem.setForeground(getSelectedItemDrawable());
    holder.cardViewCategoryItem.setClickable(true);
    holder.cardViewCategoryItem.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        context.startActivity(new Intent(context, EventByCityActivity.class)
            .putExtra("id", listitem.getEvent_city_id())
            .putExtra("city", listitem.getEvent_city_name()));
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

    @BindView(R.id.textview_title_category_item)
    TextView textviewTitleCategoryItem;
    @BindView(R.id.card_view_category_item)
    CardView cardViewCategoryItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
