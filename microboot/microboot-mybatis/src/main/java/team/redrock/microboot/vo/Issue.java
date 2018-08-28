package team.redrock.microboot.vo;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author ugly
 */
public class Issue {
    private int id;
    private String author_id;
    private String nick_name;
    private String head_url;
    private String title;
    private String content;
    private String pic_name;
    private String pic_thumb;
    private String tag;
    private int reply_count;
    private int like_count;
    private Long update_time;
    private Long create_time;
    private boolean mine;
    private List<Answer> repliesList;

    public void getIssue(int id){
        this.id = id;
    }

    public void issue(User user, Body body){

        this.author_id = String.valueOf(user.getStu_id());
        this.content = body.getContent();
        this.create_time = System.currentTimeMillis();
        this.update_time = System.currentTimeMillis();
        this.head_url = user.getHeadimgurl();
        this.nick_name = user.getNickname();
        this.pic_name = body.getOrgPic();
        this.tag = body.getTag();
        this.title = body.getTitle();
        this.id = body.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPic_thumb() {
        return pic_thumb;
    }

    public void setPic_thumb(String pic_thumb) {
        this.pic_thumb = pic_thumb;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public List<Answer> getRepliesList() {
        return repliesList;
    }

    public void setRepliesList(List<Answer> repliesList) {
        this.repliesList = repliesList;
    }
}
