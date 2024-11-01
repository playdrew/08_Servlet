package com.ohgiraffers.redirect.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//요청했으면 요청한 것을 서블릿에서 처리를 해주는데 요청정보가 저장되어 있어서 (키값으로) 요청한 정보들이 계속 유지가 되어 있음
//그래서 정보같은 것 확인할땐 포워드가 유리하긴 한데. 정보값이 저장되어있으므로 데이터베이스에 계속 쌓여서 터진다.
//성능면에서 포워드가 좋음 리다이렉트는 유지하지 않기 때문에 정보값 터지지 않음

//리다렉트 : 클라이언트(사용자)가 요청을 하면 서버에 중간에서 서블릿이 그걸 받아서 다른 서블릿에게 전달해준다 그에 맞게 요청을 처리한다
//서블릿 하나는 비즈니스 로직만 처리만 하고 한명 화면에 보여주는 역할등등으로 역할을 분리를 한 것이다.

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 서블릿으로 Redirect 성공");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        StringBuilder redirectText = new StringBuilder();
        redirectText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1>이 서블릿으로 redirect 성공!</h1>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(redirectText);
        out.flush();
        out.close();
    }
}
