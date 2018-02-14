package com.faishalbadri.hijab.ui.contact_us;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import java.util.ArrayList;
import java.util.List;

public class ContactUsActivity extends AppCompatActivity {

  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBack;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewTitle;
  @BindView(R.id.recyclerview_contanct_us)
  RecyclerView recyclerviewContanctUs;
  List<ContactUsData> contactUsData;
  ContactUsAdapter aboutAdapter;
  @BindView(R.id.layout_web)
  LinearLayout layoutWeb;
  @BindView(R.id.layout_email)
  LinearLayout layoutEmail;
  @BindView(R.id.layout_whatsapp)
  LinearLayout layoutWhatsapp;
  private int image[];
  private String caption[];

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_us);
    ButterKnife.bind(this);
    setView();
    setString();
  }

  private void setString() {
    image = new int[]{
        R.drawable.text_pink_fame_white, R.drawable.ic_collaborate, R.drawable.ic_donations,
        R.drawable.ic_story, R.drawable.ic_promotion,
    };

    caption = new String[]{
        getString(R.string.caption_pinkfame_contact_us), getString(R.string.caption_one_contact_us),
        getString(R.string.caption_two_contact_us), getString(R.string.caption_three_contact_us),
        getString(R.string.caption_four_contact_us), getString(R.string.caption_five_contact_us),
    };
    contactUsData.add(new ContactUsData(caption[0], image[0]));
    contactUsData.add(new ContactUsData(caption[1], image[1]));
    contactUsData.add(new ContactUsData(caption[2], image[2]));
    contactUsData.add(new ContactUsData(caption[3], image[3]));
    contactUsData.add(new ContactUsData(caption[4], image[4]));
    contactUsData.add(new ContactUsData(caption[5], image[4]));
  }

  private void setView() {
    textviewTitle.setText(getString(R.string.text_other_contact_us));
    contactUsData = new ArrayList<>();
    aboutAdapter = new ContactUsAdapter(this, contactUsData);
    recyclerviewContanctUs.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewContanctUs.setAdapter(aboutAdapter);
    recyclerviewContanctUs.setNestedScrollingEnabled(false);
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onViewClicked() {
    onBackPressed();
  }

  @Override
  public void onBackPressed() {
    startActivity(
        new Intent(getApplicationContext(), HomeActivity.class).putExtra("session_home", "1"));
    finish();
  }

  @OnClick(R.id.layout_web)
  public void onLayoutWebClicked() {
    setClipboard("http://www.pinkfame.com");
  }

  @OnClick(R.id.layout_email)
  public void onLayoutEmailClicked() {
    setClipboard("pinkfame@gmail.com");
  }

  @OnClick(R.id.layout_whatsapp)
  public void onLayoutWhatsappClicked() {
    setClipboard("+6281218053852");
  }

  private void setClipboard(String text) {
    Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_SHORT).show();
    if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
      android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(
          Context.CLIPBOARD_SERVICE);
      clipboard.setText(text);
    } else {
      android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(
          Context.CLIPBOARD_SERVICE);
      android.content.ClipData clip = android.content.ClipData
          .newPlainText("Text copied to clipboard", text);
      clipboard.setPrimaryClip(clip);
    }
  }
}
