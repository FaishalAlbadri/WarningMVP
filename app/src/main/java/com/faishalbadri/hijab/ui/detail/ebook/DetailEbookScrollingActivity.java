package com.faishalbadri.hijab.ui.detail.ebook;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.util.server.Server;

public class DetailEbookScrollingActivity extends AppCompatActivity {

  @BindView(R.id.imageview_background_detail_ebook_scrolling)
  ImageView imageviewBackgroundDetailEbookScrolling;
  @BindView(R.id.toolbar)
  Toolbar toolbar;
  @BindView(R.id.imageview_detail_ebook_scrolling)
  ImageView imageviewDetailEbookScrolling;
  @BindView(R.id.toolbar_layout)
  CollapsingToolbarLayout toolbarLayout;
  @BindView(R.id.textview_title_content_detail_ebook)
  TextView textviewTitleContentDetailEbook;
  @BindView(R.id.imageview_creator_content_detail_ebook)
  ImageView imageviewCreatorContentDetailEbook;
  @BindView(R.id.textview_creator_content_detail_ebook)
  TextView textviewCreatorContentDetailEbook;
  @BindView(R.id.textview_publisher_detail_ebook_scrolling)
  TextView textviewPublisherDetailEbookScrolling;
  @BindView(R.id.textview_release_date_detail_ebook_scrolling)
  TextView textviewReleaseDateDetailEbookScrolling;
  @BindView(R.id.button_read_ebook_detail_ebook)
  Button buttonReadEbookDetailEbook;
  @BindView(R.id.textview_desc_detail_ebook)
  TextView textviewDescDetailEbook;
  String title, image, description, link, publisher, time, writer;
  @BindView(R.id.scrollview_detail_ebook_content)
  NestedScrollView scrollviewDetailEbookContent;
  @BindView(R.id.app_bar)
  AppBarLayout appBar;
  boolean expanded = true;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_ebook_scrolling);
    ButterKnife.bind(this);
    setSupportActionBar(toolbar);
    setView();
  }

  private void setView() {
    title = getIntent().getStringExtra("ebook_name");
    image = getIntent().getStringExtra("ebook_image");
    description = getIntent().getStringExtra("ebook_description");
    link = getIntent().getStringExtra("ebook_url");
    publisher = getIntent().getStringExtra("ebook_publisher");
    time = getIntent().getStringExtra("ebook_time");
    writer = getIntent().getStringExtra("ebook_writer");
    textviewTitleContentDetailEbook.setText(title);
    textviewDescDetailEbook.setText(description);
//    textviewDescDetailEbook.setText(getApplicationContext().getString(R.string.large_text));
    textviewPublisherDetailEbookScrolling.setText(publisher);
    textviewReleaseDateDetailEbookScrolling.setText(time);
    textviewCreatorContentDetailEbook.setText(writer);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888);
    RequestOptions optionBackground = new RequestOptions().fitCenter()
        .format(DecodeFormat.PREFER_ARGB_8888).override(100, 100);
    Glide.with(getApplicationContext())
        .load(Server.BASE_ASSETS + image)
        .apply(options)
        .into(imageviewDetailEbookScrolling);
    Glide.with(getApplicationContext())
        .load(Server.BASE_ASSETS + image)
        .apply(optionBackground)
        .into(imageviewBackgroundDetailEbookScrolling);
    appBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
      if (verticalOffset == 0) {
        //fully expanded
        imageviewDetailEbookScrolling.setVisibility(View.VISIBLE);
        toolbar.setTitle("");
      } else {
        //not fully expanded
        imageviewDetailEbookScrolling.setVisibility(View.GONE);
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(this.getColor(R.color.color_white_ff));
      }
    });
  }
}
