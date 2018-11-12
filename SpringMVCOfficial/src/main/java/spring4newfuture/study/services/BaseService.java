package spring4newfuture.study.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import spring4newfuture.study.Repository.BaseRepository;

/**
 * @ClassName: BaseService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月24日 下午7:21:43
 * 
 */
public abstract class BaseService<M extends Serializable> {
    @Autowired
    protected BaseRepository<M> repository;

    public void save(M m) {
        repository.save(m);
    }
}
