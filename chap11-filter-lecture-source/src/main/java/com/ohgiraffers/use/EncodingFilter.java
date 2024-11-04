package com.ohgiraffers.use;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// html 인코딩 문제를 필터를 사용해서 해결
/*comment. xml 방식으로 필터 생성*/
public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*comment.
        *   xml 설정한 init-param 의 key 를 이용히야
        *   config 객체에서 꺼낼 수 있다.
        * */

        // 필터 설정관련 filterConfig 에서 initParam 의 parma-name
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType(encodingType);
        
        // 필터체인이라는 매개변수로 지정한 서블릿 동작시킴
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

// view 페이지에 항상 contentType 을 만드는데 xml 로 지정하면 contentType 을 계속 작성할 필요가 없어지는 것입니다.