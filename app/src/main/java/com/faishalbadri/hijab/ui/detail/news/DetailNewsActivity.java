package com.faishalbadri.hijab.ui.detail.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.news.NewsItem;
import com.faishalbadri.hijab.di.DetailNewsRepositoryInject;
import com.faishalbadri.hijab.ui.detail.news.DetailNewsContract.DetailNewsView;
import com.faishalbadri.hijab.util.IntentUtil;
import com.faishalbadri.hijab.util.Singleton.DataServerProgress;
import com.faishalbadri.hijab.util.UserUtil;
import com.faishalbadri.hijab.util.server.Server;
import com.gw.swipeback.SwipeBackLayout;
import java.util.ArrayList;
import java.util.List;

public class DetailNewsActivity extends AppCompatActivity implements DetailNewsView {

  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.imageview_detail_news)
  ImageView imgDetailNews;
  @BindView(R.id.web_view_description_news_detail)
  WebView webViewDescriptionNewsDetail;
  @BindView(R.id.recyclerview_activity_news_detail)
  RecyclerView recyclerviewActivityNewsDetail;
  @BindView(R.id.swipe_back_detail_news)
  SwipeBackLayout swipeBackDetailNews;
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.imageview_share_general_toolbar_with_back_button)
  ImageView imageviewShareGeneralToolbarWithBackButton;
  DetailNewsPresenter detailNewsPresenter;
  DetailNewsAdapter detailNewsAdapter;
  ArrayList<NewsItem> resultItem;
  @BindView(R.id.layout_loading)
  RelativeLayout layoutLoading;
  @BindView(R.id.scrollview_detail_news)
  ScrollView scrollviewDetailNews;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  private String share = "";
  private String image, desc, id_news;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_news);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    setView();
    detailNewsPresenter.getView(id_news);
    detailNewsPresenter.getData(id_news);
  }

  private void setView() {
    detailNewsPresenter = new DetailNewsPresenter(
        DetailNewsRepositoryInject.provideToDetailNewsInject(this));
    detailNewsPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    detailNewsAdapter = new DetailNewsAdapter(this, resultItem);
    recyclerviewActivityNewsDetail.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerviewActivityNewsDetail.setAdapter(detailNewsAdapter);
    id_news = getIntent().getStringExtra("news_id");
    image = getIntent().getStringExtra("news_image");
    textviewGeneralToolbarWithBackButton.setText(R.string.text_pinky_hijab_news);
    webViewDescriptionNewsDetail
        .setOnTouchListener((v, event) -> (event.getAction() == MotionEvent.ACTION_MOVE));
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(500, 500);
    Glide.with(getApplicationContext())
        .load(Server.BASE_ASSETS + image)
        .apply(options)
        .into(imgDetailNews);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    setSwipeBack();
    finish();
  }

  private void setSwipeBack() {
    swipeBackDetailNews.setDirectionMode(SwipeBackLayout.FROM_LEFT);
    swipeBackDetailNews.setMaskAlpha(125);
    swipeBackDetailNews.setSwipeBackFactor(0.5f);
  }

  @Override
  public void onSuccessDetailNews(List<NewsItem> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    detailNewsAdapter.notifyDataSetChanged();
  }

  @Override
  public void onSuccesView(List<NewsItem> data, String msg) {
    for (int a = 0; a < data.size(); a++) {
      desc = data.get(a).getNewsDescription();
    }
    webViewDescriptionNewsDetail.loadDataWithBaseURL(null, "<style>img{display: inline;height: "
        + "auto;max-width: 100%;" + "}</style>" + desc, "text/html", "UTF-8", null);
    DataServerProgress.getInstance().onSuccesData(scrollviewDetailNews, layoutLoading);
  }

  @Override
  public void onError(String msg) {
    whenError();
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

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    layoutLoading.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
    whenError();
  }

  private void whenError() {
    DataServerProgress.getInstance().onErrorData(layoutNoInternetAcces, layoutLoading);
    if (DataServerProgress.getInstance().getStatus().equals("error")) {
      detailNewsPresenter.getData(id_news);
    }
  }
}
