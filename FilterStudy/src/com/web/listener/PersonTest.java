package com.web.listener;


import org.junit.Test;

/**
 * @ClassName: PersonTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月6日 上午8:53:17
 * 
 */
public class PersonTest {

    @Test
    public void test() {
        Person p = new Person();
        p.registerListener(new PersonListener() {

            @Override
            public void dorun(Event e) {
                Person p = e.getSource();
                System.out.println(p + " is running and i find it");

            }

            @Override
            public void doeat(Event e) {
                Person p = e.getSource();
                System.out.println(p + " is eating");

            }
        });
        p.eat();
        p.run();
    }

}
