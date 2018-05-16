package com.remindlog.models;

import javax.persistence.*;

@Entity
public class Reminder { //implements Comparable<Reminder> TEST 1 might fix update

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Name unique?
    private String name;
    @Lob //might cause problem
    private String description;

    private String date;
    private String time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; //User who wrote the reminder

    //Perhaps delete getter and setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    //TEST 1 might fix updating
//    @Override
//    public int compareTo(Reminder reminder){
//        return this.getId().compareTo(reminder.getId());
//    }

//    //TEST 2 might fix updating
//    @Override
//    public boolean equals(Object o){
//        if (this == o)
//            return true;
//        if (id == null || o == null || getClass() != o.getClass())
//            return false;
//        Reminder that = (Reminder) o;
//        return id.equals(that.id);
//    }
//
//    //TEST 2 might fix updating
//    @Override
//    public int hashCode(){
//        return id == null ? 0 : id.hashCode();
//    }
}
