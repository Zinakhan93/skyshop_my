package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

public class StorageService {
    private final Map<UUID, Product> products  = new HashMap<>();
    private final Map<UUID, Article> articles = new HashMap<>();

    public StorageService(){
        initData();
    };
    private void initData(){
        products.put(UUID.randomUUID(),new SimpleProduct("Яблоко",100));
        products.put(UUID.randomUUID(),new DiscountedProduct("Хлеб",150,10));
        products.put(UUID.randomUUID(),new FixPriceProduct("Молоко"));
        products.put(UUID.randomUUID(),new SimpleProduct("Кефир",80));
        articles.put(UUID.randomUUID(),new Article("Кефир", "Содержание жиров 0%"));
        articles.put(UUID.randomUUID(),new Article("Хлеб", "Содержание злаков"));
    }

    public List<Product> getAllProducts(){
        return new ArrayList<>( Collections.unmodifiableCollection(products.values()));
    }
    public List<Article> getAllArticles(){
        return new ArrayList<>( Collections.unmodifiableCollection(articles.values()));
    }

    public List<Searchable>getAll(){
        List<Searchable>result = new ArrayList<>();
        result.addAll(products.values());
        result.addAll(articles.values());
        return result;

    }


}
