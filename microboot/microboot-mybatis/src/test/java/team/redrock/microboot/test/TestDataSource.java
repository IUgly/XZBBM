package team.redrock.microboot.test;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.redrock.microboot.StartSpringBootMain;
import team.redrock.microboot.dao.Dao;
import team.redrock.microboot.page.PageInfo;
import team.redrock.microboot.service.impl.ServiceImp;
import team.redrock.microboot.vo.*;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestDataSource {
	@Autowired
	private Dao dao;
	@Autowired
	private ServiceImp serviceImp;

	@Test
	public void testConnection() throws Exception {
		Issue issue = new Issue();
		issue.setAuthor_id("ov3380_5cdMfMP0SqJfZmcMqmg18");
		Page<Issue> issues = dao.myIssue(issue);
		PageInfo<Issue> pageInfo = new PageInfo<>(issues);
		System.out.println(pageInfo.toString());
	}
}
