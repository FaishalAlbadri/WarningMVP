package com.faishalbadri.hijab.ui.home.fragment.account;


import static android.app.Activity.RESULT_OK;

import android.Manifest.permission;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.faishalbadri.hijab.di.AccountRepositoryInject;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountContract.accoutView;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountContract.editImageView;
import com.faishalbadri.hijab.util.ActivityUtil;
import com.faishalbadri.hijab.util.SessionManager;
import com.faishalbadri.hijab.util.server.Server;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.IOException;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements accoutView, editImageView {


  private static final int STORAGE_PERMISSION_CODE = 123;
  @BindView(R.id.img_user_account)
  CircleImageView imgUserAccount;
  @BindView(R.id.img_edit_photo_account)
  ImageView imgEditPhotoAccount;
  @BindView(R.id.txt_username_user_account)
  TextView txtUsernameUserAccount;
  @BindView(R.id.txt_email_user_account)
  TextView txtEmailUserAccount;
  Context context;
  ActivityUtil activityUtil;
  AccountPresenter accountPresenter;
  EditImagePresenter editImagePresenter;
  SessionManager sessionManager;
  @BindView(R.id.cardview_change_password)
  CardView cardviewChangePassword;
  @BindView(R.id.cardview_log_out)
  CardView cardviewLogOut;
  private int PICK_IMAGE_REQUEST = 1;
  private String id_user, user_name, user_email, user_handphone_number, user_image, user_password, user_verify_code, user_verified_code, user_gender, user_apikey;
  private Uri filePathAccount;
  private Bitmap bitmapAccount;
  private ProgressDialog progressDialog;

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
    getSession();
    setView();
    accountPresenter.getDataAccount();

    return v;
  }

  private void getSession() {
    sessionManager = new SessionManager(getActivity());
    HashMap<String, String> user = sessionManager.getUser();
    id_user = user.get(SessionManager.key_id_user);
    user_name = user.get(SessionManager.key_user_name);
    user_email = user.get(SessionManager.key_user_email);
    user_handphone_number = user.get(SessionManager.key_user_handphone_number);
    user_image = user.get(SessionManager.key_user_image);
    user_password = user.get(SessionManager.key_user_password);
    user_verify_code = user.get(SessionManager.key_user_verify_code);
    user_verified_code = user.get(SessionManager.key_user_verified_code);
    user_gender = user.get(SessionManager.key_user_gender);
    user_apikey = user.get(SessionManager.key_user_apikey);
  }

  @Override
  public void onSuccesAccount(String msg, String id_user, String user_name, String user_email,
      String user_handphone_number, String user_image, String user_password,
      String user_verify_code, String user_verified_code, String user_gender, String user_apikey) {
    sessionManager.clear();
    sessionManager.createSession(id_user, user_name, user_email, user_handphone_number, user_image,
        user_password, user_verify_code, user_verified_code, user_gender, user_apikey);
    getSession();
    RequestOptions options = new RequestOptions().circleCrop()
        .error(R.drawable.ic_account_circle_primary_color).format(
            DecodeFormat.PREFER_ARGB_8888).override(400, 400);
    Glide.with(getActivity())
        .load(Server.BASE_ASSETS + user_image)
        .apply(options)
        .into(imgUserAccount);
  }

  @Override
  public void onErrorAccount(String msg) {
    if (msg.equals("Email atau Password salah")) {
      Toast.makeText(context, "Someone has change your password\nPlease login again",
          Toast.LENGTH_LONG).show();
      logout();
    }
  }

  @Override
  public void onSuccessEditImage(ActivityUtil activityUtil) {
    activityUtil.addFragment(getActivity().getSupportFragmentManager(),
        R.id.framelayout_for_fragment_activity_home, AccountFragment.instance());
  }

  @Override
  public void onErrorEditImage(String msg) {
    Toast.makeText(context, "Gagal Meng-upload Foto", Toast.LENGTH_SHORT).show();
  }

  private void logout() {
    sessionManager.logout();
    getActivity().finish();
  }

  private void editPhoto() {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
  }

  private void setView() {
    txtEmailUserAccount.setText(user_email);
    txtUsernameUserAccount.setText(user_name);

    accountPresenter = new AccountPresenter(
        AccountRepositoryInject.provideToLoginRepository(getActivity()));
    accountPresenter.onAttachView(this);
    editImagePresenter = new EditImagePresenter(
        AccountRepositoryInject.provideToLoginRepository(getActivity()));
    editImagePresenter.onAttachView(this);
    activityUtil = ActivityUtil.getInstance(context);
    progressDialog = new ProgressDialog(getActivity());
    progressDialog.setMessage("Loading");
    progressDialog.setCancelable(false);
    progressDialog.setCanceledOnTouchOutside(false);
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
      editImagePresenter.getEditImage(getPath(filePathAccount));
      sessionManager.clear();

      try {
        bitmapAccount = Media.getBitmap(getActivity().getContentResolver(), filePathAccount);
        sessionManager
            .createSession(id_user, user_name, user_email, user_handphone_number, user_image,
                user_password, user_verify_code, user_verified_code, user_gender, user_apikey);
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

  @OnClick(R.id.img_user_account)
  public void onImgUserAccountClicked() {
    requestStoragePermission();
    editPhoto();
    imgUserAccount.setEnabled(true);
  }

  @OnClick(R.id.img_edit_photo_account)
  public void onImgEditPhotoAccountClicked() {
    requestStoragePermission();
    editPhoto();
    imgEditPhotoAccount.setEnabled(true);
  }

  @OnClick(R.id.cardview_change_password)
  public void onCardviewChangePasswordClicked() {
    ((HomeActivity) getActivity()).changePasswordFragment();
  }

  @OnClick(R.id.cardview_log_out)
  public void onCardviewLogOutClicked() {
    logout();
  }
}