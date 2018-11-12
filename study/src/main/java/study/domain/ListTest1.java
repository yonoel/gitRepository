package study.domain;

import java.util.ArrayList;
import java.util.List;

/**  
* @ClassName: ListTest1  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月31日 上午7:43:33    
*    
*/
public class ListTest1 {
    private String name;
    private List<Integer> list = new ArrayList<>();
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the list
     */
    public List<Integer> getList() {
        return list;
    }
    /**
     * @param list the list to set
     */
    public void setList(List<Integer> list) {
        this.list = list;
    }
    
}
