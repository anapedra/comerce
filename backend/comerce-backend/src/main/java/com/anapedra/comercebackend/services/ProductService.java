package com.anapedra.comercebackend.services;

import com.anapedra.comercebackend.dtos.CategoryDTO;
import com.anapedra.comercebackend.dtos.OrderDTO;
import com.anapedra.comercebackend.dtos.ProductDTO;
import com.anapedra.comercebackend.entities.Category;
import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.entities.Product;
import com.anapedra.comercebackend.repositories.CategoryRepository;
import com.anapedra.comercebackend.repositories.OrderRepository;
import com.anapedra.comercebackend.repositories.ProductRepository;
import com.anapedra.comercebackend.services.exceptionservice.DataBaseException;
import com.anapedra.comercebackend.services.exceptionservice.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {


    private final AuthService authService;
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    public ProductService(AuthService authService, ProductRepository repository, CategoryRepository categoryRepository) {
        this.authService = authService;
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }


    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Long categoryId,String descriptionProduct,Pageable pageable){
        List<Category>categories = (categoryId == 0) ? null : Arrays.asList(categoryRepository.getOne(categoryId));
        Page<Product> page = repository.find(categories,descriptionProduct,pageable);
        repository.findProducts(page.stream().collect(Collectors.toList()));
        return page.map(ProductDTO::new);
    }
    /*

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Long categoryId,String descriptionProduct,String descriptionCategory,Pageable pageable){
        List<Category>categories = (categoryId == 0) ? null : Arrays.asList(categoryRepository.getOne(categoryId));
        Page<Product> page = repository.find(categories,descriptionProduct,descriptionProduct,pageable);
        repository.findProducts(page.stream().collect(Collectors.toList()));
        return page.map(ProductDTO::new);
    }
     */



/*


        /*

    @Transactional(readOnly = true)
    public Page<OrderDTO> findOder(String minDate, String maxDate, Pageable pageable){
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        Page<Order> page=orderRepository.findOrder(min,max,pageable);
        orderRepository.findAllOrder(page.stream().collect(Collectors.toList()));
        return page.map(OrderDTO::new);
    }


         */






@Transactional(readOnly = true)
public Page<ProductDTO> findAll(Pageable pageable) {
    Page<Product> page = repository.findAll(pageable);
    return page.map(x -> new ProductDTO(x));
}

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {

        entity.setShortDescription(dto.getShortDescription());
        entity.setFullDescription(dto.getFullDescription());
        entity.setInitialPrice(dto.getInitialPrice());
        entity.setProductCost(dto.getOfferProduct().getOfferPrice());
        entity.setMomentRegistration(Instant.now());
        entity.setMomentUpdate(Instant.now());
        entity.setImgUrl(dto.getImgUrl());
        entity.setProductCost(entity.getProductCost());


        entity.getCategories().clear();
        for (CategoryDTO catDto : dto.getCategories()) {
            Category category = categoryRepository.getOne(catDto.getId());
            entity.getCategories().add(category);
        }
    }

}




