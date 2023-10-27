package com.library_manager.service;

import com.library_manager.model.RentalContract;
import com.library_manager.repository.IRentCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentCodeService implements IRentCodeService {
    @Autowired
    private IRentCodeRepository rentCodeRepository;
    @Override
    public List<RentalContract> findAllCode() {
        return rentCodeRepository.findAll();
    }

    @Override
    public List<RentalContract> checkIfCodeExist(int code) {
        return rentCodeRepository.checkIfCodeExist(code);
    }

    @Override
    public void saveRentCode(RentalContract rentalContract) {
        rentCodeRepository.save(rentalContract);
    }

    @Override
    public void deleteRentCode(RentalContract rentalContract) {
        rentCodeRepository.delete(rentalContract);
    }

    @Override
    public RentalContract findRentCode(int code) {
        return rentCodeRepository.findRentCodeByCode(code);
    }
}
