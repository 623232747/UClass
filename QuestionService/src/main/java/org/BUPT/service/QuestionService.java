package org.BUPT.service;

import org.BUPT.dto.QuestionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="QuestionManager")
public interface QuestionService {
    @GetMapping("/{id}")
    QuestionDTO getQuestion(@PathVariable Long id);
    @GetMapping("/all")
    List<QuestionDTO> getAllQuestions();
}
