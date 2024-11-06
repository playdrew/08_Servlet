package com.ohgiraffers.jsp.controller;

import com.ohgiraffers.jsp.service.NumberCalculator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calculator/operation")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String operatorName = req.getParameter("operatorName");
        double firstNumber = Double.parseDouble(req.getParameter("firstNumber"));
        double secondNumber = Double.parseDouble(req.getParameter("secondNumber"));
        
        double totalValue = new NumberCalculator().calcTotal(operatorName,firstNumber,secondNumber);

        req.setAttribute("operatorName",operatorName);
        req.setAttribute("firstNumber",firstNumber);
        req.setAttribute("secondNumber",secondNumber);
        req.setAttribute("totalValue",totalValue);

        RequestDispatcher rd = req.getRequestDispatcher("/jsp/6_calculatorResponse.jsp");
        rd.forward(req,resp);
    }
}
