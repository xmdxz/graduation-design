package com.boot.dto;

import com.boot.common.request.page.PageQuery;
import lombok.Data;

/**
 * @class: CityDto
 * @author: liyusheng
 * @description:
 * @date: 2022/12/28 16:27
 */
@Data
public class CityDto extends PageQuery {
   
    private String cityName;
}
