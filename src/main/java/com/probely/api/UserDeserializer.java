package com.probely.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserDeserializer {
    public static User deserialize(String data) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(data, User.class);
    }
}
