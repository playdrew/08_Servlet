package com.ohgiraffers.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value = "/headers")
public class RequestHeaderServlet extends HttpServlet {
    // a 태그는 get 이라서 doGet 오버라이드 했다.
    // status code = 200 (정상) 500(개발자실수) 404
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Enumeration 은 iterator 같은 느낌이다. 목록화해서 해당 요소가 있는지 확인
        Enumeration<String> headerName = req.getHeaderNames();
        while(headerName.hasMoreElements()){
            System.out.println(headerName.nextElement());
        }
    }
}