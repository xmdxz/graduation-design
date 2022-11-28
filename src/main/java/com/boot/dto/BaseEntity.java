package com.boot.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;


@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2701426566608666463L;

    @TableId(value = "id", type = IdType.ASSIGN_ID) // Mybatis-plus注解，表明此字段表示唯一主键id，插入数据时会自动生成id
    protected String id;

}
