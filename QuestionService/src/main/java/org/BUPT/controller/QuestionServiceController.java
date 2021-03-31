package org.BUPT.controller;


import org.BUPT.dto.QuestionDTO;
import org.BUPT.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class QuestionServiceController {

@Autowired
QuestionService questionService;

    @GetMapping("/all")
    public List<QuestionDTO> findAll(){
        List<QuestionDTO> questionDTOs = questionService.getAllQuestions();

        return questionDTOs;
    }
}
