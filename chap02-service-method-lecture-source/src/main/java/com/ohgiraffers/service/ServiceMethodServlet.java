package com.ohgiraffers.service;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/request-service")
public class ServiceMethodServlet extends HttpServlet {

    /*ServletRequest 요청이 있고 ServletResponse 응답이 있다.*/
    /*service 는 get post 요청 다 받는데 get 요청만 받거나 post 요청만 받는 메소드도 있나보다*/
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // getMethod 가 String 타입이어서 String 타입의 변수를 생성
        String httpMethod = request.getMethod();
        System.out.println("httpMethod = " + httpMethod); // httpMethod = GET
        
        if(("GET").equals((httpMethod))){
            // httpMethod 방식이 GET 방식이면
            doGet(request,response);
        } else if(("POST").equals(httpMethod)){
            // httpMethod 방식이 POST 방식이면
            doPost(request,response);
        }

        /* comment. http 메소드는 get, post, head, options, put, delete
                    등등이 있지만 가장 많이 사용되는 것은 get 과 post 이다.
        * */
    }

    /*doPost 와 doGet 의 출력문이 service 에 의해 우선순위에서 밀려난다. 그래서 service 에 if문 작성 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출됨...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출됨...");
    }
}