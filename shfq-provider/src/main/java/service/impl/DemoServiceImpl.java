package service.impl;

import service.DemoService;

/**
 * Created by shifengqiang on 17/3/10.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "hello " + name;
    }
}
