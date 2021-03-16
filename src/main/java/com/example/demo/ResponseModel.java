package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ResponseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private Long responseTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public ResponseModel() {
    }

    public ResponseModel(Date date, Long responseTime) {
        this.date = date;
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "id=" + id +
                ", date=" + date +
                ", responseTime=" + responseTime +
                '}';
    }
}
