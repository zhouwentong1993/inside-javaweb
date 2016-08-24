package com.puhui.service.impl;

import com.puhui.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * Created by wentong on 2016/8/20.
 */
@Service
public class ProduceServiceImpl implements ProduceService {
    @Autowired
    @Qualifier("jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(Destination destination, String message) {
        jmsTemplate.send(destination, session -> session.createTextMessage(message));
    }
}
