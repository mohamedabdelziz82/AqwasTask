package com.mohamedabdelaziz.aqwastask.trendinghome.presentation.viewModels;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mohamedabdelaziz.aqwastask.trendinghome.data.repository.TrendingRepositoryLocalImp;
import com.mohamedabdelaziz.aqwastask.trendinghome.data.repository.TrendingRepositoryRemoteImp;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TrendingViewModel extends ViewModel {
    private static final String TAG = "TrendingViewModel";
    TrendingRepositoryRemoteImp trendingRepositoryRemoteImp;
    private final MutableLiveData<List<TrendingResponse>> trendingResponseMutableLiveData = new MutableLiveData<>();
    LiveData<List<TrendingResponse>> trendingLiveData = null;
    TrendingRepositoryLocalImp trendingRepositoryLocalImp;
    @ViewModelInject
    public TrendingViewModel(TrendingRepositoryRemoteImp trendingRepositoryRemoteImp, TrendingRepositoryLocalImp trendingRepositoryLocalImp) {
        this.trendingRepositoryRemoteImp = trendingRepositoryRemoteImp;
        this.trendingRepositoryLocalImp = trendingRepositoryLocalImp;
    }
    public MutableLiveData<List<TrendingResponse>> getTrendingResponseMutableLiveData() {
        return trendingResponseMutableLiveData;
    }


    public void getTrendingListRemote() {
        trendingRepositoryRemoteImp.getTrendingList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(trendingList -> {
                            trendingResponseMutableLiveData.setValue(trendingList);
                            deleteAllTrendingList();
                            insertTrendingList(trendingList);
                        }, errors -> Log.e(TAG, errors.getMessage()));
    }

    public void insertTrendingList(List<TrendingResponse> trendingList) {
        trendingRepositoryLocalImp.insertTrendingList(trendingList);
    }

    public void deleteAllTrendingList() {
        trendingRepositoryLocalImp.deleteAllTrendingList();
    }

    public LiveData<List<TrendingResponse>> getTrendingListLocal() {
        trendingLiveData = trendingRepositoryLocalImp.getTrendingList();
        return trendingLiveData;
    }

}
