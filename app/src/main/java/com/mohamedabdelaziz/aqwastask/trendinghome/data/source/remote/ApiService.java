package com.mohamedabdelaziz.aqwastask.trendinghome.data.source.remote;


import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("repositories")
    Single<List<TrendingResponse>> getApiTrendingRepositoriesList();
}
