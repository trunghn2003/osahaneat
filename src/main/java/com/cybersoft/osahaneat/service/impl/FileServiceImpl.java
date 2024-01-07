package com.cybersoft.osahaneat.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImpl {
    public boolean saveFile(MultipartFile file);
    public Resource loadFile(String fileName);

}
