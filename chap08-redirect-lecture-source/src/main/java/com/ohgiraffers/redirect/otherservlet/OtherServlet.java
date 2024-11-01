package com.ohgiraffers.redirect.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 조회할때는 포워드 방식이 유리하다

@WebServlet("/otherservlet")
public class OtherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청 정상 수락");

        // 콘솔창에 DB 데이터 등록 성공이 한번만 수행된다.
        // 데이터베이스관련 비즈니스 로직 수행 구역
        Logic logic = new Logic();
        logic.registData();

        resp.sendRedirect("redirect?name=cho&age=20");

    }
}
