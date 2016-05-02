package com.puhui.web.controller;

import com.puhui.mapper.ValueMapper;
import com.puhui.vo.Value;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wentong on 2016/3/29.
 */
@Controller
@RequestMapping("test")
public class TestController {

    private AtomicLong atomicLong = new AtomicLong(1L);
    @Autowired
    private ValueMapper valueMapper;

    @RequestMapping(value = "/testGet", method = RequestMethod.GET)
    @ResponseBody
    public Object testGet(HttpServletRequest request) {
        String username = request.getParameter("username");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/testPost", method = RequestMethod.POST)
    @ResponseBody
    public Object testPost(HttpServletRequest request) {
        String username = request.getParameter("username");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/insertValue", method = RequestMethod.GET)
    @ResponseBody
    public Object insert(HttpServletRequest request) throws InterruptedException {
        try {


            StringBuffer requestURL = request.getRequestURL();
//        request.get
            int serverPort = request.getServerPort();
            Long timeStamp = System.currentTimeMillis();
            long l = atomicLong.incrementAndGet();
            System.out.println("requestURL : " + l);
            System.out.println("serverPort : " + serverPort);
            System.out.println("timeStamp : " + timeStamp);
            Value value = new Value();
            value.setRequestUrl(l + "");
            value.setPort(serverPort + "");
            value.setTimeStamp(timeStamp);
            Thread.sleep(100);
            Value realValue = valueMapper.selectByPort();
            if (realValue != null) {
                valueMapper.updateValue(value);
            } else {
                valueMapper.insertValue(value);
            }
            Thread.sleep(100);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", "1");
            jsonObject.put("msg", "添加成功");
            return jsonObject;
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", "-1");
            jsonObject.put("msg", "添加失败");
            return jsonObject;
        }
    }

}
