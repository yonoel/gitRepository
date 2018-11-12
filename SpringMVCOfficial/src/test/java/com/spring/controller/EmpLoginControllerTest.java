package com.spring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

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



/**  
* @ClassName: EmpLoginControllerTest  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月1日 下午6:40:56    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:HelloWeb-servlet.xml","classpath:Spring-mybatis.xml"})
@WebAppConfiguration//1 此注解指定web资源的位置，默认为src/main/webapp
public class EmpLoginControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
   
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }
   
    @Test
    public void MyfirstTest() throws Exception {
        
        mockMvc.perform(get("/login.action"))
        .andExpect(model().attributeExists("command"));
          
    }
}
