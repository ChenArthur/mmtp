package com.plus.mmtp.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ch
 * @since 2018-09-14
 */
@TableName("t_pro_operation")
public class ProOperation extends Model<ProOperation> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String operId;
    private String operName;
    private String operCode;
    private String operType;
    private String prefixUrl;
    private String parentOperId;
    private String operation;
    private String mark;
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getPrefixUrl() {
        return prefixUrl;
    }

    public void setPrefixUrl(String prefixUrl) {
        this.prefixUrl = prefixUrl;
    }

    public String getParentOperId() {
        return parentOperId;
    }

    public void setParentOperId(String parentOperId) {
        this.parentOperId = parentOperId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ProOperation{" +
        ", id=" + id +
        ", operId=" + operId +
        ", operName=" + operName +
        ", operCode=" + operCode +
        ", operType=" + operType +
        ", prefixUrl=" + prefixUrl +
        ", parentOperId=" + parentOperId +
        ", operation=" + operation +
        ", mark=" + mark +
        ", createTime=" + createTime +
        "}";
    }
}
