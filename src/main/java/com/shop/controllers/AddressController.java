package com.shop.controllers;

import com.shop.model.Address;
import com.shop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@RequestBody Address address){
        addressRepository.save(address);
    }

    @PutMapping
    public void modifyAddress(@RequestBody Address address){
        Address a = addressRepository.findById(address.getId()).get();
        a.setCity(address.getCity());
        a.setCountry(address.getCountry());
        a.setState(address.getState());
        a.setZip(address.getZip());

        addressRepository.save(a);
    }

//    //Fetches all articles
//    @GetMapping(value= "articles")
//    public ResponseEntity<List<ArticleInfo>> getAllArticles() {
//        List<ArticleInfo> responseArticleList = new ArrayList<>();
//        List<Article> articleList = articleService.getAllArticles();
//        for (int i = 0; i < articleList.size(); i++) {
//            ArticleInfo ob = new ArticleInfo();
//            BeanUtils.copyProperties(articleList.get(i), ob);
//            responseArticleList.add(ob);
//        }
//        return new ResponseEntity<List<ArticleInfo>>(responseArticleList, HttpStatus.OK);
//    }
//
//    //Creates a new article
//    @PostMapping(value= "article")
//    public ResponseEntity<Void> addArticle(@RequestBody ArticleInfo articleInfo, UriComponentsBuilder builder) {
//        Article article = new Article();
//        BeanUtils.copyProperties(articleInfo, article);
//        articleService.addArticle(article);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

}
