package com.cjx913.es.mapper;

import com.cjx913.es.entity.persistent.Permission;
import com.cjx913.es.exception.CustomException;

import java.util.List;

public interface PermissionMapper {
    List <Permission> selectPermissionsByUserId(String userId) throws CustomException;
}
