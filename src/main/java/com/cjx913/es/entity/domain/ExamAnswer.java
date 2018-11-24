package com.cjx913.es.entity.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@JsonInclude()
public class ExamAnswer {
    private String userId;
    private String subjectId;
    private String paperId;
    private Date submitTime;
    private ArrayList<String> panduanti;
    private ArrayList<String> danxuanti;
    private ArrayList<ArrayList<String>> duoxuanti;
    private ArrayList<String> tiankongti;
    private ArrayList<String> jiedati;
}
