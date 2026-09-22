package com.ladder.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.ladder.backend.agent.DailyQuestion;
import com.ladder.backend.agent.QuestionAgentClient;

@RestController
@RequestMapping("/api")
public class QuestionController {
  private final QuestionAgentClient questionAgentClient;

  public QuestionController(QuestionAgentClient questionAgentClient) {
    this.questionAgentClient = questionAgentClient;
  }

  @GetMapping("/questions/daily")
  public List<DailyQuestion> daily() {
    return questionAgentClient.fetchDailyQuestions(3);
  }
}
