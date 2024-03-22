package com.example.itpm.models;

public class RateModel {
    String staffId;
    String feedbackMessage;
    String onTimeRate;
    String serviceRate;
    String onTimeScore;
    String serviceScore;


    public RateModel(String staffId, String feedbackMessage, String onTimeRate, String serviceRate, int onTimeScore, int serviceScore) {
        this.staffId = staffId;
        this.feedbackMessage = feedbackMessage;
        this.onTimeRate = onTimeRate;
        this.serviceRate = serviceRate;
        this.onTimeScore = String.valueOf(onTimeScore);
        this.serviceScore = String.valueOf(serviceScore);
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

    public String getOnTimeScore() {
        return onTimeScore;
    }

    public String getServiceScore() {
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

        this.onTimeScore = String.valueOf(onTimeScore);
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = String.valueOf(serviceScore);
    }

}
