package com.yoyohome.car.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author nolimits
 * @since 2019-08-26
 */
@Data
public class CarDTO {
	@ApiModelProperty(value = "车辆id")
	private Long id;
	
	@ApiModelProperty(value = "车型")
	private String carType;
}
