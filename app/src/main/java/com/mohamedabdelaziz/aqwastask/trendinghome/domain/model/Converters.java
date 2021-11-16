package com.mohamedabdelaziz.aqwastask.trendinghome.domain.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Converters {
    @TypeConverter
    public String fromBuiltByToGson(List<BuiltBy> builtByList) {
        return new Gson().toJson(builtByList);
    }

    @TypeConverter
    public List<BuiltBy> fromGsonToBuiltBy(String builtByString) {
        Type listType = new TypeToken<ArrayList<BuiltBy>>(){}.getType();
        return new Gson().fromJson(builtByString,listType);
    }
}
