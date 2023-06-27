package com.anapedra.comercebackend;

import com.anapedra.comercebackend.entities.*;
import com.anapedra.comercebackend.entities.enums.OrderStatus;
import com.anapedra.comercebackend.entities.enums.TypeAddress;
import com.anapedra.comercebackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://github.com/JodaOrg/joda-time

@SpringBootApplication
public class ComerceBackendApplication implements CommandLineRunner {
    private final ReportSaleRepository reportSaleRepository;
   private final ProductRepository productRepository;
   private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final OrderItemRepository orderItemRepository;
    private final RoleRepository roleRepository;
    private final TableShipRepository tableShipRepository;
    private final OfferProductRepository offerProductRepository;
   // private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final AddressRepository addressRepository;
    public ComerceBackendApplication(ReportSaleRepository reportSaleRepository, ProductRepository productRepository, OrderRepository orderRepository, UserRepository userRepository,
                                     EmployeeRepository employeeRepository, OrderItemRepository orderItemRepository, RoleRepository roleRepository,
                                     TableShipRepository tableShipRepository, OfferProductRepository offerProductRepository, CategoryRepository categoryRepository,
                                     AddressRepository addressRepository) {
        this.reportSaleRepository = reportSaleRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.orderItemRepository = orderItemRepository;
        this.roleRepository = roleRepository;
        this.tableShipRepository = tableShipRepository;
        this.offerProductRepository = offerProductRepository;
        this.categoryRepository = categoryRepository;
        this.addressRepository = addressRepository;

    }

    public static void main(String[] args) {
        SpringApplication.run(ComerceBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<OrderItem>orderItems=new ArrayList<>();
        List<User>clients=new ArrayList<>();
        List<Role>roles=new ArrayList<>();
    //    List<Phone>phones=new ArrayList<>();
     //   List<AdditionalData>additionalDataList=new ArrayList<>();
     //   List<Email>emails=new ArrayList<>();
        List<Address>addresses=new ArrayList<>();
        List<TableShip>tableShips=new ArrayList<>();
        List<Category>categories=new ArrayList<>();
        List<OfferProduct>offerProducts=new ArrayList<>();
        List<ReportSale>reportSales=new ArrayList<>();
      //  List<Ship>ships=new ArrayList<>();


        Address address1=new Address(1L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address2=new Address(2L, TypeAddress.SHIPPING_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address3=new Address(3L, TypeAddress.BELLING_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address4=new Address(4L, TypeAddress.DELIVERY_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address5=new Address(5L, TypeAddress.DELIVERY_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address6=new Address(6L, TypeAddress.BELLING_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address7=new Address(7L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address8=new Address(8L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address9=new Address(9L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address10=new Address(10L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address11=new Address(11L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station");
        Address address12=new Address(12L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SC","Close to train station");
        addresses.addAll(Arrays.asList(address1,address2,address3,address4,address5,address6,address7,address8,address9,address10,address11,address12));
        addressRepository.saveAll(addresses);



        Role role1=new Role(1L,"ROLE_ADMIN");
        Role role2=new Role(2L,"ROLE_CLIENT");
        roles.addAll(Arrays.asList(role1,role2));
        roleRepository.saveAll(roles);
        Employee sl1=new Employee(1L,"Luiza Brandão",Instant.parse("2017-09-24T08:00:00Z"),"6194523390","123655478","luiza@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address11,11.00,null,LocalDate.parse("2017-09-24"),null);
        Employee sl2=new Employee(2L,"Mara Vascon",Instant.parse("2019-02-23T08:00:00Z"),"8199855639","1237655479","maraca@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address6,5.000,null,LocalDate.parse("2019-02-23"),null);
        Employee sl3=new Employee(3L,"Lucas Marcone Silva",Instant.parse("2015-05-22T08:00:00Z"),"7184912587","126365478","lucasca@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address5,12.000,null,LocalDate.parse("2015-05-22"),null);
        Employee sl4=new Employee(4L,"Marta Pereira Martins",Instant.parse("2012-11-21T08:00:00Z"),"7296689950","123865478","mariasasa@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address3,8.000,null,LocalDate.parse("2012-11-21"),null);
        Employee sl5=new Employee(5L,"Luiz Soleto",Instant.parse("2011-01-14T08:00:00Z"),"123655478","1496633340","martata@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address2,3.000,null,LocalDate.parse("2011-01-14"),null);
        Employee sl6=new Employee(6L,"Mariele Aragão",Instant.parse("2017-09-29T08:00:00Z"),"123655478","1198755580","marielela@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address1,16.000,null,LocalDate.parse("2017-09-29"),null);
        User cl1=new User(7L,"Ana Bragalha",Instant.parse("2019-09-22T08:00:00Z"),"1236644475","2527869321","bragalha@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address12);
        User cl2=new User(8L,"Mari Ferreira",Instant.parse("2011-02-12T08:00:00Z"),"3598866458","25786938921","mapris@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address11);
        User cl3=new User(9L,"Sandra Magal Simão",Instant.parse("2017-01-20T08:00:00Z"),"6293344685","257869321","saidra@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address9);
        User cl4=new User(10L,"Helena Saldanha Filipa",Instant.parse("2018-02-21T08:00:00Z"),"6199658574","257869332421","helena@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address8);
        User cl5=new User(11L,"Mariana Prado",Instant.parse("2011-10-18T08:00:00Z"),"","8298813345","mariana@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address12);
        User cl6=new User(12L,"Socorro Ribeiro",Instant.parse("2019-01-23T08:00:00Z"),"6186938921","6186938921","socorro@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address1);
        User cl7=new User(13L,"Ana Prado Santana",Instant.parse("2017-06-02T08:00:00Z"),"1223655478","7127869363","anaca@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address9);
        User cl8=new User(14L,"Sandra Marcodes",Instant.parse("2013-02-28T08:00:00Z"),"7888965421","1157869358","saidrasa@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address7);
        User cl9=new User(15L,"Ana Matias",Instant.parse("2018-09-20T08:00:00Z"),"1293655478","1278693872","anapedra@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address2);
        User cl10=new User(16L,"Mari Samaria",Instant.parse("2000-09-20T08:00:00Z"),"4598698712","61786938975","anasa@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address4);
        User cl11=new User(17L,"Sandra Osca Sintra",Instant.parse("2017-10-21T08:00:00Z"),"7878965421","4578693218","saidrapa@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG",address1);
        clients.addAll(Arrays.asList(cl1, cl2, cl3, cl4,cl5,cl6,cl7,cl8,cl9,cl10,cl11));
        ArrayList sellers = new ArrayList(Arrays.asList(sl1, sl2, sl3, sl4,sl5,sl6));
        employeeRepository.saveAll(sellers);
        userRepository.saveAll(clients);
        sl1.getRoles().add(role1);
        sl2.getRoles().add(role1);
        sellers.addAll(Arrays.asList(sl1,sl2));
        employeeRepository.saveAll(sellers);

        Category cat1=new Category(null,"Eletronic",null,null);
        Category cat2=new Category(null,"Book",null,null);
        Category cat3=new Category(null,"Eletro domestico",null,null);
        categories.addAll(Arrays.asList(cat1,cat2,cat3));
        categoryRepository.saveAll(categories);

        Product p1=new Product(1L,Instant.parse("2017-09-25T08:00:00Z"),Instant.now(),"TV 60Pl","GGGGGGGGGGGGGGGGGGGGGGGGGGGGG",5.,50.,"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg",null,null);
        Product p2=new Product(2L,Instant.parse("2017-09-25T08:00:00Z"),Instant.now(),"PC GEME","GGGGGGGGGGGGGGGGGGGGGGGGGGGGG",5.,50.,"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg",null,null);
        Product p3=new Product(3L,Instant.parse("2017-09-25T08:00:00Z"),Instant.now(),"TV 30Pl","GGGGGGGGGGGGGGGGGGGGGGGGGGGGG",5.,50.,"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg",null,null);
        Product p4=new Product(4L,Instant.parse("2017-09-25T08:00:00Z"),Instant.now(),"DISKTOP","GGGGGGGGGGGGGGGGGGGGGGGGGGGGG",5.,50.,"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg",null,null);
        products.addAll(Arrays.asList(p1,p2,p3,p4));
        productRepository.saveAll(products);





        p1.getCategories().addAll(Arrays.asList(cat1,cat3));
        p2.getCategories().addAll(Arrays.asList(cat1,cat3,cat2));
        p3.getCategories().addAll(Arrays.asList(cat1,cat2));
        p4.getCategories().addAll(Arrays.asList(cat1,cat3,cat2));
        products.addAll(Arrays.asList(p1,p2,p3,p4));
        productRepository.saveAll(products);

        ReportSale r1 = new ReportSale(1L,"Report von Seller n° 1");
        ReportSale r2 = new ReportSale(2L,"Report von Seller n° 2");
        reportSales.addAll(Arrays.asList(r2,r1));
        reportSaleRepository.saveAll(reportSales);

        Order o1=new Order(1L, Instant.parse("2000-11-01T08:00:00Z"), LocalDate.parse("2000-11-01"),null ,25.00,OrderStatus.WAITING_PAYMENT,null,sl1,cl1,0.05,r1);
        Order o2=new Order(2L, Instant.parse("2022-09-25T08:00:00Z"),LocalDate.parse("2022-09-25"),null ,25.00,OrderStatus.WAITING_PAYMENT,null,sl2,cl2,0.05,r1);
        Order o3=new Order(3L, Instant.parse("2023-01-25T08:00:00Z"), LocalDate.parse("2023-01-25"),null,25.00,OrderStatus.WAITING_PAYMENT,null,sl3,cl1,0.05,r1);
        Order o4=new Order(4L,Instant.now(),LocalDate.now(),null,25.00,OrderStatus.WAITING_PAYMENT,null,sl1,cl1,0.05,r1);
        Order o5=new Order(5L,Instant.now(),LocalDate.now(),null,25.00,OrderStatus.WAITING_PAYMENT,null,sl1,cl1,0.05,r1);

        orders.addAll(Arrays.asList(o1,o2,o3,o4,o5));
        orderRepository.saveAll(orders);

        OfferProduct of1=new OfferProduct(1L,"Offer, mother's day",LocalDate.parse("2018-03-01"),LocalDate.parse("2018-03-25"),0.03,null,p1,o1);
        offerProducts.addAll(Arrays.asList(of1));
        offerProductRepository.saveAll(offerProducts);
        orders.addAll(Arrays.asList(o1));
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
        OrderItem ot14 = new OrderItem(o4,p4,1, p3.getInitialPrice());

        orderItems.addAll(Arrays.asList(ot1,ot2,ot3,ot4,ot5,ot6,ot7,ot8,ot9,ot10,ot11,ot12,ot13,ot14));
        orderItemRepository.saveAll(orderItems);

        orders.addAll(Arrays.asList(o1,o2,o3,o4));
        orderRepository.saveAll(orders);

        TableShip tableShip1=new TableShip(1L,250.800,580.900,0.02,0.05);
        tableShips.addAll(Arrays.asList(tableShip1));
        tableShipRepository.saveAll(Arrays.asList(tableShip1));
        orderItems.addAll(Arrays.asList(ot1,ot2,ot3,ot4,ot5,ot6,ot7,ot8,ot9,ot10,ot11,ot12,ot13,ot14));
        orderItemRepository.saveAll(orderItems);

        orders.addAll(Arrays.asList(o1,o2,o3,o4));
        orderRepository.saveAll(orders);
/*
        Ship ship1=new Ship(1L,null,null,null,null,o1,tableShip1);
        Ship ship2=new Ship(2L,null,null,null,null,o3,tableShip1);
        Ship ship3=new Ship(3L,null,null,null,null,o2,tableShip1);

       ships.addAll(Arrays.asList(ship1,ship2,ship3));
        shipRepository.saveAll(ships);
        orders.addAll(Arrays.asList(o1,o2,o3,o4));
        orderRepository.saveAll(orders)
        ;
 */
/*



 */













/*



 */

    }
    /*
    INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_category (name, created_At) VALUES ('Livros', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Eletrônicos', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Computadores', NOW());

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('The Lord of the Rings', 90.5, TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Smart TV', 2190.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Macbook Pro', 1250.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer', 1200.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/4-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Rails for Dummies', 100.99, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/5-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Ex', 1350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/6-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer X', 1350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/7-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Alfa', 1850.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/8-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Tera', 1950.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/9-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Y', 1700.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/10-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Nitro', 1450.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/11-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Card', 1850.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/12-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Plus', 1350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/13-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Hera', 2250.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/14-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Weed', 2200.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/15-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Max', 2340.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/16-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Turbo', 1280.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/17-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Hot', 1450.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/18-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Ez', 1750.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/19-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Tr', 1650.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/20-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Tx', 1680.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/21-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Er', 1850.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/22-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Min', 2250.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/23-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Boo', 2350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/24-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Foo', 4170.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/25-big.jpg');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (8, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (9, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (10, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (11, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (12, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (13, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (14, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (15, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (16, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (17, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (18, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (19, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (20, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (21, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (22, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (23, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (24, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (25, 3);







        Reply reply1=new Reply(null,"Obrigada",user2,comment1, LocalDate.now(), LocalDate.now());
        Reply reply2=new Reply(null,"Obrigada",user1,comment2, LocalDate.now(), LocalDate.now());
        Reply reply3=new Reply(null,"Obrigada",user1,comment2, LocalDate.now(), LocalDate.now());
        Reply reply4=new Reply(null,"Obrigada",user2,comment4, LocalDate.now(), LocalDate.now());

        replies.addAll(Arrays.asList(reply1,reply2,reply3,reply4));
        replyRepository.saveAll(replies);






     */



}
/*
AdditionalData additionalData1=new AdditionalData(1L,null);
        AdditionalData additionalData2=new AdditionalData(2L,null);
        AdditionalData additionalData3=new AdditionalData(3L,null);
        AdditionalData additionalData4=new AdditionalData(4L,null);
        AdditionalData additionalData5=new AdditionalData(5L,null);
        AdditionalData additionalData6=new AdditionalData(6L,null);
        AdditionalData additionalData7=new AdditionalData(7L,null);
        AdditionalData additionalData8=new AdditionalData(8L,null);
        AdditionalData additionalData9=new AdditionalData(9L,null);
        AdditionalData additionalData10=new AdditionalData(10L,null);
        AdditionalData additionalData11=new AdditionalData(11L,null);
        AdditionalData additionalData12=new AdditionalData(12L,null);
        AdditionalData additionalData13=new AdditionalData(13L,null);
        AdditionalData additionalData14=new AdditionalData(14L,null);
        AdditionalData additionalData15=new AdditionalData(15L,null);
        AdditionalData additionalData16=new AdditionalData(16L,null);
        AdditionalData additionalData17=new AdditionalData(17L,null);
        AdditionalData additionalData18=new AdditionalData(18L,null);
        AdditionalData additionalData19=new AdditionalData(19L,null);
        AdditionalData additionalData20=new AdditionalData(20L,null);
        AdditionalData additionalData21=new AdditionalData(21L,null);
        AdditionalData additionalData22=new AdditionalData(22L,null);
        AdditionalData additionalData23=new AdditionalData(23L,null);
        AdditionalData additionalData24=new AdditionalData(24L,null);
        AdditionalData additionalData25=new AdditionalData(25L,null);
        AdditionalData additionalData26=new AdditionalData(26L,null);
        AdditionalData additionalData27=new AdditionalData(27L,null);
        AdditionalData additionalData28=new AdditionalData(28L,null);
        AdditionalData additionalData29=new AdditionalData(29L,null);
        AdditionalData additionalData30=new AdditionalData(30L,null);
        AdditionalData additionalData31=new AdditionalData(31L,null);
        AdditionalData additionalData32=new AdditionalData(32L,null);
        AdditionalData additionalData33=new AdditionalData(33L,null);
        AdditionalData additionalData34=new AdditionalData(34L,null);



        additionalDataList.addAll(Arrays.asList(additionalData1,additionalData2,additionalData3,additionalData4,
                additionalData5,additionalData6,additionalData7,additionalData8,additionalData9,additionalData10,
                additionalData11,additionalData12,additionalData13,additionalData14,additionalData15,additionalData16,additionalData17));
        additionalDataRepository.saveAll(additionalDataList);








        E

        Phone ph1=new Phone(1l,"6199632245", TypePhone.MOBILE_PHONE_WHATSAPP_TOO,"Every day and all day",additionalData14);
        Phone ph2=new Phone(2l,"61985583390", TypePhone.MOBILE_PHONE_ONLY,"every day in the afternoon",additionalData13);
        Phone ph3=new Phone(3l,"6133694455", TypePhone.HPME_PHONE,"On weekends from 8 am to 12 pm",additionalData17);

        Phone ph4=new Phone(4l,"6199632240", TypePhone.MOBILE_PHONE_WHATSAPP_TOO,"Every day and all day",additionalData15);
        Phone ph5=new Phone(5l,"61985583393", TypePhone.MOBILE_PHONE_ONLY,"every day in the afternoon",additionalData17);
        Phone ph6=new Phone(6l,"6133694457", TypePhone.HPME_PHONE,"On weekends from 8 am to 12 pm",additionalData13);

        Phone ph7=new Phone(7l,"6199632278", TypePhone.MOBILE_PHONE_WHATSAPP_TOO,"Every day and all day",additionalData15);
        Phone ph8=new Phone(8l,"61985583399", TypePhone.MOBILE_PHONE_ONLY,"every day in the afternoon",additionalData10);
        Phone ph9=new Phone(9l,"6133694454", TypePhone.HPME_PHONE,"On weekends from 8 am to 12 pm",additionalData5);

        Phone ph10=new Phone(10l,"61996322417", TypePhone.MOBILE_PHONE_WHATSAPP_TOO,"Every day and all day",additionalData4);
        Phone ph11=new Phone(11l,"61985583399", TypePhone.MOBILE_PHONE_ONLY,"every day in the afternoon",additionalData4);
        Phone ph12=new Phone(12l,"61336944533", TypePhone.HPME_PHONE,"On weekends from 8 am to 12 pm",additionalData4);

        Phone ph13=new Phone(13l,"61996322452", TypePhone.MOBILE_PHONE_WHATSAPP_TOO,"Every day and all day",additionalData3);
        Phone ph14=new Phone(14l,"61985583390", TypePhone.MOBILE_PHONE_ONLY,"every day in the afternoon",additionalData3);
        Phone ph15=new Phone(15l,"61336944557", TypePhone.HPME_PHONE,"On weekends from 8 am to 12 pm",additionalData3);

        Phone ph16=new Phone(16l,"61996322454", TypePhone.MOBILE_PHONE_WHATSAPP_TOO,"Every day and all day",additionalData2);
        Phone ph17=new Phone(17l,"61985583390", TypePhone.MOBILE_PHONE_ONLY,"every day in the afternoon",additionalData2);
        Phone ph18=new Phone(18l,"61336944557", TypePhone.HPME_PHONE,"On weekends from 8 am to 12 pm",additionalData2);

        Phone ph19=new Phone(19l,"61996322456", TypePhone.MOBILE_PHONE_WHATSAPP_TOO,"Every day and all day",additionalData1);
        Phone ph20=new Phone(20l,"61985583390", TypePhone.MOBILE_PHONE_ONLY,"every day in the afternoon",additionalData1);
        Phone ph21=new Phone(21l,"61336944557", TypePhone.HPME_PHONE,"On weekends from 8 am to 12 pm",additionalData1);

        phones.addAll(Arrays.asList(ph1,ph2,ph3,ph4,ph5,ph6,ph7,ph8,ph9,ph10,ph11,ph12,ph13,ph14,ph15,ph16,ph17,ph18,ph19,ph20,ph21));
        phoneListRepository.saveAll(phones);


        Email email1 = new Email(1L,"anasantana@gmail.com","just work matter",additionalData1);
        Email email2 = new Email(2L,"sandrasa@gmail.com","for product offers",additionalData1);
        Email email3 = new Email(3L,"anasantana@gmail.com","just work matter",additionalData2);
        Email email4 = new Email(4L,"anasantana@gmail.com","just work matter",additionalData2);
        Email email5 = new Email(5L,"anasantana@gmail.com","just work matter",additionalData6);
        Email email6 = new Email(6L,"anasantana@gmail.com","just work matter",additionalData4);
        Email email7 = new Email(7L,"anasantana@gmail.com","just work matter",additionalData10);
        Email email8= new Email(8L,"anasantana@gmail.com","just work matter",additionalData13);
        Email email9 = new Email(9L,"anasantana@gmail.com","just work matter",additionalData5);
        Email email10 = new Email(10L,"anasantana@gmail.com","just work matter",additionalData16);
        Email email11 = new Email(11L,"anasantana@gmail.com","just work matter",additionalData17);
        Email email12 = new Email(12L,"anasantana@gmail.com","just work matter",additionalData17);
        emails.addAll(Arrays.asList(email1,email2,email3,email4,email5,email6,email7,email8,email9,email10,email11,email12));
        emailRepository.saveAll(emails);

        Address address1=new Address(1L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData1);
        Address address2=new Address(2L, TypeAddress.SHIPPING_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData1);
        Address address3=new Address(3L, TypeAddress.BELLING_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData2);
        Address address4=new Address(4L, TypeAddress.DELIVERY_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData3);
        Address address5=new Address(5L, TypeAddress.DELIVERY_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData5);
        Address address6=new Address(6L, TypeAddress.BELLING_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData4);
        Address address7=new Address(7L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData6);
        Address address8=new Address(8L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData7);
        Address address9=new Address(9L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData8);
        Address address10=new Address(10L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData9);
        Address address11=new Address(11L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SP","Close to train station",additionalData10);
        Address address12=new Address(12L, TypeAddress.HOME_ADDRESS,"Expidicionario Luiz Caitano de Mora",05,"079-4589","Santa Adélia","São Paulo","SC","Close to train station",additionalData17);
        addresses.addAll(Arrays.asList(address1,address2,address3,address4,address5,address6,address7,address8,address9,address10,address11,address12));
        addressRepository.saveAll(addresses);

        TableShip tableShip1=new TableShip(1L,250.800,580.900,0.02,0.05);
        //Depis usar orietão objeto para pegar o endereço do user
        Ship ship1=new Ship(1L,null,null,LocalDate.parse(null),null,null,address4,null);
        Ship ship2=new Ship(2L,null,null,LocalDate.parse(null),null,null,address12,null);
        Ship ship3=new Ship(3L,null,null,LocalDate.parse(null),null,null,address4,null);
        Ship ship4=new Ship(4L,null,null,LocalDate.parse(null),null,null,address12,null);
        Ship ship5=new Ship(5L,null,null,LocalDate.parse(null),null,null,address4,null);

        ships.addAll(Arrays.asList(ship1,ship2));
        shipRepository.saveAll(ships);


 */