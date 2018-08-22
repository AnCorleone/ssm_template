package com.anran.tmall.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/15
 * @time 14:38
 * 描述    ${TODO}
 */
public class UploadedImageFile {
   private MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
