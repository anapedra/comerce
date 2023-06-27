package com.anapedra.comercebackend.resources;

import com.anapedra.comercebackend.dtos.ReportSaleDTO;
import com.anapedra.comercebackend.services.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sale")
public class SaleResource {

    private final SaleService service;
    public SaleResource(SaleService service) {
        this.service = service;
    }


    @GetMapping(value = "/amount")
    public ResponseEntity<List<ReportSaleDTO>> sum() {
       List<ReportSaleDTO> sellers = service.findAll();
        return ResponseEntity.ok().body(sellers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReportSaleDTO> findById(@PathVariable Long id) {
        ReportSaleDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}





/*

    @GetMapping(value = "/summary")
    public ResponseEntity<List<SaleDTO>> findSummary(
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate
    ) {
        List<SaleDTO> list = service.findSummary(minDate,maxDate);
        return ResponseEntity.ok().body(list);
    }

 */




