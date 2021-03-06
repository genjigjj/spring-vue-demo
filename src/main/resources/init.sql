--用户表--
CREATE TABLE t_user(
  uid INT(11) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(255) NOT NULL DEFAULT '',
  user_password VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY(uid)
);

--角色表--
CREATE TABLE t_role(
 rid INT(11) NOT NULL AUTO_INCREMENT,
 rname VARCHAR(255) NOT NULL DEFAULT '',
 PRIMARY KEY(rid)
);

--权限表--
CREATE TABLE t_permission(
 pid INT(11) NOT NULL AUTO_INCREMENT,
 pname VARCHAR(255) NOT NULL DEFAULT '',
 PRIMARY KEY(pid)
);

--用户角色表--
CREATE TABLE t_user_role(
 id INT(11) NOT NULL AUTO_INCREMENT,
 uid INT(11) NOT NULL,
 rid INT(11) NOT NULL,
 PRIMARY KEY(id)
);

--角色权限表--
CREATE TABLE t_role_permission(
 id INT(11) NOT NULL AUTO_INCREMENT,
 rid INT(11) NOT NULL,
 pid INT(11) NOT NULL,
 PRIMARY KEY(id)
);
