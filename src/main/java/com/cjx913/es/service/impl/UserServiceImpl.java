package com.cjx913.es.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cjx913.es.entity.persistent.Permission;
import com.cjx913.es.entity.persistent.Role;
import com.cjx913.es.entity.domain.ScoreList;
import com.cjx913.es.entity.persistent.User;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.mapper.UserMapper;
import com.cjx913.es.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUserByName(String username) throws CustomException {
        return userMapper.findUserByName(username);
    }

    @Override
    public void saveUser(User user) throws CustomException {
        String password = new Md5Hash(user.getPassword(), user.getSalt(), 1).toString();
        user.setPassword(password);
        userMapper.insetUser(user);
    }

    @Override
    public List <Permission> findPermissionsByUserId(String userId) {
        return userMapper.selectPermissionsByUserId(userId);
    }

    @Override
    public List <Role> findRolesByUserId(String userId) {
        return userMapper.selectRolesByUserId(userId);
    }

    @Override
    public List <ScoreList> findScoreListByUserIdPaginationAndSearch(String userId, Long start, Long size, String searchtext, String sortorder) {
        Map<String,Object> map = new HashMap <>();
        map.put("userId",userId);
        map.put("start",start-1);
        map.put("size",size);
        map.put("searchText",searchtext);
        map.put("order",sortorder);
        return userMapper.selectScoreListByUserIdPaginationAndSearch(map);
    }

    @Override
    public Integer findAllScoreCountByUserIdPaginationAndSearch(String userId, String searchtext, String sortorder) {
        Map<String,Object> map = new HashMap <>();
        map.put("userId",userId);
        map.put("searchText",searchtext);
        map.put("order",sortorder);
        return userMapper.selectAllScoreCountByUserIdPaginationAndSearch(map);
    }

}
