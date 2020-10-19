package com.yujizi.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ProjectName: springcloud-demo
 * @Package: com.yujizi.config
 * @ClassName: FeignConfig
 * @Author: ychw
 * @Description:
 * @Date: 2020/10/16 21:42
 * @Version: 1.0
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
