package com.gec.it.dao;

import com.gec.it.bean.AdminBean;
import com.gec.it.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDao {

    public boolean Login_verify(String username, String password) {
    Connection  conn=DBUtil.getConnectDb();
    String sql="select * from admin where username='"+username+"'and password='"+password+"'";
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
           stm =conn.prepareStatement(sql);
           rs= stm.executeQuery();
           if (rs.next()){
               return  true;
           }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.CloseDB(rs,stm,conn);
        }
        return false;
    }

    //获取Admin的用户名和密码
    public AdminBean getAdminInfo(String username, String password) {
        AdminBean adminBean=new AdminBean();
        Connection  conn=DBUtil.getConnectDb();
        String sql="select * from admin where username='"+username+"'and password='"+password+"'";
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            stm =conn.prepareStatement(sql);
            rs= stm.executeQuery();
            if (rs.next()){
                adminBean.setAid(rs.getInt("aid"));
                adminBean.setUsername(rs.getString("username"));
                adminBean.setName(rs.getString("name"));
                adminBean.setPassword(rs.getString("password"));
                adminBean.setEmail(rs.getString("email"));
                adminBean.setPhone(rs.getString("phone"));
                adminBean.setStatus(rs.getInt("status"));
                adminBean.setLend_num(rs.getInt("lend_mun"));
                adminBean.setMax_num(rs.getInt("max_num"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.CloseDB(rs,stm,conn);
        }

        return adminBean;


    }

    //获取Admin的序列号
    public AdminBean get_AidInfo2(String aid) {

        AdminBean adminBean=new AdminBean();
        Connection  conn=DBUtil.getConnectDb();
        String sql="select * from admin where aid="+aid;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            stm =conn.prepareStatement(sql);
            rs= stm.executeQuery();
            if (rs.next()){
                adminBean.setAid(rs.getInt("aid"));
                adminBean.setUsername(rs.getString("username"));
                adminBean.setName(rs.getString("name"));
                adminBean.setPassword(rs.getString("password"));
                adminBean.setEmail(rs.getString("email"));
                adminBean.setPhone(rs.getString("phone"));
                adminBean.setStatus(rs.getInt("status"));
                adminBean.setLend_num(rs.getInt("lend_mun"));
                adminBean.setMax_num(rs.getInt("max_num"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.CloseDB(rs,stm,conn);
        }

        return adminBean;


    }

    //注册操作
    public void Register(String username, String password, String name, String email, String phone, int lend_num, int max_num) {

        Connection conn = DBUtil.getConnectDb();
        String sql="insert into  admin(status,username,password,name,email,phone,lend_num,max_num) values(?,?,?,?,?,?,?,?)";
        int rs = 0;
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1,1);
            stm.setString(2,username);
            stm.setString(3,password);
            stm.setString(4,name);
            stm.setString(5,email);
            stm.setString(6,phone);
            stm.setInt(7,lend_num);
            stm.setInt(8,max_num);

            rs = stm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //更新读者信息
    public void updateUser(int aid, String username, String password, String name, String email, String phone, int lend_num, int max_num) {
        Connection conn=DBUtil.getConnectDb();
        String sql="update admin set username=?,name=?,email=?,phone=?,password=?,lend_num=?,max_num=? where aid=?";
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);

            stm.setString(1, username);
            stm.setString(2, name);
            stm.setString(3, email);
            stm.setString(4, phone);
            stm.setString(5, password);
            stm.setInt(6, lend_num);
            stm.setInt(7, max_num);
            stm.setInt(8, aid);
            stm.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    //获取全部用户的信息，其中sql语句中的status=1，表示只查找读者，不显示管理员的
    public ArrayList<AdminBean> get_ListInfo() {

        ArrayList<AdminBean> tag_Array = new ArrayList<AdminBean>();
        Connection  conn = DBUtil.getConnectDb();
        String sql ="select * from admin where status=1";
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            stm=conn.prepareStatement(sql);
            rs=stm.executeQuery();

            while ( rs.next()) {
                AdminBean adminBean=new AdminBean();
                adminBean.setAid(rs.getInt("aid"));
                adminBean.setUsername(rs.getString("username"));
                adminBean.setName(rs.getString("name"));
                adminBean.setPassword(rs.getString("password"));
                adminBean.setEmail(rs.getString("email"));
                adminBean.setPhone(rs.getString("phone"));
                adminBean.setStatus(rs.getInt("status"));
                adminBean.setLend_num(rs.getInt("lend_num"));
                adminBean.setMax_num(rs.getInt("max_num"));
                tag_Array.add(adminBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.CloseDB(rs, stm, conn);
        }
        return tag_Array;
    }

}


