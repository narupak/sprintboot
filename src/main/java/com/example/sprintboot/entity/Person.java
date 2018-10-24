package com.example.sprintboot.entity;

import com.example.sprintboot.web.UserVM;

import java.util.List;
import java.util.Map;

public class Person {
    Map<String,Member> member;


    public Person() {
    }

    public Map<String, Member> getMember() {
        return member;
    }

    public void setMember(Map<String, Member> member) {
        this.member = member;
    }

}
