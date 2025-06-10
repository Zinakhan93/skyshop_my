package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }
    public List<SearchResult> search(String pattern) {
        String lowerPattern = pattern.toLowerCase();
        return storageService.getAllSearchables().stream()
                .map(SearchResult::fromSearchable)
                .filter(sr -> sr.getName().toLowerCase().contains(lowerPattern))
                .collect(Collectors.toList());
    }


}



