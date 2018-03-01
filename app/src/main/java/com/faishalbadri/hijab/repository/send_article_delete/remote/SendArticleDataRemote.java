package com.faishalbadri.hijab.repository.send_article_delete.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.faishalbadri.hijab.repository.send_article_delete.SendArticleDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import java.util.UUID;
import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

/**
 * Created by fikriimaduddin on 12/02/18.
 */

public class SendArticleDataRemote implements SendArticleDataResource {

  private static final String URL_UPLOAD_FILE = Server.BASE_URL_REVAMP + "add_article";
  private Context context;

  public SendArticleDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEditImageResult(String path, @NonNull uploadFile uploadFile) {
    try {
      String uploadId = UUID.randomUUID().toString();
      new MultipartUploadRequest(context, uploadId, URL_UPLOAD_FILE)
          .addFileToUpload(path, "user_article")
          .addParameter("user_id", DataUser.getInstance().getUserId())
          .setNotificationConfig(new UploadNotificationConfig())
          .setMaxRetries(2)
          .startUpload();
      Toast.makeText(context, path, Toast.LENGTH_SHORT).show();
    } catch (Exception ignored) {
      Toast.makeText(context, ignored.getMessage(), Toast.LENGTH_SHORT).show();
    }
  }
}