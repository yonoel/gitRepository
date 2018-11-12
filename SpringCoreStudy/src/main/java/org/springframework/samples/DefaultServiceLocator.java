package org.springframework.samples;

/**
 * @ClassName: DefaultServiceLocator
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月13日 下午6:55:29
 * 
 */
public class DefaultServiceLocator {
    private static ClientService clientService = new ClientService();

    private static AccountService accountService = new AccountService();

    public ClientService createClientServiceInstance() {
        return clientService;
    }

    public AccountService createAccountServiceInstance() {
        return accountService;
    }
}
