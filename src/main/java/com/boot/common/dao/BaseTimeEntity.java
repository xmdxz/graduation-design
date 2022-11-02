package com.boot.common.dao;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;


/**
 * @author YuanXin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseTimeEntity extends BaseEntity {

    private static final long serialVersionUID = 4433726174799180407L;

    @TableField(fill = FieldFill.INSERT)
    protected Timestamp createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Timestamp updateTime;

}
