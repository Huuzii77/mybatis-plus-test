package com.example.demo;

/**
 * @author chendesheng
 * @create 2019/9/16 20:24
 */
public enum SampleEnum {

    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
