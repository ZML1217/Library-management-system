package com.gec.it.servlet;

import com.gec.it.dao.AdminDao;
import com.gec.it.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//用户增加
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private  static  final  long serialVersionUID =1L;

    public AddUserServlet() {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int lend_num = Integer.parseInt(request.getParameter("lend_num"));
        int max_num = Integer.parseInt(request.getParameter("max_num"));


        AdminDao userdao = new AdminDao();

        userdao.Register(username, password, name, email, phone, lend_num, max_num);
        response.sendRedirect("admin_user.jsp");

    }


}