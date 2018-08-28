package team.redrock.microboot.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * created by CaiBaoHong at 2018/4/17 14:55<br>
 */
public class User {
    private String code;
    private Long uid;       // 用户id
    private String uname;   // 登录名，不可改
//    private String pwd;     // 已加密的登录密码
//    private String salt;    // 加密盐值

    private String city;
    private String sex;
    private String headimgurl;
    private String openid;
    private String nickname;
    private String stu_id;
    private String class_num;
    private String major;
    private int grade;
    private String college;
    private boolean scholar;



    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    private String pwd;


    private Set<String> roles = new HashSet<>();    //用户所有角色值，用于shiro做角色权限的判断
    private Set<String> perms = new HashSet<>();    //用户所有权限值，用于shiro做资源权限的判断

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPerms() {
        return perms;
    }

    public void setPerms(Set<String> perms) {
        this.perms = perms;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getClass_num() {
        return class_num;
    }

    public void setClass_num(String class_num) {
        this.class_num = class_num;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public boolean isScholar() {
        return scholar;
    }

    public void setScholar(boolean scholar) {
        this.scholar = scholar;
    }

    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", uid=" + uid +
                ", uname='" + uname + '\'' +
                ", city='" + city + '\'' +
                ", sex='" + sex + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", class_num='" + class_num + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", college='" + college + '\'' +
                ", scholar=" + scholar +
                ", pwd='" + pwd + '\'' +
                ", roles=" + roles +
                ", perms=" + perms +
                '}';
    }
}
