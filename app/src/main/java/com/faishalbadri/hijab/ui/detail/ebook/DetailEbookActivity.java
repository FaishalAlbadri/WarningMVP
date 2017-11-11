package com.faishalbadri.hijab.ui.detail.ebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.util.Server;

public class DetailEbookActivity extends AppCompatActivity {

  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.imageview_ebook_detail)
  ImageView imageviewEbookDetail;
  @BindView(R.id.txt_ebook_title_detail)
  TextView txtEbookTitleDetail;
  @BindView(R.id.txt_ebook_description_detail)
  TextView txtEbookDescriptionDetail;
  String title, image, description, link;

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
    txtEbookTitleDetail.setText(title);
    txtEbookDescriptionDetail.setText(description);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888);
    Glide.with(getApplicationContext())
        .load(Server.BASE_IMG + image)
        .apply(options)
        .into(imageviewEbookDetail);
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onViewClicked() {
    onBackPressed();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
}
