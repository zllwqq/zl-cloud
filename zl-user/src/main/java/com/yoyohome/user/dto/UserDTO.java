package com.yoyohome.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author nolimits
 * @since 2019-08-27
 */
@Data
public class UserDTO {
	
	@ApiModelProperty(value = "id")
	private Long id;
	
	@ApiModelProperty(value = "姓名")
	private String userName;
	
	@ApiModelProperty(value = "所买车型")
	private String carType;
}
