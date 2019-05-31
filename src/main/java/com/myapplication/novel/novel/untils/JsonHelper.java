package com.myapplication.novel.novel.untils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.myapplication.novel.novel.basebean.BaseResult;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JsonHelper {
    public static void toJson(BaseResult result, HttpServletResponse response) throws Exception{
        response.setContentType("text/json");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String json = JSONObject.toJSONString(result,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.DisableCircularReferenceDetect);
        writer.write(json);
        writer.close();
    }
}
