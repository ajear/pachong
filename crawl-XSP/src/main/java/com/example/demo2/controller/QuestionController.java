package com.example.demo2.controller;

import com.example.demo2.entity.Question;
import com.example.demo2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @RequestMapping("/api/spider/get")
    @ResponseBody
    public void get(Question question) {

        questionService.question_crawl();
    }

}
