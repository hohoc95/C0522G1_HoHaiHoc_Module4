package com.example.service.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    void save(Contract contract);
    void update(Contract contract);

    List<Contract> findAll();

    Page<Contract> findByContract(Pageable pageable);
}
