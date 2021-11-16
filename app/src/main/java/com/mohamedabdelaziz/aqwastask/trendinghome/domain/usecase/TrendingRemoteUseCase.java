package com.mohamedabdelaziz.aqwastask.trendinghome.domain.usecase;

import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.repository.TrendingRepositoryRemote;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.rxjava3.core.Single;


public class TrendingRemoteUseCase {
    TrendingRepositoryRemote repository;

    @Inject
    public TrendingRemoteUseCase(TrendingRepositoryRemote repository) {
        this.repository = repository;
    }

    public Single<List<TrendingResponse>> invokeTrendingListRemote() {
        return repository.getTrendingList();
    }

}
