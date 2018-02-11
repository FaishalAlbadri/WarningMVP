package com.faishalbadri.hijab.ui.contact_us;

import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.contact_us.ContactUsAdapter.ViewHolder;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/02/18.
 */

public class ContactUsAdapter extends Adapter<ViewHolder> {

  Context context;
  List<ContactUsData> aboutData;

  public ContactUsAdapter(ContactUsActivity contactUsActivity, List<ContactUsData> contactUsData) {
    this.context = contactUsActivity;
    aboutData = contactUsData;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_contact_us, parent, false);

    return new ViewHolder(view);
  }

  @RequiresApi(api = VERSION_CODES.M)
  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final ContactUsData datalist = aboutData.get(position);
    String pinkfame = context.getString(R.string.caption_pinkfame_contact_us);
    String end = context.getString(R.string.caption_five_contact_us);
    if (datalist.getCaption().equalsIgnoreCase(pinkfame)) {
      holder.textviewSmallListContactUs.setText(datalist.getCaption());
      holder.imageviewSmallListContactUs.setImageResource(datalist.getImage());
      holder.imageviewSmallListContactUs.setVisibility(View.VISIBLE);
      holder.textviewSmallListContactUs.setVisibility(View.VISIBLE);
      holder.textviewListContactUs.setVisibility(View.GONE);
      holder.imageviewListContactUs.setVisibility(View.GONE);
      holder.constraintItemContactUs.setBackgroundColor(context.getColor(R.color.colorPrimary));
    } else if (datalist.getCaption().equalsIgnoreCase(end)) {
      holder.imageviewListContactUs.setVisibility(View.GONE);
      holder.textviewListContactUs.setText(datalist.getCaption());
      holder.imageviewListContactUs.setImageResource(datalist.getImage());
    } else {
      holder.textviewListContactUs.setText(datalist.getCaption());
      holder.imageviewListContactUs.setImageResource(datalist.getImage());
    }
  }

  @Override
  public int getItemCount() {
    return aboutData.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_list_contact_us)
    ImageView imageviewListContactUs;
    @BindView(R.id.textview_list_contact_us)
    TextView textviewListContactUs;
    @BindView(R.id.constraint_item_contact_us)
    ConstraintLayout constraintItemContactUs;
    @BindView(R.id.imageview_small_list_contact_us)
    ImageView imageviewSmallListContactUs;
    @BindView(R.id.textview_small_list_contact_us)
    TextView textviewSmallListContactUs;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
