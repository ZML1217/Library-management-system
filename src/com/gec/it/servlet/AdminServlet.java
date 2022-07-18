package com.gec.it.servlet;


import com.gec.it.bean.AdminBean;
import com.gec.it.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminServlet")
//修改管理员密码
public class AdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AdminServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("textml;charset=UTF-8");


        int tip = Integer.parseInt(request.getParameter("tip"));
        String url = request.getParameter("url");
        HttpSession session = request.getSession();

        AdminBean adminBean = new AdminBean();

        String aid = (String) session.getAttribute("aid");

        AdminDao adminDao = new AdminDao();
        adminBean = adminDao.get_AidInfo2(aid);

        if (tip == 1) {
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");

            String old_password = adminBean.getPassword();
            if (old_password.equals(password)) {
                adminDao.updateUser(adminBean.getAid(), adminBean.getUsername(), password2, adminBean.getName(),
                        adminBean.getEmail(), adminBean.getPhone(), adminBean.getLend_num(), adminBean.getMax_num());
                response.sendRedirect(url+".jsp");
            } else {
                out.write("<script type'text/javascrip'>alert('password error');location.href='" + url + ".jsp';</script>");
            }
        } else {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");


            adminDao.updateUser(adminBean.getAid(), adminBean.getUsername(), adminBean.getPassword(), name, email, phone,
                    adminBean.getLend_num(), adminBean.getMax_num());
            response.sendRedirect(url+".jsp");
        }

    }
}
