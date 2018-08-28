package team.redrock.microboot.vo;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ugly
 */
public class Answer {
    private int id;
    private int pid;
    private String author_id;
    private String nick_name;
    private String head_url;
    private String content;
    private String pic_name;
    private String pic_thumb;
    private int reply_count;
    private int like_count;
    private Long update_time;
    private Long create_time;
    private boolean scholar;
    private boolean accepted;
    private boolean upvote;

    public void answer(User user, Body body){
        this.pid = body.getId();
        this.author_id = user.getStu_id();
        this.content = body.getContent();
        this.create_time = System.currentTimeMillis();
        this.head_url = user.getHeadimgurl();
        this.nick_name = user.getNickname();
        this.pic_name = body.getOrgPic();
    }

    public String getPic_thumb() {
        return pic_thumb;
    }

    public void setPic_thumb(String pic_thumb) {
        this.pic_thumb = pic_thumb;
    }


    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public int getReply_count() {
        return reply_count;
    }

    public void setReply_count(int reply_count) {
        this.reply_count = reply_count;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public boolean isScholar() {
        return scholar;
    }

    public void setScholar(boolean scholar) {
        this.scholar = scholar;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isUpvote() {
        return upvote;
    }

    public void setUpvote(boolean upvote) {
        this.upvote = upvote;
    }
}
