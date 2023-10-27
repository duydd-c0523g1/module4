package com.library_manager.service;

import com.library_manager.model.RentalContract;

import java.util.List;

public interface IRentCodeService {
    List<RentalContract> findAllCode();
    List<RentalContract> checkIfCodeExist(int code);
    void saveRentCode(RentalContract rentalContract);
    void deleteRentCode(RentalContract rentalContract);
    RentalContract findRentCode(int code);
}
