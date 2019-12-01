package com.shop.controllers;

import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/products"})
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

//    private List<Product> products = createList();

    @GetMapping(produces = "application/json")
    public List<Product> firstPage() {
        return (List<Product>) productRepository.findAll();
    }

//    @GetMapping(path = "/add")
//    public List<Product> createList() {
//        List<Product> tempProducts = new ArrayList<>();
//        Product p1 = new Product();
//        p1.setName("name1");
//        p1.setPrice(22.2);
//        p1.setDescription("desc1");
//
//        Product p2 = new Product();
//        p2.setName("name2");
//        p2.setPrice(22.2);
//        p2.setDescription("desc2");
//
//        tempProducts.add(p1);
//        tempProducts.add(p2);
//
//        productRepository.save(p1);
//        productRepository.save(p2);
//
//        return tempProducts;
//    }

//    @PostMapping
//    public Product addProduct(@RequestBody Product product) {
//        productRepository.save(product);
//        return product;
//    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productRepository.save(product));
    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/addmany")
//    public List<Product> addProducts(@RequestBody List<Product> products) {
//        for (Product product : products) {
//            productRepository.save(product);
//        }
//        return products;
//    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "update")
    public Product updateProduct(@RequestBody Product product) {
        Product p = productRepository.findById(product.getId()).get();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());

        productRepository.save(p);
        return p;
    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productRepository.findById(id).get();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/name/{name}")
    public List<Product> getProductsByName(@PathVariable("name") String name) {
        return productRepository.getProductsByName(name);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return productRepository.getProductsByCategory(category);
    }

    // @Get 
    //get by categories
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/category/{category}")
    public List<Product> getProductsByCategories(@PathVariable("category") String category) {
        return productRepository.getProductsByCategory(category);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/price")
    public List<Product> getProductsByBetweenPrice(@RequestParam double price1, @RequestParam double price2) {
        return productRepository.getAllBetweenPrices(price1, price2);
    }

}
