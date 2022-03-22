package com.partick.database.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 粉丝表，用户与粉丝的关联关系，粉丝本质也是用户。
关联关系保存到es中，粉丝数方式和用户点赞收藏文章一样。累加累减都用redis来做。
字段与用户表有些冗余，主要用于数据可视化，数据一旦有了之后，用户修改性别和省份无法影响此表，只认第一次的数据。


 * @TableName fans
 */
@TableName(value ="fans")
public class Fans implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 作家用户id
     */
    private String writerId;

    /**
     * 粉丝用户id
     */
    private String fanId;

    /**
     * 粉丝头像
     */
    private String face;

    /**
     * 粉丝昵称
     */
    private String fanNickname;

    /**
     * 粉丝性别
     */
    private Integer sex;

    /**
     * 省份
     */
    private String province;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 作家用户id
     */
    public String getWriterId() {
        return writerId;
    }

    /**
     * 作家用户id
     */
    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    /**
     * 粉丝用户id
     */
    public String getFanId() {
        return fanId;
    }

    /**
     * 粉丝用户id
     */
    public void setFanId(String fanId) {
        this.fanId = fanId;
    }

    /**
     * 粉丝头像
     */
    public String getFace() {
        return face;
    }

    /**
     * 粉丝头像
     */
    public void setFace(String face) {
        this.face = face;
    }

    /**
     * 粉丝昵称
     */
    public String getFanNickname() {
        return fanNickname;
    }

    /**
     * 粉丝昵称
     */
    public void setFanNickname(String fanNickname) {
        this.fanNickname = fanNickname;
    }

    /**
     * 粉丝性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 粉丝性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省份
     */
    public void setProvince(String province) {
        this.province = province;
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
        Fans other = (Fans) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWriterId() == null ? other.getWriterId() == null : this.getWriterId().equals(other.getWriterId()))
            && (this.getFanId() == null ? other.getFanId() == null : this.getFanId().equals(other.getFanId()))
            && (this.getFace() == null ? other.getFace() == null : this.getFace().equals(other.getFace()))
            && (this.getFanNickname() == null ? other.getFanNickname() == null : this.getFanNickname().equals(other.getFanNickname()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWriterId() == null) ? 0 : getWriterId().hashCode());
        result = prime * result + ((getFanId() == null) ? 0 : getFanId().hashCode());
        result = prime * result + ((getFace() == null) ? 0 : getFace().hashCode());
        result = prime * result + ((getFanNickname() == null) ? 0 : getFanNickname().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", writerId=").append(writerId);
        sb.append(", fanId=").append(fanId);
        sb.append(", face=").append(face);
        sb.append(", fanNickname=").append(fanNickname);
        sb.append(", sex=").append(sex);
        sb.append(", province=").append(province);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}