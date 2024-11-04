package com.ohgiraffers.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// first 로 시작하는 모든 요청을 걸려주겠다
// 클라이언트가 요청을 보내면 우리가 만든 서블릿은 요청에 따라 어떤 서블릿을 리턴할지를 고민하는데
// 필터는 url 을 확인하는데 first 로 시작하는 것에서 거름망을 만들겠다는 것입니다.

@WebFilter("/first/*")
public class firstFilter implements Filter {

    public firstFilter(){
        System.out.println("필터 기본 생성자 호출됨...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter 인스턴스 최초 생성 시 호출됨...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*comment. doFilter 메소드는 request 가 전달되기 전에
        *          가로채어 무엇인 가 할 일을 작성한다
        * */


        System.out.println("doFilter() 호출됨...");
        
        // 필터에서 실행 할 코드 작성 영역
        // 매개변수의 메소드 
        // 실행 코드 실행 후 다음 필터 혹은 서블릿으로 doGet/doPost 호출
        filterChain.doFilter(servletRequest, servletResponse);
        
        // 서블릿에서 처리 후 다시 수행 할 내용 있으면 작성하는 영역
        System.out.println("Servlet 할 일 끝");
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter 인스턴스 소멸됨..");
    }

    // 클라이언트가 요청을 보내면 서블릿이 호출전에 필터가 한번 거름망을 해주는 거에요
}
