package com.gec.it.servlet;

import com.gec.it.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//注册
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private  static  final  long serialVersionUID =1L;

    public RegisterServlet() {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("textml;charset=UTF-8");


        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        int lend_num=30;
        int max_num=5;

        AdminDao userdao=new AdminDao();

        userdao.Register(username,password,name,email,phone,lend_num,max_num);
        response.sendRedirect("/login.jsp");



    }

}