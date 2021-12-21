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
 * 支付订单补单附件
 * </p>
 *
 * @author 松梁
 * @since 2021-12-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_order_complaint_attach")
public class OrderComplaintAttachDO extends Model<OrderComplaintAttachDO> {

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
     * 补单id
     */
    @TableField("complaint_item_id")
    private Long complaintItemId;

    /**
     * 附件名称
     */
    @TableField("attach_name")
    private String attachName;

    /**
     * 附件URL
     */
    @TableField("attach_urls")
    private String attachUrls;

    /**
     * cos存储路径
     */
    @TableField("cos_path")
    private String cosPath;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
