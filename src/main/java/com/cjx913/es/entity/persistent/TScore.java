package com.cjx913.es.entity.persistent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
public class TScore {
    private String id;
    private String userId;
    private String subjectId;
    private String paperId;
    private String evaluationPerson;
    private Date evaluationTime;
    private int score;

    }
