package com.example.administrator.coolweather.util;

/**
 * Created by Administrator on 2015/10/19.
 */
public interface HttpCallbackListener {
    void  onFinish(String response);
    void  onError(Exception e);
}
