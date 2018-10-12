package com.cjx913.es.mapper;

import com.cjx913.es.entity.domain.Pagination;
import com.cjx913.es.entity.domain.ScoreList;
import com.cjx913.es.entity.persistent.Permission;
import com.cjx913.es.entity.persistent.Role;
import com.cjx913.es.entity.persistent.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select({"select id, account, name, password, salt, locked",
            "from sys_user",
            "where name=#{username}"})
    User findUserByName(@Param("username") String username);

    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    @Insert({" insert into sys_user(id, account, name, password, salt, locked)",
            "values (#{id},#{account},#{name},#{password},#{salt},#{locked})"})
    void insetUser(User user);

    @Select({"select id,name,url,available",
            "from sys_permission",
            "where id in",
            "(select rp.permission_id",
            "from sys_role_permission as rp,sys_user_role as ur",
            "where rp.role_id=ur.role_id and ur.user_id=#{userId})"})
    List <Permission> selectPermissionsByUserId(String userId);

    @Select({"select id,name,avaliable",
            "from sys_role",
            "where id in",
            "(select role_id",
            "from sys_user_role",
            "where user_id=#{userId})"})
    List <Role> selectRolesByUserId(String userId);

    List <ScoreList> selectScoreListPaginationAndSearch(Map<String,Object> map);
}
