package com.faishalbadri.hijab.ui.kritik_saran;

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
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.util.UserUtil;

public class KritikSaranActivity extends AppCompatActivity {

  private static final String EMAIL_DEVELOPER = "pinkyhijabdeveloper@gmail.com";
  private static final String SUBJECT_EMAIL = "Saran";
  @BindView(R.id.textview_general_toolbar_with_button)
  TextView textviewGeneralToolbarWithButton;
  @BindView(R.id.button_send_general_toolbar_with_button)
  ImageView buttonSendGeneralToolbarWithButton;
  @BindView(R.id.edittext_kritik_saran)
  EditText edittextKritikSaran;
  private String edittextValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kritik_saran);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    textviewGeneralToolbarWithButton.setText(R.string.text_other_kritik_saran);
  }

  @OnClick(R.id.button_send_general_toolbar_with_button)
  public void onButtonSendGeneralToolbarWithButtonClicked() {
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

  @Override
  public void onBackPressed() {
    startActivity(
        new Intent(getApplicationContext(), HomeActivity.class).putExtra("session_home", "1"));
    finish();
  }
}
