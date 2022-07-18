package com.gec.it.bean;
import com.gec.it.util.DBUtil;
import java.util.ArrayList;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryBean {

  private  int hid;  //借阅记录的id
  private  int aid;  //读者的id
  private  int bid;  //图书的id
  private  String card; //图书号
  private  String bookname;  //图书名称
  private  String adminname;  //读者的账号
  private  String username;  //读者的姓名
  private  String begintime;  //借阅时间
  private  String endtime;  //要还书的时间
  private  int status;  //表示借阅状态，1为正在借阅，2是已经还书

    public HistoryBean(int hid, int aid, int bid, String card, String bookname, String adminname, String username, String begintime, String endtime, int status) {
        this.hid = hid;
        this.aid = aid;
        this.bid = bid;
        this.card = card;
        this.bookname = bookname;
        this.adminname = adminname;
        this.username = username;
        this.begintime = begintime;
        this.endtime = endtime;
        this.status = status;
    }

    public HistoryBean() {
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HistoryBean{" +
                "hid=" + hid +
                ", aid=" + aid +
                ", bid=" + bid +
                ", card='" + card + '\'' +
                ", bookname='" + bookname + '\'' +
                ", adminname='" + adminname + '\'' +
                ", username='" + username + '\'' +
                ", begintime='" + begintime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", status=" + status +
                '}';
    }



}
