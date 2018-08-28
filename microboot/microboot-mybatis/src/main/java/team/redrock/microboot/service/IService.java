package team.redrock.microboot.service;

import com.github.pagehelper.Page;
import team.redrock.microboot.vo.Answer;
import team.redrock.microboot.vo.Issue;
import team.redrock.microboot.vo.User;

import java.util.List;

public interface IService {

    public boolean insertIssue(Issue issue);

    public User selectUserByOpenId(User user);

    public Boolean insertUser(User user);

    public Boolean insertAnswer(Answer answer);

    public Boolean selectUserScholar(User user);

    public Page<Issue> findIssuePage(int pageNo, int pageSize);

    public Page<Issue> searchIssue(int pageNo, int pageSize, Issue issue);

    public Page<Issue> searchI(int pageNo, int pageSize, Issue issue);

    public Page<Issue> myIssue(int pageNo, int pageSize, Issue issue);

    public Page<Answer> myAnswer(int pageNo, int pageSize, Answer answer);

    public List<Answer> findAnswerByUID(int uid);

    public Boolean findAnswerByMine(Issue issue);
}
