package com.gec.it.servlet;


import com.gec.it.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//删除图书
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public deleteServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        int bid = Integer.parseInt(request.getParameter("bid"));
        BookDao bookDao = new BookDao();
        BookDao.deleteBook(bid);
        response.sendRedirect("admin_book.jsp");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
