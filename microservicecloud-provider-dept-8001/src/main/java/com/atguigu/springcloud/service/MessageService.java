package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Message;

import java.util.List;

public interface MessageService {

    public boolean add(Message message);

    public Message get(Long id);

    public List<Message> list();
}
