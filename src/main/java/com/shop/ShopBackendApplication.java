package com.shop;

import com.shop.model.*;
import com.shop.repository.*;
import com.shop.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ShopBackendApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AddressRepository addressRepository;

    public ShopBackendApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        addAddresses();
//        addProducts();
//        addUsers();
//        addOrders();
//        addCategories();
//        setAddresses();
    }

    private void addAddresses(){
        Address a1 = new Address("city1","state1","country1","zip1");
        Address a2 = new Address("city2","state2","country2","zip2");

        addressRepository.save(a1);
        addressRepository.save(a2);
    }

    private void addProducts() {

//        Category c1 = new Category(1, "name1", "description1");

        Category c1 = categoryRepository.findById(new Long(1)).get();
        Category c2 = categoryRepository.findById(new Long(2)).get();
        Category c3 = categoryRepository.findById(new Long(3)).get();
//        Category c2= new Category(2,"name2","description2");
//        Category c3 = new Category(3,"name3","description1");
//        Category c4 = new Category(4,"name4","description1");

        Product p1 = new Product();
        p1.setName("name1");
        p1.setPrice(22.2);
        p1.setDescription("desc1");
//        p1.setCategories(Arrays.asList(categoryRepository.findById( new Long(1)).get(),categoryRepository.findById((new Long(2))).get()));
        p1.setCategories(Arrays.asList(c1,c3));
        Product p2 = new Product();
        p2.setName("name2");
        p2.setPrice(22.2);
        p2.setDescription("desc2");
        p2.setCategories(Arrays.asList(c2,c3));
//        p1.setCategories(Arrays.asList(categoryRepository.findById(new Long(1)).get(),categoryRepository.findById((new Long(3))).get()));
        productRepository.save(p1);
        productRepository.save(p2);
    }

    private void addUsers() {
        UserDTO u1 = new UserDTO();
        u1.setUsername("admin");
        u1.setPassword("admin");

        UserDTO u = new UserDTO();
        u.setUsername("user1");
        u.setPassword("user1");

        UserDTO u2 = new UserDTO();
        u2.setUsername("user2");
        u2.setPassword("user2");

        UserDTO u3 = new UserDTO();
        u3.setUsername("user3");
        u3.setPassword("user3");

        userDetailsService.save(u);
        userDetailsService.save(u1);
        userDetailsService.save(u2);
        userDetailsService.save(u3);
    }

    private void setAddresses(){
        Address a1 = addressRepository.findById(new Long(1)).get();
        Address a2 = addressRepository.findById(new Long(2)).get();

        DAOUser u1 = userDetailsService.getUser(new Long(1));
        DAOUser u2 = userDetailsService.getUser(new Long(2));
        DAOUser u3 = userDetailsService.getUser(new Long(3));

        userDetailsService.changeAddress(u1,a1);
        userDetailsService.changeAddress(u2,a1);
        userDetailsService.changeAddress(u3,a2);
    }

    private void addOrders() {
        Order o1 = new Order();
        o1.setStatus(OrderStatus.STATE1);
        o1.setUser(new DAOUser(1, "admin", "admin"));

        Product p1 = new Product(1, "name1", "desc1", 22.2);
        Product p2 = new Product(2, "name2", "desc2", 22.2);
        List products = Arrays.asList(p1, p2, p2);

//        o1.setProducts(products);

        orderRepository.save(o1);
    }

    private void addCategories() {
        Category c1 = new Category();
        c1.setName("name1");
        c1.setDescription("description1");

        Category c2 = new Category();
        c2.setName("name2");
        c2.setDescription("description2");

        Category c3 = new Category();
        c3.setName("name3");
        c3.setDescription("description3");

        Category c4 = new Category();
        c4.setName("name4");
        c4.setDescription("description4");

        categoryRepository.save(c1);
        categoryRepository.save(c2);
        categoryRepository.save(c3);
        categoryRepository.save(c4);
    }
}
