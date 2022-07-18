package com.gec.it.servlet;


import com.gec.it.dao.TypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//修改图书分类信息
@WebServlet("/updateBookTypeServlet")
public class updateBookTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public updateBookTypeServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //图书分类
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name=request.getParameter("name");
        int tid=Integer.parseInt(request.getParameter("tid"));

        TypeDao typeDao = new TypeDao();
        typeDao.updateBookType(name,tid);

        response.sendRedirect("admin_booktype.jsp");




    }
}