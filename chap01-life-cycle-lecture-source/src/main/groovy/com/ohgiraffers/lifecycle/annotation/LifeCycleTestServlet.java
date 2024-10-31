package com.ohgiraffers.lifecycle.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// a가 눌려졌을때 기본생성자가 호출된다.
// init은 최초에 생성될 때만 한번만 호출된다
// 어떤 요청이 들어오면 실행을 할건지 설정 value
@WebServlet(value = "/annotation-lifecycle")
public class LifeCycleTestServlet extends HttpServlet {

    private int initCount = 1;
    private int ServiceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet(){
        System.out.println("기본생성자 호출됨...");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("annotation 방식 service()호출 : " + ServiceCount++);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("annotation 방식 init()호출 : " + initCount++);
    }

    @Override
    public void destroy() {
        System.out.println("annotation 방식 destroy()호출 : " + destroyCount++);
    }
}
