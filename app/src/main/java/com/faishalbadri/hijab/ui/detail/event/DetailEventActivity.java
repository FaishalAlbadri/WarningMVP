package com.faishalbadri.hijab.ui.detail.event;

import android.content.Intent;
import android.net.Uri;
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
import com.faishalbadri.hijab.util.IntentUtil;
import com.faishalbadri.hijab.util.server.Server;
import com.gw.swipeback.SwipeBackLayout;

public class DetailEventActivity extends AppCompatActivity {

  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.imageview_detail_event)
  ImageView imageviewDetailEvent;
  @BindView(R.id.textview_title_detail_event)
  TextView textviewTitleDetailEvent;
  @BindView(R.id.textview_place_time_event_detail)
  TextView textviewPlaceTimeEventDetail;
  @BindView(R.id.web_view_description_event_detail)
  WebView webViewDescriptionEventDetail;
  @BindView(R.id.button_register_detail_event)
  Button buttonRegisterDetailEvent;
  String title, time, place, image, desc, link;
  @BindView(R.id.swipe_back_detail_event)
  SwipeBackLayout swipeBackDetailEvent;
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.imageview_share_general_toolbar_with_back_button)
  ImageView imageviewShareGeneralToolbarWithBackButton;
  String share = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_event);
    ButterKnife.bind(this);
    set();

  }

  private void set() {
    title = getIntent().getStringExtra("title");
    time = getIntent().getStringExtra("time");
    place = getIntent().getStringExtra("place");
    image = getIntent().getStringExtra("image");
    desc = getIntent().getStringExtra("desc");
    link = getIntent().getStringExtra("link");
    if (!link.startsWith("http://") || !link.startsWith("https://")) {
      link = "http://" + link;
    }
    textviewGeneralToolbarWithBackButton.setText("Deskripsi Event");
    textviewTitleDetailEvent.setText(title);
    textviewPlaceTimeEventDetail.setText(place + ", " + time);
    imageviewShareGeneralToolbarWithBackButton.setVisibility(View.VISIBLE);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888);
    Glide.with(getApplicationContext())
        .load(Server.BASE_API + image)
        .apply(options)
        .into(imageviewDetailEvent);
    webViewDescriptionEventDetail.loadData(desc, "text/html", "uutf/-8");
  }


  @OnClick(R.id.button_register_detail_event)
  public void onButtonRegisterDetailEventClicked() {
    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
    startActivity(browserIntent);
  }

  private void setSwipeBack() {
    swipeBackDetailEvent.setDirectionMode(SwipeBackLayout.FROM_LEFT);
    swipeBackDetailEvent.setMaskAlpha(125);
    swipeBackDetailEvent.setSwipeBackFactor(0.5f);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    setSwipeBack();
    finish();
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
