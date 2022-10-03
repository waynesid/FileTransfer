package com.WS.storageservice.Service;

import com.WS.storageservice.Entity.ImageData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Wayne Sidney
 * Created on {03/10/2022}
 */
public interface StorageService {

    public String uploadImage(MultipartFile file) throws IOException;
    public byte[] downloadImage(String fileName);
}
