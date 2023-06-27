package com.anapedra.comercebackend.services;

import com.anapedra.comercebackend.dtos.CategoryDTO;
import com.anapedra.comercebackend.dtos.OrderDTO;
import com.anapedra.comercebackend.entities.Category;
import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.entities.User;
import com.anapedra.comercebackend.repositories.CategoryRepository;
import com.anapedra.comercebackend.services.exceptionservice.DataBaseException;
import com.anapedra.comercebackend.services.exceptionservice.ResourceNotFoundException;
import com.anapedra.comercebackend.services.exceptionservice.UnauthorizedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

     private final CategoryRepository categoryRepository;
     private final AuthService authService;
    public CategoryService(CategoryRepository categoryRepository, AuthService authService) {
        this.categoryRepository = categoryRepository;
        this.authService = authService;
    }
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list=categoryRepository.findAll();
        return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }



    /*
      @Transactional(readOnly = true)
    public Page<PostDTO> findPost(Long categoryId,Long authorId,String minDate, String maxDate, Pageable pageable){
        List<Category>list=(categoryId == 0) ? null : List.of(categoryRepository.getOne(categoryId));
        User author=(authorId == 0) ? null : userRepository.getOne(authorId);
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        Page<Post> page=postRepository.findPost(list,author,min,max,pageable);
        postRepository.findAllPost(page.stream().collect(Collectors.toList()));
        return page.map(PostDTO::new);
    }

     */


    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id){
        Optional<Category> obj=categoryRepository.findById(id);
        Category entity=obj.orElseThrow(
                ()-> new ResourceNotFoundException("Id "+id+" not found"));
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        try {
          //  authService.validateAdmin();
            var category=new Category();
            category.setDescription(category.getDescription());
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
           // authService.validateAdmin();
            var category= categoryRepository.getOne(id);
            category.setDescription(category.getDescription());
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
          //  authService.validateAdmin();
            categoryRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id "+id+" not found!");
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrity violation");
        }
        catch (NullPointerException e){
            throw new UnauthorizedException( "Full authentication is required to access this resource");
        }


    }

}
