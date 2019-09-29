package com.yoyohome.car.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zl.common.util.IPUtils;
import org.zl.common.util.Response;

import com.alibaba.nacos.client.utils.IPUtil;
import com.yoyohome.car.dto.CarDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "汽车服务")
@RefreshScope
@RestController
@RequestMapping("car")
public class CarController {

    @Value("${pay.url}")
    private String payUrl;

    @ApiOperation(value = "打招呼", notes = "测试打招呼")
    @GetMapping("hi")
    public String home(@RequestParam(value = "name", defaultValue = "yoyo") String name) {
        return "hi " + name + " ,the pay url is:" + payUrl;
    }
    
    @ApiOperation(value = "根据id查询")
    @GetMapping("{id}")
    public Response<CarDTO> get(HttpServletRequest request, @PathVariable Long id){
    	
    	try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	CarDTO carDTO = new CarDTO();
    	carDTO.setId(id);
    	carDTO.setCarType(IPUtils.getIpAddr(request) + "大众帕萨特");
    	
    	return Response.success(carDTO);
    }
}
