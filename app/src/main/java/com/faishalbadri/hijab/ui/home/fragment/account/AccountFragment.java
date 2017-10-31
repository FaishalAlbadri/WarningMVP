package com.faishalbadri.hijab.ui.home.fragment.account;


import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
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
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountContract.accoutView;
import com.faishalbadri.hijab.ui.home.fragment.home.HomeFragment;
import com.faishalbadri.hijab.util.Server;
import com.faishalbadri.hijab.util.SessionManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

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
  private int PICK_IMAGE_REQUEST = 1;
  private String id, email;

  private static final int STORAGE_PERMISSION_CODE = 123;

  private Uri filePathAccount;
  private Bitmap bitmapAccount;

  public AccountFragment() {
    // Required empty public constructor
  }

  public static AccountFragment instance(){
    return new AccountFragment();
  }
  AccountPresenter accountPresenter;
  SessionManager sessionAccount;
  private static final String save = "save";

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_account, container, false);
    ButterKnife.bind(this, v);
    pd = new ProgressDialog(getActivity());
    pd.setMessage("Loading");
    pd.setCanceledOnTouchOutside(false);
    pd.setCancelable(false);
    pd.show();
    setView();
    requestStoragePermission();
    if (savedInstanceState != null) {
      ArrayList<UserBean> resultArray = savedInstanceState.getParcelableArrayList(save);
    } else {
      accountPresenter.getDataAccount(email);
    }

    return v;
  }

  @Override
  public void onSuccesAccount(List<UserBean> user, String username, String image, String id) {
    this.id = id;
    txtUsernameUserAccount.setText(username);
    RequestOptions options = new RequestOptions().circleCrop().format(
        DecodeFormat.PREFER_ARGB_8888).override(400, 400);
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

  private void logout() {
    pd.show();
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
    HashMap<String, String> user = sessionAccount.getUserDetails();
    email = user.get(SessionManager.key_email);
    txtEmailUserAccount.setText(email);
    accountPresenter = new AccountPresenter(
        AccountRepositoryInject.provideToLoginRepository(getActivity()));
    accountPresenter.onAttachView(this);
  }

  private void requestStoragePermission() {
    if (ContextCompat
        .checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
        == PackageManager.PERMISSION_GRANTED) {
      return;
    }

    if (ActivityCompat
        .shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {

    }
    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
        STORAGE_PERMISSION_CODE);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    Toast.makeText(getActivity(), "ini adalah : "+RESULT_OK, Toast.LENGTH_SHORT).show();
    if (requestCode ==PICK_IMAGE_REQUEST && resultCode== RESULT_OK && data != null
        && data.getData() != null) {
      filePathAccount = data.getData();
      uploadMultipart();

      try {
        bitmapAccount = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePathAccount);

        imgUserAccount.setImageBitmap(bitmapAccount);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void uploadMultipart() {
    String path = getPath(filePathAccount);
    final ProgressDialog pd = new ProgressDialog(getActivity());
    pd.setMessage("Loading");
    pd.show();
    try {
      String uploadId = UUID.randomUUID().toString();

      new MultipartUploadRequest(getActivity(), uploadId, Server.BASE_URL + "uploadimage.php")
          .addFileToUpload(path, "image")
          .addParameter("id", id)
          .setNotificationConfig(new UploadNotificationConfig())
          .setMaxRetries(2)
          .startUpload();
      Handler handler = new Handler();
      handler.postDelayed(new Runnable() {
        @Override
        public void run() {
          pd.dismiss();
          startActivity(new Intent(getActivity(), HomeActivity.class));
          getActivity().finish();
        }
      }, 4000);
    } catch (Exception exc) {

    }
  }

  public String getPath(Uri uri) {
    Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
    cursor.moveToFirst();
    String document_id = cursor.getString(0);
    document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
    cursor.close();

    cursor = getActivity().getContentResolver().query(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
    cursor.moveToFirst();
    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
    cursor.close();

    return path;
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == STORAGE_PERMISSION_CODE) {

      if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        Toast.makeText(getActivity(), "Permission granted now you can read the storage", Toast.LENGTH_SHORT)
            .show();
      } else {

        Toast.makeText(getActivity(), "Oops you just denied the permission", Toast.LENGTH_SHORT).show();
      }
    }
  }

  @OnClick({R.id.img_edit_photo_account, R.id.btn_logout_account})
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.img_edit_photo_account:
        editPhoto();
        imgEditPhotoAccount.setEnabled(true);
        break;
      case R.id.btn_logout_account:
        logout();
        break;
    }
  }
}