package com.mohamedabdelaziz.aqwastask.trendinghome.presentation.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import androidx.test.core.app.ActivityScenario;
 import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.mohamedabdelaziz.aqwastask.R;
import com.mohamedabdelaziz.aqwastask.trendinghome.presentation.viewModels.TrendingViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.TestScheduler;

@RunWith(AndroidJUnit4ClassRunner.class)
  public class MainActivityTest {

   @Test
   public void isMainActivityInView() {
       ActivityScenario.launch(MainActivity.class);
       onView(ViewMatchers.withId(R.id.mainActivity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
   }
    @Test
    public void  testSchedulers() {
        TestScheduler scheduler = new TestScheduler();
        final List<Long> result = new ArrayList<>();
        Observable.interval(1, TimeUnit.SECONDS, scheduler)
                .take(5)
                .subscribe(result::add);
        assertTrue(result.isEmpty());
        scheduler.advanceTimeBy(2, TimeUnit.SECONDS);
        assertEquals(2, result.size());
        scheduler.advanceTimeBy(10, TimeUnit.SECONDS);
        assertEquals(5, result.size());
    }


  }