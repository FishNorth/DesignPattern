# 工厂模式

## 说明

本部分代码是模仿Spring DI;

```java
public class RateLimiter{
    private RedisCounter redisCounter;
    public RateLimiter(RedisCounter redisCounter){
        this.redisCounter = redisCounter;
    }
    public void test(){
        System.out.println("hello world!");
    }
    
}

public class RedisCounter{
    private String ipAddress;
    private int port;
    public RedisCounter(String ipAddress,int port){
        this.ipAddress = ipAddress;
        this.port = port;
    }
}
```


// 配置文件beans.xml
```xml
<beans>
    <bean id = "rateLimiter" class ="com.glodon.guanl.RateLimiter">
        <conStructor-args ref="redisCounter"/>
    </bean>
    
    <bean id = "redisCounter" class ="com.glodon.guanl.RedisCounter">
        <conStructor-args type = "String" value = "127.0.0.1"/>
        <conStructor-args type = "int" value = "1234"/>
    </bean>
</beans>
```