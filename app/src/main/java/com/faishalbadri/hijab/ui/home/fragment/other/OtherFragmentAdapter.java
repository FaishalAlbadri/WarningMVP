package com.faishalbadri.hijab.ui.home.fragment.other;


import android.app.Activity;
import android.content.Context;
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
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.DataOtherFragment;
import com.faishalbadri.hijab.ui.home.fragment.other.OtherFragmentAdapter.ViewHolder;
import java.util.List;

/**
 * Created by faishal on 10/31/17.
 */

public class OtherFragmentAdapter extends Adapter<ViewHolder> {

  Context context;
  List<DataOtherFragment> datalist;
  String kritiksaran, kirimartikel, share, about;

  public OtherFragmentAdapter(Context context,
      List<DataOtherFragment> datalist) {
    this.context = context;
    this.datalist = datalist;
  }


  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.card_view_other_item)
    CardView cardViewOtherItem;
    @BindView(R.id.img_title_other_item)
    ImageView imgTitleOtherItem;
    @BindView(R.id.textview_title_other_item)
    TextView textviewTitleOtherItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);

    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.other_item, parent, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final DataOtherFragment dataOtherFragment = datalist.get(position);

    kritiksaran = ((Activity) context).getResources().getString(R.string.text_other_kritik_saran);
    kirimartikel = ((Activity) context).getResources().getString(R.string.text_other_kirim_artikel);
    share = ((Activity) context).getResources().getString(R.string.text_other_share);
    about = ((Activity) context).getResources().getString(R.string.text_other_about);

    holder.textviewTitleOtherItem.setText(dataOtherFragment.getTitle());
    Glide.with(context).load(dataOtherFragment.getImage()).into(holder.imgTitleOtherItem);
    holder.cardViewOtherItem.setForeground(getSelectedItemDrawable());
    holder.cardViewOtherItem.setClickable(true);
    holder.cardViewOtherItem.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (dataOtherFragment.getTitle().equalsIgnoreCase(kritiksaran)) {

        } else if (dataOtherFragment.getTitle().equalsIgnoreCase(kirimartikel)) {

        } else if (dataOtherFragment.getTitle().equalsIgnoreCase(share)) {

        } else if (dataOtherFragment.getTitle().equalsIgnoreCase(about)) {

        }
      }
    });


  }

  @Override
  public int getItemCount() {
    return datalist.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = ((Activity) context).obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

}
