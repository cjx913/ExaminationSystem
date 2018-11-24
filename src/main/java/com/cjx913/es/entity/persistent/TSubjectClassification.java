package com.cjx913.es.entity.persistent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TSubjectClassification {
    private String id;
    private String name;
    private String parent;
    private short avaliable;
}
