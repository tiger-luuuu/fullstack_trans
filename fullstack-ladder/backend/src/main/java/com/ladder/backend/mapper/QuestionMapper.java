package com.ladder.backend.mapper;

import com.ladder.backend.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
  @Select("SELECT id, stem, options, answer, difficulty FROM questions ORDER BY id")
  List<Question> findAll();
}
