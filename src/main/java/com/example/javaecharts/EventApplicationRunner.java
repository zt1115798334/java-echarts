package com.example.javaecharts;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.javaecharts.utils.PhantomJS;
import com.example.javaecharts.utils.PhantomJSUtil;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class EventApplicationRunner implements ApplicationRunner {

    private final FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    public EventApplicationRunner(FreeMarkerConfigurer freeMarkerConfigurer) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //启动后执行
        System.out.println("MyApplicationRunner class will be execute when the project was started!");
// 变量
        String title = "水果";
        String[] categories = new String[]{"苹果", "香蕉", "西瓜"};
        int[] values = new int[]{3, 2, 1};

        // 模板参数
        HashMap<String, Object> datas = new HashMap<>();
        datas.put("categories", JSON.toJSONString(categories));
        datas.put("values", JSON.toJSONString(values));
        datas.put("title", title);

        // 生成option字符串
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("option2.ftl");
        StringWriter stringWriter = new StringWriter();
        template.process(datas, stringWriter);
        String s = stringWriter.toString();
        Map<String, Object> opt = (Map<String, Object>) JSONObject.parse(s);
        System.out.println("opt = " + opt);
        long nowStr = Calendar.getInstance().getTimeInMillis();
        String imgUrlPath = "E:/echarts/";
        // 根据option参数
//        String base64 = EchartsUtil.generateEchartsBase64(s);
        String imageName = "pie" + nowStr + ".png";
        PhantomJS js = new PhantomJS();
        js.setOpt(opt);
        js.setReqMethod("echarts");
        js.setFile(imgUrlPath + imageName);
        String base64 = PhantomJSUtil.phantomJS("http://localhost:6666", JSON.parseObject(JSON.toJSONString(js)));


        System.out.println("BASE64:" + base64);
    }

}
