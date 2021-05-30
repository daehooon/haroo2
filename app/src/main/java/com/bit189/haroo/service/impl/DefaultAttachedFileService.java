package com.bit189.haroo.service.impl;

import org.springframework.stereotype.Service;
import com.bit189.haroo.dao.AttachedFileDao;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.service.AttachedFileService;

@Service
public class DefaultAttachedFileService implements AttachedFileService{
  AttachedFileDao attachedFileDao;

  public DefaultAttachedFileService(AttachedFileDao attachedFileDao) {
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  public int add(AttachedFile attachedFile) throws Exception {
    return attachedFileDao.insert(attachedFile); 
  }



}