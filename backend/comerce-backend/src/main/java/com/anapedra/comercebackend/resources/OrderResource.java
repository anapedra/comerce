package com.anapedra.comercebackend.resources;

import com.anapedra.comercebackend.dtos.OrderDTO;
import com.anapedra.comercebackend.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

private final OrderService service;
    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/report")
    public ResponseEntity<Page<OrderDTO>> findAll(Pageable pageable) {
        Page<OrderDTO> page = service.findAllSale(pageable);
        return ResponseEntity.ok().body(page);

    }
    /*

@RestController
@RequestMapping(value = "/ordrs")
public class OrderResource {

    private final OderService service;
    public OrderResource(OderService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Page<OrderDTO>> findAll(
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<OrderDTO> list = service.findOder(minDate,maxDate,pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("id") Long id) {
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

     */
}
