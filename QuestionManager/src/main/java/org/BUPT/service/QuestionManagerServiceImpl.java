package org.BUPT.service;

import org.BUPT.DAO.QuestionRepository;
import org.BUPT.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class QuestionManagerServiceImpl {

    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository){
        this.questionRepository=questionRepository;
    }
    public List<Question> findAll(){
        return (List<Question>) questionRepository.findAll();
    }
    public Question findById(Long Id){
        return questionRepository.findById(Id).orElse(new Question());
    }

}
