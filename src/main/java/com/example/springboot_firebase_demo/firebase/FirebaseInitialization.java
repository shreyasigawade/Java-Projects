package com.example.springboot_firebase_demo.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Service;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitialization {

    @PostConstruct
    public void initialization() throws IOException {
        FileInputStream serviceAccount = null;
         serviceAccount =
                new FileInputStream("./serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

    }
}
