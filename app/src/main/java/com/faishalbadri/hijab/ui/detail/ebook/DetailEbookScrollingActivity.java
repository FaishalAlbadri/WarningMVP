package com.faishalbadri.hijab.ui.detail.ebook;

import android.annotation.TargetApi;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnScrollChangeListener;
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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_ebook_scrolling);
    ButterKnife.bind(this);
    setSupportActionBar(toolbar);
    setView();
  }

  @TargetApi(VERSION_CODES.M)
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
//    if (toolbarLayout.isScrollContainer()) {
//      toolbar.setVisibility(View.VISIBLE);
//      toolbar.setTitle(title);
//    } else {
//      toolbar.setVisibility(View.GONE);
//    }
    toolbarLayout.setOnScrollChangeListener(new OnScrollChangeListener() {
      @Override
      public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

      }
    });
  }
}
