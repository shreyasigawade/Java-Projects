package com.example.springboot_firebase_demo.utils;

import com.example.springboot_firebase_demo.entity.ProductSearchRequest;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Query;
import org.springframework.stereotype.Component;

@Component
public class DButils {
    public Query createAdvancedSearchFilter(ProductSearchRequest searchRequest, CollectionReference productsCollection){
        Query query = productsCollection;
        if(searchRequest.getName() != null && !searchRequest.getName().isEmpty()){
            query = query.whereEqualTo("name" , searchRequest.getName());
        }
        if (searchRequest.getDescription() != null && !searchRequest.getDescription().isEmpty()) {
            query = query.whereEqualTo("description", searchRequest.getDescription());
        }
        if(searchRequest.getPrice()!= 0){
            query = query.whereEqualTo("price", searchRequest.getPrice());
        }
        return query;
    }
}
