package com.mohamedabdelaziz.aqwastask.trendinghome.data.repository;

import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.repository.TrendingRepositoryRemote;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.source.remote.ApiService;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.rxjava3.core.Single;

/**
 * This repository is responsible for
 * fetching data[Album] from server or db
 * */

public class TrendingRepositoryRemoteImp implements TrendingRepositoryRemote {
    private final ApiService apiService;

    @Inject
    public TrendingRepositoryRemoteImp(ApiService apiService) {
        this.apiService = apiService;
    }


    @Override
    public Single<List<TrendingResponse>> getTrendingList() {
        return apiService.getApiTrendingRepositoriesList();
    }

}
