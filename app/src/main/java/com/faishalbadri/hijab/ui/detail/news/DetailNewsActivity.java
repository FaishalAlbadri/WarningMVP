package com.faishalbadri.hijab.ui.detail.news;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.di.DetailNewsRepositoryInject;
import com.faishalbadri.hijab.ui.detail.news.DetailNewsContract.DetailNewsView;
import com.faishalbadri.hijab.util.IntentUtil;
import com.faishalbadri.hijab.util.Server;
import com.gw.swipeback.SwipeBackLayout;
import java.util.ArrayList;
import java.util.List;

public class DetailNewsActivity extends AppCompatActivity implements DetailNewsView {

  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.txt_title_news_detail)
  TextView txtTitleNewsDetail;
  @BindView(R.id.img_detail_news)
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
  private String title, image, desc;
  private static final String SAVE_DATA_NEWS_DETAIL = "save";
  DetailNewsPresenter detailNewsPresenter;
  DetailNewsAdapter detailNewsAdapter;
  ArrayList<IsiBean> resultItem;
  String share = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_news);
    ButterKnife.bind(this);
    setView();
    if (savedInstanceState != null) {
      ArrayList<IsiBean> resultArray = savedInstanceState
          .getParcelableArrayList(SAVE_DATA_NEWS_DETAIL);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      detailNewsAdapter.notifyDataSetChanged();
    } else {
      detailNewsPresenter.getData();
    }
  }

  private void setView() {
    detailNewsPresenter = new DetailNewsPresenter(
        DetailNewsRepositoryInject.provideToDetailNewsInject(this));
    detailNewsPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    detailNewsAdapter = new DetailNewsAdapter(this, resultItem);
    recyclerviewActivityNewsDetail.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerviewActivityNewsDetail.setAdapter(detailNewsAdapter);
    title = getIntent().getStringExtra("title");
    image = getIntent().getStringExtra("image");
    desc = getIntent().getStringExtra("desc");
    txtTitleNewsDetail.setText(title);
    imageviewShareGeneralToolbarWithBackButton.setVisibility(View.VISIBLE);
    textviewGeneralToolbarWithBackButton.setText(R.string.text_pinky_hijab_news);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888)
        .override(500, 500);
    Glide.with(getApplicationContext())
        .load(Server.BASE_IMG + image)
        .apply(options)
        .into(imgDetailNews);
    webViewDescriptionNewsDetail.loadData(desc, "text/html", "uutf/-8");
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(SAVE_DATA_NEWS_DETAIL, resultItem);
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
  public void onSuccessDetailNews(List<IsiBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    detailNewsAdapter.notifyDataSetChanged();
  }

  @Override
  public void onError(String msg) {
    Toast.makeText(this, "check your internet connection", Toast.LENGTH_SHORT).show();
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
