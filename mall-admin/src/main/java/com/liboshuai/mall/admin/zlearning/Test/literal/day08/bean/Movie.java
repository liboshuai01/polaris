package com.liboshuai.mall.admin.zlearning.Test.literal.day08.bean;

import java.util.Date;
import java.util.List;

/**
 * @author:Sun
 * @date2022/12/1418:55
 */
public class Movie {
    private String name;
    private String actor;
    private double time;
    private double price;
    private int number;
    private Date StartTime;

    public Movie() {
    }

    public Movie(String name, String actor, double time, double price, int number, Date startTime) {
        this.name = name;
        this.actor = actor;
        this.time = time;
        this.price = price;
        this.number = number;
        StartTime = startTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
//    public double getScore(){
//
//    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }
}
