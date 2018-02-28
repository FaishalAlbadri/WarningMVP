package com.faishalbadri.hijab.repository.voting_dialog.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.response.GlobalResponse;
import com.faishalbadri.hijab.data.session.SessionItem;
import com.faishalbadri.hijab.data.session.SessionResponse;
import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogDataRemote implements VotingDialogDataResource {

  private Context context;

  public VotingDialogDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getResulVotingDialogGetSession(String id_voting,
      @NonNull VotingDialogGetSessionGetCallback votingDialogGetSessionGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<SessionResponse> sessionResponseCall = apiInterface
        .getSession(DataUser.getInstance().getUserId(), id_voting,
            DataUser.getInstance().getUserApiKey());
    sessionResponseCall.enqueue(new Callback<SessionResponse>() {
      @Override
      public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
        votingDialogGetSessionGetCallback.onSuccesVotingDialogGetSessionNull("Null");
        try {
          if (response.body().getSession() == null) {
            votingDialogGetSessionGetCallback.onSuccesVotingDialogGetSessionNull("Null");
          } else {
            SessionResponse sessionResponse = response.body();
            List<SessionItem> items = sessionResponse.getSession();
            for (int a = 0; a < items.size(); a++) {
              String id_session = items.get(a).getSessionId();
              String status_session = items.get(a).getSessionStatus();
              votingDialogGetSessionGetCallback
                  .onSuccesVotingDialogGetSession("Succes", id_session, status_session);
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<SessionResponse> call, Throwable t) {
        votingDialogGetSessionGetCallback
            .onErrorVotingDialogGetSession("Tidak Ada Koneksi Internet");
      }
    });
  }

  @Override
  public void getResulVotingDialogVotingRate(String voting_id, String type,
      String voting_session_id,
      @NonNull VotingDialogVotingRateGetCallback votingDialogVotingRateGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<GlobalResponse> responseVotingVoteCall = apiInterface.getVotingVote(DataUser
            .getInstance().getUserId(), voting_id, type, voting_session_id,
        DataUser.getInstance().getUserApiKey());
    responseVotingVoteCall.enqueue(new Callback<GlobalResponse>() {
      @Override
      public void onResponse(Call<GlobalResponse> call, Response<GlobalResponse> response) {
        try {
          if (response.body().getMessage().equals("You've already voting")) {
            votingDialogVotingRateGetCallback
                .onSuccesVotingDialogVotingRate("You've already voting");
          } else {
            votingDialogVotingRateGetCallback.onSuccesVotingDialogVotingRate("ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<GlobalResponse> call, Throwable t) {
        votingDialogVotingRateGetCallback
            .onErrorVotingDialogVotingRate("Tidak ada koneksi internet");
      }
    });
  }
}
