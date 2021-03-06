package com.example.shivam.learningfragments.utils;

/**
 * Created by shivam on 2/12/17.
 */

public class MyConfig {
    //Total tweets or max tweets = 10
    //Same is with notifications
    public boolean isLoggedIn = false;
    public int no_of_tweets_selected = 4;
    public int no_of_notifications = 4;
    public String name_of_user = "";
    public long id_of_user = 0l;

    public MyConfig(boolean isLoggedIn, int no_of_tweets_selected, int no_of_notifications, String name_of_user, long id_of_user) {
        this.isLoggedIn = isLoggedIn;
        this.no_of_tweets_selected = no_of_tweets_selected;
        this.no_of_notifications = no_of_notifications;
        this.name_of_user = name_of_user;
        this.id_of_user = id_of_user;
    }
    public MyConfig(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }
     public MyConfig(boolean isLoggedIn, int no_of_tweets_selected, int no_of_notifications) {
        this.isLoggedIn = isLoggedIn;
        this.no_of_tweets_selected = no_of_tweets_selected;
        this.no_of_notifications = no_of_notifications;
    }


    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public int getNo_of_tweets_selected() {
        return no_of_tweets_selected;
    }

    public void setNo_of_tweets_selected(int no_of_tweets_selected) {
        this.no_of_tweets_selected = no_of_tweets_selected;
    }

    public int getNo_of_notifications() {
        return no_of_notifications;
    }

    public void setNo_of_notifications(int no_of_notifications) {
        this.no_of_notifications = no_of_notifications;
    }

    public String getName_of_user() {
        return name_of_user;
    }

    public void setName_of_user(String name_of_user) {
        this.name_of_user = name_of_user;
    }

    public long getId_of_user() {
        return id_of_user;
    }

    public void setId_of_user(long id_of_user) {
        this.id_of_user = id_of_user;
    }
}
