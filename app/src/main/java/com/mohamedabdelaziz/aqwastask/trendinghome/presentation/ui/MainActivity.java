package com.mohamedabdelaziz.aqwastask.trendinghome.presentation.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mohamedabdelaziz.aqwastask.R;
import com.mohamedabdelaziz.aqwastask.core.presentation.ui.BaseActivity;
import com.mohamedabdelaziz.aqwastask.databinding.ActivityMainBinding;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;
import com.mohamedabdelaziz.aqwastask.trendinghome.presentation.adapters.TrendingAdapter;
import com.mohamedabdelaziz.aqwastask.trendinghome.presentation.viewModels.TrendingViewModel;
import com.mohamedabdelaziz.aqwastask.core.presentation.utils.constants.ConstantSort;

import java.util.Collections;
import java.util.Comparator;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private TrendingViewModel trendingViewModel;
    private TrendingAdapter trendingAdapter;
    private boolean isConnectedForMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        binding.trendRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.trendSwipeRefresh.setColorSchemeResources(R.color.black);
        binding.trendRecyclerView.setAdapter(trendingAdapter);

        binding.trendSwipeRefresh.setOnRefreshListener(() -> {
            if (isConnectedForMenu)
                getTrendingDataRemote(ConstantSort.DEFAULT_SORT);
            else
                getTrendingDataLocal(ConstantSort.DEFAULT_SORT);
            binding.trendSwipeRefresh.setRefreshing(false);
        });
        binding.retryBtn.setOnClickListener(v -> {
            if (isConnectedForMenu){
                visibleTrendRecyclerView();
                getTrendingDataRemote(ConstantSort.DEFAULT_SORT);
            }
            else visibleNoInternet();
        });
        binding.offlineModeBtn.setOnClickListener(v -> {
                    visibleTrendRecyclerView();
                    getTrendingDataLocal(ConstantSort.DEFAULT_SORT);
                }
        );
    }

    @Override
    protected void onConnectionSuccess() {
        isConnectedForMenu=true;
        visibleTrendRecyclerView();
    }
    @Override
    protected void onConnectionFailed() {
        isConnectedForMenu=false;
            visibleNoInternet();
    }

    private void visibleTrendRecyclerView() {
        binding.noInternetConstraintLayout.setVisibility(View.GONE);
        binding.shimmerLayout.setVisibility(View.VISIBLE);
        binding.trendRecyclerView.setVisibility(View.VISIBLE);
        binding.shimmerLayout.startShimmer();
        getTrendingDataRemote(ConstantSort.DEFAULT_SORT);
    }

    private void visibleNoInternet() {
        binding.noInternetConstraintLayout.setVisibility(View.VISIBLE);
        binding.shimmerLayout.setVisibility(View.GONE);
        binding.trendRecyclerView.setVisibility(View.GONE);
    }

    private void init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.trendingToolbar);
        trendingViewModel = new ViewModelProvider(this).get(TrendingViewModel.class);
        trendingAdapter = new TrendingAdapter(this);
     }

    @SuppressLint("NewApi")
    private void getTrendingDataRemote(int sortType) {
         binding.shimmerLayout.startShimmer();
        trendingViewModel.getTrendingListRemote();
        trendingViewModel.getTrendingResponseMutableLiveData().observe(this, trendingList -> {
            if (sortType == ConstantSort.DEFAULT_SORT) trendingAdapter.setList(trendingList);
            else if (sortType == ConstantSort.SORT_NAME) {
                Collections.sort(trendingList, Comparator.comparing(TrendingResponse::getName));
                trendingAdapter.setList(trendingList);
            } else if (sortType == ConstantSort.SORT_STAR) {
                Collections.sort(trendingList, Comparator.comparing(TrendingResponse::getStars));
                trendingAdapter.setList(trendingList);
            }
            binding.shimmerLayout.stopShimmer();
            binding.shimmerLayout.setVisibility(View.GONE);

        });
    }

    @SuppressLint("NewApi")
    private void getTrendingDataLocal(int sortType) {
        trendingAdapter.clear();
        binding.shimmerLayout.startShimmer();
        trendingViewModel.getTrendingListLocal();
        trendingViewModel.getTrendingListLocal().observe(this, trendingList -> {
            if (sortType == ConstantSort.DEFAULT_SORT) trendingAdapter.setList(trendingList);
            else if (sortType == ConstantSort.SORT_NAME) {
                Collections.sort(trendingList, Comparator.comparing(TrendingResponse::getName));
                trendingAdapter.setList(trendingList);
            } else if (sortType == ConstantSort.SORT_STAR) {
                Collections.sort(trendingList, Comparator.comparing(TrendingResponse::getStars));
                trendingAdapter.setList(trendingList);
            }
            binding.shimmerLayout.stopShimmer();
            binding.shimmerLayout.setVisibility(View.GONE);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.sortByName) {
            if (isConnectedForMenu)
                getTrendingDataRemote(ConstantSort.SORT_NAME);
            else
                getTrendingDataLocal(ConstantSort.SORT_NAME);
            return true;
        } else if (itemId == R.id.sortByStar) {
            if (isConnectedForMenu)
                getTrendingDataRemote(ConstantSort.SORT_STAR);
            else
                getTrendingDataLocal(ConstantSort.SORT_STAR);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}