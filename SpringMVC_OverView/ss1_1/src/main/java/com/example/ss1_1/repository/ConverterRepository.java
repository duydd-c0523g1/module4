package com.example.ss1_1.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ConverterRepository implements IConverterRepository {
    @Override
    public double convertUsdToVnd(double input) {
        return input * 23000;
    }

    @Override
    public double convertVndToUsd(double input) {
        return input / 23000;
    }
}
