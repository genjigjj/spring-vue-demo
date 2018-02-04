package com.gjj.springvuedemo.shiro;

import com.gjj.springvuedemo.model.Permission;
import com.gjj.springvuedemo.model.User;
import com.gjj.springvuedemo.service.IPermissionService;
import com.gjj.springvuedemo.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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

    /** 注入权限Service */
    @Autowired
    private IPermissionService permissionService;

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
        List<String> permissionList = new ArrayList<>();
        List<Permission> temp = permissionService.findByUserid(user.getUid());
        if(CollectionUtils.isNotEmpty(temp)){
            for (Permission permission : temp){
                permissionList.add(permission.getPname());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
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
        User user = userService.findByUserName(username);
        return  new SimpleAuthenticationInfo(user,user.getUserPassword(),this.getClass().getName());
    }

}
