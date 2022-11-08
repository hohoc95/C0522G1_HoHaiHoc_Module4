package com.example.service.contract;

import com.example.model.contract.Contract;

import java.util.List;

public interface IContractService {
    void save(Contract contract);
    void update(Contract contract);

    List<Contract> findAll();
}
