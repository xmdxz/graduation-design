package com.boot.common.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;


/**
 * @author YuanXin
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2701426566608666463L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    protected String id;

}
