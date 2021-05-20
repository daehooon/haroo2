package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.LearningSchedule;

public interface ScheduleService {

  List<LearningSchedule> list() throws Exception;
}
