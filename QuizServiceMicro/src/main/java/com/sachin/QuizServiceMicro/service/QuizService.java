package com.sachin.QuizServiceMicro.service;

//import com.sachin.QuizServiceMicro.dao.QuestionDao;
import com.sachin.QuizServiceMicro.dao.QuizDao;
import com.sachin.QuizServiceMicro.feign.QuizInterface;
import com.sachin.QuizServiceMicro.model.QuestionWrapper;
import com.sachin.QuizServiceMicro.model.Quiz;
import com.sachin.QuizServiceMicro.model.QuizDto;
import com.sachin.QuizServiceMicro.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

     @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {


        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }



    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

          Quiz quiz = quizDao.findById(id).get();
          List<Integer> questionIds = quiz.getQuestionIds();
          quizInterface.getQuestionsFromId(questionIds);
          ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);

          return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        ResponseEntity<Integer> score =  quizInterface.getScore(responses);


        return score;
    }
}
