package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class FileService implements FileServiceImpl {

    @Value("${fileUpload.rootPath}")
    private String rootPath;
    private Path root;
    public void  init(){
        try {
            root = Paths.get(rootPath);
            if (Files.exists(root)) {
                Files.createDirectories(root);
            }
        }
        catch (Exception e){
            System.out.println("Loi tao folder root"+e);
        }
    }

    @Override
    public boolean saveFile(MultipartFile file) {
        init();
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            return  true;
        }
        catch (Exception e){
            System.out.println("Loi save file"+e);
            return  false;
        }


//        return false;
    }

    @Override
    public Resource loadFile(String fileName) {
        init();
        Path file = this.root.resolve(fileName);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable())
                     return resource;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
//            return null;
        }

    return null;

    }
}
