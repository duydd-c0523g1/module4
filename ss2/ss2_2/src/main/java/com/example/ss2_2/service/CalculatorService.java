package com.example.ss2_2.service;

import com.example.ss2_2.repository.ICalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Autowired
    private ICalculatorRepository calculatorRepositoryl;
    @Override
    public double calculate(double num1, double num2, String operator) {
        return calculatorRepositoryl.calculate(num1, num2, operator);
    }
}
