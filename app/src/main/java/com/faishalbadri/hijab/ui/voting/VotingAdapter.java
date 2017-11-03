package com.faishalbadri.hijab.ui.voting;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVoting;
import com.faishalbadri.hijab.data.PojoVoting.VotingBean;
import com.faishalbadri.hijab.ui.voting.VotingAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.voting_dialog_fragment.VotingDialogFragment;
import com.faishalbadri.hijab.util.Server;
import com.faishalbadri.hijab.util.SessionManager;
import java.util.HashMap;
import java.util.List;

public class VotingAdapter extends Adapter<ViewHolder> {

  Context context;
  List<VotingBean> list_voting;
  SessionManager sessionManager;
  String id_user;


  public VotingAdapter(Context context, List<VotingBean> list_voting, FragmentActivity fragmentActivity) {
    this.context = context;
    this.list_voting = list_voting;
    this.context = fragmentActivity;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_voting_grid)
    ImageView imageviewVotingGrid;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_voting_item, null);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final PojoVoting.VotingBean listitem = list_voting.get(position);
    sessionManager = new SessionManager(context);
    HashMap<String, String> user = sessionManager.getUserDetails();
    id_user = user.get(SessionManager.key_id);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(150, 150);
    Glide.with(context)
        .load(Server.BASE_IMG + listitem.getVoting_img())
        .apply(options)
        .into(holder.imageviewVotingGrid);
    holder.imageviewVotingGrid.setOnClickListener(v -> {
      Bundle bundle = new Bundle();
      bundle.putString("id_voting",listitem.getId_voting());
      bundle.putString("nama",listitem.getVoting_nickname());
      bundle.putString("img",listitem.getVoting_img());
      bundle.putString("id_user",id_user);
      FragmentActivity activity = (FragmentActivity) (context);
      android.support.v4.app.FragmentManager fm = activity.getSupportFragmentManager();
      VotingDialogFragment alert = new VotingDialogFragment();
      alert.setArguments(bundle);
      alert.show(fm,"");
    });
  }

  @Override
  public int getItemCount() {
    return list_voting.size();
  }

}
