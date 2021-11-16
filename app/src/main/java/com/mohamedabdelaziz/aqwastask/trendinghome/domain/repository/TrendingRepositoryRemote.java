package com.mohamedabdelaziz.aqwastask.trendinghome.domain.repository;

import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;
import java.util.List;
import io.reactivex.rxjava3.core.Single;

public interface TrendingRepositoryRemote {
    Single<List<TrendingResponse>> getTrendingList();
}
