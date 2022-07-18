package com.gec.it.servlet;


import com.gec.it.dao.TypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//添加图书分类
@WebServlet("/AddBookTypeServlet")
public class AddBookTypeServlet extends HttpServlet {
    private  static  final  long serialVersionUID =1L;

    public AddBookTypeServlet() {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");



        String name = request.getParameter("name");


        TypeDao typeDao = new TypeDao();

        typeDao.addBookType(name);
        response.sendRedirect("admin_booktype.jsp");


    }





}