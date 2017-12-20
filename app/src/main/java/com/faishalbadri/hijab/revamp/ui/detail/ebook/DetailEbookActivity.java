package com.faishalbadri.hijab.revamp.ui.detail.ebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.revamp.ui.detail.read_ebook.ReadEbook;
import com.faishalbadri.hijab.revamp.util.IntentUtil;
import com.faishalbadri.hijab.revamp.util.Server;
import com.gw.swipeback.SwipeBackLayout;

public class DetailEbookActivity extends AppCompatActivity {

  String title, image, description, link, publisher, time, writer, share = "";
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.imageview_detail_ebook)
  ImageView imageviewDetailEbook;
  @BindView(R.id.textview_title_detal_ebook)
  TextView textviewTitleDetalEbook;
  @BindView(R.id.button_read_ebok_detail_ebook)
  Button buttonReadEbokDetailEbook;
  @BindView(R.id.web_view_description_ebook_detail)
  WebView webViewDescriptionEbookDetail;
  @BindView(R.id.textview_writer_detail_ebook)
  TextView textviewWriterDetailEbook;
  @BindView(R.id.textview_publisher_detail_ebook)
  TextView textviewPublisherDetailEbook;
  @BindView(R.id.textview_time_detail_ebook)
  TextView textviewTimeDetailEbook;
  @BindView(R.id.swipe_back_detail_ebook)
  SwipeBackLayout swipeBackDetailEbook;
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.imageview_share_general_toolbar_with_back_button)
  ImageView imageviewShareGeneralToolbarWithBackButton;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_ebook);
    ButterKnife.bind(this);
    setView();
  }

  private void setView() {
    title = getIntent().getStringExtra("name");
    image = getIntent().getStringExtra("image");
    description = getIntent().getStringExtra("description");
    link = getIntent().getStringExtra("link");
    publisher = getIntent().getStringExtra("publisher");
    time = getIntent().getStringExtra("time");
    writer = getIntent().getStringExtra("writer");
    textviewTitleDetalEbook.setText(title);
    textviewPublisherDetailEbook.setText(publisher);
    textviewTimeDetailEbook.setText(time);
    imageviewShareGeneralToolbarWithBackButton.setVisibility(View.VISIBLE);
    textviewWriterDetailEbook.setText(writer);
    textviewGeneralToolbarWithBackButton.setText("Deskripsi Ebook");
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888);
    Glide.with(getApplicationContext())
        .load(Server.BASE_API + image)
        .apply(options)
        .into(imageviewDetailEbook);
    webViewDescriptionEbookDetail.loadData(description, "text/html", "uutf/-8");
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    setSwipeBack();
    finish();
  }

  private void setSwipeBack() {
    swipeBackDetailEbook.setDirectionMode(SwipeBackLayout.FROM_LEFT);
    swipeBackDetailEbook.setMaskAlpha(125);
    swipeBackDetailEbook.setSwipeBackFactor(0.5f);
  }


  @OnClick(R.id.button_read_ebok_detail_ebook)
  public void onButtonReadEbokDetailEbookClicked() {
    startActivity(new Intent(getApplicationContext(), ReadEbook.class).putExtra("ebook", link));
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onButtonBackGeneralToolbarWithBackButtonClicked() {
    onBackPressed();
  }

  @OnClick(R.id.imageview_share_general_toolbar_with_back_button)
  public void onImageviewShareGeneralToolbarWithBackButtonClicked() {
    IntentUtil intentUtil = new IntentUtil(this);
    intentUtil.IntentShare("", share);
  }
}
