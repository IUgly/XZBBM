package team.redrock.microboot.test;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import team.redrock.microboot.StartSpringBootMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sungang on 2017/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {StartSpringBootMain.class})
@WebAppConfiguration
public class QINiuTest {


    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).alwaysExpect(status().isOk()).addFilters(new CharacterEncodingFilter()).build();
    }


    @Test
    public void testUpload() throws Exception {

    }
    private String storeThumbnail() throws Exception {
        return "";
    }

}
