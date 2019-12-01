//package com.shop.controllers;
//
//import com.shop.model.Company;
//import com.shop.model.DAOUser;
//import com.shop.model.Product;
//import com.shop.repository.CompanyRepository;
//import com.shop.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//@RestController
//@RequestMapping({"/company"})
//public class CompanyController {
//
//    @Autowired
//    CompanyRepository companyRepository;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Transactional
//    @GetMapping(produces = "application/json", path = "/delete")
//    public void clearData() {
//        companyRepository.deleteAll();
//        productRepository.deleteAll();
//    }
//
//    @Transactional
//    @GetMapping(produces = "application/json", path = "/save")
//    public void saveData() {
//        saveDataWithApproach1();
//        // saveDataWithApproach2();
//    }
//
//    @GetMapping(produces = "application/json", path = "companies")
//    public List<Company> getAllCompanies() {
//        return (List<Company>) companyRepository.findAll();
//    }
//
//    @GetMapping(produces = "application/json", path = "products")
//    public List<Product> getAllProducts() {
//        return (List<Product>) productRepository.findAll();
//    }
//
//    /**
//     * Save Company objects that include Product list
//     */
//    private void saveDataWithApproach1() {
//        Company apple = new Company("Apple");
//        Company samsung = new Company("Samsung");
//
//        Product iphone7 = new Product("Iphone 7", "desc1", apple);
//        Product iPadPro = new Product("IPadPro", "desc2", apple);
//
//        Product galaxyJ7 = new Product("GalaxyJ7", "desc3", samsung);
//        Product galaxyTabA = new Product("GalaxyTabA", "desc4", samsung);
//
//        apple.setProducts(new HashSet<Product>() {{
//            add(iphone7);
//            add(iPadPro);
//        }});
//
//        samsung.setProducts(new HashSet<Product>() {{
//            add(galaxyJ7);
//            add(galaxyTabA);
//        }});
//
//        // save companies
//        companyRepository.save(apple);
//        companyRepository.save(samsung);
//    }
//
//
//}
