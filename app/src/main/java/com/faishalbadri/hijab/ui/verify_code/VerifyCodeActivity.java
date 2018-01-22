package com.faishalbadri.hijab.ui.verify_code;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.di.VerifyCodeRepositoryInject;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.util.SessionManager;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.widget.PinEntryEditText;

public class VerifyCodeActivity extends AppCompatActivity implements
    VerifyCodeContract.VerifyCodeView {

  @BindView(R.id.edittext_verify_code)
  PinEntryEditText edittextVerifyCode;
  @BindView(R.id.button_next_verify_code)
  Button buttonNextVerifyCode;
  private String user_verify_code;
  private String user_verified_code;
  private ProgressDialog pd;
  private VerifyCodePresenter verifyCodePresenter;
  private SessionManager sessionManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verify_code);
    ButterKnife.bind(this);
    user_verify_code = DataUser.getInstance().getUserVerifyCode();
    user_verified_code = DataUser.getInstance().getUserVerifiedCode();
    if (user_verified_code != null) {
      startActivity(new Intent(getApplicationContext(), HomeActivity.class));
      finish();
    }

    setView();
  }

  private void setView() {
    if (VERSION.SDK_INT >= VERSION_CODES.M) {
      buttonNextVerifyCode.setForeground(getSelectedItemDrawable());
    }
    sessionManager = new SessionManager(VerifyCodeActivity.this);
    pd = new ProgressDialog(this);
    pd.setMessage("Loading");
    pd.setCancelable(false);
    pd.setCanceledOnTouchOutside(false);
    verifyCodePresenter = new VerifyCodePresenter(
        VerifyCodeRepositoryInject.provideToRepository(getApplicationContext()));
    verifyCodePresenter.onAttachView(this);
  }

  @OnClick(R.id.button_next_verify_code)
  public void onViewClicked() {
    pd.show();
    if (edittextVerifyCode.getText().toString().equals(user_verify_code)) {
      verifyCodePresenter.getDataVerifyCode();
    } else {
      Toast.makeText(VerifyCodeActivity.this, "Code salah", Toast.LENGTH_SHORT).show();
      pd.dismiss();
    }
  }

  @Override
  public void onSuccesVerifyCode(String msg) {
    sessionManager.editVerifiedCode(user_verify_code);
    pd.dismiss();
  }

  @Override
  public void onErrorVerifyCode(String msg) {
    pd.dismiss();
    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = getApplicationContext().obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }
}
