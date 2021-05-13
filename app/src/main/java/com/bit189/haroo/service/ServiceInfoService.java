package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Learning;

public interface ServiceInfoService {

  int add(Learning learning) throws Exception;

  List<Learning> list() throws Exception;

  Learning get(int no) throws Exception;

  int update(Learning Learning) throws Exception;

  int delete(int no) throws Exception;

  Learning Search(int no) throws Exception;
}
