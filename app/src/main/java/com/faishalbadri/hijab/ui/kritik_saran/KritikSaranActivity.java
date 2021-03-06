package com.faishalbadri.hijab.ui.kritik_saran;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
  @BindView(R.id.layout_kritik_saran)
  ConstraintLayout layoutKritikSaran;
  @BindView(R.id.layout_succes)
  ConstraintLayout layoutSucces;
  private String edittextValue;
  private Handler handler;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kritik_saran);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    handler = new Handler();
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
      Toast.makeText(this, "Tolong Masukkan Data", Toast.LENGTH_SHORT).show();
    } else {
      edittextValue = edittextKritikSaran.getText().toString();
      Intent send = new Intent(Intent.ACTION_SENDTO);
      String uriText = "mailto:" + Uri.encode(EMAIL_DEVELOPER) +
          "?subject=" + Uri.encode(SUBJECT_EMAIL) +
          "&body=" + Uri.encode(edittextValue);
      Uri uri = Uri.parse(uriText);
      send.setData(uri);
      handler.postDelayed(() -> {
        layoutKritikSaran.setVisibility(View.GONE);
        layoutSucces.setVisibility(View.VISIBLE);
      }, 3000);
      startActivity(Intent.createChooser(send, "Send Email..."));
    }
  }
}
