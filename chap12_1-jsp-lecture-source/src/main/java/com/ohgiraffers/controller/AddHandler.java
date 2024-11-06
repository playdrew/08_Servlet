package com.ohgiraffers.controller;

import com.ohgiraffers.model.AddService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddHandler implements CommandHandler{

    private AddService addService = new AddService();

    @Override
    public String handlerAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int n1 = Integer.parseInt(request.getParameter("n1"));
        int n2 = Integer.parseInt(request.getParameter("n2"));

        int result = addService.add(n1,n2);

        request.setAttribute("result",result);

        return "/WEB-INF/add.jsp";
    }
}
