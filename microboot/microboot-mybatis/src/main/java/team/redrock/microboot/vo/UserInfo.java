package team.redrock.microboot.vo;

public class UserInfo {
    private Long id;
    private String name;
    private String stu_id;
    private String gender;
    private String class_num;
    private String major;
    private int grade;
    private String college;
    private String head_url;
    private String nick_name;
    private Boolean scholar;

    public void userInfo(User user){
        this.id=user.getUid();
        this.name=user.getUname();
        this.stu_id=user.getStu_id();
        this.gender=user.getSex();
        this.class_num=user.getClass_num();
        this.major=user.getMajor();
        this.grade=user.getGrade();
        this.college=user.getCollege();
        this.head_url=user.getHeadimgurl();
        this.nick_name=user.getNickname();
//        this.scholar=user.getRoles().;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClass_num() {
        return class_num;
    }

    public void setClass_num(String class_num) {
        this.class_num = class_num;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setScholar(Boolean scholar) {
        this.scholar = scholar;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", gender='" + gender + '\'' +
                ", class_num='" + class_num + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", college='" + college + '\'' +
                ", head_url='" + head_url + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", scholar='" + scholar + '\'' +
                '}';
    }
}
