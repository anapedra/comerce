package com.anapedra.comercebackend.services;

import com.anapedra.comercebackend.dtos.OrderDTO;
import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.repositories.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }


    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Optional<Order> result = repository.findById(id);
        Order entity = result.get();
        return new OrderDTO(entity,entity.getItems());
    }
    @Transactional(readOnly = true)
    public Page<OrderDTO> findAllSale(Pageable pageable){
        Page<Order> page=repository.findAll(pageable);
        return page.map(OrderDTO::new);
    }
    /*

@Service
public class OderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    public OderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    @Transactional(readOnly = true)
    public Page<OrderDTO> findOder(String minDate, String maxDate, Pageable pageable){
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        Page<Order> page=orderRepository.findOrder(min,max,pageable);
        orderRepository.findAllOrder(page.stream().collect(Collectors.toList()));
        return page.map(OrderDTO::new);
    }


    @Transactional(readOnly = true)
    public Page<OrderDTO> findAllOrderByClient(Long clientId, Pageable pageable) {
        User client=(clientId == 0) ? null : userRepository.getOne(clientId);
        Page<Order> page= orderRepository.findOrderByClient(client,pageable);
        return page.map(OrderDTO::new);
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Optional<Order> obj=orderRepository.findById(id);
        Order entity=obj.orElseThrow(
                ()-> new ResourceNotFoundException("Id "+id+" not found"));
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
            throw new DatabaseException(" Integrity violation");
        }
        catch (NullPointerException e){
            throw new UnauthorizedException( "Full authentication is required to access this resource");
        }

    }

    private void copyDtoToEntity(OrderDTO dto, Order entity){
        entity.setDataOrder(LocalDate.now());
        entity.setMomentOrder(Instant.now());
        entity.setMomentUpdateOrder(Instant.now());
        entity.setOrderStatus(entity.getOrderStatus());

        User cl=new User();
        cl.setId(dto.getClient().getId());
        entity.setClient(cl);

    }

}


     */
}
