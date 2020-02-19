package fun.codefarmer.websocket1.bean;

/**
 *  封装消息对象 类
 * @ @ClassName Message
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/18 16:32
 **/
public class Message {
    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
