package com.example.itpm.models;

import java.util.Date;

public class RateModel {
    String staffId;
    String feedbackMessage;
    String onTimeRate;
    String serviceRate;
    int onTimeScore;
    int serviceScore;


    public RateModel(String staffId, String feedbackMessage, String onTimeRate, String serviceRate, int onTimeScore, int serviceScore) {
        this.staffId = staffId;
        this.feedbackMessage = feedbackMessage;
        this.onTimeRate = onTimeRate;
        this.serviceRate = serviceRate;
        this.onTimeScore = onTimeScore;
        this.serviceScore = serviceScore;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public String getOnTimeRate() {
        return onTimeRate;
    }

    public String getServiceRate() {
        return serviceRate;
    }

    public int getOnTimeScore() {
        return onTimeScore;
    }

    public int getServiceScore() {
        return serviceScore;
    }


    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public void setOnTimeRate(String onTimeRate) {
        this.onTimeRate = onTimeRate;
    }

    public void setServiceRate(String serviceRate) {
        this.serviceRate = serviceRate;
    }

    public void setOnTimeScore(int onTimeScore) {
        this.onTimeScore = onTimeScore;
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }

}
