package com.mohamedabdelaziz.aqwastask.trendinghome.presentation.di;

import android.app.Application;
import androidx.room.Room;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.repository.TrendingRepositoryLocalImp;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.source.local.dao.TrendingDao;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.source.local.TrendingDataBase;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.repository.TrendingRepositoryLocal;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {
    @Provides
    @Singleton
    public static TrendingDataBase provideDB(Application application){
        return Room.databaseBuilder(application ,TrendingDataBase.class,"trending_DB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

    }
    @Provides
    @Singleton
    public static TrendingDao provideDao(TrendingDataBase trendingDataBase){
        return trendingDataBase.trendingDao();
    }
    @Singleton
    @Provides
    public TrendingRepositoryLocal provideTrendingRepositoryLocal(TrendingDao trendingDao)  {
        return new TrendingRepositoryLocalImp(trendingDao);
    }

}
