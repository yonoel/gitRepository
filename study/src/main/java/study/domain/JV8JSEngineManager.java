package study.domain;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**  
* @ClassName: JV8JSEngineManager  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月31日 上午10:03:11    
*    
*/
public class JV8JSEngineManager {
    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
      
    }
}
