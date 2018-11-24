package com.cjx913.es.service.impl;

import com.cjx913.es.entity.domain.ExamAnswer;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.service.ExaminationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class ExaminationServiceImpl implements ExaminationService {
    @Value("${answerJsonPath}")
    private String answerJsonPath;

    @Override
    public void saveExamAnswer(ExamAnswer examAnswer) throws IOException {

            ObjectMapper mapper = new ObjectMapper();
            File file = new File(answerJsonPath+examAnswer.getUserId()+"-"+examAnswer.getSubjectId()+"-"+examAnswer.getPaperId()+".json");
            mapper.writeValue(file, examAnswer);

    }
}
