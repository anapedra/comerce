package com.anapedra.comercebackend.resources;

public class RoleResource {
    /*

@RestController
@RequestMapping(value = "/roles")
public class RoleResource {

    private final RoleService service;
    public RoleResource(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> findAll() {
        List<RoleDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleDTO> findById(@PathVariable Long id) {
        RoleDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> insert(@RequestBody @Valid RoleDTO dto) {
        RoleDTO newDto = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RoleDTO> update(@PathVariable Long id, @RequestBody @Valid RoleDTO dto) {
        RoleDTO newDto = service.upDate(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


     */
}
