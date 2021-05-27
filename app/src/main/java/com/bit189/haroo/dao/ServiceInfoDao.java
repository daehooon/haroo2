package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.domain.ServiceInfo;

public interface ServiceInfoDao {

  int insert(ServiceInfo serivceInfo) throws Exception;

  int insertSchedule(List<LearningSchedule> schedule) throws Exception;

  int delete(int no) throws Exception;
}
