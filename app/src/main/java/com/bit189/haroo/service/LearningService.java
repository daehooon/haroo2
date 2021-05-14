package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.BroadCategory;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.domain.NarrowCategory;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.domain.Sido;
import com.bit189.haroo.domain.Sigungu;

public interface LearningService {

  int add(Learning learning) throws Exception;

  int add(ServiceInfo serviceInfo, Learning learning, LearningSchedule learningSchedule,
      BroadCategory broadCategory, NarrowCategory narrowCategory,
      Sido sido, Sigungu sigungu) throws Exception;

  List<Learning> list() throws Exception;

  Learning get(int no) throws Exception;

  int update(Learning Learning) throws Exception;

  int delete(int no) throws Exception;

  Learning Search(int no) throws Exception;
}
