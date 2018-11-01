package com.atguigu.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 消息
 */
@NoArgsConstructor
//@AllArgsConstructor
@Data

@Accessors(chain = true)
public class Message implements Serializable// entity --orm--- db_table
{
    public Long id;
    public String tonumber;
    public String messagetype;
    public String senddate;
    public String context;
    public String sendflag;

    public Message(String ToNumber)
    {
        super();
        this.tonumber = tonumber;
    }
}
