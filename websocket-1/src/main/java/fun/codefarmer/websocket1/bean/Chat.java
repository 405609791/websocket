package fun.codefarmer.websocket1.bean;

/**
 * 单聊实体类
 * @ @ClassName Chat
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/19 20:27
 **/
public class Chat {
    private String from;
    private String content;
    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
