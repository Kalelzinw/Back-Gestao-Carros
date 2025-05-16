package com.example.gestao.carros.services;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;

@Service
public class FirebaseStorageService {

   
    public String uploadFile(InputStream fileStream, String fileName, String contentType) {
        try {
            Bucket bucket = StorageClient.getInstance().bucket();

            Blob blob = bucket.create(fileName, fileStream, contentType);

            // Retorna o link público do arquivo (se o bucket estiver configurado para isso)
            return blob.getMediaLink();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
