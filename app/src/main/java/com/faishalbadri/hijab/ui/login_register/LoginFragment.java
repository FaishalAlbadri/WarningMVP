package com.faishalbadri.hijab.ui.login_register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.di.LoginRepositoryInject;
import com.faishalbadri.hijab.util.Server;
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

  public LoginFragment() {
    // Required empty public constructor
  }

  public static LoginFragment instance(){
    return new LoginFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_login, container, false);
    ButterKnife.bind(this, view);

    loginPresenter = new LoginPresenter(
        LoginRepositoryInject.provideToLoginRepository(getActivity()));
    loginPresenter.onAttachView(this);

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
      email = materialedittextEmailFragmentLogin.getText().toString();
      password = materialedittextPasswordFragmentLogin.getText().toString();
      loginPresenter.getDataLogin(email, password);
    }
  }

  @Override
  public void onSuccesLogin(String msg) {
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorLogin(String msg) {
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }
}
