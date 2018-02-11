package com.faishalbadri.hijab.ui.about;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.about.AboutAdapter.ViewHolder;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/02/18.
 */

public class AboutAdapter extends Adapter<ViewHolder> {

  Context context;
  List<AboutData> aboutData;

  public AboutAdapter(AboutScrollingActivity aboutActivity, List<AboutData> aboutData) {
    this.context = aboutActivity;
    this.aboutData = aboutData;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_about, parent, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    String pinkfame = context.getResources().getString(R.string.caption_about_pink_fame);
    final AboutData datalist = aboutData.get(position);
    if (datalist.getText().equalsIgnoreCase(pinkfame)) {
      holder.imageviewListAbout.getLayoutParams().height = 200;
      holder.imageviewListAbout.getLayoutParams().width = 600;
      holder.imageviewListAbout.requestLayout();
    } else {
      holder.imageviewListAbout.getLayoutParams().width = LayoutParams.MATCH_PARENT;
    }
    holder.imageviewListAbout.setImageResource(datalist.getImage());
    holder.textviewListAbout.setText(datalist.getText());
  }

  @Override
  public int getItemCount() {
    return aboutData.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_list_about)
    ImageView imageviewListAbout;
    @BindView(R.id.textview_list_about)
    TextView textviewListAbout;
    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
