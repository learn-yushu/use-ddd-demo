package com.tojaoomy.payment.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 支付订单补单工作流映射表
 * </p>
 *
 * @author 松梁
 * @since 2021-12-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_order_complaint_flow_mapping")
public class OrderComplaintFlowMappingDO implements Serializable {

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
    @TableField(value = "mtime", fill = FieldFill.UPDATE)
    private LocalDateTime mtime;

    /**
     * 是否删除
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /**
     * 工作流id
     */
    @TableField("flow_id")
    private Long flowId;

    /**
     * 工作流明细id
     */
    @TableField("flow_detail_id")
    private Long flowDetailId;

    /**
     * 是否开启工作流
     */
    @TableField("is_active_flow")
    private Integer isActiveFlow;

    /**
     * 工作流状态;init-初始化,processing-处理中, approved-已审批
     */
    @TableField("flow_status")
    private String flowStatus;


}
