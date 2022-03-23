JSP需要注意的：
    1. upload.jsp设置一个表单（methods为post，如果是get请求参数就是文件名）和一个input（type为file）
    2. form表单的enctype设置multipart/form-data，以二进制的形式传输数据

Servlet需要注意的：
    1. UpLoadServlet接收
    2. 不能以parameter形式去取，会null
    3. 需要以流的方式去取（req.getInputStream()）

读取文本：
    输入流
    InputStream inputStream = req.getInputStream();
    Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
    BufferedReader bufferedReader = new BufferedReader(reader);
    String str = "";
    while((str = bufferedReader.readLine()) != null) {
        System.out.println(str);
    }

读取文本并保存
    1. 通过输入流获取客户端传来的数据流
        代码同上(但是要注释掉读取输入流，流只能被读取一次！！！)
    2. 通过输出流将数据流输出到本地硬盘
        需要先在out/artifacts/.../创建一个file，就是工程的web文件夹下
        获取文件的绝对路径（可以通过ServletContext去找，其实找的是打包后的out/里面）
        
        String filePath = req.getServletContext().getRealPath("file/copy.txt");
        OutputStream outputStream = new FileOutputStream(filePath);
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        while((str = bufferedReader.readLine()) != null) {
            bufferedWriter.write(str);
        }

使用框架（fileupload）完成文件上传
    1. 导包，WEB-INF下创建lib
    2. 
    


//TODO:（还是回去看书吧，网上的太杂了）
java的I/O流学习
    1. 字节流byte
        - InputStream
            - read()读取下一个字节
            - read(byte[])读取全部字节放到byte数组
            - read(byte[], off, len)读取从off开始后的len个字节
        - outputStream
    2. 字符流
        - Reader
        - Writer