$(function () {
    $("#connect").click(function () {
        connect();
    })
    //断开连接
    $("#disconnect").click(function () {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
    })
    //发送
    $("#send").click(function () {
        //发送到/app/hello 经过处理再关播感到 @SendTo("/topic/greetings")这个服务器
        /**
         * 第一个参数：
         * 发送到/app/hello 经过处理再关播感到 @SendTo("/topic/greetings")这个服务器
         * 第二个参数：
         * 消息的优先级等等
         * 第三个参数：
         * Message对象，需要转成JSON 字符串格式
         */
        var param = {
            "name":$("#name").val(),
            "content":$("#content").val()
        }
        stompClient.send('/app/hello',{},JSON.stringify(param));
    })
})
var stompClient = null;
function connect() {
    //用户名不能为空
    if (!$("#name").val()) {
        return;
    }
    // WebSocketConfig 类中建立连接
    var socket = new SockJS('/chat');
    //调用 stompClient
    stompClient = Stomp.over(socket);
    /**
     * 建立连接
     * 第一个参数：公共属性，优先级等
     * 第二个参数：连接成功的回调
     * 第三个参数：失败的回调（先不处理）
     */
    stompClient.connect({},function (success) {
        // 给按钮设置正确状态
        setConnected(true);
        //订阅服务器上的东西
        /**
         * 第一个参数：订阅服务器的参数
         * controller 处理的消息会存在/topic/greetings
         * 服务器发消息，会被下面监听到
         */
        stompClient.subscribe('/topic/greetings',function (msg) {
            //将字符串转成json,消息存在body中
            showGreeting(JSON.parse(msg.body));
        })
    });
}
// 给按钮设置正确状态
function setConnected(flag) {
    $("#connect").prop("disabled", flag);
    $("#disconnect").prop("disabled", !flag);
    if (flag) {
        $("#chat").show();
    } else {
        $("#chat").hide();
    }
}
function showGreeting(msg) {
    console.log(msg);
    $("#conversation").append('<div>'+msg.name+':'+msg.content+'</div>');
}