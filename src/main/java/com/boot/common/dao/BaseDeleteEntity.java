package com.boot.common.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author YuanXin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseDeleteEntity extends BaseEntity {

    private static final long serialVersionUID = 3651900407347978455L;

    @TableLogic
    @TableField(select = false)
    protected Integer isDeleted;

}
