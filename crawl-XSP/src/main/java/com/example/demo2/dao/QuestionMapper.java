package com.example.demo2.dao;

import com.example.demo2.entity.Answer;
import com.example.demo2.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionMapper {

    void insertQuestion(Question question);

    void insertAnswer(Answer answer);
}
