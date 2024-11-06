package com.ohgiraffers.jsp.service;

public class NumberCalculator {
    public double calcTotal(String operatorName , double firstNumber, double secondNumber) {

        double totalValue = 0.0;
        switch (operatorName){
            case "더하기" :
                totalValue = firstNumber+secondNumber;
                break;
            case "빼기" :
                totalValue = firstNumber-secondNumber;
                break;
            case "곱하기" :
                totalValue = firstNumber*secondNumber;
                break;
            case "나누기" :
                totalValue = firstNumber/secondNumber;
                break;
            case "모드연산" :
                totalValue = firstNumber%secondNumber;
                break;
        }

        return totalValue;
    }
}
