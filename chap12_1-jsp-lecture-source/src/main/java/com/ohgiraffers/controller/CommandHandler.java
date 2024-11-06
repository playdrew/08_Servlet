package com.ohgiraffers.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface CommandHandler {

    public String handlerAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
