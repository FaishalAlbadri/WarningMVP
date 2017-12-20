package com.faishalbadri.hijab.revamp.ui.login_register;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.revamp.di.LoginRepositoryInject;
import com.faishalbadri.hijab.revamp.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.revamp.util.Server;
import com.faishalbadri.hijab.revamp.util.SessionManager;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.loginView {


  @BindView(R.id.materialedittext_email_fragment_login)
  MaterialEditText materialedittextEmailFragmentLogin;
  @BindView(R.id.materialedittext_password_fragment_login)
  MaterialEditText materialedittextPasswordFragmentLogin;
  @BindView(R.id.button_login_fragment_login)
  Button buttonLoginFragmentLogin;
  LoginPresenter loginPresenter;
  String email, password;
  SessionManager sessionManagerLogin;
  ProgressDialog pd;

  public LoginFragment() {
    // Required empty public constructor
  }

  public static LoginFragment instance() {
    return new LoginFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_login, container, false);
    ButterKnife.bind(this, view);
    sessionManagerLogin = new SessionManager(getActivity());
    pd = new ProgressDialog(getActivity());
    pd.setMessage("Loading");
    pd.setCancelable(false);
    pd.setCanceledOnTouchOutside(false);
    loginPresenter = new LoginPresenter(
        LoginRepositoryInject.provideToLoginRepository(getActivity()));
    loginPresenter.onAttachView(this);
    if (VERSION.SDK_INT >= VERSION_CODES.M) {
      buttonLoginFragmentLogin.setForeground(getSelectedItemDrawable());
    }
    buttonLoginFragmentLogin.setClickable(true);
    buttonLoginFragmentLogin.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        loginOnClick();
      }
    });

    return view;
  }

  private void loginOnClick() {
    materialedittextEmailFragmentLogin.setError(null);
    materialedittextPasswordFragmentLogin.setError(null);
    if (Server.isEmpty(materialedittextEmailFragmentLogin) && Server
        .isEmpty(materialedittextPasswordFragmentLogin)) {
      materialedittextEmailFragmentLogin.setError("Email tidak boleh kosong");
      materialedittextPasswordFragmentLogin.setError("Password tidak boleh kosong");
      materialedittextEmailFragmentLogin.requestFocus();
      materialedittextPasswordFragmentLogin.requestFocus();
    } else if (Server.isEmpty(materialedittextEmailFragmentLogin)) {
      materialedittextEmailFragmentLogin.setError("Email tidak boleh kosong");
      materialedittextEmailFragmentLogin.requestFocus();
    } else if (Server.isEmpty(materialedittextPasswordFragmentLogin)) {
      materialedittextPasswordFragmentLogin.setError("Password tidak boleh kosong");
      materialedittextPasswordFragmentLogin.requestFocus();
    } else {
      pd.show();
      email = materialedittextEmailFragmentLogin.getText().toString();
      password = materialedittextPasswordFragmentLogin.getText().toString();
      loginPresenter.getDataLogin(email, password);
    }
  }


  @Override
  public void onSuccesLogin(String msg, String id_user, String user_name, String user_email,
      String user_handphone_number, String user_image, String user_password,
      String user_verify_code, String user_verified_code, String user_gender, String user_apikey) {
    pd.dismiss();
    Log.i("OK",msg);
    sessionManagerLogin.createSession(id_user, user_name, user_email, user_handphone_number,
        user_image, password, user_verify_code, user_verified_code, user_gender, user_apikey);
    startActivity(new Intent(getActivity(), HomeActivity.class));
    getActivity().finish();
  }

  @Override
  public void onWrongLogin(String msg) {
    pd.dismiss();
  }

  @Override
  public void onErrorLogin(String msg) {
    pd.dismiss();
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = getActivity().obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

}
