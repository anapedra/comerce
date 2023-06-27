package com.anapedra.comercebackend.services;

import com.anapedra.comercebackend.dtos.ReportSaleDTO;
import com.anapedra.comercebackend.entities.ReportSale;
import com.anapedra.comercebackend.repositories.ReportSaleRepository;
import com.anapedra.comercebackend.services.exceptionservice.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleService {
 private final ReportSaleRepository reportSaleRepository;
    public SaleService(ReportSaleRepository reportSaleRepository) {
        this.reportSaleRepository = reportSaleRepository;
    }

    @Transactional(readOnly = true)
    public List<ReportSaleDTO> findAll() {
        List<ReportSale> list = reportSaleRepository.findAll();
        return list.stream().map(ReportSaleDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public ReportSaleDTO findById(Long id){
        Optional<ReportSale> obj=reportSaleRepository.findById(id);
        ReportSale entity=obj.orElseThrow(
                ()-> new ResourceNotFoundException("Id "+id+" not found"));
        return new ReportSaleDTO(entity,entity.getOrders());
    }
}


















