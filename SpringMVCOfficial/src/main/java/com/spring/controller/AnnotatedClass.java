package com.spring.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonView;
import com.spring.domain.AddressListBean;
import com.spring.domain.AddressSetBean;
import com.spring.domain.Person;
import com.spring.domain.Preferences;
import com.spring.domain.TagsModel;
import com.spring.domain.User;
import com.spring.domain.UserBean;
import com.spring.exception.SpringException;

import jsr303.jsr349.Java.Bean.Validation.Book;

/**
 * @ClassName: AnnotatedClass
 * @Description: 测试类
 * @date 2018年7月9日 下午3:20:50
 * 
 */
@Controller
// @RestController // = @Controller + @ResponseBody 所以返回值就是直接重写了
// @RequestMapping("/persons")
// @SessionAttributes("user") // 预初始化一个sessionattr name = user
public class AnnotatedClass {
    private Logger log = LogManager.getLogger();
    
    // direct register a exception
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }
    // 这个没有页面，集中了一下异常的处理
    @ExceptionHandler({ SpringException.class })
    @RequestMapping(value = "/persontest", method = RequestMethod.POST)
    public String addStudent(Person person, Model model) {
       
        if(person.getBirthday().before(new Date(2000, 12, 11))) {
            throw new SpringException("Given age is too low");
        }
        model.addAttribute("age", person.getBirthday());
   
        return "result";
    }

    // 测试jsr303校验BOOK类
    @PostMapping("/addbook")
    public String addbook( @Valid Book book, BindingResult result,WebRequest request) {
        // 校验成功 了，不会回显
        if (result.hasErrors()) {
            request.setAttribute("command", book, 0);
            return "book";
        }
        System.out.println(book.toString());
        request.setAttribute("command", book, 1);
        return "result";
    }

    @RequestMapping("/book")
    @ModelAttribute("command")
    public Book createBook() {

        return new Book();
    }
    // 这里出现个问题，即在后台配置了一个Validator，前台这个也绑定了，出现了冲突，都在校验
//     @InitBinder
//     protected void initBValidator(WebDataBinder binder) {
//     binder.addValidators(new UserValidator());
//    
//     }

    // test 如果属性名与提交项名称相同，可以不配置@RequestParam
    @PostMapping("/addUser")
    public String addUser( @Valid User user, BindingResult result, 
            SessionStatus status) {
        if (result.hasErrors()) {
            // request.setAttribute(name, value, scope);
            // request.setAttribute("user", user);
            return "user";
        }
        System.out.println(user.getPsd());
        // cleanup session all
        // status.setComplete();
        return "result";
    }

    @GetMapping("/user")
    // @ModelAttribute("user") //因为seesion 里声明了,request里不用声明了
    public User userHandle() {
        return new User();
    }

    // test multipart
    @PostMapping("/jsp/upload")
    public String uoload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] arr = file.getBytes();
            log.info("uploadSuccess");
            return "redirect:index";
        }
        log.info("uploadFaild");
        return "redirect:index";
    }

    // test convert
    @PostMapping("/dateTest")
    public String doconvet(Date date) {
        log.info(date);
        return "dateTest";
    }

    @GetMapping("/dateTest")
    public String date() {
        return "dateTest";
    }

    // test initdata
    @PostMapping("/registerUserBean.do")
    public String registBean(UserBean user) {
        log.info("username:" + user.getUsername());
        log.info("age:" + user.getAge());
        log.info("income:" + user.getIncome());
        log.info("interests.length:" + user.getInterests().length);
        log.info("married:" + user.isMarried());
        log.info("addressList.size():" + user.getList().size());
        log.info("addressSet.size():" + user.getSet().size());
        log.info("addressMap.size():" + user.getMap().size());
        log.info("address:" + user.getAddress().getAddressName());

        for (String string : user.getInterests()) {
            log.info("具体的兴趣有=========" + string);
        }

        for (AddressListBean add : user.getList()) {
            log.info("具体的list地址有=========" + add.getAddressListName());
        }

        for (AddressSetBean asetb : user.getSet()) {
            log.info("具体的set地址有=========" + asetb.getAddressSetName());
        }

        for (int i = 0; i < 2; i++) {
            log.info("具体的map地址有=========" + user.getMap().get("a" + i).getAddressMapName());
        }

        return "index";
    }
    // public void registerUser(String username,int age,double income,String[]
    // interests,boolean married) {
    // log.info("username=" + username);
    // log.info("age=" + age);
    // log.info("income=" + income);
    // log.info("interests=" + interests.length);
    // log.info("married=" + married);
    // }

    @GetMapping("/registerUserBean")

    public UserBean goRegister() {
        return new UserBean();
    }

    // test tag checkboxes items!=null ,if null ,500 status
    // note: item support ELexpr not SPELexpr
    @GetMapping(value = "/checkboxes")
    public Preferences perfencesHandle(@ModelAttribute("checkboxes") Preferences preferences) {
        String[] arr = { "aa", "bb" };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        preferences.setInterests(arr);
        return preferences;
    }

    // 测试tags 在jsp里声明先访问这个方法，再去访问View
    @GetMapping("/preferenceForm")
    @ModelAttribute("command")
    public Preferences perfencesHandle() {
        Preferences p = new Preferences();

        // p.setFavouriteWord("test");
        // p.setReceiveNewsletter(true);
        // p.setInterests(new String[] { "play", "sing" });
        return p;
    }

    // initbinder
    // 初始化绑定。。。类型转换
    // @InitBinder
    // public void initBinder(WebDataBinder binder) {
    // binder.registerCustomEditor(Date.class, new CustomDateEditor(new
    // SimpleDateFormat("yyyy-MM-dd"), false));
    // }

    // @PostMapping("/convert")
    // public String DateConvert(@ModelAttribute("command") Date2 date2) {
    //
    // return "result";
    // }
    @PostMapping("/setModel")
    public String setModel(@ModelAttribute("contentModel") TagsModel tagsModel) {
        // Map<String, Object> map = model.asMap();
        // System.out.println(map.size());
        // if (!map.isEmpty()) {
        // map.entrySet().forEach(p -> System.out.println(p.getKey() + "," +
        // p.getValue()));
        // }
        if (tagsModel != null) {
            if (tagsModel.getTestArray() != null) {
                String[] test = tagsModel.getTestArray();
                for (int i = 0; i < test.length; i++) {
                    System.out.println(test[i]);
                }

            }
        }
        return "result";
    }

    @GetMapping("/tagstest")
    public void getModel(@ModelAttribute("contentModel") TagsModel tagsModel) {
        tagsModel.setSelectArray(new String[] { "arrayItem 路人甲" });
        tagsModel.setTestArray(new String[] { "arrayItem 路人甲", "arrayItem 路人乙", "arrayItem 路人丙" });
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "mapItem 路人甲");
        map.put(2, "mapItem 路人乙");
        map.put(3, "mapItem 路人丙");
        tagsModel.setTestMap(map);
        tagsModel.setRemark("备注...");
    }

    @GetMapping("/initbinder")
    // @ModelAttribute("contentModel") //
    // 本来是声明在方法上代表给model层生成一个叫contentModel的attr
    public String handleDate(Model model) {
        if (!model.containsAttribute("contentModel")) {
            TagsModel tagsModel = new TagsModel();
            tagsModel.setUsername("aaa");
            tagsModel.setPassword("bbb");
            tagsModel.setTestBoolean(true);
            tagsModel.setSelectArray(new String[] { "arrayItem 路人甲" });
            tagsModel.setTestArray(new String[] { "arrayItem 路人甲", "arrayItem 路人乙", "arrayItem 路人丙" });
            tagsModel.setRadiobuttonId(1);
            tagsModel.setSelectId(2);
            tagsModel.setSelectIds(Arrays.asList(1, 2));
            Map<Integer, String> map = new HashMap<Integer, String>();
            map.put(1, "mapItem 路人甲");
            map.put(2, "mapItem 路人乙");
            map.put(3, "mapItem 路人丙");
            tagsModel.setTestMap(map);
            tagsModel.setRemark("备注...");
            model.addAttribute("contentModel", tagsModel);
        }
        return "tagstest";
    }

    @GetMapping("/jsonview")
    @JsonView(Person.WithoutPasswordView.class)
    public Person getUser() {
        return new Person("eric", 55555L);
    }

    @GetMapping("/person")
    @ModelAttribute("command")
    public Person handle() {
        System.out.println("model person name command is created");
        return new Person();
    }

    // @GetMapping("/person")
    // public ModelAndView Person() {
    // return new ModelAndView("person", "command", new Person());
    // }

    @PostMapping("/addPerson")
    // 注意要注解@ModelAttribute binds a method parameter or method return value
    // to a named model attribute
    public String setupForm(@ModelAttribute("command") Person person, Model model) {
        // post param ,the person is created
        model.addAttribute("name", person.getName());
        return "result";
    }

    // // GET /owners/42;q=11;r=12/pets/21;q=22;s=23
    // @GetMapping("/owners/{ownerId}/pets/{petId}")
    // public void findPet(@MatrixVariable MultiValueMap<String, String>
    // matrixVars,
    // @MatrixVariable(pathVar = "petId") MultiValueMap<String, String>
    // petMatrixVars) {
    //
    // // matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
    // // petMatrixVars: ["q" : 22, "s" : 23]
    // }

    // GET /pets/42

    // @GetMapping("/pets/{petId}")
    // public void findPet(@MatrixVariable(required = false, defaultValue = "1")
    // int q) {
    //
    // // q == 1
    // }

    // // GET /owners/42;q=11/pets/21;q=22
    // @GetMapping("/owners/{ownerId}/pets/{petId}")
    // public void findPet(@MatrixVariable(name = "q", pathVar = "ownerId") int
    // q1,
    // @MatrixVariable(name = "q", pathVar = "petId") int q2) {
    // System.out.println(q1);
    // System.out.println(q2);
    // }

    // // get /pets/20;q=5
    // @GetMapping("/pets/{petId}")
    // public void findPet(@PathVariable String petId, @MatrixVariable int q) {
    // System.out.println(petId);
    // System.out.println(q);
    // }

    // @GetMapping("/{id}")
    // public Person getPerson(@PathVariable Long id) {
    // return new Person(id);
    // }

    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public void add(@RequestBody Person person) {
    // // ...
    // }

    @RequestMapping(value = "/hello")
    public String handle(Model model) {
        model.addAttribute("message", "hello");
        return "index2";
    }

    @GetMapping(value = "/test")
    public String test(Model model) {
        model.addAttribute("message", "test ");
        return "index2";
    }
}
