package cxc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 原生的上传下载
 *
 * @author cxc
 * @date 2021/5/22
 */

@WebServlet("/downLoad")
public class DownLoad extends HttpServlet {

    private static final long serialVersionUID = 3524685063787514310L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所下载文件的真实路径
        String realPath = this.getServletContext().getRealPath("resource/img/好看的妞.jpg");

        //将路径所对应的内容用文件对象读取
        File file = new File(realPath);
        //获取文件名
        String fileName = file.getName();
        //设置响应对象的响应头
        resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //使用输入流来读取文件的内容
        FileInputStream fileInputStream = new FileInputStream(file);
        //获取响应对象的输出流
        OutputStream outputStream = resp.getOutputStream();
        int len = 0;
        //定义数组大小（每次从字节输入流）
        byte[] bytes = new byte[1024];
        //fileInputStream.read(bytes)
        //从此输入流中读取最多bytes.length个字节的数据到字节数组中。
        while ((len = fileInputStream.read(bytes)) > 0) {
            //将指定字节数组中从offset off开始的len个字节写入此输出流。
            outputStream.write(bytes, 0, len);
        }
        fileInputStream.close();

    }
}
