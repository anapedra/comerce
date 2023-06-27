package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Category;
import com.anapedra.comercebackend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

        @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cats WHERE " +
                "(COALESCE(:categories) IS NULL OR cats IN :categories ) AND " +
                "(LOWER(obj.shortDescription) LIKE LOWER(CONCAT('%',:productDescription,'%')))")
        Page<Product> find(List<Category> categories,String productDescription,Pageable pageable);
        @Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products ")
        List<Product> findProducts(List<Product> products);




















/*

    @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cats WHERE " +
             "(COALESCE(:categories) IS NULL OR cats IN :categories LIMIT 0,5) AND " +
             "(LOWER(obj.shortDescription) LIKE LOWER(CONCAT('%',:shortDescription,'%'))) " +
             "order by obj.initialPrice desc ")
    Page<Product> find(List<Category> categories, String shortDescription,Pageable pageable);
    @Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products ")
    List<Product> findProductsWithCategories(List<Product> products);


     @Query("SELECT obj FROM  Order  obj WHERE obj.dataOrder BETWEEN :min AND :max")
    Page<Order> findOrder(LocalDate min, LocalDate max, Pageable pageable);

    @Query("SELECT obj FROM Order obj JOIN FETCH obj.client WHERE obj IN :orders")
    List<Order> findAllOrder(List<Order>orders);

    @Query("SELECT DISTINCT obj FROM Order obj INNER JOIN obj.client cl WHERE " +
            "(:client IS NULL OR :client = obj.client) ")
    Page<Order> findOrderByClient(User client, Pageable pageable);

}

    @Query("SELECT DISTINCT obj FROM Post obj INNER JOIN obj.author aut WHERE " +
            " (COALESCE(:author) IS NULL OR aut IN :author)")
    Page<Post> findPostAuthor(User author, Pageable pageable);

      @Query("SELECT DISTINCT obj FROM Order obj INNER JOIN obj.client cl WHERE " +
            "(:client IS NULL OR :client = obj.client) AND " +
            "obj.momentOrder BETWEEN :min AND :max")
    Page<Order> findOrder(LocalDate min, LocalDate max, Pageable pageable);


    @Query("SELECT obj FROM  Order  obj WHERE obj.dataOrder BETWEEN :min AND :max")
    Page<Order> findOrder(LocalDate min, LocalDate max, Pageable pageable);

    @Query("SELECT obj FROM Order obj JOIN FETCH obj.client WHERE obj IN :orders")
    List<Order> findAllOrder(List<Order>orders);

    @Query("SELECT DISTINCT obj FROM Order obj INNER JOIN obj.client cl WHERE " +
            "(:client IS NULL OR :client = obj.client) ")
    Page<Order> findOrderByClient(User client, Pageable pageable);

}

    @Query("SELECT DISTINCT obj FROM Post obj INNER JOIN obj.author aut WHERE " +
            " (COALESCE(:author) IS NULL OR aut IN :author)")
    Page<Post> findPostAuthor(User author, Pageable pageable);

      @Query("SELECT DISTINCT obj FROM Order obj INNER JOIN obj.client cl WHERE " +
            "(:client IS NULL OR :client = obj.client) AND " +
            "obj.momentOrder BETWEEN :min AND :max")
    Page<Order> findOrder(LocalDate min, LocalDate max, Pageable pageable);


    **********
@Query("SELECT DISTINCT obj FROM User obj INNER JOIN obj.roles rol WHERE " +
        " (COALESCE(:roles) IS NULL OR rol IN :roles)")
    Page<User> findUserRole(List<Role> roles, Pageable pageable);

        */
        }









