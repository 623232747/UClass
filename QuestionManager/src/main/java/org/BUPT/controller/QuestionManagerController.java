package org.BUPT.controller;

import org.BUPT.entity.Question;
import org.BUPT.service.QuestionManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionManagerController {
    @Autowired
    QuestionManagerServiceImpl questionManagerService;

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id) {
        Question q = questionManagerService.findById(id);

        return q;
    }

    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionManagerService.findAll();
    }
}
