package com.meiyukai.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    /**
     * mvc 实现文件上传的方式
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/commonUpload")
    public String uploadFile( MultipartFile upload) throws Exception {
        String path = "/Users/meiyukai/Documents/test_upload/";

        if (upload != null) {
            String originalName = upload.getOriginalFilename();
            String suffix = originalName.substring(originalName.lastIndexOf("."));
            String newName = UUID.randomUUID().toString().replace("-", "");
            File dirFile = new File(path + "uploadDir/");
            if (!dirFile.exists()) {
                dirFile.mkdir();
                System.out.println("文件夹已经创建 ！");
            }
            File file = new File(dirFile, newName + suffix);
            upload.transferTo(file);
            return "success";
        } else {
            System.out.println("未获取到文件upload ... ...  ");
            return "error";
        }

    }

    /**
     * 跨服务器实现文件上传
     */

    @RequestMapping(value = "betweenServers.do")
    public String beweenServersUpload(MultipartFile upload) throws Exception{
        String path = "http://127.0.0.1:9090/uploads/";
        if(upload != null){
            String originalName = upload.getOriginalFilename();
            String suffix = originalName.substring(originalName.lastIndexOf("."));
            String newName = UUID.randomUUID().toString().replace("-","");
            File uploadDir = new File(path+"uploadFile/");

            File file  =  new File(uploadDir+newName+suffix);

            //1. 创建 client 客户端对象
            Client client = Client.create();
            //2.建立连接
            WebResource webResources = client.resource(path + newName + suffix);
            //3.上传文件
            webResources.put(upload.getBytes());
            return "success";
        }else{
            System.out.println("未获取到upload 文件！");
            return "error";
        }
    }



    /* //传统方式实现文件上传
    @RequestMapping(value="testUpload1")
    public String test(HttpServletRequest request) throws Exception {
        //使用fileupload 组件完成文件的上传
        //上传位置
        String path = request.getServletContext().getRealPath("/uploads/");
        File file  = new File(path);
        if(!file.exists()){
            //创建该文件夹
            file.mkdirs();
            System.out.println("文件夹已创建 "+path);
        }else{
            System.out.println("文件夹已存在 ： "+path);
            //解析request 对象 获取上传的文件项
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解析request
            List<FileItem> items = upload.parseRequest(request);
            //遍历
            for(FileItem item: items){
                //判断item是不是上传文件项
                System.out.println("是表单");
                if(item.isFormField()){
                    //是普通的表单向
                }else{
                    System.out.println("是普通文件 ... ");
                    //是上传文件项
                    //获取上传文件的名称
                    String fileName= item.getName();
                    String uuid = UUID.randomUUID().toString().replace("-","");
                    fileName = uuid+fileName +"_";
                    System.out.println("fileName  :  " + fileName);
                    //完成文件上传
                    item.write(new File(path,fileName));
                    //删除临时文件
                    item.delete();
                }
            }
        }

        return "success";
    }*/






}
