package com.gjj.springvuedemo.shiro;

import com.gjj.springvuedemo.model.Permission;
import com.gjj.springvuedemo.model.Role;
import com.gjj.springvuedemo.model.User;
import com.gjj.springvuedemo.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户自定义Realm
 *
 * @author gjj
 *
 * @date 2018/2/3
 */
public class UserRealm extends AuthorizingRealm {

    /** 注入userService */
    @Autowired
    private IUserService userService;

    /**
     * 授权
     * @param
     * @return
     * @Author gjj
     * @date 2018/2/3
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        Set<String> roleList = new HashSet<>();
        Set<String> permissionList = new HashSet<>();
        //从数据库中取出用户信息
        User temp = userService.findUserById(user.getUid());
        for(Role role: temp.getRoleList()){
            roleList.add(role.getRname());
            for(Permission permission : role.getPermissionList()){
                permissionList.add(permission.getPname());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleList);
        simpleAuthorizationInfo.addStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证登录
     * @param authenticationToken 用户token
     * @return 认证信息
     * @Author gjj
     * @date 2018/2/3
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        if(username != null){
            User user = userService.findByUserName(username);
            if (user == null){
                //账号不存在
                throw  new UnknownAccountException();
            }
            //以用户名作为盐值
            return  new SimpleAuthenticationInfo(user,user.getUserPassword(),new MyByteSource(user.getUserName()),this.getClass().getName());
        }
        return null;
    }

}
