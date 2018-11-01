package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.entities.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageDao {
    public boolean addMessage(Message dept);

    public Message findById(Long id);

    public List<Message> findAll();

    public boolean updateMessage(Message message);

}
