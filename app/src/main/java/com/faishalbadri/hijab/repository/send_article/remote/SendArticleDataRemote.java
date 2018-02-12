package com.faishalbadri.hijab.repository.send_article.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.repository.send_article.SendArticleDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import java.util.UUID;
import net.gotev.uploadservice.MultipartUploadRequest;

/**
 * Created by fikriimaduddin on 12/02/18.
 */

public class SendArticleDataRemote implements SendArticleDataResource {

  private static final String URL_UPLOAD_FILE = Server.BASE_URL_REVAMP + "article_user";
  private Context context;
  private RequestQueue requestQueue;

  public SendArticleDataRemote(Context context) {
    this.context = context;
    this.requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getEditImageResult(String path, @NonNull uploadFile uploadFile) {
    try {
      String uploadId = UUID.randomUUID().toString();
      new MultipartUploadRequest(context, uploadId, URL_UPLOAD_FILE)
          .addFileToUpload(path, "filename")
          .addParameter("username", DataUser.getInstance().getUserName())
          .setMaxRetries(2)
          .startUpload();
    } catch (Exception ignored) {

    }
  }
}
