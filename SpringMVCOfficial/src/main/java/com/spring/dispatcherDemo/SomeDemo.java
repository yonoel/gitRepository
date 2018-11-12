package com.spring.dispatcherDemo;

import java.net.URI;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @ClassName: SomeDemo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月9日 下午2:12:00
 * 
 */
public class SomeDemo {
    public static void main(String[] args) {
        String uriTemplate = "http://example.com/hotels/{hotel}";
        String baseUrl = "http://example.com";
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUrl);

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(uriTemplate).queryParam("q", "{q}").build();

        // URI uri = uriComponents.expand("Westin", "123").encode().toUri();
        URI uri = uriBuilderFactory.uriString("/hotels/{hotel}").queryParam("q", "{q}").build("Westin", "123"); // encoding
                                                                                                                // applied..
        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(factory);
        
        System.out.println(restTemplate);

    }
}
