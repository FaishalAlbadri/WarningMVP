package com.faishalbadri.hijab.ui.kritik_saran;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.util.UserUtil;

public class KritikSaranActivity extends AppCompatActivity {

  private static final String EMAIL_DEVELOPER = "pinkfameapp@gmail.com";
  private static final String SUBJECT_EMAIL = "Saran";
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBack;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView titleText;
  @BindView(R.id.edittext_kritik_saran)
  EditText edittextKritikSaran;
  @BindView(R.id.button_send_feedback)
  Button buttonSendFeedback;
  private String edittextValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kritik_saran);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    titleText.setText(R.string.text_other_kritik_saran);
  }

  @Override
  public void onBackPressed() {
    startActivity(
        new Intent(getApplicationContext(), HomeActivity.class).putExtra("session_home", "1"));
    finish();
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onButtonBackClicked() {
    onBackPressed();
  }

  @OnClick(R.id.button_send_feedback)
  public void onButtonSendFeedbackClicked() {
    if (edittextKritikSaran.getText().toString().equals("")) {
      Toast.makeText(this, "Please input data", Toast.LENGTH_SHORT).show();
    } else {
      edittextValue = edittextKritikSaran.getText().toString();
      Intent send = new Intent(Intent.ACTION_SENDTO);
      String uriText = "mailto:" + Uri.encode(EMAIL_DEVELOPER) +
          "?subject=" + Uri.encode(SUBJECT_EMAIL) +
          "&body=" + Uri.encode(edittextValue);
      Uri uri = Uri.parse(uriText);
      send.setData(uri);
      startActivity(Intent.createChooser(send, "Send Email..."));
    }
  }
}
