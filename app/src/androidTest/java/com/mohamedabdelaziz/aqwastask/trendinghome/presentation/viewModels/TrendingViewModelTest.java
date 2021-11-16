package com.mohamedabdelaziz.aqwastask.trendinghome.presentation.viewModels;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.repository.TrendingRepositoryLocalImp;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.repository.TrendingRepositoryRemoteImp;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.source.local.TrendingDataBaseTest;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.source.remote.ApiService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RunWith(AndroidJUnit4ClassRunner.class)
public class TrendingViewModelTest extends TrendingDataBaseTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Mock
    private TrendingViewModel viewModel;
    @Mock
    ApiService apiService;
    @Before
    public void init() {
        apiService = new Retrofit.Builder()
                .baseUrl("https://private-anon-ff5114eef6-githubtrendingapi.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
        viewModel = new TrendingViewModel(new TrendingRepositoryRemoteImp(apiService), new TrendingRepositoryLocalImp(appDatabase.trendingDao()));
    }

    @Test
    public void testTrendingViewModel() {
        viewModel.getTrendingListRemote();
         viewModel.getTrendingResponseMutableLiveData().observeForever(
                trendingResponses -> Assert.assertEquals(trendingResponses.size(),4));
    }


}