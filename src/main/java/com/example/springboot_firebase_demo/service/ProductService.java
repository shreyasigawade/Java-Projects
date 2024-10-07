package com.example.springboot_firebase_demo.service;

import com.example.springboot_firebase_demo.entity.Product;
import com.example.springboot_firebase_demo.entity.ProductSearchRequest;
import com.example.springboot_firebase_demo.repository.ProductRespository;
import com.example.springboot_firebase_demo.utils.DButils;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService {

    @Autowired
    private ProductRespository productRespository;

    @Autowired
    private DButils dButils;

    public String saveproduct(Product product) throws ExecutionException, InterruptedException {
      return productRespository.saveProduct(product);

    }

    public Product getProductDetailsByName(String name) throws ExecutionException, InterruptedException {
        return productRespository.getProductByName(name);

//        Firestore db = FirestoreClient.getFirestore();
//
//        DocumentReference documentReference = db.collection(COLLECTION_NAME).document(name);
//
//        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
//
//        DocumentSnapshot documentSnapshot = apiFuture.get();
//        Product product = null;
//        if(documentSnapshot.exists()){
//             product = documentSnapshot.toObject(Product.class);
//            return product;
//        }else{
//            return null;
//        }

    }
    public List<Product> getProductDetails() throws ExecutionException, InterruptedException {

        return productRespository.getProductList();
//        Firestore db = FirestoreClient.getFirestore();
//
//        Iterable<DocumentReference> documentReference = db.collection(COLLECTION_NAME).listDocuments();
//        Iterator<DocumentReference> iterator = documentReference.iterator();
//        List<Product> productList = new ArrayList<>();
//        while(iterator.hasNext()){
//            DocumentReference documentReference1 = iterator.next();
//            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference1.get();
//            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
//
//            Product product = documentSnapshot.toObject(Product.class);
//            productList.add(product);
//        }
//
//        return productList;

    }

    public String updateProductDetails(String name, Product product) throws ExecutionException, InterruptedException {
        return productRespository.updateProductDetails(name, product);
//        Firestore db = FirestoreClient.getFirestore();
//
//        ApiFuture<WriteResult> collApiFutore = db.collection(COLLECTION_NAME).document(product.getName()).set(product);
//
//        return collApiFutore.get().getUpdateTime().toString();

    }

    public String deleteProduct(String name) throws ExecutionException, InterruptedException {
        return productRespository.deleteProduct(name);
//        Firestore db = FirestoreClient.getFirestore();
//
//        ApiFuture<WriteResult> collApiFutore = db.collection(COLLECTION_NAME).document(name).delete();
//
//        return "document "+name+ " has been deleted successfully";

    }

    public List<Product> getProductListBasedGreaterThanPrice(double price) throws ExecutionException, InterruptedException {
        return productRespository.getProductListBasedGreaterThanPrice(price);
    }

    public String performBatchOperations(String productToDelete, Product productToUpdate, Product productToAdd) throws ExecutionException, InterruptedException {
        return productRespository.performBatchOperations(productToDelete, productToUpdate, productToAdd);

    }

    public List<Product> advancedSearchProduct(ProductSearchRequest productSearchRequest) throws ExecutionException, InterruptedException {
        return productRespository.advancedSearchProduct(productSearchRequest);
    }
}
