//1. 引入express
const { response } = require('express');
const express = require('express');

//2. 创建应用对象
const app = express();

//3. 创建路由规则
app.get('/server', (request, response)=>{
    //设置响应头    设置允许跨域
    response.setHeader('Access-Control-Allow-Origin','*');

    //设置响应
    response.send("hello ajax");
    
});

app.post('/server', (request, response)=>{
    //设置响应头    设置允许跨域
    response.setHeader('Access-Control-Allow-Origin', '*');

    //响应头
    response.setHeader('Access-Control-Allow-Headers', '*');

    //设置响应
    response.send('hello ajax post');
    
});

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

//jQuery服务
app.all('/jquery-server', (request, response) => {
    response.setHeader('Access-Control-Allow-Origin', '*');
    response.send('hello jquery ajax')
});








//4. 监听端口启动服务
app.listen(8000, ()=>{
    console.log('服务已经启动，8000端口监听中');
});