package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.ReportSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportSaleRepository extends JpaRepository<ReportSale,Long> {

}

/*
    @Query("SELECT obj FROM CalcSale obj INNER JOIN obj.orders ord WHERE " +
            "ord.dateOrder BETWEEN :min AND :max and " +
            "(LOWER(ord.client.cpf) LIKE LOWER(CONCAT('%',:cpfClient,'%'))) AND " +
            "(LOWER(ord.seller.cpf) LIKE LOWER(CONCAT('%',:cpfSeller,'%'))) ")
    CalcSale findAmountSale(LocalDate min, LocalDate max,String cpfClient ,String cpfSeller);
    @Query("SELECT obj FROM CalcSale obj JOIN FETCH obj.orders WHERE " +
            "obj IN :sales ")
    CalcSale find(CalcSale sales);




    @Query("SELECT obj FROM ReportSaleRepository obj WHERE " +
            "obj.date BETWEEN :min AND :max ")
    List<ReportSaleRepository> findAllSummary(LocalDate min, LocalDate max);

 */

    /*
    @Query("SELECT DISTINCT obj FROM Order obj INNER JOIN obj.client cli JOIN obj.seller sel WHERE " +
            "(COALESCE(:client) IS NULL OR cli IN :client) AND " +
            "(COALESCE(:seller) IS NULL OR sel IN :seller) AND " +
            " (LOWER(obj.client.name) LIKE LOWER(CONCAT('%',:nameClint,'%'))) AND" +
            " (LOWER(obj.seller.name) LIKE LOWER(CONCAT('%',:nameSeller,'%'))) AND" +
            " (LOWER(obj.client.cpf) LIKE LOWER(CONCAT('%',:cpfClient,'%'))) AND " +
            "obj.dateOrder BETWEEN :min AND :max ORDER BY obj.totalAmount DESC ")
    Page<Order> find(User client, User seller, String nameClint, String nameSeller, String cpfClient, LocalDate min, LocalDate max, Pageable pageable);
    @Query("SELECT obj FROM Order obj JOIN FETCH obj.client JOIN FETCH obj.seller WHERE obj IN :orders ")
    List<Order> findOrder(List<Order> orders);


    @Query("SELECT obj FROM Order obj WHERE " +
            "obj.dateOrder BETWEEN :min AND :max and " +
            "(LOWER(obj.client.name) LIKE LOWER(CONCAT('%',:nameClint,'%'))) ")
    Page<Order> findOrderbyNameClient(LocalDate min, LocalDate max,String nameClint , Pageable pageable);

    @Query("SELECT obj FROM Order obj WHERE " +
            "obj.dateOrder BETWEEN :min AND :max ")
    List<Order> findSummary(LocalDate min, LocalDate max);
    ******************************************
    @Query("SELECT obj FROM ReportSaleRepository obj WHERE " +
            "obj.date BETWEEN :min AND :max and " +
      "(LOWER(obj.seller.name) LIKE LOWER(CONCAT('%',:name,'%'))) ")
    Page<ReportSaleRepository> findAllSale(LocalDate min, LocalDate max,String name , Pageable pageable);
    @Query("SELECT obj FROM ReportSaleRepository obj JOIN FETCH obj.seller WHERE " +
            "obj IN :sales ")
    List<ReportSaleRepository> findAllSales(List<ReportSaleRepository>sales);




    @Query("SELECT obj FROM ReportSaleRepository obj WHERE " +
            "obj.date BETWEEN :min AND :max ")
    List<ReportSaleRepository> findAllSummary(LocalDate min, LocalDate max);
     */





