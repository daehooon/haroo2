package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Product;

public interface ProductDao {
  List<Product> findAll() throws Exception;

  //정렬 기준과, 정렬 방향을 받는 findSortedAll()도 추가 해야함

}