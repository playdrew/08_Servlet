package com.ohgiraffers.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String statusCode = req.getAttribute("jakarta.servlet.error.status_code").toString();
        String message = req.getAttribute("jakarta.servlet.error.message").toString();

        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(statusCode)
                .append(" - ")
                .append(message)
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.print(errorPage.toString());

        out.flush();
        out.close();

    }
}

// HTTP 무상태성 : 다음 페이지와는 공유하지 않음 : 로그인할때 또 로그인 
// 정보를 공유할때 쓰는 세션 쿠키등을 다음 시간에 하게 될 것