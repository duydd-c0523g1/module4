package com.library_manager.repository;

import com.library_manager.model.RentalContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRentCodeRepository extends JpaRepository<RentalContract, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM contracts WHERE code = :param")
    List<RentalContract> checkIfCodeExist(@Param("param") int code);
    RentalContract findRentCodeByCode(int code);
}
