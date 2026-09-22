package com.ladder.backend.agent;

import java.util.List;

public interface QuestionAgentClient {
  List<DailyQuestion> fetchDailyQuestions(int count);
}