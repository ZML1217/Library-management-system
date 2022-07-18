package com.gec.it.servlet;

import com.gec.it.dao.AdminDao;
import com.gec.it.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
@WebServlet("/AddBookServlet")
//添加图书
public class AddBookServlet extends HttpServlet {
    private  static  final  long serialVersionUID =1L;

    public AddBookServlet() {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        String card = request.getParameter("card");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String autho = request.getParameter("autho");
        String press = request.getParameter("press");
        int num=Integer.parseInt(request.getParameter("num"));


        BookDao bookdao = new BookDao();

        BookDao.addBook(card,name, type,autho,press,num);
        response.sendRedirect("admin_book.jsp");


    }



}
