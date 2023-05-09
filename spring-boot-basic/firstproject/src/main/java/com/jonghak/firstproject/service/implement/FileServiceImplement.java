package com.jonghak.firstproject.service.implement;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jonghak.firstproject.service.FileService;

@Service
public class FileServiceImplement implements FileService {

    // @ file.path와 file.url 받아오기
    @Value("${file.path}")
    private String FILE_PATH;

    @Value("${file.url}")
    private String FILE_URL;

    @Override
    public String upload(MultipartFile file) {

        if (file.isEmpty())
            return null;

        // @ 파일명 가져오기
        String originalFileName = file.getOriginalFilename();
        // @ 확장자 가져오기
        // * 제일 마지막에 있는 .의 인덱스를 가져온다
        int extensionIndex = originalFileName.lastIndexOf(".");
        // * .인덱스 뒤에 있는 문자들을 가져오는 것으로 확장자 가져온다
        String extension = originalFileName.substring(extensionIndex);

        // @ 파일의 새로운 이름 지정
        String uuid = UUID.randomUUID().toString();
        String saveName = uuid + extension;

        // @ 파일 저장 경로 지정
        String savePath = FILE_PATH + saveName;

        try {
            // @ 파일 저장
            file.transferTo(new File(savePath));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        // @ 클라이언트가 해당 파일에 접근하기 위한 url
        String fileUrl = FILE_URL + saveName;
        return fileUrl;

    }

    @Override
    public Resource getFile(String fileName) {

        Resource file = null;

        try {

            // @ 파일을 URL로 가져오기
            String url = "file:" + FILE_PATH + fileName;
            file = new UrlResource(url);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return file;

    }

}
