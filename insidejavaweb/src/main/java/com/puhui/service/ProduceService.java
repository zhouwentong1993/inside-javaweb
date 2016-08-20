package com.puhui.service;

import javax.jms.Destination;

/**
 * Created by wentong on 2016/8/20.
 * 生产者 Service
 */
public interface ProduceService {
    void sendMessage(Destination destination, final String message);
}
