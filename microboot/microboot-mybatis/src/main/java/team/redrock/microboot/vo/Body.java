package team.redrock.microboot.vo;

import javax.servlet.http.HttpServletRequest;

public class Body{
    private String type;
    private int page;
    private int pageSize;

    private int id;
    private String content;
    private String orgPic;
    private String title;
    private String tag;

    private String key;

    public void body(HttpServletRequest request){
        this.type=request.getParameter("type");
        if (request.getParameter("id")!=null){
            this.id=Integer.parseInt(request.getParameter("id"));
        }
        this.content=request.getParameter("content");
        this.orgPic=request.getParameter("orgPic");
        this.title=request.getParameter("title");
        this.tag=request.getParameter("tag");
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrgPic() {
        return orgPic;
    }

    public void setOrgPic(String orgPic) {
        this.orgPic = orgPic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
