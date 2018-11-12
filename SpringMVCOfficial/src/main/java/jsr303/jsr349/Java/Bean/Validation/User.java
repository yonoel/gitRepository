package jsr303.jsr349.Java.Bean.Validation;

import java.io.Serializable;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月24日 下午2:46:10
 * 
 */
@GroupSequence({First.class,Second.class,User.class})
public class User implements Serializable {
    @NotNull(message = "{user.id.null}", groups = First.class)
    private Long id;
    @Length(min = 5, max = 20, message = "{user.name.length.illegal}", groups = First.class)
    @Pattern(regexp = "[a-zA-Z]{5,20}", message = "{user.name.illegal}", groups = Second.class)
    private String name;

    @NotNull(message = "{user.password.null}", groups = { First.class, Second.class })
    private String password;
    
    
}
