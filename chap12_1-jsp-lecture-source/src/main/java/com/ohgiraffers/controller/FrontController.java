package com.ohgiraffers.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController extends HttpServlet {

    private Map<String,CommandHandler> commandHandlerMap = new HashMap<>();

    public void init() throws ServletException{
        commandHandlerMap.put("/add",new AddHandler());
        commandHandlerMap.put("/min",new MinHandler());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUrl = req.getRequestURI().toString();
        String command = requestUrl.substring(req.getContextPath().length());
        CommandHandler handler = null;
        String viewPage = null;

        if(requestUrl.indexOf(req.getContextPath())==0){
            handler = commandHandlerMap.get(command);
            viewPage = handler.handlerAction(req,resp);
        }
        req.getRequestDispatcher(viewPage).forward(req,resp);
    }
}
