package com.faishalbadri.hijab.repository.sponsor.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.sponsor.SponsorItem;
import com.faishalbadri.hijab.data.sponsor.SponsorResponse;
import com.faishalbadri.hijab.repository.sponsor.SponsorDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorDataRemote implements SponsorDataResource {

  private Context context;


  public SponsorDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSponsorResult(@NonNull SponsorGetCallback sponsorGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<SponsorResponse> sponsorResponseCall = apiInterface
        .getSponsor(DataUser.getInstance().getUserApiKey());
    sponsorResponseCall.enqueue(new Callback<SponsorResponse>() {
      @Override
      public void onResponse(Call<SponsorResponse> call, Response<SponsorResponse> response) {
        try {
          if (response.body().getSponsor() == null) {
            sponsorGetCallback.onErrorSponsor("Error");
          } else {
            SponsorResponse sponsorResponse = response.body();
            List<SponsorItem> items = sponsorResponse.getSponsor();
            sponsorGetCallback.onSuccesSponsor(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<SponsorResponse> call, Throwable t) {
        sponsorGetCallback.onErrorSponsor("Tidak ada koneksi internet");
      }
    });
  }
}
