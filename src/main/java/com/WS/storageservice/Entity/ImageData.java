package com.WS.storageservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Wayne Sidney
 * Created on {03/10/2022}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "ImageDataTable")
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageId;
    private String fileName;
    private String type;
    @Lob
    @Column(name = "imageData")
    private byte[] imageData;
}
