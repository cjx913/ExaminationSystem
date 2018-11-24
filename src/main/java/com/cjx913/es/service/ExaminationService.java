package com.cjx913.es.service;

import com.cjx913.es.entity.domain.ExamAnswer;

import java.io.IOException;

public interface ExaminationService {
    void saveExamAnswer(ExamAnswer examAnswer) throws IOException;
}
