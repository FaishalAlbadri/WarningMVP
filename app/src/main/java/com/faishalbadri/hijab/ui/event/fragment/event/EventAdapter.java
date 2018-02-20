package com.faishalbadri.hijab.ui.event.fragment.event;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEvent.EventBean;
import com.faishalbadri.hijab.ui.detail.event.DetailEventActivity;
import com.faishalbadri.hijab.util.Singleton.LoadingStatus;
import com.faishalbadri.hijab.util.server.Server;
import java.util.List;

/**
 * Created by faishal on 04/01/18.
 */

public class EventAdapter extends Adapter<ViewHolder> {

  private static final int ITEM = 0;
  private static final int LOADING = 1;
  private Context context;
  private List<EventBean> data;
  private EventFragment eventFragment;
  private String error;
  private ViewHolderLoading viewHolderLoading;

  public EventAdapter(Context context, List<EventBean> data, EventFragment eventFragment) {
    this.context = context;
    this.data = data;
    this.eventFragment = eventFragment;
  }


  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewHolder viewHolder = null;
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());

    switch (viewType) {
      case ITEM:
        viewHolder = getViewHolder(parent, inflater);
        break;
      case LOADING:
        View viewLoading = inflater.inflate(R.layout.item_loading, parent, false);
        viewHolder = new ViewHolderLoading(viewLoading);
        break;
    }
    return viewHolder;
  }

  @NonNull
  private ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
    ViewHolder viewHolder;
    View viewItem = inflater.inflate(R.layout.item_event, parent, false);
    viewHolder = new ViewHolderItem(viewItem);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final EventBean datalist = data.get(position);

    switch (getItemViewType(position)) {
      case ITEM:
        ViewHolderItem viewHolderItem = (ViewHolderItem) holder;
        RequestOptions options = new RequestOptions().fitCenter()
            .format(DecodeFormat.PREFER_ARGB_8888)
            .override(200, 200);
        Glide.with(context)
            .load(Server.BASE_ASSETS + datalist.getEvent_image())
            .apply(options)
            .into(viewHolderItem.imageviewEventItemEvent);
        viewHolderItem.textviewPlaceTimeEventItem
            .setText(datalist.getEvent_city_name() + ", " + datalist.getEvent_date());
        viewHolderItem.textviewTitleEventItem.setText(datalist.getEvent_title());
        viewHolderItem.cardViewEventItem.setForeground(getSelectedItemDrawable());
        viewHolderItem.cardViewEventItem.setClickable(true);
        viewHolderItem.cardViewEventItem.setOnClickListener(view -> {
          view.getContext().startActivity(new Intent(view.getContext(), DetailEventActivity.class)
              .putExtra("title", datalist.getEvent_title())
              .putExtra("image", datalist.getEvent_image())
              .putExtra("desc", datalist.getEvent_detail())
              .putExtra("link", datalist.getEvent_link())
              .putExtra("place", datalist.getEvent_city_name())
              .putExtra("time", datalist.getEvent_date()));
          ((Activity) context)
              .overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_right);
        });
        break;
      case LOADING:
        viewHolderLoading = (ViewHolderLoading) holder;
        error = LoadingStatus.getInstance().getStatus();
        if (error != null) {
          viewHolderLoading.buttonLoadData.setVisibility(View.GONE);
          viewHolderLoading.progressLoadData.setVisibility(View.GONE);
          viewHolderLoading.textviewThanksItemLoading.setVisibility(View.VISIBLE);
        } else {
          viewHolderLoading.buttonLoadData.setVisibility(View.VISIBLE);
          viewHolderLoading.progressLoadData.setVisibility(View.GONE);
          viewHolderLoading.textviewThanksItemLoading.setVisibility(View.GONE);
        }
        viewHolderLoading.buttonLoadData.setOnClickListener(v -> {
          viewHolderLoading.buttonLoadData.setVisibility(View.GONE);
          viewHolderLoading.progressLoadData.setVisibility(View.VISIBLE);
          eventFragment.getData();
        });
        break;
    }
  }

  public void onErrorPagination() {
    Toast.makeText(context, "Koneksi internet anda lambat", Toast.LENGTH_SHORT).show();
    viewHolderLoading.progressLoadData.setVisibility(View.GONE);
    viewHolderLoading.buttonLoadData.setVisibility(View.VISIBLE);
  }

  @Override
  public int getItemViewType(int position) {
    return (position == data.size() - 1) ? LOADING : ITEM;
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

  protected class ViewHolderItem extends ViewHolder {

    @BindView(R.id.imageview_event_item_event)
    ImageView imageviewEventItemEvent;
    @BindView(R.id.textview_title_event_item)
    TextView textviewTitleEventItem;
    @BindView(R.id.textview_place_time_event_item)
    TextView textviewPlaceTimeEventItem;
    @BindView(R.id.card_view_event_item)
    CardView cardViewEventItem;

    public ViewHolderItem(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);

    }
  }

  protected class ViewHolderLoading extends ViewHolder {

    @BindView(R.id.button_load_data)
    ImageButton buttonLoadData;
    @BindView(R.id.progress_load_data)
    ProgressBar progressLoadData;
    @BindView(R.id.textview_thanks_item_loading)
    TextView textviewThanksItemLoading;
    @BindView(R.id.constraint_item_loading)
    ConstraintLayout constraintItemLoading;

    public ViewHolderLoading(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
