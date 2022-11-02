package com.boot.common.dao;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * @author YuanXin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseTimeDeleteEntity extends BaseEntity {

    private static final long serialVersionUID = 5987346338468167719L;

    @TableField(fill = FieldFill.INSERT)
    protected Timestamp createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Timestamp updateTime;

    @TableLogic
    @TableField(select = false)
    protected Integer isDeleted;

}
