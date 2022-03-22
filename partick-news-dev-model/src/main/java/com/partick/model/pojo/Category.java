package com.partick.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 新闻资讯文章的分类（或者称之为领域）
 * @TableName category
 */
@TableName(value ="category")
public class Category implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名，比如：科技，人文，历史，汽车等等
     */
    private String name;

    /**
     * 标签颜色
     */
    private String tagColor;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 分类名，比如：科技，人文，历史，汽车等等
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名，比如：科技，人文，历史，汽车等等
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 标签颜色
     */
    public String getTagColor() {
        return tagColor;
    }

    /**
     * 标签颜色
     */
    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Category other = (Category) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTagColor() == null ? other.getTagColor() == null : this.getTagColor().equals(other.getTagColor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTagColor() == null) ? 0 : getTagColor().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", tagColor=").append(tagColor);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}