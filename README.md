# 乐心运动刷步数

**开源项目仅供学习交流，由本项目衍生出的商业项目或用于商业用途与开发者[biuaxia](https://github.com/biuaxia)无关，望知悉**

> 当前版本号(Current version): `1.0.2-RELEASE`

CodeRepository: 

- <https://github.com/biuaxia/lexin>
- <https://gitee.com/biuaxia/lexin.git>

Demo: <http://129.28.192.85:8080/step?u={U}&p={P}&s={S}>

- `{U}`: 手机
- `{P}`: 密码
- `{S}`: 步数（需要刷的）

## 更新日志

仅从 `1.0.1-RELEASE` 开始记录，之前的版本更新请自行查看git commit。

| 版本号 | 更新内容 |
| ----- | ------ |
| 1.0.2-RELEASE| 1. 新增异常处理（主要用于密码错误或手机不存在等提示） <br/> 2. 修改默认启动端口为80 <br/> 3. 修改 `README.md` 文档的**使用说明#启动** <br/> 4. 新增 `.gitignore` 文件 <br/> 5. 修改日志打印为 `debug` 等级 |

## Todo

下面列出来的内容是规划中的功能，可做可不做，请勿强求！！！

- 添加每日自动刷步

如果你有好的点子，请提 `Issues`.

## 如何使用

服务端需要具备：

- JDK8+

简单的安装可以直接执行：

```shell
yum install java-1.8.0-openjdk* -y
java -version
```

执行完可以看到下面类似的内容即可。

```bash
openjdk version "1.8.0_265"
OpenJDK Runtime Environment (build 1.8.0_265-b01)
OpenJDK 64-Bit Server VM (build 25.265-b01, mixed mode)
```

从 [Releases](https://github.com/biuaxia/lexin/releases) 页面获取jar包，执行：

```bash
nohup java -jar lexin-{VERSION}.jar --server.port=8080 &
```

直接启动即可，其中 `{VERSION}`为对应版本号，如 `1.0.0-RELEASE`。

`--server.port=8080` 表示启动端口为8080，可以修改，如 `--server.port=80`。

访问 `http://localhost:8080/step` ，接口请求参数如下：

| key | type | commits |
| --- | ---- | ------- |
| u | String | username, 乐心注册手机 |
| p | String | password, 乐心注册密码 |
| s | String | step, 需要刷取的步数（不要超过98800） |

**注意：**`application.yml` 为乐心接口配置，如果功能失效，请关注本项目的最新进度。
