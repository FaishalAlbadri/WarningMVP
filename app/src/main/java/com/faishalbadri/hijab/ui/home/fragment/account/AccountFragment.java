package com.faishalbadri.hijab.ui.home.fragment.account;


import static android.app.Activity.RESULT_OK;

import android.Manifest.permission;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
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
import com.faishalbadri.hijab.ui.home.fragment.account.AccountContract.editImageView;
import com.faishalbadri.hijab.util.ActivityUtil;
import com.faishalbadri.hijab.util.Server;
import com.faishalbadri.hijab.util.SessionManager;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements accoutView, editImageView {


  private static final int STORAGE_PERMISSION_CODE = 123;
  private static final String save = "save";
  @BindView(R.id.img_user_account)
  CircleImageView imgUserAccount;
  @BindView(R.id.img_edit_photo_account)
  ImageView imgEditPhotoAccount;
  @BindView(R.id.txt_username_user_account)
  TextView txtUsernameUserAccount;
  @BindView(R.id.txt_email_user_account)
  TextView txtEmailUserAccount;
  ProgressDialog pd;
  @BindView(R.id.btn_logout_account)
  Button btnLogoutAccount;
  Context context;
  ActivityUtil activityUtil;
  HashMap<String, String> user;
  AccountPresenter accountPresenter;
  EditImagePresenter editImagePresenter;
  SessionManager sessionAccount;
  private int PICK_IMAGE_REQUEST = 1;
  private String id, email, username, image;
  private Uri filePathAccount;
  private Bitmap bitmapAccount;
  public AccountFragment() {
    // Required empty public constructor
  }

  public static AccountFragment instance() {
    return new AccountFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_account, container, false);
    ButterKnife.bind(this, v);
    setView();
    requestStoragePermission();
    accountPresenter.getDataAccount(email);

    return v;
  }

  @Override
  public void onSuccesAccount(List<UserBean> user, String username, String image, String id) {
    this.id = id;
    RequestOptions options = new RequestOptions().circleCrop()
        .error(R.drawable.ic_account_circle_primary_color).format(
            DecodeFormat.PREFER_ARGB_8888).override(400, 400);
    Glide.with(getActivity())
        .load(Server.BASE_IMG + image)
        .apply(options)
        .into(imgUserAccount);
  }

  @Override
  public void onErrorAccount(String msg) {
    Toast.makeText(getActivity(), "Internal Server Error", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onSuccessEditImage(ActivityUtil activityUtil) {
    activityUtil.addFragment(getActivity().getSupportFragmentManager(),
        R.id.framelayout_for_fragment_activity_home, AccountFragment.instance());
  }

  @Override
  public void onErrorEditImage(String msg) {

  }

  private void logout() {
    sessionAccount.logout();
    getActivity().finish();
  }

  private void editPhoto() {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
  }

  private void setView() {
    sessionAccount = new SessionManager(getActivity());
    user = sessionAccount.getUserDetails();
    email = user.get(SessionManager.key_email);
    username = user.get(SessionManager.key_username);
    image = user.get(SessionManager.key_image);
    txtEmailUserAccount.setText(email);
    txtUsernameUserAccount.setText(username);

    if (VERSION.SDK_INT >= VERSION_CODES.M) {
      btnLogoutAccount.setForeground(getSelectedItemDrawable());
    }
    accountPresenter = new AccountPresenter(
        AccountRepositoryInject.provideToLoginRepository(getActivity()));
    accountPresenter.onAttachView(this);
    editImagePresenter = new EditImagePresenter(
        AccountRepositoryInject.provideToLoginRepository(getActivity()));
    editImagePresenter.onAttachView(this);
    activityUtil = ActivityUtil.getInstance(context);
  }

  private void requestStoragePermission() {
    if (ContextCompat
        .checkSelfPermission(getActivity(), permission.READ_EXTERNAL_STORAGE)
        == PackageManager.PERMISSION_GRANTED) {
      return;
    }

    if (ActivityCompat
        .shouldShowRequestPermissionRationale(getActivity(),
            permission.READ_EXTERNAL_STORAGE)) {

    }
    ActivityCompat
        .requestPermissions(getActivity(), new String[]{permission.READ_EXTERNAL_STORAGE},
            STORAGE_PERMISSION_CODE);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null
        && data.getData() != null) {
      filePathAccount = data.getData();
      editImagePresenter.getEditImage(id, getPath(filePathAccount));
      sessionAccount.clear();
//
      try {
        bitmapAccount = Media
            .getBitmap(getActivity().getContentResolver(), filePathAccount);
        sessionAccount.createSession(email, id, username, image);
        imgUserAccount.setImageBitmap(bitmapAccount);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public String getPath(Uri uri) {
    Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
    cursor.moveToFirst();
    String document_id = cursor.getString(0);
    document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
    cursor.close();

    cursor = getActivity().getContentResolver().query(
        Media.EXTERNAL_CONTENT_URI,
        null, Media._ID + " = ? ", new String[]{document_id}, null);
    cursor.moveToFirst();
    String path = cursor.getString(cursor.getColumnIndex(Media.DATA));
    cursor.close();

    return path;
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == STORAGE_PERMISSION_CODE) {

      if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        Toast.makeText(getActivity(), "Permission granted now you can read the storage",
            Toast.LENGTH_SHORT)
            .show();
      } else {

        Toast.makeText(getActivity(), "Oops you just denied the permission", Toast.LENGTH_SHORT)
            .show();
      }
    }
  }

  @OnClick({R.id.img_edit_photo_account, R.id.btn_logout_account, R.id.img_user_account})
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.img_edit_photo_account:
        editPhoto();
        imgEditPhotoAccount.setEnabled(true);
        break;
      case R.id.img_user_account:
        editPhoto();
        imgUserAccount.setEnabled(true);
        break;
      case R.id.btn_logout_account:
        logout();
        break;
    }
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = (getActivity()).obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

}