package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

  //Методы получения всех товаров и статей:
    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    // Метод получения всех Searchable (для поиска)
    public Collection<Searchable> getAllSearchables() {
        List<Searchable> list = new ArrayList<>();
        list.addAll(products.values());
        list.addAll(articles.values());
        return list;
    }



}
