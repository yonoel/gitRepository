package com.igeek.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.igeek.config.WebMvcConfig;

/**  
* @ClassName: ExamControllerTest  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 上午7:05:27    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes= {WebMvcConfig.class})
public class ExamControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
  

    @Before
    public void setup() throws Exception {
      

        mvc = MockMvcBuilders.webAppContextSetup(context).build();
        assertNotNull(mvc);
    }
    @Test
    public void testmain() throws Exception {
   
    }


}
