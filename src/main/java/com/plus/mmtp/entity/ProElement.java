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
@TableName("t_pro_element")
public class ProElement extends Model<ProElement> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String elementId;
    private String elementName;
    private String elementType;
    private String elementColor;
    private String elementStyle;
    private String element;
    private String mark;
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getElementColor() {
        return elementColor;
    }

    public void setElementColor(String elementColor) {
        this.elementColor = elementColor;
    }

    public String getElementStyle() {
        return elementStyle;
    }

    public void setElementStyle(String elementStyle) {
        this.elementStyle = elementStyle;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
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
        return "ProElement{" +
        ", id=" + id +
        ", elementId=" + elementId +
        ", elementName=" + elementName +
        ", elementType=" + elementType +
        ", elementColor=" + elementColor +
        ", elementStyle=" + elementStyle +
        ", element=" + element +
        ", mark=" + mark +
        ", createTime=" + createTime +
        "}";
    }
}
