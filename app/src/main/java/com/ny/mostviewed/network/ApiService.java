package com.ny.mostviewed.network;

import com.ny.mostviewed.model.MostViewedArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("mostviewed/{section}/{time-period}.json")
    Call<MostViewedArticleResponse> getMostViewedArticles(@Path("section") String section, @Path("time-period") int timePeriod, @Query("api_key") String apiKey);
}
