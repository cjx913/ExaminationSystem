package com.cjx913.es.mapper;

import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.entity.persistent.SysPermission;
import com.cjx913.es.entity.persistent.SysRole;
import com.cjx913.es.entity.persistent.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select({"select id, account, name, password, salt, locked",
            "from sys_user",
            "where name=#{username} and password=#{password}"})
    SysUser selectUserByNameAndPassword(@Param("username") String username, @Param("password") String password);

    @Select({"select id, account, name, password, salt, locked",
            "from sys_user",
            "where name=#{username}"})
    SysUser selectUserByName(@Param("username") String username);

    @Select({"select count(id)",
            "from sys_user",
            "where name=#{account}"})
    Integer selectUserCountByAccount(@Param("account") String account);

    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    @Insert({" insert into sys_user(id, account, name, password, salt, locked)",
            "values (#{id},#{account},#{name},#{password},#{salt},#{locked})"})
    Integer insetUser(SysUser sysUser);

    @Select(value = {"select id,name,url,available",
            "from sys_permission",
            "where id in",
            "(select rp.permission_id",
            "from sys_role_permission as rp,sys_user_role as ur",
            "where rp.role_id=ur.role_id and ur.user_id=#{userId})"})
    List <SysPermission> selectPermissionsByUserId(String userId);

    @Select({"select id,name,avaliable",
            "from sys_role",
            "where id in",
            "(select role_id",
            "from sys_user_role",
            "where user_id=#{userId})"})
    List <SysRole> selectRolesByUserId(String userId);

    List <Map <String, Object>> selectScoreListByUserIdPaginationAndSearch(Map <String, Object> map);

    Integer selectAllScoreCountByUserIdSearch(Map <String, Object> map);

    List <Map <String, Object>> selectAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch(Map <String, Object> map);

    Integer selectAllUserIdentitiesCountSearch(Map <String, Object> map);


    //
    /*
    @Results(id = "userIdentityWithRoleNameAndPermissionNameResult",
            value = {
                    @Result(column = "userId", property = "userId"),
                    @Result(column = "account", property = "account"),
                    @Result(column = "username", property = "username"),
                    @Result(property = "permissions", column = "userId", javaType = List.class,
                            many = @Many(select = "com.cjx913.es.mapper.UserMapper.selectPermissionNamesByUserId")),
                    @Result(property = "roles", column = "userId", javaType = List.class,
                            many = @Many(select = "com.cjx913.es.mapper.UserMapper.selectRoleNamesByUserId"))
            })
    @Select({"select u.id as userId,u.account as account,u.name as username",
            "from sys_user as u",
            "where u.id=#{userId}"})
    Map <String, Object> selectUserIdentityWithRoleAndPermissionById(@Param("userId") String userId);
*/
    @Select(value = {"select name",
            "from sys_permission",
            "where id in",
            "(select rp.permission_id",
            "from sys_role_permission as rp,sys_user_role as ur",
            "where rp.role_id=ur.role_id and ur.user_id=#{userId})"})
    List <String> selectPermissionNamesByUserId(String userId);


    @Select({"select name",
            "from sys_role",
            "where id in",
            "(select role_id",
            "from sys_user_role",
            "where user_id=#{userId})"})
    List <String> selectRoleNamesByUserId(String userId);

    @Delete({"delete from sys_user where id=#{userId}"})
    Integer deleteUserByUserId(@Param("userId") String userId);


    @Insert({"insert into sys_user_role(user_id,role_id)","values(#{userId},'2000')"})
    Integer setUserRole(@Param("userId") String userId);


}
