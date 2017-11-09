package com.faishalbadri.hijab.ui.home.fragment.other;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
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
import com.faishalbadri.hijab.data.DataOtherFragment;
import com.faishalbadri.hijab.ui.home.fragment.other.OtherFragmentAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.kritik_saran.KritikSaranActivity;
import com.faishalbadri.hijab.ui.send_article.SendArticleActivity;
import java.util.List;

/**
 * Created by faishal on 10/31/17.
 */

public class OtherFragmentAdapter extends Adapter<ViewHolder> {

  Context context;
  List<DataOtherFragment> datalist;
  String kritiksaran, kirimartikel, share, rate, about, sponsor;
  String shareSubject, shareText;


  public OtherFragmentAdapter(Context context,
      List<DataOtherFragment> datalist) {
    this.context = context;
    this.datalist = datalist;
  }


  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.card_view_other_item)
    CardView cardViewOtherItem;
    @BindView(R.id.textview_title_other_item)
    TextView textviewTitleOtherItem;
    @BindView(R.id.img_title_other_item)
    AppCompatImageView imgTitleOtherItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);

    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_other, parent, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final DataOtherFragment dataOtherFragment = datalist.get(position);

    kritiksaran = ((Activity) context).getResources().getString(R.string.text_other_kritik_saran);
    kirimartikel = ((Activity) context).getResources().getString(R.string.text_other_kirim_artikel);
    share = ((Activity) context).getResources().getString(R.string.text_other_share);
    about = ((Activity) context).getResources().getString(R.string.text_other_about);
    rate = ((Activity) context).getResources().getString(R.string.text_rate);
    sponsor = ((Activity) context).getResources().getString(R.string.text_sponsor);
    shareSubject = ((Activity) context).getResources().getString(R.string.text_share_app_subject);
    shareText = ((Activity) context).getResources().getString(R.string.text_share_app_text);

    holder.textviewTitleOtherItem.setText(dataOtherFragment.getTitle());
    holder.imgTitleOtherItem.setImageResource(dataOtherFragment.getImage());
//    Glide.with(context).load(dataOtherFragment.getImage()).into(holder.imgTitleOtherItem);
    holder.cardViewOtherItem.setForeground(getSelectedItemDrawable());
    holder.cardViewOtherItem.setClickable(true);
    holder.cardViewOtherItem.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (dataOtherFragment.getTitle().equalsIgnoreCase(kritiksaran)) {
          ((Activity) context).startActivity(new Intent(context, KritikSaranActivity.class));
          ((Activity) context).finish();
        } else if (dataOtherFragment.getTitle().equalsIgnoreCase(kirimartikel)) {
          ((Activity) context).startActivity(new Intent(context, SendArticleActivity.class));
          ((Activity) context).finish();
        } else if (dataOtherFragment.getTitle().equalsIgnoreCase(share)) {
          Intent sharing = new Intent(Intent.ACTION_SEND);
          sharing.setType("text/plain");
          sharing.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
          sharing.putExtra(Intent.EXTRA_TEXT, shareText);
          ((Activity) context).startActivity(Intent.createChooser(sharing, "Share Via"));
        } else if (dataOtherFragment.getTitle().equalsIgnoreCase(rate)) {
          rateApp();
        } else if (dataOtherFragment.getTitle().equalsIgnoreCase(sponsor)) {

        } else if (dataOtherFragment.getTitle().equalsIgnoreCase(about)) {

        }
      }
    });


  }

  private void rateApp() {
    Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
    Intent rate = new Intent(Intent.ACTION_VIEW, uri);
//    rate.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT
//        | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);

    try {
      ((Activity) context).startActivity(rate);
    } catch (ActivityNotFoundException e) {
      ((Activity) context).startActivity(new Intent(Intent.ACTION_VIEW,
          Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
    }
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
