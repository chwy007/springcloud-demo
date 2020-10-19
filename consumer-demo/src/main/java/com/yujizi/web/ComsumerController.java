package com.yujizi.web;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yujizi.client.UserClient;
import com.yujizi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * TODO
 * feign中 hytrix 熔断？？？
 * @ClassName ComsumerController
 * @author ychw
 * @date 2020/10/17 23:30
 */

@RestController
@RequestMapping("user")
//@DefaultProperties(defaultFallback = "queryByIdFallback")
public class ComsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate template;

    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
//    @HystrixCommand(commandProperties = {
//                /*短路多久以后开始尝试恢复*/
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10")
//    })
    public User queryById(@PathVariable("id") Long id){
        List<ServiceInstance> instances =discoveryClient.getInstances("user-service");
        ServiceInstance instance = instances.get(0);
        System.out.println("实例ip:port=="+instance.getHost()+instance.getPort());



//        String url="http://user-service/user/"+id;
//        return template.getForObject(url,String.class);

        return userClient.queryById(id);
    }

//    public String queryByIdFallback(){
//        return "对不起，现在服务正忙";
//    }

}
