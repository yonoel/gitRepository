package spring4newfuture.study.Repository;

import java.io.Serializable;

/**
 * @ClassName: BaseRepository
 * @Description: //
 *               对于Repository，我们一般是这样实现的：首先写一个模板父类，把通用的crud等代码放在BaseRepository；然后子类继承后，只需要添加额外的实现。
 * @date 2018年7月24日 下午7:17:31
 * 
 */
public abstract class BaseRepository<M extends Serializable> {
    public void save(M m) {
        System.out.println("=====repository save:" + m);
    }
}
