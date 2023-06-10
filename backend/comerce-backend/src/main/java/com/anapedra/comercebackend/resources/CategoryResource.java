package com.anapedra.comercebackend.resources;
/*
public class CategoryResource {


@RestController
@RequestMapping(value = "/categories")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CategoryResource {

    private final CategoryService service;
    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    /*
    @GetMapping(value = "/postss")
    public ResponseEntity<Page<CategoryDTO>> findCategoryByPost(@RequestParam(value = "postId",defaultValue = "0") Long postId, Pageable pageable) {
        Page<CategoryDTO> list = service.findAllByPost(postId,pageable);
        return ResponseEntity.ok().body(list);
    }

     */
    /*
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        CategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody @Valid CategoryDTO dto) {
        CategoryDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody @Valid CategoryDTO dto) {
        CategoryDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}




}

     */
