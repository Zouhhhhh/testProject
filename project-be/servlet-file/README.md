JSP需要注意的：
    1. upload.jsp设置一个表单（methods为post，如果是get请求参数就是文件名）和一个input（type为file）
    2. form表单的enctype设置multipart/form-data，以二进制的形式传输数据

Servlet需要注意的：
    1. UpLoadServlet接收
    2. 不能以parameter形式去取，会null
    3. 需要以流的方式去取（req.getInputStream()）