package com.faishalbadri.hijab.aaa_migration_server.ui.sponsor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoSponsor;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoSponsor.SponsorBean;
import com.faishalbadri.hijab.aaa_migration_server.di.SponsorRepositoryInject;
import com.faishalbadri.hijab.aaa_migration_server.ui.home.activity.HomeActivity;
import java.util.ArrayList;
import java.util.List;

public class SponsorActivity extends AppCompatActivity implements SponsorContract.SponsorView {

  private static final String save_sponsor = "saveSponsor";
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.recyclerview_activity_sponsor)
  RecyclerView recyclerviewActivitySponsor;
  SponsorPresenter sponsorPresenter;
  SponsorAdapter sponsorAdapter;
  ArrayList<PojoSponsor.SponsorBean> list_data;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sponsor);
    ButterKnife.bind(this);
    setView();

    sponsorPresenter.onAttachView(this);

    if (savedInstanceState != null) {
      ArrayList<PojoSponsor.SponsorBean> data = savedInstanceState
          .getParcelableArrayList(save_sponsor);
      this.list_data.clear();
      this.list_data.addAll(data);
      sponsorAdapter.notifyDataSetChanged();
    } else {
      sponsorPresenter.getDataSponsor();
    }

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
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_sponsor, list_data);
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onViewClicked() {
    onBackPressed();
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
  }

  @Override
  public void onErrorSponsor(String msg) {

  }
}
