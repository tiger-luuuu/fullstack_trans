package com.ladder.backend.agent;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MockQuestionAgentClient implements QuestionAgentClient {

  @Override
  public List<DailyQuestion> fetchDailyQuestions(int count) {
    return List.of(
        new DailyQuestion(
            1L,
            "Vue 3 中 ref 和 reactive 的区别，正确的是？",
            List.of("ref 包装基本类型，reactive 包装对象", "两者完全等价", "reactive 可整体替换", "ref 不能用于对象"),
            "EASY"),
        new DailyQuestion(
            2L,
            "Java 中定义接口的关键字是？",
            List.of("interface", "struct", "protocol", "trait"),
            "EASY"),
        new DailyQuestion(
            3L,
            "MySQL 中查看表结构的命令是？",
            List.of("DESC 表名", "SHOW ME 表名", "STRUCTURE 表名", "PRINT 表名"),
            "MEDIUM"));
  }
}