package com.gec.it.dao;

import com.gec.it.bean.BookBean;
import com.gec.it.util.DBUtil;
import com.gec.it.bean.HistoryBean;
import com.gec.it.bean.*;
import com.gec.it.dao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class BookDao {

    //获取全部书籍的信息
    public ArrayList<BookBean> get_ListInfo() {

        ArrayList<BookBean> tag_Array=new ArrayList<BookBean>();
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from book";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                BookBean tag = new BookBean();
                tag.setBid(rs.getInt("bid"));
                tag.setName(rs.getString("name"));
                tag.setCard(rs.getString("card"));
                tag.setAutho(rs.getString("autho"));
                tag.setPress(rs.getString("press"));
                tag.setType(rs.getString("type"));
                tag.setNum(rs.getInt("num"));
                tag_Array.add(tag);
            }



        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.CloseDB(rs,stm,conn);
        }
        return tag_Array;

    }

    //获取名字相同的书籍信息
    public ArrayList<BookBean> getLikeList(String name) {
        ArrayList<BookBean> tag_Array=new ArrayList<BookBean>();
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from book where name like '%"+name+"%'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                BookBean tag = new BookBean();
                tag.setBid(rs.getInt("bid"));
                tag.setName(rs.getString("name"));
                tag.setCard(rs.getString("card"));
                tag.setAutho(rs.getString("autho"));
                tag.setPress(rs.getString("press"));
                tag.setType(rs.getString("type"));
                tag.setNum(rs.getInt("num"));
                tag_Array.add(tag);
            }



        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.CloseDB(rs,stm,conn);
        }
        return tag_Array;
    }

    //添加图书
    public static void addBook(String card, String name, String type, String autho, String press, int num) {
        Connection conn = DBUtil.getConnectDb();
        String sql="insert into  book(card,name,type,autho,press,num) values(?,?,?,?,?,?)";
        int rs = 0;
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);

            stm.setString(1,card);
            stm.setString(2,name);
            stm.setString(3,type);
            stm.setString(4,autho);
            stm.setString(5,press);
            stm.setInt(6,num);

            rs = stm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除图书
    public static void deleteBook(int bid) {
        Connection conn = DBUtil.getConnectDb();
        String sql="delete from book where bid=?";
        PreparedStatement stm=null;
        try{
            stm = conn.prepareStatement(sql);
            stm.setInt(1,bid);
            stm.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //修改图书
    public  void updataBook(int bid, String name, String card, String type, String autho, String press, int num) {
        Connection   conn=DBUtil.getConnectDb();
        String sql="update book set name=?,card=?,type=?,autho=?,press=?,num=? where bid=?";
        PreparedStatement stm =null;
        try {

            stm = conn.prepareStatement(sql);

            stm.setString(1,name);
            stm.setString(2,card);
            stm.setString(3,type);
            stm.setString(4,autho);
            stm.setString(5,press);
            stm.setInt(6,num);
            stm.setInt(7,bid);
            stm.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //修改借书时间
    public void borrowBook2(int hid) {
        Calendar c=Calendar.getInstance();

        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DATE);
        String endtime=""+year+"-"+(month+1)+"-"+day;

        Connection conn=DBUtil.getConnectDb();
        String sql="update history set endtime=?,status=? where hid=?";
        PreparedStatement stm=null;
        try{
            stm= conn.prepareStatement(sql);
            stm.setString(1,endtime);
            stm.setInt(2,0);
            stm.setInt(3,hid);
            stm.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();

        }
    }

    //获取图书历史信息
    public ArrayList<HistoryBean> get_HistoryListInfo2(int status) {
        ArrayList<HistoryBean> tag_Array=new ArrayList<HistoryBean>();
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from history where status='"+status+"'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                HistoryBean tag = new HistoryBean();
                tag.setHid(rs.getInt("hid"));
                tag.setAid(rs.getInt("aid"));
                tag.setBid(rs.getInt("bid"));
                tag.setCard(rs.getString("card"));
                tag.setBookname(rs.getString("bookname"));
                tag.setAdminname(rs.getString("adminname"));
                tag.setUsername(rs.getString("username"));
                tag.setBegintime(rs.getString("begintime"));
                tag.setEndtime(rs.getString("endtime"));
                tag.setStatus(rs.getInt("status"));
                tag_Array.add(tag);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.CloseDB(rs, stm, conn);
        }return tag_Array;
    }

    //删除用户
    public void deleteUser(int aid) {

        Connection conn = DBUtil.getConnectDb();
        String sql = "delete from admin where aid=?";
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, aid);

            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    //读者借书
    public void borrowBook(int bid, AdminBean admin) {

        BookBean bookBean=new BookBean();
        bookBean=this.get_BookInfo(bid);

        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DATE);
        String begintime=""+year+"-"+(month+1)+"-"+day;

        String endtime=""+year+"-"+(month+1)+"-"+day;
        Connection conn=DBUtil.getConnectDb();
        String sql="insert into history(aid,bid,card,bookname,adminname,username,begintime,endtime,status) values(?,?,?,?,?,?,?,?,?)";
        int rs=0;
        PreparedStatement stm=null;
        try{
            stm= conn.prepareStatement(sql);

            stm.setInt(1,admin.getAid());
            stm.setInt(2,bookBean.getBid());
            stm.setString(3,bookBean.getCard());
            stm.setString(4,bookBean.getName());
            stm.setString(5,admin.getUsername());
            stm.setString(6,admin.getName());
            stm.setString(7,begintime);
            stm.setString(8,endtime);
            stm.setInt(9,1);
            rs=stm.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    //读者借书
    private BookBean get_BookInfo(int bid) {
        BookBean tag=new BookBean();

        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from book where bid='"+bid+"'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while(rs.next()){
                tag.setBid(rs.getInt("bid"));
                tag.setName(rs.getString("name"));
                tag.setCard(rs.getString("card"));
                tag.setType(rs.getString("type"));
                tag.setAutho(rs.getString("autho"));
                tag.setPress(rs.getString("press"));
                tag.setNum(rs.getInt("num"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.CloseDB(rs, stm, conn);
        }
        return tag;
    }

    //获取借阅历史信息
    public ArrayList<HistoryBean> get_HistoryListInfo(int status, String aid) {
        ArrayList<HistoryBean> tag_Array = new ArrayList<HistoryBean>();
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from history where aid='" + aid + "' and status='"+ status +"'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                HistoryBean tag = new HistoryBean();
                tag.setHid(rs.getInt("hid"));
                tag.setAid(rs.getInt("aid"));
                tag.setCard(rs.getString("bid"));
                tag.setBookname(rs.getString("bookname"));
                tag.setAdminname(rs.getString("adminname"));
                tag.setUsername(rs.getString("username"));
                tag.setBegintime(rs.getString("begintime"));
                tag.setEndtime(rs.getString("endtime"));
                tag.setStatus(rs.getInt("status"));
                tag_Array.add(tag);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DBUtil.CloseDB(rs, stm, conn);
            return tag_Array;

        }
    }


}