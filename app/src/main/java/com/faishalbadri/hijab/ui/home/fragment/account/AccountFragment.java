package com.faishalbadri.hijab.ui.home.fragment.account;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoUser;
import com.faishalbadri.hijab.data.PojoUser.UserBean;
import com.faishalbadri.hijab.di.AccountRepositoryInject;
import com.faishalbadri.hijab.util.Server;
import com.faishalbadri.hijab.util.SessionManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements AccountContract.accoutView{


  public AccountFragment() {
    // Required empty public constructor
  }
  AccountPresenter accountPresenter;
  SessionManager sessionAccount;
  private static final String save = "save";
  String email;
  TextView txtEmailProfile,txtUsernameProfile;
  ImageView imgUserProfile;
  Button btnLogout;
  Context context;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_account, container, false);
    sessionAccount = new SessionManager(getActivity());
    HashMap<String, String> user = sessionAccount.getUserDetails();
    email = user.get(SessionManager.key_email);
    txtEmailProfile = v.findViewById(R.id.txt_email_detail_user_profile);
    txtUsernameProfile = v.findViewById(R.id.txt_nama_detail_user_profile);
    imgUserProfile = v.findViewById(R.id.img_detail_user_profile);
    btnLogout = v.findViewById(R.id.btn_logout);
    btnLogout.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        logout();
      }
    });
    txtEmailProfile.setText(email);
    accountPresenter = new AccountPresenter(AccountRepositoryInject.provideToLoginRepository(getActivity()));
    accountPresenter.onAttachView(this);
    if (savedInstanceState != null){
      ArrayList<PojoUser.UserBean> resultArray = savedInstanceState.getParcelableArrayList(save);
    }else{
      accountPresenter.getDataAccount(email);
    }
    return v;
  }
  private void logout() {
    sessionAccount.logout();
    ((Activity) context ).finish();
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override
  public void onSuccesAccount(List<UserBean> user, String username, String image) {
    txtUsernameProfile.setText(username);
    RequestOptions options = new RequestOptions().circleCrop().format(
        DecodeFormat.PREFER_ARGB_8888).override(200, 200);
    Glide.with(getActivity())
        .load(Server.BASE_IMG + image)
        .apply(options)
        .into(imgUserProfile);
  }

  @Override
  public void onErrorAccount(String msg) {
    Toast.makeText(getActivity(), "Internal Server Error", Toast.LENGTH_SHORT).show();
  }
}
