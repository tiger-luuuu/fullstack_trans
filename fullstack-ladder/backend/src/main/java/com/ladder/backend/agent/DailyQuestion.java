package com.ladder.backend.agent;

import java.util.List;

public record DailyQuestion(
  Long id,
  String stem,
  List<String> options,
  String difficulty
){}