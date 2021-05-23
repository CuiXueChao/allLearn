package cxc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 上传和下载
 *
 * @author cxc
 * @date 2021/5/22
 */

@Controller
public class SevenMvc {
    /* 文件的下载和上传 - 虚拟目录的映射
     *  原生的servletAPI实现下载
     *  使用responseEntity<byte[]>来实现文件的下载（不建议使用）
     *
     *  文件上传（需进行额外的配置）
     *  多文件上传
     *  多线程的文件上传
     * */


    /**
     * 原生的servletAPI实现下载
     *
     * @param request  请求对象
     * @param response 响应对象
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/23
     */
    @RequestMapping(value = "/SevenOne")
    public String sevenOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = request.getServletContext().getRealPath("resource/img/好看的妞.jpg");
        File file = new File(path);
        String fileName = file.getName();
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        FileInputStream fileInputStream = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, len);
        }
        return null;
    }

    /**
     * 使用ResponseEntity对象来进行文件的下载
     *
     * @param fileName 文件名
     * @param request  请求对象
     * @return org.springframework.http.ResponseEntity<byte [ ]>
     * @author cxc
     * @date 2021/5/23
     */
    @RequestMapping(value = "/SevenTwo")
    public ResponseEntity<byte[]> sevenTwo(String fileName, HttpServletRequest request) throws Exception {
        String path = "C:\\Users\\ASUS\\Pictures\\好看的图片\\" + fileName;
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("content-disposition", "attachment;filename=" + fileName);
        return new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.OK);
    }

    /**
     * 单文件上传（文件上传使用Jakarta Commons FileUpload依赖）
     *
     * @param multipartFile 文件类型 - 该对象需在配置文件中进行配置
     *                      （CommonsMultipartResovler）
     * @param model         响应数据传输
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/23
     */
    @PostMapping("/SevenThree")
    public String sevenThree(MultipartFile multipartFile, Model model) throws IOException {
        File file = new File("C:\\Users\\ASUS\\Pictures\\" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        model.addAttribute("file", file.getName());
        return "viewController";
    }


    /**
     * 多文件传输
     *
     * @param multipartFile 文件接收类型
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/23
     */
    @PostMapping("/SevenFour")
    public String sevenFour(MultipartFile[] multipartFile) throws IOException {
        //多文件的上传
        for (MultipartFile file : multipartFile) {
            File upFile = new File("C:\\Users\\ASUS\\Pictures\\" + file.getOriginalFilename());
            file.transferTo(upFile);
        }
        return "viewController";
    }


    /**
     * 多文件多线程上传
     *
     * @param multipartFile 文件接收对象
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/23
     */
    @PostMapping("/SevenFive")
    public String sevenFive(MultipartFile[] multipartFile) throws Exception {
        //多文件多线程上传
        for (MultipartFile file : multipartFile) {
            Thread thread = new Thread(() -> {
                File upFile = new File("C:\\Users\\ASUS\\Pictures\\" + file.getOriginalFilename());
                try {
                    file.transferTo(upFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread.join();
        }
        return "viewController";
    }

}
