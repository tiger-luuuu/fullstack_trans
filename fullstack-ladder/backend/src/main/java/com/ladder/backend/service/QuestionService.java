package com.ladder.backend.service;

import com.ladder.backend.mapper.QuestionMapper;
import com.ladder.backend.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
  private final QuestionMapper questionMapper;

  public QuestionService(QuestionMapper questionMapper) {
    this.questionMapper = questionMapper;
  }

  public List<Question> listAll() {
    return this.questionMapper.findAll();
  }
}
