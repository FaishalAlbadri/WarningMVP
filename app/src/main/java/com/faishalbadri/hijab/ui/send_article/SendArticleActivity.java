package com.faishalbadri.hijab.ui.send_article;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;

public class SendArticleActivity extends AppCompatActivity {

  @BindView(R.id.textview_general_toolbar_with_button)
  TextView textviewGeneralToolbarWithButton;
  @BindView(R.id.button_send_general_toolbar_with_button)
  ImageView buttonSendGeneralToolbarWithButton;
  @BindView(R.id.edittext_send_article)
  EditText edittextSendArticle;
  String edittextValue;
  private static final String EMAIL_DEVELOPER = "pinkyhijabdeveloper@gmail.com";
  private static final String SUBJECT_EMAIL = "This is my article";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_send_article);
    ButterKnife.bind(this);
    textviewGeneralToolbarWithButton.setText(R.string.text_send_article);
  }

  @OnClick(R.id.button_send_general_toolbar_with_button)
  public void onViewClicked() {
    if (edittextSendArticle.getText().toString().equals("")) {
      Toast.makeText(this, "Please input data", Toast.LENGTH_SHORT).show();
    } else {
      edittextValue = edittextSendArticle.getText().toString();
      Intent send = new Intent(Intent.ACTION_SENDTO);
      String uriText = "mailto:" + Uri.encode(EMAIL_DEVELOPER) +
          "?subject=" + Uri.encode(SUBJECT_EMAIL) +
          "&body=" + Uri.encode(edittextValue);
      Uri uri = Uri.parse(uriText);
      send.setData(uri);
      startActivity(Intent.createChooser(send, "Send Email..."));
    }
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
}
