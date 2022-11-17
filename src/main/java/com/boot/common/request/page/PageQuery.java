package com.boot.common.request.page;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@ApiModel("分页请求")
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery {

    private static enum OrderBy {
        /**
         * 升序
         */
        ASC,
        /**
         * 降序
         */
        DESC
    }

    private final static String SQL_REGEX = "'|%|--|insert|delete|select|count|group|union|drop|truncate|alter|grant|execute|exec|xp_cmdshell|call|declare|sql";

    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    @ApiModelProperty(value = "每页的数量")
    private Integer size = 10;

    @ApiModelProperty("升序字段，多个则使用逗号分隔，使用数据库字段名")
    private String asc;

    @ApiModelProperty("降序字段，多个则使用逗号分隔，使用数据库字段名")
    private String desc;


    /**
     * 转换成mybatis中的page
     *
     * @param query
     * @param <T>
     * @return
     */
    public static <T> IPage<T> getPage(PageQuery query) {
        Page<T> page = new Page<>(Convert.toInt(query.getCurrent(), 1), Convert.toInt(query.getSize(), 10));
        //升序
        if (CharSequenceUtil.isNotBlank(query.getAsc())) {
            page.addOrder(getOrderBy(query.getAsc(), OrderBy.ASC));
        }
        //降序
        if (CharSequenceUtil.isNotBlank(query.getDesc())) {
            page.addOrder(getOrderBy(query.getDesc(), OrderBy.DESC));
        }
        return page;
    }

    /**
     * 添加升序降序
     *
     * @param order
     * @param orderBy
     * @return
     */
    private static List<OrderItem> getOrderBy(String order, OrderBy orderBy) {
        String[] orderStrings = StrUtil.splitToArray(filter(order), ',');
        return OrderBy.ASC.equals(orderBy) ? OrderItem.ascs(orderStrings) : OrderItem.descs(orderStrings);
    }

    /**
     * 把SQL关键字替换为空字符串
     *
     * @param param 关键字
     * @return string
     */
    public static String filter(String param) {
        if (param == null) {
            return null;
        }
        return param.replaceAll("(?i)" + SQL_REGEX, "");
    }

    /**
     * 转义like语句中的特殊字符
     *
     * @param str like条件
     * @return String 转义后的like条件
     */
    public static String parseLikeStr(String str) {
        if (null == str) {
            return null;
        }
        str = str.trim();
        str = str.replaceAll("%", "\\\\%");
        str = str.replaceAll("_", "\\\\_");
        return str.replace("\\\\", "\\\\\\\\");
    }


}
