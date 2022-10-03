package com.WS.storageservice.Service;

import com.WS.storageservice.Entity.ImageData;
import com.WS.storageservice.Repository.ImageDataRepository;
import com.WS.storageservice.Utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Wayne Sidney
 * Created on {03/10/2022}
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private ImageDataRepository imageDataRepository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = imageDataRepository.save(
                ImageData.builder()
                        .fileName(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                        .build());
        if( imageData != null ){
            return "file uploaded successfully: " + file.getOriginalFilename();
        }
        return null;
    }

    @Override
    public byte[] downloadImage(String fileName) {
        Optional<ImageData> imageData = imageDataRepository.findByFileName(fileName);
        byte[] decompressedImage = ImageUtils.decompressImage(imageData.get().getImageData());
        return decompressedImage;

    }
}
