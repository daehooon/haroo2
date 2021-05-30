package com.bit189.haroo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.service.LearningScheduleService;

// 미완
@Service
public class DefaultLearningScheduleService implements LearningScheduleService {

  LearningScheduleDao learningScheduleDao;

  public DefaultLearningScheduleService(LearningScheduleDao learningScheduleDao) {

    this.learningScheduleDao = learningScheduleDao;
  }

  @Override
  public List<LearningSchedule> list() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }
}