package com.mohamedabdelaziz.aqwastask.trendinghome.data.source.local;

import static org.junit.Assert.assertEquals;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4ClassRunner.class)
public class TrendingDaoTest extends TrendingDataBaseTest{
    int size;
    @Rule
    public  InstantTaskExecutorRule instantTaskExecutorRule=new InstantTaskExecutorRule();
    @Test
    public void insertTrendingTest() {
        TrendingResponse trendingResponse1 = new TrendingResponse( );
        TrendingResponse trendingResponse2 = new TrendingResponse( );
        TrendingResponse trendingResponse3 = new TrendingResponse( );
        TrendingResponse trendingResponse4 = new TrendingResponse( );
        List<TrendingResponse> trendingResponseList=new ArrayList<>();
        trendingResponseList.add(trendingResponse1);
        trendingResponseList.add(trendingResponse2);
        trendingResponseList.add(trendingResponse3);
        trendingResponseList.add(trendingResponse4);
        appDatabase.trendingDao().insertTrendingList(trendingResponseList);

       appDatabase.trendingDao().getAllTrendingFromDB().observeForever( trendingList -> {
           size=trendingList.size();
                });
        assertEquals(size,4);
    }

    @Test
    public void deleteTrendingTest() {
        TrendingResponse trendingResponse1 = new TrendingResponse( );
        TrendingResponse trendingResponse2 = new TrendingResponse( );
        TrendingResponse trendingResponse3 = new TrendingResponse( );
        TrendingResponse trendingResponse4 = new TrendingResponse( );
        List<TrendingResponse> trendingResponseList=new ArrayList<>();
        trendingResponseList.add(trendingResponse1);
        trendingResponseList.add(trendingResponse2);
        trendingResponseList.add(trendingResponse3);
        trendingResponseList.add(trendingResponse4);
        appDatabase.trendingDao().insertTrendingList(trendingResponseList);

        appDatabase.trendingDao().getAllTrendingFromDB().observeForever( trendingList -> {
            size=trendingList.size();
        });
        assertEquals(size,4);
        appDatabase.trendingDao().deleteAllTrendingList();
        appDatabase.trendingDao().getAllTrendingFromDB().observeForever( trendingList -> {
            size=trendingList.size();
        });
        assertEquals(size,0);
    }
}
