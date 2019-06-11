package com.example.demo2.dao;

import com.example.demo2.entity.Answer;
import com.example.demo2.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDao {

    @Autowired
    QuestionMapper questionMapper;


    public void insertQuestion(Question po){
         questionMapper.insertQuestion(po);
    }

    public void insertAnswer(Answer answer) {
            questionMapper.insertAnswer(answer);
    }

}
