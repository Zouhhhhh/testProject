https://blog.csdn.net/qq_24099547/article/details/91899248



# 一、原生AJAX 
## 1.2 XML简介
    XML可扩展标记语言
    XML被设计用来传输和存储数据
    <student>
        <name>孙悟空</name>
    </student>
    之前用ajax发送请求，传输数据的格式就是XML，现在被json代替
## 1.3 AJAX的特点
    优点：
    1. 可以无需刷新页面而与服务器端进行通信
    2. 允许根据用户事件来更新部分页面内容
    缺点：
    1. 没有浏览历史，不能回退
    2. 存在跨域问题（同源策略）
    3. SEO不友好（爬虫爬不到网页内容）

## 1.4 HTTP协议
    HTTP（超文本传输协议），协议详细规定了浏览器和万维网服务器之间通信的规则。

### 请求报文
    重点是格式与参数
    
    行  GET /s?ie=utf-8 HTTP/1.1
    头  Host: atguigu.com
        Cookie: name=guigu
        Content-type: application/x-www-form-urlencoded
        User-Agent: chrome 83
    空行
    体  GET请求为空，POST请求可以为空   username=admin&password=admin

### 响应报文
    重点是格式与参数
    
    行  HTTP/1.1 200 OK
    头  Content-Type: text/html;charset=utf-8
        Content-length: 2048
        Content-encoding: gzip
    空行
    体  <html>
            <head>
            </head>
            <body>
                <h1>标题</h1>
            </body>
        </html>

## 1.5 Express框架
    基于Node.js平台，快速、开放、极简的Web开发框架
    作为小型服务器接收请求

    //1. 引入express
    const { response } = require('express');
    const express = require('express');

    //2. 创建应用对象
    const app = express();

    //3. 创建路由规则
    app.get('/server', (request, response)=>{
        //设置响应头    设置允许跨域
        response.setHeader("Access-Control-Allow-Origin",'*');

        //设置响应
        response.send("hello ajax");
        
    });

    //4. 监听端口启动服务
    app.listen(8000, ()=>{
        console.log("服务已经启动，8000端口监听中");
    });

    当有浏览器请求127.0.0.1:8000/server时，express服务器则会监听到该请求并处理

## 1.6 原生AJAX
### （1）发送get和post请求
    1. 服务器server.js
    2. 页面写ajax请求，并通过button发送请求，获取响应体信息放到div展示
        ajax请求:
            //获取button元素
            const btn = document.getElementsByTagName('button')[0];
            const result = document.getElementById('result');
            //绑定事件
            btn.onclick = function(){
                
                //1. 创建对象
                const xhr = new XMLHttpRequest();

                //2. 初始化 设置请求方法和url
                xhr.open('GET', 'http://127.0.0.1:8000/server');

                //3. 发送
                xhr.send();

                //4. 事件绑定   处理服务端返回的结果
                //readystate 是 xhr 对象中的属性， 表示状态0 1 2 3 4
                xhr.onreadystatechange = function() {
                    //判断
                    if (xhr.readyState === 4) {
                        //判断响应状态码 200 404 403 401 500
                        //2xx成功
                        if (xhr.status >= 200 && xhr.status <300) {
                            //处理结果  行 头 空行  体
                            //响应
                            // console.log(xhr.status);    //状态码
                            // console.log(xhr.statusText);    //状态字符串
                            // console.log(xhr.getAllResponseHeaders());   //所有响应头
                            // console.log(xhr.response);  //响应体

                            //设置 result 的文本
                            result.innerHTML = xhr.response;

                        }
                    }
                }
            }
    3. 设置请求方法和url
        xhr.open('POST', url);
    4. 设置请求体，POST方式
        xhr.send('a=100&b=200');
    5. 设置请求头
        xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
### （2）发送和接收JSON数据
    服务端：
        app.all('/json-server', (request, response)=>{
        //设置响应头    设置允许跨域
        response.setHeader('Access-Control-Allow-Origin','*');
        //响应一个数据
        const data = {
            name: 'atguigu'
        }
        //对对象进行字符串转换
        let str = JSON.stringify(data);
        //设置响应
        response.send(str);
        
    });

    浏览器：
        1. 手动对数据转换
            let data = JSON.parse(xhr.response);
            result.innerHTML = data.name;
        2. 自动转换
            //设置响应体数据类型
            xhr.responseType = 'json';
### （3）nodemon自动重启服务端
    nodemon server.js

### （4）AJAX IE缓存问题
    用IE浏览器发送ajax请求的时候，如果请求同一地址，可能出现缓存情况
    解决方法：
        在请求url上加时间戳
        xhr.open('GET', 'http:127.0.0.1:8000/ie?t=' + Date.now());

### （5）这些内容用到再看把
    AJAX请求超时
    AJAX取消请求
    AJAX请求重复发送

# 二、JQuery中的AJAX
## get请求
    $('button').eq(0).click(function() {
            //第一个参数是请求url，第二个参数是发送的参数，第三个参数是回调函数，其中的参数是响应体。
            //第四个参数是响应体类型
            $.get('http:127.0.0.1:8000/jquery-server', {a:100,b:200}, function(data){
                console.log(data);
            }, 'json');
        });


## post请求
    $('button').eq(1).click(function() {
            //第一个参数是请求url，第二个参数是发送的参数，第三个参数是回调函数，其中的参数是响应体
            $.post('http:127.0.0.1:8000/jquery-server', {a:100,b:200}, function(data){
                console.log(data);
            });
        });

## 通用方法
    $.ajax({
        //url
        url: 'http:127.0.0.1:8000/jquery-server',
        //参数
        data: {a:100, b:200},
        //请求类型
        type: 'GET',
        //响应体类型
        dataType: 'json',
        //成功的回调
        success: function(data) {
            console.log(data);
        },
        //超时时间
        timeout: 2000,
        //失败的回调
        error: function() {
            console.log("出错啦");
        }
    })

# 三、axios中的AJAX
    const btns = document.querySelectorAll('button');

        btns[0].onclick = function() {

            //配置baseURL
            axios.defaults.baseURL = 'http:127.0.0.1:8000';
            //GET请求
            axios.get('/axios-server', {
                //url参数
                params: {
                    id: 100,
                    vip: 7
                },
                //请求头信息
                headers: {
                    name: 'atguigu',
                    age: 20
                }
            });
        }

