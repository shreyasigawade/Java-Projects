package com.example.springboot_firebase_demo.repository;

import com.example.springboot_firebase_demo.entity.Product;
import com.example.springboot_firebase_demo.entity.ProductSearchRequest;

import com.example.springboot_firebase_demo.utils.DButils;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class ProductRespository {


    @Autowired
    private DButils dButils;

    public static final String COLLECTION_NAME = "products";

    public String saveProduct(Product product) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = db.collection(COLLECTION_NAME).document(product.getName()).set(product);
        return writeResultApiFuture.get().getUpdateTime().toString();
    }

    public List<Product> getProductList() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReferenceIterable = db.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> documentReferenceIterator = documentReferenceIterable.iterator();
        List<Product> productList = new ArrayList<>();
        while(documentReferenceIterator.hasNext()){
            DocumentReference documentReference = documentReferenceIterator.next();
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            Product product = documentSnapshot.toObject(Product.class);
            productList.add(product);
        }
        return productList;
    }

    public Product getProductByName(String name) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
        if(documentSnapshot.exists()){
            Product product = documentSnapshot.toObject(Product.class);
            return product;
        }else{
            return null;
        }
    }

    public String deleteProduct(String name) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = db.collection(COLLECTION_NAME).document().delete();
        writeResultApiFuture.get();
        return "document "+ name + "has been deleted successfully.";
    }

    public String updateProductDetails(String name, Product product) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
       ApiFuture<QuerySnapshot> querySnapshotApiFuture = db.collection(COLLECTION_NAME).whereEqualTo("name", name).get();
       List<QueryDocumentSnapshot> queryDocumentSnapshots = querySnapshotApiFuture.get().getDocuments();
       if(queryDocumentSnapshots.isEmpty()){
           return "no name found";
       }else{
           DocumentReference documentReference = queryDocumentSnapshots.get(0).getReference();
           ApiFuture<WriteResult> apiFuture = documentReference.set(product);
           apiFuture.get();
           return "product with "+ name + " has been updated successfully.";
       }
    }
    public List<Product> getProductListBasedGreaterThanPrice(double price) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> writeResultApiFuture = db.collection(COLLECTION_NAME).whereGreaterThanOrEqualTo("price", price).get();
        QuerySnapshot querySnapshot = writeResultApiFuture.get();
        List<Product> productList = new ArrayList<>();
        for(QueryDocumentSnapshot documentSnapshot: querySnapshot.getDocuments()){
            Product product = documentSnapshot.toObject(Product.class);
            productList.add(product);
        }
        return productList;
    }

    public String performBatchOperations(String productToDelete, Product productToUpdate, Product productToAdd) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        WriteBatch batch = db.batch();

        DocumentReference documentReference = db.collection(COLLECTION_NAME).document(productToDelete);
        DocumentReference documentReference1 = db.collection(COLLECTION_NAME).document();
        DocumentReference documentReference2 = db.collection(COLLECTION_NAME).document(productToUpdate.getName());

        batch.delete(documentReference);
        batch.set(documentReference1, productToAdd);
        batch.update(documentReference2, "name", productToUpdate.getName(), "description", productToUpdate.getDescription(),
                "price", productToUpdate.getPrice());
        ApiFuture<List<WriteResult>> writeResultApiFuture = batch.commit();
        List<WriteResult> results = writeResultApiFuture.get();
        return "Batch operations completed. Total operations: " + results.size();
    }

    public List<Product> advancedSearchProduct(ProductSearchRequest product) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        List<Product> result = new ArrayList<>();
        CollectionReference collectionReference = db.collection(COLLECTION_NAME);
        Query query = dButils.createAdvancedSearchFilter(product, collectionReference);
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = query.get();
        QuerySnapshot querySnapshot = querySnapshotApiFuture.get();
        if(!querySnapshot.isEmpty()){
            for(DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()){
                result.add(documentSnapshot.toObject(Product.class));

            }
        }
        return result;
    }

}
