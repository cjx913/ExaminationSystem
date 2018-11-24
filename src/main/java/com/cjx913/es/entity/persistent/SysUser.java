package com.cjx913.es.entity.persistent;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SysUser {
    private String id;
    private String account;
    private String name;
    private String password;
    private String salt;
    private int locked;


}
