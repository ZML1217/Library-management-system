package com.gec.it.bean;
import java.util.*;

public class BookBean {

  private  int bid;  //id
  private  String name;  //图书名称
  private  String card;  //图书号
  private  String autho;  //作者
  private  int num;  //图书数量
  private  String press;  //图书的分类
  private  String type;  //出版社

    public BookBean(int bid, String name, String card, String autho, int num, String press, String type) {
        this.bid = bid;
        this.name = name;
        this.card = card;
        this.autho = autho;
        this.num = num;
        this.press = press;
        this.type = type;
    }

    public BookBean() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getAutho() {
        return autho;
    }

    public void setAutho(String autho) {
        this.autho = autho;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", card='" + card + '\'' +
                ", autho='" + autho + '\'' +
                ", num=" + num +
                ", press='" + press + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
