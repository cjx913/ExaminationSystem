package com.cjx913.es.shiro;

import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.entity.persistent.Permission;
import com.cjx913.es.entity.persistent.Role;
import com.cjx913.es.entity.persistent.User;
import com.cjx913.es.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class CustomRealm extends AuthorizingRealm {

    //注入service
    @Autowired
    private UserService userService;

    // 设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    /**
     * realm的认证方法
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        // token是用户输入的用户名和密码
        // 第一步从token中取出用户名
        String username = (String) token.getPrincipal();

        // 第二步：根据用户输入的userCode从数据库查询
        User user = null;
        user = userService.findUserByName(username);


        // 如果查询不到返回null
        if (user == null) {
            return null;
        }
        // 从数据库查询到密码
        String password = user.getPassword();

        //盐
        String salt = user.getSalt();

        // 如果查询到返回认证信息AuthenticationInfo

        //userIdentity就是用户身份信息
        UserIdentity userIdentity = new UserIdentity();

        userIdentity.setUserId(user.getId());
        userIdentity.setAccount(user.getAccount());
        userIdentity.setUsername(user.getName());

        //将activeUser设置simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userIdentity, password, ByteSource.Util.bytes(salt), this.getName());

        return simpleAuthenticationInfo;
    }


    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

            //从 principals获取主身份信息
            //将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
            UserIdentity userIdentity = (UserIdentity) principals.getPrimaryPrincipal();

            //根据身份信息获取权限信息
            //从数据库获取到角色数据
            List <Role> roles = userService.findRolesByUserId(userIdentity.getUserId());
            List<String> roleList = new ArrayList <>();
            if(roles!=null){
                for(Role role:roles){
                    roleList.add(role.getName());
                }
            }

            //从数据库获取到权限数据
            List <Permission> permissions = userService.findPermissionsByUserId(userIdentity.getUserId());

            //单独定一个集合对象
            List <String> permissionList = new ArrayList <String>();
            if (permissions != null) {
                for (Permission permission : permissions) {
                    //将数据库中的权限标签 符放入集合
                    permissionList.add(permission.getName());
                }
            }

            //查到权限数据，返回授权信息(要包括 上边的permissions)
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            //将上边查询到授权信息填充到simpleAuthorizationInfo对象中
            simpleAuthorizationInfo.addStringPermissions(permissionList);
            simpleAuthorizationInfo.addRoles(roleList);

            return simpleAuthorizationInfo;

    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }


}
