package com.tojaoomy.payment.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支付订单补单工作流
 * </p>
 *
 * @author 松梁
 * @since 2021-12-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_order_complaint_flow")
public class OrderComplaintFlowDO extends Model<OrderComplaintFlowDO> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "ctime", fill = FieldFill.INSERT)
    private LocalDateTime ctime;

    /**
     * 更新时间
     */
    @TableField(value = "mtime", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime mtime;

    /**
     * 是否删除
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /**
     * 游戏基础id
     */
    @TableField("game_base_id")
    private Long gameBaseId;

    /**
     * 游戏名称
     */
    @TableField("game_name")
    private String gameName;

    /**
     * 发起人
     */
    @TableField("actor")
    private String actor;

    /**
     * 当前处理人
     */
    @TableField("processor")
    private String processor;

    /**
     * 工作流处理id
     */
    @TableField("process_id")
    private String processId;

    /**
     * 处理时间
     */
    @TableField("process_time")
    private LocalDateTime processTime;

    /**
     * 处理状态
     */
    @TableField("flow_status")
    private String flowStatus;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
