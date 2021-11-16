package com.mohamedabdelaziz.aqwastask.trendinghome.data.source.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;

import java.util.List;

@Dao
public interface TrendingDao {
    @Insert
    void insertTrendingList(List<TrendingResponse> trendingList);
    @Query("delete from trend_table")
    void deleteAllTrendingList();
    @Query("select * from trend_table")
    LiveData<List<TrendingResponse>> getAllTrendingFromDB();
}
