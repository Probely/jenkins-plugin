package com.probely.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;

public class FindingsDeserializer {
    public static Findings deserialize(Reader reader) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(reader, Findings.class);
    }
}
