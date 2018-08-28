package team.redrock.microboot.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import team.redrock.microboot.vo.Answer;
import team.redrock.microboot.vo.Issue;
import team.redrock.microboot.vo.Like;
import team.redrock.microboot.vo.User;

import java.util.List;

@Mapper
@Component
public interface Dao {

    @Select("SELECT * FROM user WHERE openid = #{openid} ")
    User getUser(User user);

    @Insert("INSERT INTO user(nickname,openid,headimgurl,sex,city,stu_id)VALUE (#{nickname},#{openid},#{headimgurl},#{sex},#{city},#{openid})")
    Boolean insertUser(User user);

    @Insert("INSERT INTO issue(author_id,nick_name,head_url,title,content,pic_name,pic_thumb,tag,create_time) VALUE" +
            " (#{author_id},#{nick_name},#{head_url},#{title},#{content},#{pic_name},#{pic_thumb},#{tag},#{create_time})")
    Boolean insertIssue(Issue issue);

    @Insert("INSERT INTO answer(pid,author_id,nick_name,head_url,content,pic_name,pic_thumb,create_time,scholar)VALUE " +
            "(#{pid},#{author_id},#{nick_name},#{head_url},#{content},#{pic_name},#{pic_thumb},#{create_time},#{scholar})  ")
    Boolean insertAnswer(Answer answer);

    @Select("SELECT scholar FROM user WHERE openid = #{openid}")
    Boolean selectUserScholar(User user);

    @Select("SELECT * FROM issue")
    Page<Issue> findIssuePage();

    @Select("SELECT * FROM issue WHERE title LIKE '%${title}%'")
    Page<Issue> searchIssue(Issue issue);

    @Select("SELECT * FROM issue WHERE tag = #{tag}")
    Page<Issue> searchI(Issue issue);

    @Select("SELECT * FROM issue WHERE author_id = #{author_id}")
    Page<Issue> myIssue(Issue issue);

    @Select("SELECT * FROM answer WHERE author_id = #{author_id}")
    Page<Answer> myAnswer(Answer answer);

    @Select("SELECT * FROM answer WHERE pid = #{uid}")
    List<Answer> findAnswerByUID(int uid);

    @Select("SELECT * FROM issue WHERE id=#{id}")
    Issue findIssueById(Issue issue);

    //查询是否是自己的问题
    @Select("SELECT author_id FROM issue where id = #{id}")
    Boolean findAnswerByMine(Issue issue);

    @Select("select * from user where openid=#{openid}")
    User findUserByOpenID(User user);

    @Select("SELECT * FROM issue WHERE id=#{id}")
    Issue findIssueBy(int id);

    //查询点赞数
    @Select("SELECT like_count FROM issue WHERE id=#{id}")
    int findLikeNum(Issue issue);

    //查询是否点赞
    @Select("select * from islike where id=#{id} AND uid=#{uid}")
    Like selectLike(Like like);

    //插入赞赞记录
    @Insert("INSERT INTO islike(id,uid)VALUE (#{id},#{uid})")
    Boolean insertLike(Like like);
    //点赞
    @Update("update answer set like_count=#{like_count} where id =#{id}")
    Boolean updateVote(Issue issue);

    //查询是否赞同
    @Select("select upvote from answer where id = #{id}")
    Boolean findAccept(Answer answer);
    @Select("update answer set upvote=1 where id = #{id}")
    Boolean updateAccept(Answer answer);

}
