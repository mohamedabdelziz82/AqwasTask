package com.mohamedabdelaziz.aqwastask.trendinghome.data.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.mohamedabdelaziz.aqwastask.trendinghome.data.source.local.dao.TrendingDao;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.Converters;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;


@Database(entities = TrendingResponse.class,version = 1,exportSchema = false)
@TypeConverters(Converters.class)
public abstract class TrendingDataBase extends RoomDatabase {
    public abstract TrendingDao trendingDao();
}
