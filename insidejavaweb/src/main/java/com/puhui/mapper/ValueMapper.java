package com.puhui.mapper;

import com.puhui.vo.Value;

/**
 * Created by wentong on 2016/4/28.
 */
public interface ValueMapper {
    void insertValue(Value value);

    Value selectByPort();

    void updateValue(Value value);
}
