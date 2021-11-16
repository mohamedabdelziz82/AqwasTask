package com.mohamedabdelaziz.aqwastask.trendinghome.domain.repository;

import androidx.lifecycle.LiveData;

import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;

import java.util.List;

public interface TrendingRepositoryLocal {
    void insertTrendingList(List<TrendingResponse> trendingList);

    void deleteAllTrendingList();

    LiveData<List<TrendingResponse>> getTrendingList();
}
