package com.faishalbadri.hijab.repository.voting.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.voting.VotingItem;
import com.faishalbadri.hijab.data.voting.VotingResponse;
import com.faishalbadri.hijab.repository.voting.VotingDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDataRemote implements VotingDataResource {

  private Context context;


  public VotingDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVotingResult(int PAGE, @NonNull VotingGetCallback votingGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<VotingResponse> votingResponseCall = apiInterface
        .getVoting(DataUser.getInstance().getUserApiKey());
    votingResponseCall.enqueue(new Callback<VotingResponse>() {
      @Override
      public void onResponse(Call<VotingResponse> call, Response<VotingResponse> response) {
        try {
          if (response.body().getVoting() == null) {
            votingGetCallback.onErrorVoting("Data Voting Null");
          } else {
            VotingResponse votingResponse = response.body();
            List<VotingItem> items = votingResponse.getVoting();
            votingGetCallback.onSuccesVoting(items, "Succes");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<VotingResponse> call, Throwable t) {
        votingGetCallback.onErrorVoting("Tidak ada koneksi internet");
      }
    });
  }
}
