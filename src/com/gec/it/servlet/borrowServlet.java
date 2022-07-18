package com.gec.it.servlet;

import com.gec.it.dao.BookDao;
import com.gec.it.dao.*;
import com.gec.it.bean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//归还图书
@WebServlet("/borrowServlet")
public class borrowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public borrowServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        BookDao bookDao=new BookDao();

        int tip=Integer.parseInt(request.getParameter("tip"));
        if (tip==2) {
            int hid=Integer.parseInt(request.getParameter("hid"));

            int show=Integer.parseInt(request.getParameter("show")) ;

            bookDao.borrowBook2(hid);
            if (show==2){
                response.sendRedirect("admin_borrow.jsp");
            }else{
                response.sendRedirect("borrow.jsp");
            }

        }else{

            int bid=Integer.parseInt(request.getParameter("bid"));
            HttpSession session=request.getSession();

            String aid=(String) session.getAttribute("aid");
            AdminDao adminDao=new AdminDao();
            AdminBean admin =new AdminBean();
            admin=adminDao.get_AidInfo2(aid);

            bookDao.borrowBook(bid,admin);
            response.sendRedirect("select.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}