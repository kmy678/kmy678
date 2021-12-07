package edu.soft2.controller;

import edu.soft2.pojo.User;
import org.apache.poi.util.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
@RequestMapping(value = "user")
public class UserController {
    //删除操作
    @RequestMapping(value = "delete")
    public String delete() {
        System.out.println("--------delete()-------");
        return "hello";
    }
    @RequestMapping(value = "login")
    public String login(User user, HttpSession session, HttpServletRequest request) {
        System.out.println("-------login()-------");
        int flag = 1; //调用业务层,获取返回值
        if (flag == 1) {
            session.setAttribute("user",user);
        }
        return "welcome";
    }

    @RequestMapping(value = "login")
    public String login(User user,HttpSession session){
        System.out.println("-----login-----");
        int flag = 1;
        if (flag == 1){
            session.setAttribute("user",user);
        }
        return "welcome";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        System.out.println("-----logout-----");
        HttpSession session = request.getSession();
        session.invalidate();//session里的数据被清空
        System.out.println("session失效");
        String msg = "你已退出登录！";
        request.setAttribute("msg",msg);
        return "forward:/index.jsp";
    }

    @RequestMapping(value = "hello")
    public String hello(){
        System.out.println("----hello()----");
        return "hello";
    }

    @RequestMapping(value = "upload",method = {RequestMethod.POST})
    public String upload(MultipartFile image,HttpServletRequest request) throws IOException {
        System.out.println("-----upload()-----");
        InputStream is = image.getInputStream();
        //获取文件名称
        String filename = image.getOriginalFilename();
        //设置上传路径
        String realPath = request.getServletContext().getRealPath("/images");
        System.out.println("上传路径="+realPath);
        String newname = doFilename(filename);
        OutputStream os = new FileOutputStream(new File(realPath,newname));
        int size = IOUtils.copy(is,os);
        System.out.println("上传"+filename+"到（"+realPath+"完毕，共计"+size+"字节，上传后文件名为'"+newname+"'。");
        os.close();is.close();
        return "";
    }

    private String doFilename(String filename){
        return "";
    }
    @RequestMapping(value = "upload2",method = {RequestMethod.POST})
    public String upload2(MultipartFile[] image,HttpServletRequest request) throws IOException {
        System.out.println("-----upload()-----");
        for (MultipartFile imageFile : image) {
            InputStream is = imageFile.getInputStream();
            //获取文件名称
            String filename = imageFile.get();
            //设置上传路径
            String realPath = request.getServletContext().getRealPath("/images");
            System.out.println("上传路径=" + realPath);
            String newname = doFilename(filename);
            OutputStream os = new FileOutputStream(new File(realPath, newname));
            int size = IOUtils.copy(is, os);
            System.out.println("上传" + filename + "到（" + realPath + "完毕，共计" + size + "字节，上传后文件名为'" + newname + "'。");
            os.close();
            is.close();
        }
        return "";
    }
}
