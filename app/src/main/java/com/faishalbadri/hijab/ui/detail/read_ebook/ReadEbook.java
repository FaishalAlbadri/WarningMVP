package com.faishalbadri.hijab.ui.detail.read_ebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.util.UserUtil;
import com.faishalbadri.hijab.util.server.Server;

public class ReadEbook extends AppCompatActivity {

  @BindView(R.id.web_view_read_ebook)
  WebView webViewReadEbook;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_read_ebook);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    String ebook =
        "http://docs.google.com/gview?embedded=true&url=" + Server.BASE_ASSETS + getIntent()
        .getStringExtra("ebook");
    webViewReadEbook.setWebViewClient(new WebViewClient());
    webViewReadEbook.getSettings().setJavaScriptEnabled(true);
    webViewReadEbook.getSettings().setPluginState(WebSettings.PluginState.ON);
    webViewReadEbook.getSettings().setAllowFileAccess(true);
    webViewReadEbook.loadUrl(ebook);
  }
}
