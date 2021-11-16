package com.mohamedabdelaziz.aqwastask.trendinghome.data.source.local;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TrendingDataBaseTest {
    public TrendingDataBase appDatabase;

    @Before
    public void initDb() {
        appDatabase = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                TrendingDataBase.class)
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void  closeDb() {
        appDatabase.close();
    }

}