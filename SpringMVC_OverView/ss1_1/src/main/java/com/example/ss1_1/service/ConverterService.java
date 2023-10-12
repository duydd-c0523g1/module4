package com.example.ss1_1.service;

import com.example.ss1_1.repository.IConverterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {
    @Autowired
    private IConverterRepository converterRepository;

    @Override
    public double convertUsdToVnd(double input) {
        return converterRepository.convertUsdToVnd(input);
    }

    @Override
    public double convertVndToUsd(double input) {
        return converterRepository.convertVndToUsd(input);
    }
}
