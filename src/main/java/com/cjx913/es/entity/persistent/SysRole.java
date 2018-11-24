package com.cjx913.es.entity.persistent;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class SysRole {
    public static final SysRole ADMINISTRATOR=new SysRole("0000","administrator",1);
    public static final SysRole ADMIN=new SysRole("1000","admin",1);
    public static final SysRole USER=new SysRole("2000","user",1);

    private String id;
    private String name;
    private int avaliable;



    public SysRole(String id, String name, int avaliable) {
        this.id = id;
        this.name = name;
        this.avaliable = avaliable;
    }



}
