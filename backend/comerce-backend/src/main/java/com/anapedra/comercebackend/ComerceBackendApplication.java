package com.anapedra.comercebackend;

import com.anapedra.comercebackend.entities.*;
import com.anapedra.comercebackend.entities.enums.OrderStatus;
import com.anapedra.comercebackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ComerceBackendApplication implements CommandLineRunner {
   private final ProductRepository productRepository;
   private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final OrderItemRepository orderItemRepository;
    public ComerceBackendApplication(ProductRepository productRepository, OrderRepository orderRepository, UserRepository userRepository, EmployeeRepository employeeRepository, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ComerceBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<OrderItem>orderItems=new ArrayList<>();

        Employee sl1=new Employee(1L,null,"Pedro",Instant.parse("2017-09-25T08:00:00Z"),"257869321","pedro@gmaol.com","123",null,10.000,LocalDate.now(),null);
        Employee sl2=new Employee(2L,null,"Maria Satana",Instant.parse("2017-09-25T08:00:00Z"),"257869321","maria@gmaol.com","123",null,8.000,LocalDate.now(),null);
        Employee sl3=new Employee(3L,null,"Sanmaria",Instant.parse("2017-09-25T08:00:00Z"),"257869321","samaria@gmaol.com","123",null,5.000,LocalDate.now(),null);
        Employee sl4=new Employee(4L,null,"Luiza",Instant.parse("2017-09-25T08:00:00Z"),"257869321","luiza@gmaol.com","123",null,5.000,LocalDate.now(),null);
        ArrayList sellers = new ArrayList(Arrays.asList(sl1, sl2, sl3, sl4));
        employeeRepository.saveAll(sellers);

        User cl1=new User(5L,"Ana",Instant.parse("2017-09-25T08:00:00Z"),"257869321","ana@gmaol.com","123",null);
        User cl2=new User(6L,"Mari",Instant.parse("2017-09-25T08:00:00Z"),"257869321","mari@gmaol.com","123",null);
        User cl3=new User(7L,"Sandra",Instant.parse("2017-09-25T08:00:00Z"),"257869321","sadra@gmaol.com","123",null);
        User cl4=new User(8L,"Helena",Instant.parse("2017-09-25T08:00:00Z"),"257869321","helena@gmaol.com","123",null);
        List<User> clients = new ArrayList<>(Arrays.asList(cl1, cl2, cl3, cl4));
        userRepository.saveAll(clients);

        Product p1 = new Product(1L, "computador", "Computar ultima geração", Instant.parse("2017-09-25T08:00:00Z"), Instant.parse("2017-09-25T08:00:00Z"), 33.5, 55.5, null);
        Product p2 = new Product(2L, "Tv", "Computar ultima geração", Instant.parse("2017-09-25T08:00:00Z"), Instant.parse("2017-09-25T08:00:00Z"), 33.5, 55.5, null);
        Product p3 = new Product(3L, "Game", "Computar ultima geração", Instant.parse("2017-09-25T08:00:00Z"), Instant.parse("2017-09-25T08:00:00Z"), 33.5, 55.5, null);
        Product p4 = new Product(4L, "PC Game", "Computar ultima geração", Instant.parse("2017-09-25T08:00:00Z"), Instant.parse("2017-09-25T08:00:00Z"), 33.5, 55.5, null);
        products.addAll(Arrays.asList(p1,p2,p3,p4));
        productRepository.saveAll(products);

        Order o1=new Order(1L, Instant.parse("2017-09-25T08:00:00Z"),Instant.parse("2017-09-25T11:00:00Z"), LocalDate.now(), OrderStatus.WAITING_PAYMENT,sl1,cl1);
        Order o2=new Order(2L, Instant.parse("2017-09-25T08:00:00Z"),Instant.parse("2017-09-25T11:00:00Z"), LocalDate.now(), OrderStatus.WAITING_PAYMENT,sl2,cl2);
        Order o3=new Order(3L, Instant.parse("2017-09-25T08:00:00Z"),Instant.parse("2017-09-25T11:00:00Z"), LocalDate.now(), OrderStatus.WAITING_PAYMENT,sl3,sl3);
        Order o4=new Order(4L, Instant.parse("2017-09-25T08:00:00Z"),Instant.parse("2017-09-25T11:00:00Z"), LocalDate.now(), OrderStatus.WAITING_PAYMENT,sl4,sl4);
        orders.addAll(Arrays.asList(o1,o2,o3,o4));
        orderRepository.saveAll(orders);

        OrderItem ot1 = new OrderItem(o1,p1,3, p1.getInitialPrice());
        OrderItem ot2 = new OrderItem(o1,p2,3, p2.getInitialPrice());
        OrderItem ot3 = new OrderItem(o1,p3,5, p3.getInitialPrice());
        OrderItem ot4 = new OrderItem(o1,p4,2, p4.getInitialPrice());

        OrderItem ot5 = new OrderItem(o2,p1,1, p1.getInitialPrice());
        OrderItem ot6 = new OrderItem(o2,p2,2, p2.getInitialPrice());
        OrderItem ot7 = new OrderItem(o2,p3,1, p3.getInitialPrice());
        OrderItem ot8 = new OrderItem(o2,p4,2, p4.getInitialPrice());

        OrderItem ot9 = new OrderItem(o3,p1,1, p1.getInitialPrice());
        OrderItem ot10 = new OrderItem(o3,p2,2, p2.getInitialPrice());
        OrderItem ot11 = new OrderItem(o3,p3,5, p3.getInitialPrice());
        OrderItem ot12 = new OrderItem(o3,p4,1, p4.getInitialPrice());

        OrderItem ot13 = new OrderItem(o4,p2,1, p2.getInitialPrice());
        OrderItem ot14 = new OrderItem(o4,p4,2, p3.getInitialPrice());

        orderItems.addAll(Arrays.asList(ot1,ot2,ot3,ot4,ot5,ot6,ot7,ot8,ot9,ot10,ot11,ot12,ot13,ot14));
        orderItemRepository.saveAll(orderItems);

        orders.addAll(Arrays.asList(o1,o2,o3,o4));
        orderRepository.saveAll(orders);

    }

}