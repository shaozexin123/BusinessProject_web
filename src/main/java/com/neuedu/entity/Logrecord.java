package com.neuedu.entity;

public class Logrecord {
    private int id;
    private  int user_id;
    private String operation;
    private  String creat_time;

    public Logrecord() {
    }

    public Logrecord(int user_id, String operation, String creat_time) {
        this.user_id = user_id;
        this.operation = operation;
        this.creat_time = creat_time;
    }

    public Logrecord(int id, int user_id, String operation, String creat_time) {
        this.id = id;
        this.user_id = user_id;
        this.operation = operation;
        this.creat_time = creat_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(String creat_time) {
        this.creat_time = creat_time;
    }

    @Override
    public String toString() {
        return "Logrecord{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", operation='" + operation + '\'' +
                ", creat_time='" + creat_time + '\'' +
                '}';
    }
}
