package com.anapedra.comercebackend.resources;

import com.anapedra.comercebackend.dtos.OrderDTO;
import com.anapedra.comercebackend.dtos.SaleDTO;
import com.anapedra.comercebackend.dtos.SalesClientSellerDTO;
import com.anapedra.comercebackend.dtos.SellerSaleMinDTO;
import com.anapedra.comercebackend.services.OderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    private final OderService service;
    public OrderResource(OderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<OrderDTO>> findAll(

            @RequestParam(value = "clientId",defaultValue = "0")Long clientId,
            @RequestParam(value = "sellerId",defaultValue = "0")Long sellerId,
            @RequestParam(value = "nameClient",defaultValue = "") String nameClient,
            @RequestParam(value = "nameSeller",defaultValue = "") String nameSeller,
            @RequestParam(value = "cpfClient",defaultValue = "") String cpfClient,
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<OrderDTO> list = service.find(clientId,sellerId,nameClient,nameSeller,cpfClient,minDate,maxDate,pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/summary")
    public ResponseEntity<List<SaleDTO>> findSummary(
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate

    ) {
        List<SaleDTO> list = service.findSummary(minDate,maxDate);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/sumSale")
    public ResponseEntity<List<SellerSaleMinDTO>> sumSale(
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate,
            @RequestParam(value = "cpf",defaultValue = "") String cpf
    ) {
        List<SellerSaleMinDTO> list = service.SumSaleBySeller(minDate,maxDate,cpf);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/report")
    public ResponseEntity<List<SalesClientSellerDTO>> findSummaryMitSellerAndClient(
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate
    ) {
        List<SalesClientSellerDTO> list = service.findSummaryOserClientSeller(minDate,maxDate);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findByI(@PathVariable Long id) {
        OrderDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody @Valid OrderDTO dto) {
        OrderDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody @Valid OrderDTO dto) {
        OrderDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }










}




