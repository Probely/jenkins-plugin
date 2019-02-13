package com.probely.api;

import java.util.List;

public class Findings {
    private int count;
    private List<Finding> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Finding> getResults() {
        return results;
    }

    public void setResults(List<Finding> results) {
        this.results = results;
    }
}
