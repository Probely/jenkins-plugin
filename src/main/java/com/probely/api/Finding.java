package com.probely.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Finding {
    private Target target;
    private List<String> scans;
    private String evidence;
    private int severity;
    @SerializedName("cvss_score")
    private int cvssScore;
    @SerializedName("cvss_vector")
    private int cvssVector;
    private String state;

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public List<String> getScans() {
        return scans;
    }

    public void setScans(List<String> scans) {
        this.scans = scans;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getCvssScore() {
        return cvssScore;
    }

    public void setCvssScore(int cvssScore) {
        this.cvssScore = cvssScore;
    }

    public int getCvssVector() {
        return cvssVector;
    }

    public void setCvssVector(int cvssVector) {
        this.cvssVector = cvssVector;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
