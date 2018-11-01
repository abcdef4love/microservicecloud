package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.MessageDao;
import com.atguigu.springcloud.entities.Message;
import com.atguigu.springcloud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao dao ;
    @Override
    public boolean add(Message message) {
        System.out.println(message.toString());
        return dao.addMessage(message);
    }

    @Override
    public Message get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Message> list() {
        return dao.findAll();
    }
}
