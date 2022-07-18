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

//登陆
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //登录的判断
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取账号和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminDao userDao = new AdminDao();
        //对账号和密码进行判断
        boolean result = userDao.Login_verify(username, password);
        HttpSession session = request.getSession();
        //判断输入正确
        if (result) {
            AdminBean adminBean = new AdminBean();
            AdminDao adminDao = new AdminDao();
            //更加账号和密码查找出读者的信息
            adminBean = adminDao.getAdminInfo(username, password);
            //将aid存入session中
            session.setAttribute("aid", "" + adminBean.getAid());
            //设置session的失效时间
            session.setMaxInactiveInterval(6000);
            //根据status的值来判断是管理员，还是读者，status=1为读者
            if (adminBean.getStatus() == 1) {
                response.sendRedirect("/index2.jsp");
            } else {
                response.sendRedirect("/admin.jsp");
            }

        } else {
            //没有找到对应的账号和密码，返回重新登录
            session.setAttribute("state", "密码错误");
            response.sendRedirect("/login.jsp");
        }


    }


}
