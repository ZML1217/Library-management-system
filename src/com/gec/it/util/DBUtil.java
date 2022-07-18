package com.gec.it.util;

import java.sql.*;

public class DBUtil {

    private  static  String username="root";
    private  static  String password="123456";
    private   static String   url="jdbc:mysql://127.0.0.1:3306/books";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
//连接数据库
    public  static Connection getConnectDb(){

        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url,username,password);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;


    }

//关闭数据库
public  static  void  CloseDB(ResultSet rs, PreparedStatement stm,Connection conn){

        if (rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
        if (stm!=null){
            try {
                stm.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
        if (conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }


}



}
