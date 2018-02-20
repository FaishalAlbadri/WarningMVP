package com.faishalbadri.hijab.ui.send_article;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.di.SendArticleRepositoryInject;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.util.ActivityUtil;
import com.faishalbadri.hijab.util.UserUtil;
import com.faishalbadri.hijab.util.helper.FilePath;

public class SendArticleActivity extends AppCompatActivity implements
    SendArticleContract.uploadFileView {

  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBack;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textTitle;
  @BindView(R.id.textview_file_name)
  TextView textviewFileName;
  @BindView(R.id.button_choose_send_article)
  Button buttonChooseSendArticle;
  @BindView(R.id.button_send_article)
  Button buttonSendArticle;
  SendArticlePresenter sendArticlePresenter;
  //  private Bitmap bitmapAccount;
  ActivityUtil activityUtil;
  String mimetypes[] = {
      "application/msword",
      "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
  };
  private int PICK_IMAGE_REQUEST = 1;
  private Uri filePathSendArticle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_send_article);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    setView();
  }

  private void setView() {
    sendArticlePresenter = new SendArticlePresenter(
        SendArticleRepositoryInject.provideToSendArticleRepository(this));
    sendArticlePresenter.onAttachView(this);
    textTitle.setText(R.string.text_send_article);
    buttonBack.setOnClickListener(v -> onBackPressed());
    activityUtil = ActivityUtil.getInstance(this);
  }

  @Override
  public void onBackPressed() {
    startActivity(
        new Intent(getApplicationContext(), HomeActivity.class).putExtra("session_home", "1"));
    finish();
  }

  @OnClick(R.id.button_choose_send_article)
  public void onButtonChooseSendArticleClicked() {
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_GET_CONTENT);
//    intent.setType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    intent.setType("application/pdf");
    startActivityForResult(Intent.createChooser(intent, "Pilih Berkas"), PICK_IMAGE_REQUEST);
  }

  @OnClick(R.id.button_send_article)
  public void onButtonSendArticleClicked() {
    try {
      sendArticlePresenter.getUploadFile(FilePath.getPath(this, filePathSendArticle));
    } catch (Exception e) {

    }
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    try {
      if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null
          && data.getData() != null) {
        filePathSendArticle = data.getData();
      }
      textviewFileName.setText(FilePath.getPath(this, filePathSendArticle));
      textviewFileName.setVisibility(View.VISIBLE);
    } catch (Exception e) {

    }
  }

  @Override
  public void onSuccessUploadFile(ActivityUtil activityUtil) {

  }

  @Override
  public void onErrorUploadFile(String msg) {

  }
}
