package com.mohamedabdelaziz.aqwastask.trendinghome.domain.model;

import static org.junit.Assert.*;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;
import org.junit.Test;

public class TrendingResponseTest {

    @Test
    public void getAuthor() {
        TrendingResponse trendingResponse=new TrendingResponse();
        trendingResponse.setAuthor("Author");
        assertEquals("Author",trendingResponse.getAuthor());
    }



    @Test
    public void getName() {
        TrendingResponse trendingResponse=new TrendingResponse();
        trendingResponse.setName("Name");
        assertEquals("Name",trendingResponse.getName());
    }



    @Test
    public void getAvatar() {
        TrendingResponse trendingResponse=new TrendingResponse();
        trendingResponse.setAvatar("https://github.com/xingshaocheng.png");
        assertEquals("https://github.com/xingshaocheng.png",trendingResponse.getAvatar());
    }



    @Test
    public void getUrl() {
        TrendingResponse trendingResponse=new TrendingResponse();
        trendingResponse.setUrl("https://github.com/xingshaocheng");
        assertEquals("https://github.com/xingshaocheng",trendingResponse.getUrl());
    }



    @Test
    public void getDescription() {
        TrendingResponse trendingResponse=new TrendingResponse();
        trendingResponse.setDescription("后端架构师技术图谱");
        assertEquals("后端架构师技术图谱",trendingResponse.getDescription());
    }


    @Test
    public void getLanguage() {
        TrendingResponse trendingResponse=new TrendingResponse();
        trendingResponse.setLanguage("Go");
        assertEquals("Go",trendingResponse.getLanguage());
    }

}