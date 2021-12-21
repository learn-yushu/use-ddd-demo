package com.tojaoomy.payment.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支付订单补单工作流明细
 * </p>
 *
 * @author 松梁
 * @since 2021-12-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_order_complaint_item")
public class OrderComplaintItemDO extends Model<OrderComplaintItemDO> {

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
     * 游戏id
     */
    @TableField("game_id")
    private Long gameId;

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
     * 游戏区服
     */
    @TableField("game_zone")
    private String gameZone;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 用户游戏昵称
     */
    @TableField("user_game_nickname")
    private String userGameNickname;

    /**
     * 用户联系方式
     */
    @TableField("user_contract")
    private String userContract;

    /**
     * 订单金额
     */
    @TableField("order_amount")
    private BigDecimal orderAmount;

    /**
     * 支付金额
     */
    @TableField("pay_amount")
    private BigDecimal payAmount;

    /**
     * 下单时间
     */
    @TableField("order_time")
    private LocalDateTime orderTime;

    /**
     * 支付订单号
     */
    @TableField("pay_order_id")
    private String payOrderId;

    /**
     * 支付流水号
     */
    @TableField("pay_order_tx_id")
    private String payOrderTxId;

    /**
     * 渠道订单号
     */
    @TableField("channel_order_id")
    private String channelOrderId;

    /**
     * CP订单号
     */
    @TableField("cp_order_id")
    private String cpOrderId;

    /**
     * 操作人
     */
    @TableField("operator")
    private String operator;

    /**
     * 操作时间
     */
    @TableField("operate_time")
    private LocalDateTime operateTime;

    /**
     * 处理状态
     */
    @TableField("deal_status")
    private Integer dealStatus;

    /**
     * 处理结果
     */
    @TableField("deal_result")
    private String dealResult;

    /**
     * 运营意见
     */
    @TableField("operator_comment")
    private String operatorComment;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
