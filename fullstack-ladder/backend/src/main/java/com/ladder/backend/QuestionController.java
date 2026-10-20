package com.ladder.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.ladder.backend.agent.DailyQuestion;
import com.ladder.backend.agent.QuestionAgentClient;
import com.ladder.backend.common.ApiRsp;
import com.ladder.backend.model.Question;
import com.ladder.backend.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {
  private final QuestionAgentClient questionAgentClient;
  private final QuestionService questionService;

  public QuestionController(QuestionAgentClient qac, QuestionService qs) {
    this.questionAgentClient = qac;
    this.questionService = qs;
  }

  @GetMapping("/questions/daily")
  public List<DailyQuestion> daily() {
    return questionAgentClient.fetchDailyQuestions(3);
  }

  @GetMapping("questions")
  public ApiRsp<List<Question>> listQuestions() {
    return ApiRsp.ok(this.questionService.listAll());
  }
}
