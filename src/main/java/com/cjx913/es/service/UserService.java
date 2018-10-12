package com.cjx913.es.service;

import com.cjx913.es.entity.persistent.Permission;
import com.cjx913.es.entity.persistent.Role;
import com.cjx913.es.entity.domain.ScoreList;
import com.cjx913.es.entity.persistent.User;
import com.cjx913.es.exception.CustomException;

import java.util.List;


public interface UserService {
    User findUserByName(String username) throws CustomException;

    void saveUser(User user) throws CustomException;

    List <Permission> findPermissionsByUserId(String userId) throws CustomException;

    List <Role> findRolesByUserId(String userId) throws CustomException;

    List<ScoreList> findScoreListPaginationAndSearch(String userId, Long start, Long size, String searchtext, String sortorder);
}
