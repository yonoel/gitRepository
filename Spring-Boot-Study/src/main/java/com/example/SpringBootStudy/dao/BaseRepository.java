package com.example.SpringBootStudy.dao;

import java.io.Serializable;

/**
 * @ClassName: BaseRepository
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月11日 下午2:52:36
 * 
 */
public abstract class BaseRepository<M extends Serializable> {
    public void save(M m) {
        System.out.println("=====repository save:" + m);
    }
}
