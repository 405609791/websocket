# websocket
spring boot 整合websocket、在线群聊、在线单聊

** https://mvnrepository.com 
	这里也能搜到前端依赖，
	<!--前端依赖 开始-->
        <!-- https://mvnrepository.com/artifact/org.webjars/sockjs-client -->
		<!-- socket 连接-->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>sockjs-client</artifactId>
            <version>1.1.2</version>
        </dependency>
        <!--Jquery-->
        <!-- https://mvnrepository.com/artifact/org.webjars/jquery -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>3.4.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.webjars/stomp-websocket -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>stomp-websocket</artifactId>
            <version>2.3.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.webjars/webjars-locator-core -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>webjars-locator-core</artifactId>
        </dependency>
        <!--前端依赖 结束-->
	
	前端依赖可以也可以不在pom.xml文件中加依赖，可以下载js文件前端引入，maven 优势：有更新时在pom.xml中修改即可。

