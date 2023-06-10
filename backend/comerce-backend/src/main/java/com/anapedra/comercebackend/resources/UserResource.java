package com.anapedra.comercebackend.resources;

public class UserResource {
    /*

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    private final UserService service;
    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        Page<UserDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping(value = "/roles")
    public ResponseEntity<Page<UserDTO>> findPostsByCategory(@RequestParam(value = "roleId",defaultValue = "0") Long roleId, Pageable pageable) {
        Page<UserDTO> list = service.findAllByRole(roleId,pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserInsertDTO dto) {
        UserDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dto) {
        UserDTO newDto = service.update(id, dto);
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
