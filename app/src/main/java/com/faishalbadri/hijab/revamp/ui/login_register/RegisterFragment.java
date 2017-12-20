package com.faishalbadri.hijab.revamp.ui.login_register;


import android.app.ProgressDialog;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
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
import com.faishalbadri.hijab.revamp.di.RegisterRepositoryInject;
import com.faishalbadri.hijab.revamp.util.SendMail;
import com.faishalbadri.hijab.revamp.util.Server;
import com.rengwuxian.materialedittext.MaterialEditText;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements RegisterContract.registerView {


  @BindView(R.id.materialedittext_username_fragment_register)
  MaterialEditText materialedittextUsernameFragmentRegister;
  @BindView(R.id.materialedittext_email_fragment_register)
  MaterialEditText materialedittextEmailFragmentRegister;
  @BindView(R.id.materialedittext_password_fragment_register)
  MaterialEditText materialedittextPasswordFragmentRegister;
  @BindView(R.id.button_register_fragment_register)
  Button buttonRegisterFragmentRegister;
  RegisterPresenter registerPresenter;
  String username, email, password, verify_code;
  ProgressDialog pd;


  public RegisterFragment() {
    // Required empty public constructor
  }

  public static RegisterFragment instance() {
    return new RegisterFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_register, container, false);
    ButterKnife.bind(this, view);
    pd = new ProgressDialog(getActivity());
    pd.setMessage("Loading");
    pd.setCanceledOnTouchOutside(false);
    pd.setCancelable(false);
    registerPresenter = new RegisterPresenter(
        RegisterRepositoryInject.provideToRegisterRepository(getActivity()));
    registerPresenter.onAttachView(this);
    if (VERSION.SDK_INT >= VERSION_CODES.M) {
      buttonRegisterFragmentRegister.setForeground(getSelectedItemDrawable());
    }
    buttonRegisterFragmentRegister.setClickable(true);
    buttonRegisterFragmentRegister.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        registerOnClick();
      }
    });

    return view;
  }

  private void registerOnClick() {
    materialedittextUsernameFragmentRegister.setError(null);
    materialedittextEmailFragmentRegister.setError(null);
    materialedittextPasswordFragmentRegister.setError(null);
    if (Server.isEmpty(materialedittextUsernameFragmentRegister) && Server
        .isEmpty(materialedittextEmailFragmentRegister) && Server
        .isEmpty(materialedittextPasswordFragmentRegister)) {
      materialedittextUsernameFragmentRegister.setError("Username tidak boleh kosong");
      materialedittextEmailFragmentRegister.setError("Email tidak boleh kosong");
      materialedittextPasswordFragmentRegister.setError("Password tidak boleh kosong");
      materialedittextUsernameFragmentRegister.requestFocus();
      materialedittextEmailFragmentRegister.requestFocus();
      materialedittextPasswordFragmentRegister.requestFocus();
    } else if (Server.isEmpty(materialedittextUsernameFragmentRegister)) {
      materialedittextUsernameFragmentRegister.setError("Username tidak boleh kosong");
      materialedittextUsernameFragmentRegister.requestFocus();
    } else if (Server.isEmpty(materialedittextEmailFragmentRegister)) {
      materialedittextEmailFragmentRegister.setError("Email tidak boleh kosong");
      materialedittextEmailFragmentRegister.requestFocus();
    } else if (Server.isEmpty(materialedittextPasswordFragmentRegister)) {
      materialedittextPasswordFragmentRegister.setError("Password tidak boleh kosong");
      materialedittextPasswordFragmentRegister.requestFocus();
    } else {
      pd.show();
      username = materialedittextUsernameFragmentRegister.getText().toString();
      email = materialedittextEmailFragmentRegister.getText().toString();
      password = materialedittextPasswordFragmentRegister.getText().toString();
      DateFormat df = new SimpleDateFormat("ssmmHH");
      verify_code = df.format(Calendar.getInstance().getTime());
      registerPresenter.getDataRegister(username, email, password, verify_code);
    }
  }

  @Override
  public void onSuccesRegister(String msg) {
    sendMail();
    pd.dismiss();
    Toast.makeText(getActivity(), "Anda telah terdaftar\nSilahkan Login", Toast.LENGTH_SHORT)
        .show();
  }

  @Override
  public void onWrongRegister(String msg) {
    pd.dismiss();
  }

  @Override
  public void onErrorRegister(String msg) {
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

  private void sendMail() {
    String subject = "Your Verification Account Key From Pink Muslimah";
    String message = "Your verification code : " + verify_code;
    SendMail sm = new SendMail(getActivity(), email, subject, message);
    sm.execute();
  }

}
