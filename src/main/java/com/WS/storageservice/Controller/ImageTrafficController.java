package com.WS.storageservice.Controller;

import com.WS.storageservice.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Wayne Sidney
 * Created on {03/10/2022}
 */
@RestController
@RequestMapping("/image")
public class ImageTrafficController {

    @Autowired
    private StorageService storageService;

    @PostMapping
    private ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = storageService.uploadImage(file);

        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);

    }

    @GetMapping("/getImage/{fileName}")
    private ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] retrievedImage = storageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpeg"))
                .body(retrievedImage);

    }
}
