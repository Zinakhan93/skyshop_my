package org.skypro.skyshop.model.search;

public interface Searchable {
    String getSearchTerm();

    String getContentType();
    String getSearchableName();
    default String getStringRepresentation() {
        return String.format("%s-%s",getSearchableName(),getContentType());
    }


}