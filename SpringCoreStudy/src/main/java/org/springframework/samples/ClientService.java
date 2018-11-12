package org.springframework.samples;

/**
 * @ClassName: ClientService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月13日 下午6:46:21
 * 
 */
public class ClientService {
    private static ClientService clientService = new ClientService();

    public ClientService() {
    }

    public static ClientService createInstance() {
        return clientService;
    }
}
