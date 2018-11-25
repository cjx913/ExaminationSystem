package com.cjx913.es.entity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class SubjectClassification {
    private String id;
    private String name;
    private String parentId;
    private short avaliable;

//    private SubjectClassification parent;
    private ArrayList<SubjectClassification> children;
}
