package com.myapplication.novel.novel.untils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class AliYunOssUtil {
    private static OSSClient ossClient;
    private static StringBuffer buffer =new StringBuffer();
    /** 上传文件到阿里云,并生成url
     * @param filedir (key)文件名(不包括后缀)
     * @param in 	文件字节流
     * @param suffix 文件后缀名
     * @return String 生成的文件url
     */
    public static String UploadToAliyun(String filedir, InputStream in, String suffix) {
        System.out.println("------------>文件名称为:  " + filedir + "." + suffix);
        ossClient  = new OSSClient(OSSClientConstants.ENDPOINT,OSSClientConstants.ACCESS_KEY_ID, OSSClientConstants.ACCESS_KEY_SECRET);
        URL url = null;
        try {
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(in.available());
            objectMetadata.setCacheControl("no-cache");//设置Cache-Control请求头，表示用户指定的HTTP请求/回复链的缓存行为:不经过本地缓存
            objectMetadata.setHeader("Pragma", "no-cache");//设置页面不缓存
            objectMetadata.setContentType(getcontentType(suffix));
            objectMetadata.setContentDisposition("inline;filename=" + filedir + "." + suffix);
            // 上传文件
            ossClient.putObject(OSSClientConstants.BACKET_NAME, filedir, in, objectMetadata);

            Date expiration = null;//过期时间
//            String[] split = filedir.split("/");
//            if(split[0].equals("circle")){// 朋友圈图片,设置URL过期时间为3个月
//                expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 90);
//            }else{// 头像,设置URL过期时间为10年
            expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
//            }
            // 生成URL
            url = ossClient.generatePresignedUrl(OSSClientConstants.BACKET_NAME, filedir, expiration);
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return url.toString();
    }

    /**删除图片
     * @param key
     */
    public static void deletePicture(String key){
        ossClient  = new OSSClient(OSSClientConstants.ENDPOINT,OSSClientConstants.ACCESS_KEY_ID, OSSClientConstants.ACCESS_KEY_SECRET);
        ossClient.deleteObject(OSSClientConstants.BACKET_NAME, key);
        System.out.println("aliyundelete-------"+key);
        ossClient.shutdown();
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     * @param suffix 文件后缀
     * @return String HTTP Content-type
     */
    public static String getcontentType(String suffix) {
        System.out.println("------------>文件格式为:  " + suffix);
        if (suffix.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        } else if (suffix.equalsIgnoreCase("gif")) {
            return "image/gif";
        } else if (suffix.equalsIgnoreCase("jpeg") || suffix.equalsIgnoreCase("jpg")) {
            return "image/jpeg";
        } else if (suffix.equalsIgnoreCase("png")) {
            return "image/png";
        } else if (suffix.equalsIgnoreCase("html")) {
            return "text/html";
        } else if (suffix.equalsIgnoreCase("txt")) {
            return "text/plain";
        } else if (suffix.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        } else if (suffix.equalsIgnoreCase("pptx") || suffix.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        } else if (suffix.equalsIgnoreCase("docx") || suffix.equalsIgnoreCase("doc")) {
            return "application/msword";
        } else if (suffix.equalsIgnoreCase("xml")) {
            return "text/xml";
        } else if (suffix.equalsIgnoreCase("mp3")) {
            return "audio/mp3";
        } else if (suffix.equalsIgnoreCase("amr")) {
            return "audio/amr";
        } else {
            return "text/plain";
        }
    }
    public  static  String getimgurl(String key){

        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);

        ossClient  = new OSSClient(OSSClientConstants.ENDPOINT,OSSClientConstants.ACCESS_KEY_ID, OSSClientConstants.ACCESS_KEY_SECRET);
        URL imgurl = ossClient.generatePresignedUrl(OSSClientConstants.BACKET_NAME, key,expiration);
        return imgurl.toString();
    }

    //测试
//    public static void main(String[] args) {
//        //上传文件
//        String filePath="E:\\springBootImage\\aa.png";
//        long timeInMillis = Calendar.getInstance().getTimeInMillis();
//        File file = new File(filePath);
//        try {
//            String s = UploadToAliyun(timeInMillis + file.getName(), new FileInputStream(file), "png");
//            System.out.println(s);//图片路径
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }



}
