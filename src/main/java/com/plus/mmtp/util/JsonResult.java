package com.plus.mmtp.util;

import java.io.Serializable;

/**
 * @ClassName: JsonResult
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/9/27 11:41
 * @Version: 1.0
 **/
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final int SUCCESS = 0;
    private static final int ERROR = 1;
    private static final String MESSAGE = "成功";

    private int state;
    /** 错误消息  */
    private String message;
    /** 返回正确时候的数据 */
    private Object data;

    public JsonResult() {
        state = SUCCESS;
        message = MESSAGE;
    }

    public JsonResult(String error){
        state = ERROR;
        this.message = error;
    }

    public JsonResult(Object data){
        state = SUCCESS;
        this.data = data;
    }

    public JsonResult(Throwable e) {
        state = ERROR;
        message = e.getMessage();
    }

    public JsonResult(int state, Throwable e) {
        this.state = state;
        this.message = e.getMessage();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
    }
}
