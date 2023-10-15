package com.example.ss2_2.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepository implements ICalculatorRepository {
    @Override
    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "subtraction":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "division":
               return num1 / num2;
            default:
                return num1 + num2;
        }
    }
}
