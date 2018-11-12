package com.spring.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: UserBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月12日 上午8:42:34
 * 
 */
public class UserBean {
    private String username;
    private int age;
    private double income;
    private String[] interests;
    private boolean married;
    // List不能单独使用，必须要绑定到某一个具体的Bean,并且要实例化ArrayList
    private List<AddressListBean> list ;
    // Set不能单独使用，必须要绑定到某一个具体的Bean,并且要实例化HashSet
    private Set<AddressSetBean> set = new HashSet<>();
    // Map不能单独使用，必须要绑定到某一个具体的Bean,并且要实例化HashMap
    private Map<String, AddressMapBean> map ;
    // 复合数据类型
    private AddressBean address;

    public UserBean(){
        //set集合需要提前定义个数
//        for(int i=0;i<2;i++){
//            AddressSetBean asb=new AddressSetBean();
//            set.add(asb);
//        }
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Map<String, AddressMapBean> getMap() {
        return map;
    }

    public void setMap(Map<String, AddressMapBean> map) {
        this.map = map;
    }

    public Set<AddressSetBean> getSet() {
        return set;
    }

    public void setSet(Set<AddressSetBean> set) {
        this.set = set;
    }

    public List<AddressListBean> getList() {
        return list;
    }

    public void setList(List<AddressListBean> list) {
        this.list = list;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

}
