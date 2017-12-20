package com.faishalbadri.hijab.ui.voting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVoting.VotingBean;
import com.faishalbadri.hijab.revamp.di.VotingRepositoryInject;
import com.faishalbadri.hijab.revamp.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.voting.VotingContract.votingView;
import java.util.ArrayList;
import java.util.List;

public class VotingActivity extends AppCompatActivity implements votingView {

  private static final String save_data_voting = "save_data_voting";
  @BindView(R.id.recyclerview_activity_voting)
  RecyclerView recyclerviewActivityVoting;
  VotingPresenter votingPresenter;
  ArrayList<VotingBean> list_data;
  VotingAdapter votingAdapter;
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.refresh_voting)
  SwipeRefreshLayout refreshVoting;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_voting);
    ButterKnife.bind(this);
    setView();
    if (savedInstanceState != null) {
      ArrayList<VotingBean> data = savedInstanceState
          .getParcelableArrayList(save_data_voting);
      this.list_data.clear();
      this.list_data.addAll(data);
      votingAdapter.notifyDataSetChanged();
    } else {
      votingPresenter.getDataVoting();
    }

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
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_data_voting, list_data);
  }

  @Override
  public void onSuccesVoting(List<VotingBean> list, String msg) {
    list_data.clear();
    list_data.addAll(list);
    votingAdapter.notifyDataSetChanged();
  }

  @Override
  public void onDataVotingNull(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorVoting(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onBackPressed() {
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onViewClicked() {
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }
}
