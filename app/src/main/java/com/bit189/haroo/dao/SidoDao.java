package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Sido;

public interface SidoDao {

  List<Sido> findAll() throws Exception;
}
