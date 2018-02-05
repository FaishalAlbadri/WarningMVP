package com.faishalbadri.hijab.ui.voting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVoting.VotingBean;
import com.faishalbadri.hijab.di.VotingRepositoryInject;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.voting.VotingContract.votingView;
import com.faishalbadri.hijab.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class VotingActivity extends AppCompatActivity implements votingView {

  @BindView(R.id.recyclerview_activity_voting)
  RecyclerView recyclerviewActivityVoting;
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.refresh_voting)
  SwipeRefreshLayout refreshVoting;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  private VotingPresenter votingPresenter;
  private ArrayList<VotingBean> list_data;
  private VotingAdapter votingAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_voting);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    setView();
    votingPresenter.getDataVoting();
    refreshVoting.setOnRefreshListener(() -> {
      refreshVoting.setRefreshing(false);
      votingPresenter.getDataVoting();
    });
  }

  private void setView() {
    textviewGeneralToolbarWithBackButton.setText(R.string.text_pinky_hijab_voting);
    votingPresenter = new VotingPresenter(
        VotingRepositoryInject.provideToVotingRepository(getApplicationContext()));
    votingPresenter.onAttachView(this);
    list_data = new ArrayList<>();
    votingAdapter = new VotingAdapter(getApplicationContext(), list_data, this);
    GridLayoutManager voting = new GridLayoutManager(getApplicationContext(), 3);
    voting.setOrientation(GridLayoutManager.VERTICAL);
    recyclerviewActivityVoting.setLayoutManager(voting);
    recyclerviewActivityVoting.setAdapter(votingAdapter);
    refreshVoting.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSuccesVoting(List<VotingBean> list, String msg) {
    list_data.clear();
    list_data.addAll(list);
    votingAdapter.notifyDataSetChanged();
    refreshVoting.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onDataVotingNull(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorVoting(String msg) {
    refreshVoting.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }

  @Override
  public void onBackPressed() {
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onButtonBackGeneralToolbarWithBackButtonClicked() {
    onBackPressed();
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onLayoutNoInternetAccesClicked() {
    votingPresenter.getDataVoting();
  }
}
