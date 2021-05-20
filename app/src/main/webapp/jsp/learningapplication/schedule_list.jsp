<%@page import="com.bit189.haroo.domain.LearningSchedule"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%
List<LearningSchedule> scheduls = (List<LearningSchedule>) request.getAttribute("schedules");
List<LearningSchedule> learningSchedules = (List<LearningSchedule>) request.getAttribute("learningSchedules");

for (LearningSchedule ls : scheduls) {
  String checked = "";
  if (learningSchedules != null) {
    for (LearningSchedule learningSchedule : learningSchedules) {
      if (ls.getNo() == learningSchedule.getNo()) {
        checked = "checked";
        break;
      }
    }
  }
  %> 
  <input type='checkbox' name='learningDate' value='<%=ls.getNo()%>' <%=checked%>><%=ls.getLearningDate()%><br>
<%
}
%>