package com.faishalbadri.hijab.ui.sponsor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoSponsor.SponsorBean;
import com.faishalbadri.hijab.di.SponsorRepositoryInject;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.sponsor.SponsorContract.SponsorView;
import java.util.ArrayList;
import java.util.List;

public class SponsorActivity extends AppCompatActivity implements SponsorView {

  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.recyclerview_activity_sponsor)
  RecyclerView recyclerviewActivitySponsor;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  private SponsorPresenter sponsorPresenter;
  private SponsorAdapter sponsorAdapter;
  private ArrayList<SponsorBean> list_data;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sponsor);
    ButterKnife.bind(this);
    setView();
    sponsorPresenter.onAttachView(this);
    sponsorPresenter.getDataSponsor();
  }

  private void setView() {
    textviewGeneralToolbarWithBackButton.setText("Sponsored By");
    sponsorPresenter = new SponsorPresenter(
        SponsorRepositoryInject.provideToSponsorRepository(this));
    list_data = new ArrayList<>();
    sponsorAdapter = new SponsorAdapter(list_data, this);
    recyclerviewActivitySponsor.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerviewActivitySponsor.setAdapter(sponsorAdapter);
  }

  @Override
  public void onBackPressed() {
    startActivity(
        new Intent(getApplicationContext(), HomeActivity.class).putExtra("session_home", "1"));
    finish();
  }

  @Override
  public void onSuccesSponsor(List<SponsorBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    sponsorAdapter.notifyDataSetChanged();
    recyclerviewActivitySponsor.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onErrorSponsor(String msg) {
    recyclerviewActivitySponsor.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onButtonBackGeneralToolbarWithBackButtonClicked() {
    onBackPressed();
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onLayoutNoInternetAccesClicked() {
    sponsorPresenter.getDataSponsor();
  }
}
