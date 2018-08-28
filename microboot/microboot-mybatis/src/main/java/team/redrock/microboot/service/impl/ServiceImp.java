package team.redrock.microboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.redrock.microboot.dao.Dao;
import team.redrock.microboot.service.IService;
import team.redrock.microboot.vo.Answer;
import team.redrock.microboot.vo.Issue;
import team.redrock.microboot.vo.User;

import java.lang.annotation.Annotation;
import java.util.List;

@Service
public class ServiceImp implements IService {

    @Autowired
    private Dao dao;
    @Override
    public boolean insertIssue(Issue issue) {
        return dao.insertIssue(issue);
    }

    @Override
    public User selectUserByOpenId(User user) {
        return dao.getUser(user);
    }

    @Override
    public Boolean insertUser(User user) {
        return dao.insertUser(user);
    }

    @Override
    public Boolean insertAnswer(Answer answer) {
        return dao.insertAnswer(answer);
    }

    @Override
    public Boolean selectUserScholar(User user) {
        return dao.selectUserScholar(user);
    }

    @Override
    public Page<Issue> findIssuePage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return dao.findIssuePage();
    }

    @Override
    public Page<Issue> searchIssue(int pageNo, int pageSize, Issue issue) {
        PageHelper.startPage(pageNo,pageSize);
        return dao.searchIssue(issue);
    }

    @Override
    public Page<Issue> searchI(int pageNo, int pageSize, Issue issue) {
        PageHelper.startPage(pageNo, pageSize);
        return dao.searchI(issue);
    }

    @Override
    public Page<Issue> myIssue(int pageNo, int pageSize, Issue issue) {
        PageHelper.startPage(pageNo, pageSize);
        return dao.myIssue(issue);
    }

    @Override
    public Page<Answer> myAnswer(int pageNo, int pageSize, Answer answer) {
        PageHelper.startPage(pageNo, pageSize);
        return dao.myAnswer(answer);
    }

    //通过问题id查回答
    @Override
    public List<Answer> findAnswerByUID(int uid){
        return dao.findAnswerByUID(uid);
    }

    @Override
    public Boolean findAnswerByMine(Issue issue) {
        return dao.findAnswerByMine(issue);
    }

    //通过问题id查问题详情
    public Issue findIssueById(Issue issue){
        return dao.findIssueById(issue);
    }
}
