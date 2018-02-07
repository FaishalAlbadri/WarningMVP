package com.faishalbadri.hijab.ui.change.password;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.di.ChangePasswordRepositoryInject;
import com.faishalbadri.hijab.ui.change.password.PasswordContract.PasswordView;
import com.faishalbadri.hijab.util.SessionManager;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangePasswordFragment extends Fragment implements PasswordView {


  private static final String errorCurrentPassword = "Current password is empty";
  private static final String errorNewPassword = "New password is empty";
  private static final String errorConfirmPassword = "Confirm password is empty";
  @BindView(R.id.materialedittext_current_password)
  MaterialEditText materialedittextCurrentPassword;
  @BindView(R.id.materialedittext_new_password)
  MaterialEditText materialedittextNewPassword;
  @BindView(R.id.materialedittext_confirm_password)
  MaterialEditText materialedittextConfirmPassword;
  @BindView(R.id.button_change_password)
  Button buttonChangePassword;
  PasswordPresenter passwordPresenter;
  private String currentPassword, newPassword, confirmPassword;
  private ProgressDialog pd;
  private SessionManager sessionManager;

  public ChangePasswordFragment() {
    // Required empty public constructor
  }

  public static ChangePasswordFragment instance() {
    return new ChangePasswordFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_change_password, container, false);
    setView();
    ButterKnife.bind(this, v);
    return v;
  }

  private void setView() {
    passwordPresenter = new PasswordPresenter(
        ChangePasswordRepositoryInject.provideToRepositoryInject(getActivity()));
    passwordPresenter.onAttachView(this);
    pd = new ProgressDialog(getActivity());
    pd.setMessage("Loading");
    pd.setCancelable(false);
    pd.setCanceledOnTouchOutside(false);
    sessionManager = new SessionManager(getActivity());
  }

  @Override
  public void onResponse(String msg) {
    pd.dismiss();
    if (msg.equals("succes")) {
      sessionManager.editPassword(newPassword);
      getActivity().onBackPressed();
      Toast.makeText(getActivity(), "Succes", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(getActivity(), "Request failed\nCheck your internet connection",
          Toast.LENGTH_SHORT).show();
    }

  }


  @OnClick(R.id.button_change_password)
  public void onViewClicked() {
    checkInputDataIsEmpty();
  }

  private void checkInputDataIsEmpty() {
    currentPassword = materialedittextCurrentPassword.getText().toString();
    newPassword = materialedittextNewPassword.getText().toString();
    confirmPassword = materialedittextConfirmPassword.getText().toString();

    if (currentPassword.isEmpty() && newPassword.isEmpty() && confirmPassword.isEmpty()) {
      materialedittextCurrentPassword.setError(errorCurrentPassword);
      materialedittextNewPassword.setError(errorNewPassword);
      materialedittextConfirmPassword.setError(errorConfirmPassword);
      materialedittextCurrentPassword.requestFocus();
      materialedittextNewPassword.requestFocus();
      materialedittextConfirmPassword.requestFocus();
    } else if (!currentPassword.isEmpty() && !newPassword.isEmpty() && confirmPassword.isEmpty()) {
      materialedittextConfirmPassword.setError(errorConfirmPassword);
      materialedittextConfirmPassword.requestFocus();
    } else if (!currentPassword.isEmpty() && newPassword.isEmpty() && !confirmPassword.isEmpty()) {
      materialedittextNewPassword.setError(errorNewPassword);
      materialedittextNewPassword.requestFocus();
    } else if (currentPassword.isEmpty() && !newPassword.isEmpty() && !confirmPassword.isEmpty()) {
      materialedittextCurrentPassword.setError(errorCurrentPassword);
      materialedittextCurrentPassword.requestFocus();
    } else if (!currentPassword.isEmpty() && newPassword.isEmpty() && confirmPassword.isEmpty()) {
      materialedittextNewPassword.setError(errorNewPassword);
      materialedittextConfirmPassword.setError(errorConfirmPassword);
      materialedittextNewPassword.requestFocus();
      materialedittextConfirmPassword.requestFocus();
    } else if (currentPassword.isEmpty() && !newPassword.isEmpty() && confirmPassword.isEmpty()) {
      materialedittextCurrentPassword.setError(errorCurrentPassword);
      materialedittextConfirmPassword.setError(errorConfirmPassword);
      materialedittextCurrentPassword.requestFocus();
      materialedittextConfirmPassword.requestFocus();
    } else if (currentPassword.isEmpty() && newPassword.isEmpty() && !confirmPassword.isEmpty()) {
      materialedittextCurrentPassword.setError(errorCurrentPassword);
      materialedittextNewPassword.setError(errorNewPassword);
      materialedittextCurrentPassword.requestFocus();
      materialedittextNewPassword.requestFocus();
    } else {
      pd.show();
      checkInputDataPassword();
    }
  }

  private void checkInputDataPassword() {
    currentPassword = Server.convertPassMd5(currentPassword);
    if (!currentPassword.equals(DataUser.getInstance().getUserPassword()) && !newPassword
        .equals(confirmPassword)) {
      pd.dismiss();
      materialedittextCurrentPassword.setError("Password Salah");
      materialedittextConfirmPassword.setError("Password Tidak Cocok");
      materialedittextCurrentPassword.requestFocus();
      materialedittextConfirmPassword.requestFocus();
    } else if (currentPassword.equals(DataUser.getInstance().getUserPassword()) && !newPassword
        .equals(confirmPassword)) {
      pd.dismiss();
      materialedittextConfirmPassword.setError("Password Tidak Cocok");
      materialedittextConfirmPassword.requestFocus();
    } else if (!currentPassword.equals(DataUser.getInstance().getUserPassword()) && newPassword
        .equals(confirmPassword)) {
      pd.dismiss();
      materialedittextCurrentPassword.setError("Password Salah");
      materialedittextCurrentPassword.requestFocus();
    } else {
      newPassword = Server.convertPassMd5(newPassword);
      passwordPresenter.getPassword(newPassword);
    }
  }

}
