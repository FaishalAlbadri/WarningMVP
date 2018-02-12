package com.faishalbadri.hijab.ui.about;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import java.util.ArrayList;
import java.util.List;

public class AboutScrollingActivity extends AppCompatActivity {

  @BindView(R.id.imageview_about_banner_about)
  ImageView imageviewAboutBannerAbout;
  @BindView(R.id.recyclerview_about)
  RecyclerView recyclerviewAbout;
  @BindView(R.id.fab)
  FloatingActionButton fab;
  List<AboutData> aboutData;
  AboutAdapter aboutAdapter;
  private int image[];
  private String caption[];

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about_scrolling);
    ButterKnife.bind(this);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    setView();
    setString();
    toolbar.setNavigationOnClickListener(v -> onBackPressed());
  }

  private void setString() {
    image = new int[]{
        R.drawable.text_pink_fame_primary, R.drawable.banner_news_about, R.drawable.banner_tv_about,
        R.drawable.banner_vote_about, R.drawable.banner_event_about, R.drawable.banner_ebook_about
    };
    caption = new String[]{
        getString(R.string.caption_about_pink_fame),
        getString(R.string.caption_about_news), getString(R.string.caption_about_tv),
        getString(R.string.caption_about_vote), getString(R.string.caption_about_event),
        getString(R.string.caption_about_ebook)
    };
    aboutData.add(new AboutData(image[0], caption[0]));
    aboutData.add(new AboutData(image[1], caption[1]));
    aboutData.add(new AboutData(image[2], caption[2]));
    aboutData.add(new AboutData(image[3], caption[3]));
    aboutData.add(new AboutData(image[4], caption[4]));
    aboutData.add(new AboutData(image[5], caption[5]));
  }

  private void setView() {
    aboutData = new ArrayList<>();
    aboutAdapter = new AboutAdapter(this, aboutData);
    recyclerviewAbout.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewAbout.setAdapter(aboutAdapter);
  }

  @Override
  public void onBackPressed() {
    startActivity(
        new Intent(getApplicationContext(), HomeActivity.class).putExtra("session_home", "1"));
    finish();
  }


  @OnClick(R.id.fab)
  public void onViewClicked() {
    Toast.makeText(this, "action share", Toast.LENGTH_SHORT).show();
  }
}
