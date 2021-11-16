package com.mohamedabdelaziz.aqwastask.trendinghome.presentation.di;

import com.mohamedabdelaziz.aqwastask.trendinghome.data.repository.TrendingRepositoryRemoteImp;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.source.remote.ApiService;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.repository.TrendingRepositoryRemote;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitModule {

    @Provides
    @Singleton
    public static ApiService getTrendingRepositoriesApiService(){
       return new Retrofit.Builder()
               .baseUrl("https://private-anon-ff5114eef6-githubtrendingapi.apiary-mock.com/")
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
               .build()
               .create(ApiService.class);
    }
    @Singleton
    @Provides
    public TrendingRepositoryRemote provideTrendingRepositoryRemote(ApiService  apiService)  {
        return new TrendingRepositoryRemoteImp(apiService);
    }

}
