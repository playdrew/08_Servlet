package com.ohgiraffers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    // redirect 는 url 을 아예 새롭게 변경하기 때문에
    // url 과 관련된 doGet 메소드를 오버라이딩 해야 한다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("userId");
        String pwd = req.getParameter("userPwd");
        
        // 새로운 요청과 응답이기에 안나옴
        System.out.println("redirect 후 id = " + id);
        System.out.println("redirect 후 pwd = " + pwd);

        HttpSession session = req.getSession();

        System.out.println("redirect 페이지의 session id : " + session.getId());
        id = (String) session.getAttribute("id");
        pwd = (String) session.getAttribute("pwd");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>");
        out.println(id + "님 환영합니다!!!");
        out.println("</h3>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();
    }
}
