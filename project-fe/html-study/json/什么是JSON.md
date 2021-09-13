
# JSON其实就是一个独立于任何编程语言的独立的轻量的数据交换的东西，方便于人的阅读和机器的解析。里面的内容还是键值对的形式存在的，可以对其进行增删改查的，但是当从数据库中调用数据的时候，需要对其进行数据的转换。

    ## 对象格式和数组格式可以互相嵌套!!注意：json的key是字符串（不能以数字开头）  json的value是Object

 # 一、JSON含义：
　　JSON的全称是”JavaScript Object Notation”，意思是JavaScript对象表示法，它是一种基于文本，独立于语言的轻量级数据交换格式。

    json是js的原生内容，也就意味着js可以直接取出json对象中的数据.

    json是一种与语言无关的数据交换的格式，作用：使用ajax进行前后台数据交换、移动端与服务端的数据交换!
　　（XML也是一种数据交换格式，为什么没有选择XML呢？因为XML虽然可以作为跨平台的数据交换格式，但是在JS(JavaScript的简写)中处理XML非常不方便，同时XML标记比数据多，增加了交换产生的流量，而JSON没有附加的任何标记，在JS中可作为对象处理，所以我们更倾向于选择JSON来交换数据。）

# 二、JSON和js对象的转换关系
很多人搞不清楚 JSON 和 JS 对象的关系，甚至连谁是谁都不清楚。其实，可以这么理解：JSON 是 JS 对象的字符串表示法，它使用文本表示一个 JS 对象的信息，本质是一个字符串。平时说的JSON对象，是JSON格式的JS对象或是符合JSON数据结构要求的JS对象。

json字符串：指的是符合json格式要求的js字符串。例如：var jsonStr = "{StudentID:'100',Name:'tmac',Hometown:'usa'}";
json对象：指符合json格式要求的js对象。例如：var jsonObj = { StudentID: "100", Name: "tmac", Hometown: "usa" };

# 三、JSON和js对象互转
将JSON对象转为字符串
var json = JSON.stringify({"province":"shanghai", "city":"xian"});
console.log(json);  //结果是{"province":"shanghai", "city":"xian"}

将字符串转为JSON对象
var obj = JSON.parse('{"province":"shanghai", "city":"xian"}');
console.log(obj);   //结果是Object
