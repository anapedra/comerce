package com.anapedra.comercebackend.services;

public class CategoryService {
    /*
     private final CategoryRepository categoryRepository;
    private final AuthService authService;
    private final ProductRepository postRepository;
    public CategoryService(CategoryRepository categoryRepository, AuthService authService, ProductRepository postRepository) {
        this.categoryRepository = categoryRepository;
        this.authService = authService;
        this.postRepository = postRepository;
    }


    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        //Publico
        List<Category> list=categoryRepository.findAll();
        return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id){
        //Publico
        Optional<Category> obj=categoryRepository.findById(id);
        Category entity=obj.orElseThrow(
                ()-> new ResourceNotFoundException("Id "+id+" not found"));
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        try {
            authService.validateAdmin();
            var category=new Category();
            category.setName(dto.getName());
            category=categoryRepository.save(category);
            return new CategoryDTO(category);
        }
        catch (NullPointerException e){
            throw new UnauthorizedException( "Full authentication is required to access this resource");
        }

    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO categoryDTO){
        try {
            authService.validateAdmin();
            var category= categoryRepository.getOne(id);
            category.setName(categoryDTO.getName());
            category=categoryRepository.save(category);
            return new CategoryDTO(category);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id " + id + " not found :(");
        }
        catch (NullPointerException e){
            throw new UnauthorizedException( "Full authentication is required to access this resource");
        }


    }
    @Transactional
    public void deleteById(Long id){

        try {
            authService.validateAdmin();
            categoryRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id "+id+" not found!");
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
        catch (NullPointerException e){
            throw new UnauthorizedException( "Full authentication is required to access this resource");
        }


    }
     */
}
