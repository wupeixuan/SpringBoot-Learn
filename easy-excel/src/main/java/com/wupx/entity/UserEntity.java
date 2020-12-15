package com.wupx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 *
 * @author wupx
 * @since 2020-12-15
 */
@Data
@TableName("user")
public class UserEntity extends Model<UserEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
