package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.entities.Message;
import com.atguigu.springcloud.service.DeptService;
import com.atguigu.springcloud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MessageController {


    @Autowired
    private MessageService service;
    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value = "/message/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Message message) {
        System.out.println("add");
        System.out.println(message.toString());
        return service.add(message);
    }

    @RequestMapping(value = "/message/get/{id}", method = RequestMethod.GET)
    public Message get(@PathVariable("id") Long id) {

        System.out.println("i am 8001 ");
        System.out.println(service.get(id).toString());
        return service.get(id);

    }


    @RequestMapping(value = "/message/info", method = RequestMethod.GET)
    public String get() {
        System.out.println("i am 8001 ");
        return  System.currentTimeMillis()+"";

    }

    @RequestMapping(value = "/message/list", method = RequestMethod.GET)
    public List<Message> list() {
        return service.list();
    }


//	@Autowired
//	private DiscoveryClient client;

    /**
     * 服务发现：可以得到当前在eureka中已注册的服务
     *
     * @return
     */
    @RequestMapping(value = "/message/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
