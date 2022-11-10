package com.example.service.contract.impl;

import com.example.model.contract.Contract;
import com.example.repository.contract.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void update(Contract contract) {

    }

    @Override
    public Contract findById(int id) {
        return iContractRepository.findById(id);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Page<Contract> findByContract(Pageable pageable) {
        return iContractRepository.findByContract(pageable);
    }

}
