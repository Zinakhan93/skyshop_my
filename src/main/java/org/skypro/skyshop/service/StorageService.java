package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class StorageService {
    private final Map<UUID, Product> products  = new HashMap<>();
    private final Map<UUID, Article> articles = new HashMap<>();

    public StorageService(){
        initData();
    };
    private void initData(){
        addProduct(new SimpleProduct(UUID.randomUUID(), "Яблоко", 300));
        addProduct(new FixPriceProduct(UUID.randomUUID(), "Молоко"));
        addProduct(new DiscountedProduct(UUID.randomUUID(), "Хлеб",150,10));
        addProduct(new SimpleProduct(UUID.randomUUID(),"Кефир",80));
        addArticle(new Article(UUID.randomUUID(), "Кефир", "Содержание жиров 0%"));
        addArticle(new Article(UUID.randomUUID(), "Хлеб", "Содержание злаков"));

    }
    private void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    private void addArticle(Article article) {
        articles.put(article.getId(), article);
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
