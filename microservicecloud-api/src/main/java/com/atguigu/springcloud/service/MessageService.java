package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.entities.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface MessageService {


    // 采用Feign我们就可以使用SpringMVC的注解来对服务进行绑定！
    @RequestMapping(value = "/message/get/{id}", method = RequestMethod.GET)
    public Message get(@PathVariable("id") long id);

    @RequestMapping(value = "/message/list", method = RequestMethod.GET)
    public List<Message> list();

    @RequestMapping(value = "/message/add", method = RequestMethod.POST)
    public boolean add(Message message);

}
