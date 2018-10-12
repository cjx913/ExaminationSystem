package com.cjx913.es.Service;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.domain.ScoreList;
import com.cjx913.es.entity.persistent.User;
import com.cjx913.es.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends SpringTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveUser(){
        User user = new User();
        user.setAccount("1231212342243321");
        user.setName("abcdlmn");
        user.setPassword("abcdefgh");
        user.setSalt("abcd");
        user.setLocked(0);
        userService.saveUser(user);
    }

    @Test
    public void findScoreListPaginationAndSearch(){
        List <ScoreList> list = userService.findScoreListPaginationAndSearch("2000001", 1l, 4l, "", "");
        assert list!=null&&list.size()>0;
    }

}
