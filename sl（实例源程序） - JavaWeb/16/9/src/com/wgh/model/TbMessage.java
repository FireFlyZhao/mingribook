package com.wgh.model;

import java.sql.Timestamp;

public class TbMessage {


     private Integer id;	//ID∫≈
     private String writer;//¡Ù—‘»À
     private String content;//¡Ù—‘ƒ⁄»›
     private Timestamp sendTime;//¡Ù—‘ ±º‰


    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getWriter() {
        return this.writer;
    }
    
    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSendTime() {
        return this.sendTime;
    }
    
    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }
   

}