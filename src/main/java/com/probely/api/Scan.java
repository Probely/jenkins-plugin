package com.probely.api;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Scan {
    private String id;
    private transient Target target;
    private String status;
    @SerializedName("scan_profile")
    private String scanProfile;
    private int lows;
    private int mediums;
    private int highs;
    private Date started;
    private Date completed;
    private Date created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScanProfile() {
        return scanProfile;
    }

    public void setScanProfile(String scanProfile) {
        this.scanProfile = scanProfile;
    }

    public int getLows() {
        return lows;
    }

    public void setLows(int lows) {
        this.lows = lows;
    }

    public int getMediums() {
        return mediums;
    }

    public void setMediums(int mediums) {
        this.mediums = mediums;
    }

    public int getHighs() {
        return highs;
    }

    public void setHighs(int highs) {
        this.highs = highs;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


}
