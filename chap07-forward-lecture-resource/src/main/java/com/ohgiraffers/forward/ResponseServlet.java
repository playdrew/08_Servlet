package com.ohgiraffers.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//요청했으면 요청한 것을 서블릿에서 처리를 해주는데 요청정보가 저장되어 있어서 (키값으로) 요청한 정보들이 계속 유지가 되어 있음
//그래서 정보같은 것 확인할땐 포워드가 유리하긴 한데. 정보값이 저장되어있으므로 데이터베이스에 계속 쌓여서 터진다.

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // set 으로 값을 집어넣었기에 get 으로 꺼내는데 키 값으로 꺼내요
        String userId = (String)req.getAttribute("id");
        System.out.println("Request 서블릿에서 전달 받은 ID" + userId);

        StringBuilder response = new StringBuilder();
        response.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h3 align=\"center\">")
                .append(userId)
                .append("</h3>")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(response.toString());
        out.flush();
        out.close();



    }
}
