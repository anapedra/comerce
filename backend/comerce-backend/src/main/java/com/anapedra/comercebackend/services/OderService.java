package com.anapedra.comercebackend.services;

import com.anapedra.comercebackend.dtos.*;
import com.anapedra.comercebackend.entities.Employee;
import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.entities.OrderItem;
import com.anapedra.comercebackend.entities.User;
import com.anapedra.comercebackend.entities.pk.OrderItemPK;
import com.anapedra.comercebackend.repositories.EmployeeRepository;
import com.anapedra.comercebackend.repositories.OrderItemRepository;
import com.anapedra.comercebackend.repositories.OrderRepository;
import com.anapedra.comercebackend.repositories.UserRepository;
import com.anapedra.comercebackend.services.exceptionservice.DataBaseException;
import com.anapedra.comercebackend.services.exceptionservice.ResourceNotFoundException;
import com.anapedra.comercebackend.services.exceptionservice.UnauthorizedException;
import net.bytebuddy.asm.Advice;
import org.apache.http.annotation.Contract;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OderService{

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final OrderItemRepository orderItemRepository;
    private final EmployeeRepository employeeRepository;
    public OderService(OrderRepository orderRepository,  UserRepository
            userRepository,  OrderItemRepository orderItemRepository, EmployeeRepository employeeRepository) {
        this.orderRepository = orderRepository;

        this.userRepository = userRepository;

        this.orderItemRepository = orderItemRepository;
        this.employeeRepository = employeeRepository;
    }



    @Transactional(readOnly = true)
    public Page<OrderDTO> find(Long clientId,Long sellerId,String nameClient,String nameSeller,String cpfClient,String minDate, String maxDate, Pageable pageable){

        User client=(clientId == 0) ? null : userRepository.getOne(clientId);
        Employee seller=(sellerId == 0) ? null : employeeRepository.getOne(sellerId);
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        Page<Order> page=orderRepository.find(client,seller,nameClient,nameSeller,cpfClient,min,max,pageable);
        orderRepository.findOrder(page.stream().collect(Collectors.toList()));
        return page.map(OrderDTO::new);
    }



    @Transactional(readOnly = true)
    public List<SaleDTO> findSummary(String minDate, String maxDate){
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        List<Order> list=orderRepository.findSummary(min,max);
        return list.stream().map(SaleDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<SellerSaleMinDTO> SumSaleBySeller(String minDate, String maxDate,String cpfSeller){
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        List<Order> list=orderRepository.sumSaleBySeller(min,max,cpfSeller);
        return list.stream().map(SellerSaleMinDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<SalesClientSellerDTO> findSummaryOserClientSeller(String minDate, String maxDate){
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        List<Order> list=orderRepository.findSummary(min,max);
        orderRepository.sum(list.stream().collect(Collectors.toList()));
        return list.stream().map(SalesClientSellerDTO::new).collect(Collectors.toList());
    }


/*
    @Transactional(readOnly = true)
    public List<SalesClientSellerDTO> findSummaryOserClientSellers(String minDate, String maxDate){
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        long days = ChronoUnit.DAYS.between(min,max);
        SalesClientSellerDTO clientSellerDTO=new SalesClientSellerDTO();
        clientSellerDTO.setAverageSales(clientSellerDTO.getTotal()/days) ;
        List<Order> list=orderRepository.findSummary(min,max);
        return list.stream().map(SalesClientSellerDTO::new).collect(Collectors.toList());
    }

 */

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Optional<Order> obj=orderRepository.findById(id);
        Order entity=obj.orElseThrow(
                ()-> new ResourceNotFoundException("Id "+id+" not found"));
        return new OrderDTO(entity,entity.getItems(),entity.getOfferProducts());
    }


    @Transactional(readOnly = true)
    public Page<OrderDTO> findAll(Pageable pageable) {
        Page<Order> page = orderRepository.findAll(pageable);
        return page.map(OrderDTO::new);
    }

    @Transactional(readOnly = true)
    public OrderDTO findByI(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        Order entity = obj.orElseThrow(
                () -> new ResourceNotFoundException("Entity not found"));
        return new OrderDTO(entity);
    }




    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        try {
           // authService.validateAdmin();
            var entity=new Order();
            copyDtoToEntity(dto,entity);
            entity=orderRepository.save(entity);
            return new OrderDTO(entity);
        }
        catch (NullPointerException e){
            throw new UnauthorizedException( "Full authentication is required to access this resource");
        }
    }

    @Transactional
    public OrderDTO update(Long id, OrderDTO dto){
        try {
            //  authService.validateSelf();
            var entity=new Order();
            copyDtoToEntity(dto,entity);
            entity=orderRepository.save(entity);
            return new OrderDTO(entity);
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
         //   authService.validateAdmin();
            orderRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id "+id+" not found!");
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException(" Integrity violation");
        }
        catch (NullPointerException e){
            throw new UnauthorizedException( "Full authentication is required to access this resource");
        }

    }

    private void copyDtoToEntity(OrderDTO dto, Order entity){
        entity.setMomentUpdate(Instant.now());
        if (entity.getMomentUpdate()==null){
            Instant.parse("Pedido sem auteração");
        }
        else {
            entity.setMomentUpdate(Instant.now());
        }
        entity.setStatus(dto.getStatus());
        entity.setMomentRegistration(Instant.now());
        entity.setMinAmountDiscount(dto.getAmountDiscount());
        entity.setAmountDiscount(dto.getDiscount());
        entity.setDateOrder(LocalDate.now());

       Employee employee=employeeRepository.getOne(dto.getSellerId());
       User user=userRepository.getOne(dto.getClientId());


        entity.getItems().clear();
        for (OrderItemDTO orderItemDTO: dto.getItems()){
            OrderItem orderItem= orderItemRepository.getOne(new OrderItemPK());
            entity.getItems().add(orderItem);
        }

        

    }

}




