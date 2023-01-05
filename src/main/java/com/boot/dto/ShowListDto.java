package com.boot.dto;

import com.boot.common.request.page.PageQuery;
import lombok.Data;

/**
 * @class: ShowListDto
 * @author: liyusheng
 * @description:
 * @date: 2023/1/4 09:27
 */
@Data
public class ShowListDto extends PageQuery {
    private String showName;
    private String type;
    private String city;
}
