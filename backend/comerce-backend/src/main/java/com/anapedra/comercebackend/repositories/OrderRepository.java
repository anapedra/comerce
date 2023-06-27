package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Employee;
import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

//DEPIS TENTAR  POR C

    @Query("SELECT DISTINCT obj FROM Order obj INNER JOIN obj.client cli JOIN obj.seller sel WHERE " +
            "(COALESCE(:client) IS NULL OR cli IN :client) AND " +
            "(COALESCE(:seller) IS NULL OR sel IN :seller) AND " +
            " (LOWER(obj.client.name) LIKE LOWER(CONCAT('%',:nameClint,'%'))) AND" +
            " (LOWER(obj.seller.name) LIKE LOWER(CONCAT('%',:nameSeller,'%'))) AND" +
            " (LOWER(obj.client.cpf) LIKE LOWER(CONCAT('%',:cpfClient,'%'))) AND " +
            "obj.dateOrder BETWEEN :min AND :max ORDER BY obj.totalAmount DESC ")
    Page<Order> find(User client,User seller,String nameClint,String nameSeller,String cpfClient,LocalDate min, LocalDate max, Pageable pageable);
    @Query("SELECT obj FROM Order obj JOIN FETCH obj.client JOIN FETCH obj.seller WHERE obj IN :orders ")
    List<Order> findOrder(List<Order> orders);


    @Query("SELECT obj FROM Order obj WHERE " +
            "obj.dateOrder BETWEEN :min AND :max and " +
            "(LOWER(obj.client.name) LIKE LOWER(CONCAT('%',:nameClint,'%'))) ")
    Page<Order> findOrderbyNameClient(LocalDate min, LocalDate max,String nameClint , Pageable pageable);

    @Query("SELECT obj FROM Order obj WHERE " +
            "obj.dateOrder BETWEEN :min AND :max ")
    List<Order> findSummary(LocalDate min, LocalDate max);



//***********************************************************


    @Query("SELECT obj FROM Order obj JOIN obj.seller sel WHERE " +
            "obj.dateOrder BETWEEN :min AND :max and " +
            "(LOWER(obj.seller.cpf) LIKE LOWER(CONCAT('%',:cpfSeller,'%'))) ")
    List<Order> sumSaleBySeller(LocalDate min, LocalDate max,String cpfSeller);
    @Query("SELECT obj FROM Order obj JOIN FETCH obj.client JOIN FETCH obj.seller WHERE obj IN :orders ")
    List<Order> sum(List<Order> orders);


/*
    @Query("SELECT obj FROM Order obj JOIN obj.seller sel WHERE " +
            "obj.dateOrder BETWEEN :min AND :max and " +
            "(LOWER(sel.cpf) LIKE (:cpfSeller)) ")
    List<Order> sumSaleBySeller(LocalDate min, LocalDate max,String cpfSeller);

 */

    @Query("SELECT obj FROM Order obj WHERE " +
            "obj.dateOrder BETWEEN :min AND :max ")
    List<Order> sumSale(LocalDate min, LocalDate max);



















}

