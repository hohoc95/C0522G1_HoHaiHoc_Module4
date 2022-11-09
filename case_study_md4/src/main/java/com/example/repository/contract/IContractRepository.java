package com.example.repository.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract",nativeQuery = true)
    Page<Contract> findByContract(Pageable pageable);
}
