package com.codeit.blog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    // yml에 작성해 놓고 @Value 등으로 끌어오셔도 괜찮습니다.
    private final String uploadDir;

    public FileService(@Value("${blog.file-directory}") String uploadDir) {
        this.uploadDir = uploadDir;
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public String saveFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("파일이 비어있습니다.");
        }

        // 원본 파일명에서 확장자 추출
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

        // UUID를 활용하여 고유한 파일명 생성
        String savedFileName
                = UUID.randomUUID().toString().replaceAll("-", "") + extension;

        // 파일 저장
        File uploadPath = new File(uploadDir, savedFileName);

        try {
            file.transferTo(uploadPath);
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 실패!");
        }

        return savedFileName;

    }

    public void deleteFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) return;

        File file = new File(uploadDir + "/" + fileName);
        if (file.exists()) {
            file.delete();
        }
    }


}












