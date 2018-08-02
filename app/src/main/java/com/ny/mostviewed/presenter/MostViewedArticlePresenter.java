package com.ny.mostviewed.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ny.mostviewed.R;
import com.ny.mostviewed.model.MostViewedArticleResponse;
import com.ny.mostviewed.network.ApiService;
import com.ny.mostviewed.network.RetrofitClient;
import com.ny.mostviewed.view.MostViewedArticleView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostViewedArticlePresenter {

    private MostViewedArticleView mMostViewedArticleView;
    private Context mContext;

    public MostViewedArticlePresenter(Context context, MostViewedArticleView mostViewedArticleView) {
        this.mMostViewedArticleView = mostViewedArticleView;
        this.mContext = context;
    }

    public void getMostViewedArticles() {
        ApiService service = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        String API_KEY = mContext.getResources().getString(R.string.api_key);
        Call<MostViewedArticleResponse> call = service.getMostViewedArticles("all-sections", 7, API_KEY);
        call.enqueue(new Callback<MostViewedArticleResponse>() {

            @Override
            public void onResponse(@NonNull Call<MostViewedArticleResponse> call, @NonNull Response<MostViewedArticleResponse> response) {
                mMostViewedArticleView.hideProgress();
                mMostViewedArticleView.populateArticle(response.body().getMostViewedArticleList());
            }

            @Override
            public void onFailure(@NonNull Call<MostViewedArticleResponse> call, @NonNull Throwable t) {
                mMostViewedArticleView.hideProgress();
                mMostViewedArticleView.showToast();
            }
        });
    }
}
