package com.sachin.QuizServiceMicro.controller;


import com.sachin.QuizServiceMicro.model.QuestionWrapper;
import com.sachin.QuizServiceMicro.model.QuizDto;
import com.sachin.QuizServiceMicro.model.Response;
import com.sachin.QuizServiceMicro.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {


    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){

        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());
    }


    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){

       return quizService.getQuizQuestions(id);
    }


    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){

        return quizService.calculateResult(id,responses);
    }
}
