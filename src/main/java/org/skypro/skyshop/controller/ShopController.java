package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }
@GetMapping("/products")
    public List<Product>getAllProducts(){
        return storageService.getAllProducts();
    }
@GetMapping ("/articles")
    public  List<Article> getAllArticles(){
        return storageService.getAllArticles();
    }
@GetMapping ("/all")
    public List <Searchable> search (@RequestParam String query){
        return searchService.search(query);
    }
}
