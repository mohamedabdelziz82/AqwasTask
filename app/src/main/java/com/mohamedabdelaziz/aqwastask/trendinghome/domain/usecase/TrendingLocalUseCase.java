package com.mohamedabdelaziz.aqwastask.trendinghome.domain.usecase;

import androidx.lifecycle.LiveData;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.repository.TrendingRepositoryLocal;

import java.util.List;
import javax.inject.Inject;

public class TrendingLocalUseCase {
    TrendingRepositoryLocal repository;

    @Inject
    public TrendingLocalUseCase(TrendingRepositoryLocal repository) {
        this.repository = repository;
    }

    public LiveData<List<TrendingResponse>> invokeAllTrendingListLocal() {
        return repository.getTrendingList();
    }

     public void insertTrendingList(List<TrendingResponse> trendingList) {
        repository.insertTrendingList(trendingList);

    }
     public void deleteAllTrendingList() {
        repository.deleteAllTrendingList();
    }

}
