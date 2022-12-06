package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.collection_app.d4_collection_object;

/**
 * @author:Sun
 * @date06/12/202211:23 PM
 */
public class Movie {

    private String name;
    private double score;
    private String actor;

    public Movie() {
    }

    public Movie(String name, double score, String actor) {
        this.name = name;
        this.score = score;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public  String toString(){
        return "Movie{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", actor='" + actor + '\'' +
                '}';
    }

}
