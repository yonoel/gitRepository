package com.igeek.services;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.igeek.web.controller.EmpLoginController;

/**  
* @ClassName: EmpLoginControllerTest  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月1日 下午6:40:56    
*    
*/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:Spring-mybatis.xml")
//@WebAppConfiguration//1 此注解指定web资源的位置，默认为src/main/webapp
public class EmpLoginControllerTest2 {

    private MockMvc mockMvc;
   
    @Before
    public void setup() {
       EmpLoginController empLogin = new EmpLoginController();
       this.mockMvc = MockMvcBuilders.standaloneSetup(empLogin).build();

    }
   
    @Test
    public void MyfirstTest() throws Exception {
      
        mockMvc.perform(get("/login.action")).andExpect(MockMvcResultMatchers.view().name("login"))
        .andExpect(model().attributeExists("command"));
          
    }
}
