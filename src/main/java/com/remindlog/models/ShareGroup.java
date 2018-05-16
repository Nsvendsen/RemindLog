package com.remindlog.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShareGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User founder;

    @ManyToMany(mappedBy="shareGroups", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> userList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shareGroup")
    private List<Reminder> reminders;

    public ShareGroup() {
    }

    //Constructor. Makes sure the ShareGroup has a founder. Admin privileges can be implemented later?
    public ShareGroup(User user) {
        setFounder(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getFounder() {
        return founder;
    }

    public void setFounder(User founder) {
        this.founder = founder;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
    }
}
