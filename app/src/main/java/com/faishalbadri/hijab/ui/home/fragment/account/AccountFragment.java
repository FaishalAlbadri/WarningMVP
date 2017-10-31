package com.faishalbadri.hijab.ui.home.fragment.account;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoUser.UserBean;
import com.faishalbadri.hijab.di.AccountRepositoryInject;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountContract.accoutView;
import com.faishalbadri.hijab.util.Server;
import com.faishalbadri.hijab.util.SessionManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements accoutView {


  @BindView(R.id.img_user_account)
  ImageView imgUserAccount;
  @BindView(R.id.img_edit_photo_account)
  ImageView imgEditPhotoAccount;
  @BindView(R.id.txt_username_user_account)
  TextView txtUsernameUserAccount;
  @BindView(R.id.txt_email_user_account)
  TextView txtEmailUserAccount;
  @BindView(R.id.btn_logout_account)
  Button btnLogoutAccount;
  ProgressDialog pd;

  public AccountFragment() {
    // Required empty public constructor
  }

  public static AccountFragment instance(){
    return new AccountFragment();
  }
  AccountPresenter accountPresenter;
  SessionManager sessionAccount;
  private static final String save = "save";
  String email;
  Button myButton;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_account, container, false);
    ButterKnife.bind(this, view);
    pd = new ProgressDialog(getActivity());
    pd.setMessage("Loading");
    pd.setCanceledOnTouchOutside(false);
    pd.setCancelable(false);
    pd.show();
    setView();
    if (savedInstanceState != null) {
      ArrayList<UserBean> resultArray = savedInstanceState.getParcelableArrayList(save);
    } else {
      accountPresenter.getDataAccount(email);
    }
    return view;
  }

  private void logout() {
    sessionAccount.logout();
    getActivity().finish();
  }

  private void setView() {
    sessionAccount = new SessionManager(getActivity());
    HashMap<String, String> user = sessionAccount.getUserDetails();
    email = user.get(SessionManager.key_email);
    txtEmailUserAccount.setText(email);
    accountPresenter = new AccountPresenter(
        AccountRepositoryInject.provideToLoginRepository(getActivity()));
    accountPresenter.onAttachView(this);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override
  public void onSuccesAccount(List<UserBean> user, String username, String image) {
    txtUsernameUserAccount.setText(username);
    RequestOptions options = new RequestOptions().circleCrop().format(
        DecodeFormat.PREFER_ARGB_8888).override(200, 200);
    Glide.with(getActivity())
        .load(Server.BASE_IMG + image)
        .apply(options)
        .into(imgUserAccount);
    pd.dismiss();
  }

  @Override
  public void onErrorAccount(String msg) {
    pd.dismiss();
    Toast.makeText(getActivity(), "Internal Server Error", Toast.LENGTH_SHORT).show();
  }


  @OnClick(R.id.btn_logout_account)
  public void onViewClicked() {
    logout();
  }
}
