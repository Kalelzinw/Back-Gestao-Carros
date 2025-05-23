   package com.example.gestao.carros.config;

   import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

   @Configuration
   public class FirebaseConfig {

       @PostConstruct
       public void init() {
           try {
               String filename = "serviceAccountKey.json";
               // Lê o arquivo JSON da pasta resources usando o ClassLoader
               InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream(filename);

               if (serviceAccount == null) {
                   System.err.println("Erro: Arquivo " + filename + " não encontrado em resources!");
                   throw new IllegalStateException("Arquivo " + filename + " não encontrado em resources");
               } else {
                   System.out.println("Arquivo " + filename + " encontrado no classpath."); // Adicionado log
               }

               FirebaseOptions options = FirebaseOptions.builder()
                       .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                       .setStorageBucket("gestao-carros-cfc5d.appspot.com")
                       .build();

               if (FirebaseApp.getApps().isEmpty()) {
                   FirebaseApp.initializeApp(options);
               }

               System.out.println("Firebase inicializado com sucesso!");

           } catch (IOException e) { // Trate IOException, que pode ocorrer ao ler o stream.
               e.printStackTrace();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }
   