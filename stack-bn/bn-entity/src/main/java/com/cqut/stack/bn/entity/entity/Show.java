package com.cqut.stack.bn.entity.entity;

import java.util.List;

public class Show {
    private String age;

    private String gender;

    private String education;

    private String topic;

    private String prob;

    private List<List<String>> probs;

    public String getProb() {
        return prob;
    }

    public void setProb(String prob) {
        this.prob = prob;
    }
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<List<String>> getProbs() {
        return probs;
    }

    public void setProbs(List<List<String>> probs) {
        this.probs = probs;
    }

}
