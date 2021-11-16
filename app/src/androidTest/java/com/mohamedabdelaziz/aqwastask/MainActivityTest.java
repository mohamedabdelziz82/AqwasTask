package com.mohamedabdelaziz.aqwastask;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.core.app.ActivityScenario;
 import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import com.mohamedabdelaziz.aqwastask.trendinghome.presentation.ui.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
  public class MainActivityTest {

   @Test
   public void isMainActivityInView() {
       ActivityScenario.launch(MainActivity.class);
       onView(withId(R.id.mainActivity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
   }

  }