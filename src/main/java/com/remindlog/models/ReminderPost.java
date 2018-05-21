package com.remindlog.models;

public class ReminderPost {
    private String name;

    private String description;

    private String date;
    private String time;

    private String dateTimeCreate;
    private String dateTimeEdit;

    //Point of this POJO, bad practice way to get the shareGroupId from frontend. Alternativly use pathvariable?
    private Long shareGroupId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(String dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public String getDateTimeEdit() {
        return dateTimeEdit;
    }

    public void setDateTimeEdit(String dateTimeEdit) {
        this.dateTimeEdit = dateTimeEdit;
    }

    public Long getShareGroupId() {
        return shareGroupId;
    }

    public void setShareGroupId(Long shareGroupId) {
        this.shareGroupId = shareGroupId;
    }
}
