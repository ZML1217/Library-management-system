package com.gec.it.servlet;

import com.gec.it.dao.TypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除图书分类
@WebServlet("/deleteTypeServlet")
public class deleteTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        int tid = Integer.parseInt(request.getParameter("tid"));

        TypeDao typeDao = new TypeDao();
        TypeDao.deleteType(name,tid);
        response.sendRedirect("admin_booktype.jsp");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //shan chu du zhe
    }
}