package cn.iocoder.springcloudalibaba.labx5.nacosdemo.controller;

import cn.iocoder.springcloudalibaba.labx5.nacosdemo.config.OrderProperties;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private OrderProperties orderProperties;

    // 测试 @ConfigurationProperties 注解的配置属性类
    @GetMapping("/test01")
    public OrderProperties test01() {
        return orderProperties;
    }

    // @NacosValue(value = "${order.pay-timeout-seconds}")
    @Value(value = "${order.pay-timeout-seconds}")
    private Integer payTimeoutSeconds;

    // @NacosValue(value = "${order.create-frequency-seconds}")
    @Value(value = "${order.create-frequency-seconds}")
    private Integer createFrequencySeconds;

    // 测试 @Value 注解的属性
    @GetMapping("/test02")
    public Map<String, Object> test02() {
        return new JSONObject().fluentPut("payTimeoutSeconds", payTimeoutSeconds)
                .fluentPut("createFrequencySeconds", createFrequencySeconds);
    }

}
