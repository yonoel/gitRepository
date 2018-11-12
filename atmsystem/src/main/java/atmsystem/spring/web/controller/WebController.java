package atmsystem.spring.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import atmsystem.spring.domain.Account;
import atmsystem.spring.domain.ConditionAccount;
import atmsystem.spring.services.AccountServices;
import atmsystem.spring.web.validator.AccountValidator;

/**
 * @ClassName: WebController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月11日 下午4:46:43
 * 
 */
@Controller
@SessionAttributes(names = "account", types = Account.class) // 并不是默认sessionAttr
public class WebController {
    // private AccountServices services = new AccountServices();

    // 访问任意页面跳转jsp/index --->这属于内部跳转没有生产command对象
    @GetMapping("/")
    public String test(Model model) {
        model.addAttribute("command", new ConditionAccount());
        return "index";
    }

    // 实例化查询对象
    @RequestMapping("/index")
    @ModelAttribute("command")
    public ConditionAccount getConditionAccount() {
        return new ConditionAccount();
    }

    private Map<String, Object> map = new HashMap<>();

    // 校验Account
    @PostMapping("/addAccount")
    public String addAccount(@Valid @ModelAttribute("command") ConditionAccount conditionAccount,
            @RequestParam("remember") boolean flag, WebRequest request, HttpServletResponse response, Model model) {

        // if has error --->index
        // if (result.hasErrors()) {
        // request.setAttribute("message", "there is a error", 0);
        // return "index";
        // }
        // call services --> vaild

        // Map<String, Account> map = AccountDB.getAll();
        // if (!map.containsKey(conditionAccount.getName())) {
        // request.setAttribute("message", "该账户不存在", 0);
        // return "index";
        // }
        // Account account = map.get(conditionAccount.getName());

        AccountServices services = new AccountServices();
        services.setSession();

        map = services.queryOne(conditionAccount);
        String message = (String) map.get("message");
        // 查询失败
        if (!"查询成功".equals(message)) {

            model.addAllAttributes(map);
            return "index";
        }
        // 成功
        // judge flag ,if true -->save it in cookie
        if (flag) {
            Cookie name = new Cookie("name", conditionAccount.getName());
            Cookie password = new Cookie("password", Integer.toString(conditionAccount.getPassword()));
            response.addCookie(name);
            response.addCookie(password);
        }
        // session attribute
        request.setAttribute("account", map.get("account"), 1);
        // else ---->main
        return "redirect:main";
    }

    @GetMapping("/main")
    public String mainrun(Model model) {
        model.addAttribute("message", "欢迎来到本行交易");
        return "main";
    }

    // logout
    @GetMapping("/logout")
    public String doLogout(SessionStatus session) {
        // clearup
        session.setComplete();
        return "redirect:index";
    }

    // draw
    @PostMapping("/draw")
    public String doDraw(@RequestParam("draw") double draw, @SessionAttribute("account") Account account, Model model) {
        ConditionAccount conditionAccount = new ConditionAccount();
        conditionAccount.setDraw(draw);
        conditionAccount.setName(account.getName());

        AccountServices services = new AccountServices();
        services.setSession();

        map = services.drawCash(conditionAccount);
        model.addAllAttributes(map);
        if ("取款成功".equals(map.get("message"))) {
            account = (Account) map.get("account");
        }
        return "main";
    }

    // save
    @PostMapping("/save")
    public String doSave(@RequestParam("save") double save, @SessionAttribute("account") Account account, Model model) {
        ConditionAccount conditionAccount = new ConditionAccount();
        conditionAccount.setSave(save);
        conditionAccount.setName(account.getName());
        // int i = AccountDB.saveCash(conditionAccount);
        AccountServices services = new AccountServices();
        services.setSession();

        map = services.saveCash(conditionAccount);
        model.addAllAttributes(map);
        // judge
        if ("存款成功".equals(map.get("message"))) {
            account = (Account) map.get("account");
        }
        return "main";
    }

    // transfer
    @PostMapping("/transfer")
    public String doTransfer(@RequestParam("transfer") double transferNum, @RequestParam("name") String name,
            @SessionAttribute("account") Account account, Model model) {
        // 对于orgin 是取钱
        ConditionAccount orgin = new ConditionAccount();
        orgin.setName(account.getName());
        orgin.setDraw(transferNum);
        // 对于dest 是存钱
        ConditionAccount dest = new ConditionAccount();
        dest.setName(name);
        dest.setSave(transferNum);

        AccountServices services = new AccountServices();
        services.setSession();

        map = services.transferAccount(dest, orgin);
        if ("转账成功".equals(map.get("message"))) {
            account = (Account) map.get("account");
        }
        model.addAllAttributes(map);
        // if (i == -1) {
        // model.addAttribute("message", "转账账户不存在");
        // } else if (i == -2) {
        // model.addAttribute("message", "账户余额不足");
        // } else if (i != 2) {
        // model.addAttribute("message", "转账失败");
        // } else {
        // model.addAttribute("message", "转账成功");
        // account.setCash(account.getCash() - transferNum);
        // }
        return "main";
    }

    // bind date convert
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    // bind valid 
    protected void initBValidator(WebDataBinder binder) {
        binder.addValidators(new AccountValidator());
    }
}
