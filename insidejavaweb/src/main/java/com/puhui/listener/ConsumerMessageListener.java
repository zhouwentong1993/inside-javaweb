package com.puhui.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by wentong on 2016/8/20.
 * 消息监听器
 */
public class ConsumerMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("【 onMessage 】方法被调用");
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("接受到的信息是：" + textMessage.getText());
        } catch (JMSException e) {
            throw new IllegalStateException("MQ 状态不对了", e);
        }

    }
}
