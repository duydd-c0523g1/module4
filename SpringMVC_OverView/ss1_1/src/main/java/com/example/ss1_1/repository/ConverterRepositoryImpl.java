package com.example.ss1_1.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ConverterRepositoryImpl implements IConverterRepository {
    @Override
    public double convertUsdToVnd(String input) {
        return Double.parseDouble(input) * 23000;
    }

    @Override
    public double convertVndToUsd(String input) {
        return (Double.parseDouble(input) / 23000);
    }
}
