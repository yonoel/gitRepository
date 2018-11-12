package com.spring.controller;

import static java.lang.System.out;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @ClassName: TestForm
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月2日 上午9:09:06
 * 
 */

// @SpringJUnitWebConfig(locations="classpath:app-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:app-servlet.xml")
public class TestForm {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    WebClient webClient;

    @Test
    public void testContext() {
        assertNotNull(context);
    }

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
        assertNotNull(mvc);
        webClient = MockMvcWebClientBuilder.webAppContextSetup(context).contextPath("").build();
        // assertNotNull(webClient);

    }

    @Test
    public void testHtml() throws Exception {
        /*
         * String summaryParamName = "summary"; String textParamName = "text";
         * mvc.perform(get("/messages")) .andExpect(jsonPath("//input[@name='" +
         * summaryParamName + "']").exists())
         * .andExpect(jsonPath("//textarea[@name='" + textParamName +
         * "']").exists());
         */
        MockHttpServletRequestBuilder createMessage = post("/messages").param("summary", "Spring Rocks").param("text",
                "In case you didn't know, Spring Rocks!");

        mvc.perform(createMessage).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/messages/123"));

    }

    @Test
    public void testHtmlUnit() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
//        out.println();
//        out.print(webClient.toString()+"/r/n");
//        out.println();
//        out.print(webClient.getWebConnection()+"/r/n");
       
         HtmlPage test1 = webClient.getPage("http://localhost/test1");
        
        // HtmlPage page = webClient.getPage("http://localhost/");
        // assertNotNull(page);
        // HtmlForm form = page.getForms().get(0);
        // assertNotNull(form);

        // HtmlPage createMsgFormPage =
        // webClient.getPage("http://localhost/messages");

    }
}
