package com.yoyohome.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zl.common.util.Response;

import com.yoyohome.car.api.CarApiService;
import com.yoyohome.car.dto.CarDTO;
import com.yoyohome.user.dto.UserDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author nolimits
 * @since 2019-08-27
 */
@Api(tags = "会员服务")
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private CarApiService carApiService;
	
	@ApiOperation(value = "根据id查询用户")
	@GetMapping("{id}")
	public Response<UserDTO> get(@PathVariable Long id) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setUserName("测试用户");
		
		CarDTO car = carApiService.getById(id);
		userDTO.setCarType(car.getCarType());
		return Response.success(userDTO);
	}
}
