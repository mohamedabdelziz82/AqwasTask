package com.mohamedabdelaziz.aqwastask.trendinghome.data.repository;

import androidx.lifecycle.LiveData;

import com.mohamedabdelaziz.aqwastask.trendinghome.data.source.local.dao.TrendingDao;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.repository.TrendingRepositoryLocal;

import java.util.List;
import javax.inject.Inject;


/**
 * This repository is responsible for
 * fetching data[Album] from server or db
 * */

public class TrendingRepositoryLocalImp implements TrendingRepositoryLocal {
    private final TrendingDao trendingDao ;

    @Inject
    public TrendingRepositoryLocalImp(TrendingDao trendingDao) {
        this.trendingDao = trendingDao;
    }


    @Override
    public void insertTrendingList(List<TrendingResponse> trendingList) {
        trendingDao.insertTrendingList(trendingList);

    }
    @Override
    public void deleteAllTrendingList() {
        trendingDao.deleteAllTrendingList();
    }
    @Override
    public LiveData<List<TrendingResponse>> getTrendingList() {
        return trendingDao.getAllTrendingFromDB();
    }
}
