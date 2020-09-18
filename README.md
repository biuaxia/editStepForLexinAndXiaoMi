# 乐心运动刷步数

[github](https://github.com/biuaxia/lexin)

## 如何使用

无需修改直接启动即可。

访问 `http://localhost:8080/step`，接口接收参数如下：

| key | type | commits |
| --- | ---- | ------- |
| u | String | username, 乐心注册手机 |
| p | String | password, 乐心注册密码 |
| s | String | step, 需要刷取的步数（不要超过98800） |

如果您需要修改接口默认参数可以关注下面的文件，对其修改。

1. `StepController.java`

```jav
    /**
     * 请求接口默认的乐心手机
     */
    public static final String USERNAME = "17608348340";
    /**
     * 请求接口默认的乐心密码
     */
    public static final String PASSWORD = "biuaxia666";
    /**
     * 请求接口默认的刷取步数
     */
    public static final String STEP = "98765";
```

2. `application.yml` 为乐心接口配置，如果功能失效，请关注本项目的最新进度。