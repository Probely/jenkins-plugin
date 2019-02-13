package com.probely.api;

import java.util.ArrayList;

public class Target {
    private String id;
    private String name;
    private String desc;
    private String url;
    private ArrayList<StackEntry> stack;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<StackEntry> getStack() {
        return stack;
    }

    public void setStack(ArrayList<StackEntry> stack) {
        this.stack = stack;
    }

    private class StackEntry {
        private String id;
        private String name;
        private String desc;
    }
}
