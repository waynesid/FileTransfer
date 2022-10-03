package com.WS.storageservice.Repository;

import com.WS.storageservice.Entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Wayne Sidney
 * Created on {03/10/2022}
 */
public interface ImageDataRepository extends JpaRepository<ImageData, Long> {

    Optional<ImageData> findByFileName(String fileName);
}
