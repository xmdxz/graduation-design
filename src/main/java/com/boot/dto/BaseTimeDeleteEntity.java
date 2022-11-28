package com.boot.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseTimeDeleteEntity extends BaseEntity {

    private static final long serialVersionUID = 5987346338468167719L;

    @TableField(fill = FieldFill.INSERT) // Mybatis-plus注解，表明该字段在插入操作时自动参与值的插入
    protected Timestamp createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) // Mybatis-plus注解，表明该字段在更新操作时自动参与值的插入
    protected Timestamp updateTime;

    @TableLogic  // Mybatis-plus注解，注解在这里，表示这个字段是逻辑删除字段，所谓逻辑删除指的是删除数据时，并不会真正的删除数据，而是将字段赋值为1,做查询时自动过滤掉
    @TableField(select = false) // Mybatis-plus注解，表示这个字段在做查询时不参与结果列返回
    protected Integer isDeleted;

}
