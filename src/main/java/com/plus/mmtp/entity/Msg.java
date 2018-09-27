package com.plus.mmtp.entity;

/**
 * @ClassName: Msg
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/9/25 18:22
 * @Version: 1.0
 **/
public class Msg {

    private String title;
    private String content;
    private String body;

    public Msg(String title, String content, String body) {
        this.title = title;
        this.content = content;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
