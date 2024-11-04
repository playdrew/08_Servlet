package com.ohgiraffers.jsp.controller;

import com.ohgiraffers.jsp.service.MenuPriceCalculator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//클라이언트가 요청을 받으면 응답을 해주는데
//필터는 한번 여과를 해줍니다. 사용자가 요청을 할때 서버에서 거름망을 해줘요. 응답을 할때도 마찬가지고요
//필터의 중요한 점 http request response 를 우리가 거름망을 해준다.
//로그인에서 많이 씁니다. 사용자 요청보내는데 들어갈수 있을지 없을지 이 사용자는 로그인가능 불가능 이페이지는 출입가능 불가능여부
//menu/order 뒤에 덧붙여서 menu/order/menu/regist 상대경로
// menu/order 하면 url을 바꿔요 절대경로 앞에 뭐가 있든지간에

//webapp/ 에서 webapp은 무시처리 jsp/menu/order 이런식으로 뒤에 달라붙는 상대경로
// 사용자의 요청을 서블릿이 받아들이고 서비스로직을 호출하고 서비스 로직이 끝나면 사용자에게 보여줄 뷰페이지를 보여줌
@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // name 속성의 amount
        // 사용자의 요청에 대한 처리
        String menuName = req.getParameter("menuName");
        int amount = Integer.parseInt(req.getParameter("amount"));

        // 비즈니스 로직 간단히 수행
        int totalPrice = new MenuPriceCalculator().calcTotalPrice(menuName,amount);

        // 다른 서블릿에서 사용할 값 setting
        req.setAttribute("menuName",menuName);
        req.setAttribute("amount",amount);
        req.setAttribute("totalPrice",totalPrice);

        // 포워드
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(req,resp);


    }
}
