package com.partick.database.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章资讯表
 * @TableName article
 */
@TableName(value ="article")
public class Article implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容，长度不超过9999，需要在前后端判断
     */
    private String content;

    /**
     * 文章所属分类id
     */
    private Integer categoryId;

    /**
     * 文章类型，1：图文（1张封面），2：纯文字
     */
    private Integer articleType;

    /**
     * 文章封面图，article_type=1 的时候展示
     */
    private String articleCover;

    /**
     * 是否是预约定时发布的文章，1：预约（定时）发布，0：即时发布    在预约时间到点的时候，把1改为0，则发布
     */
    private Integer isAppoint;

    /**
     * 文章状态，1：审核中（用户已提交），2：机审结束，等待人工审核，3：审核通过（已发布），4：审核未通过；5：文章撤回（已发布的情况下才能撤回和删除）
     */
    private Integer articleStatus;

    /**
     * 发布者用户id
     */
    private String publishUserId;

    /**
     * 文章发布时间（也是预约发布的时间）
     */
    private Date publishTime;

    /**
     * 用户累计点击阅读数（喜欢数）（点赞） - 放redis
     */
    private Integer readCounts;

    /**
     * 文章评论总数。评论防刷，距离上次评论需要间隔时间控制几秒
     */
    private Integer commentCounts;

    /**
     * 
     */
    private String mongoFileId;

    /**
     * 逻辑删除状态，非物理删除，1：删除，0：未删除
     */
    private Integer isDelete;

    /**
     * 文章的创建时间
     */
    private Date createTime;

    /**
     * 文章的修改时间
     */
    private Date updateTime;

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
     * 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 文章内容，长度不超过9999，需要在前后端判断
     */
    public String getContent() {
        return content;
    }

    /**
     * 文章内容，长度不超过9999，需要在前后端判断
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 文章所属分类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 文章所属分类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 文章类型，1：图文（1张封面），2：纯文字
     */
    public Integer getArticleType() {
        return articleType;
    }

    /**
     * 文章类型，1：图文（1张封面），2：纯文字
     */
    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    /**
     * 文章封面图，article_type=1 的时候展示
     */
    public String getArticleCover() {
        return articleCover;
    }

    /**
     * 文章封面图，article_type=1 的时候展示
     */
    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    /**
     * 是否是预约定时发布的文章，1：预约（定时）发布，0：即时发布    在预约时间到点的时候，把1改为0，则发布
     */
    public Integer getIsAppoint() {
        return isAppoint;
    }

    /**
     * 是否是预约定时发布的文章，1：预约（定时）发布，0：即时发布    在预约时间到点的时候，把1改为0，则发布
     */
    public void setIsAppoint(Integer isAppoint) {
        this.isAppoint = isAppoint;
    }

    /**
     * 文章状态，1：审核中（用户已提交），2：机审结束，等待人工审核，3：审核通过（已发布），4：审核未通过；5：文章撤回（已发布的情况下才能撤回和删除）
     */
    public Integer getArticleStatus() {
        return articleStatus;
    }

    /**
     * 文章状态，1：审核中（用户已提交），2：机审结束，等待人工审核，3：审核通过（已发布），4：审核未通过；5：文章撤回（已发布的情况下才能撤回和删除）
     */
    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    /**
     * 发布者用户id
     */
    public String getPublishUserId() {
        return publishUserId;
    }

    /**
     * 发布者用户id
     */
    public void setPublishUserId(String publishUserId) {
        this.publishUserId = publishUserId;
    }

    /**
     * 文章发布时间（也是预约发布的时间）
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 文章发布时间（也是预约发布的时间）
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 用户累计点击阅读数（喜欢数）（点赞） - 放redis
     */
    public Integer getReadCounts() {
        return readCounts;
    }

    /**
     * 用户累计点击阅读数（喜欢数）（点赞） - 放redis
     */
    public void setReadCounts(Integer readCounts) {
        this.readCounts = readCounts;
    }

    /**
     * 文章评论总数。评论防刷，距离上次评论需要间隔时间控制几秒
     */
    public Integer getCommentCounts() {
        return commentCounts;
    }

    /**
     * 文章评论总数。评论防刷，距离上次评论需要间隔时间控制几秒
     */
    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }

    /**
     * 
     */
    public String getMongoFileId() {
        return mongoFileId;
    }

    /**
     * 
     */
    public void setMongoFileId(String mongoFileId) {
        this.mongoFileId = mongoFileId;
    }

    /**
     * 逻辑删除状态，非物理删除，1：删除，0：未删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 逻辑删除状态，非物理删除，1：删除，0：未删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 文章的创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 文章的创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 文章的修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 文章的修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getArticleType() == null ? other.getArticleType() == null : this.getArticleType().equals(other.getArticleType()))
            && (this.getArticleCover() == null ? other.getArticleCover() == null : this.getArticleCover().equals(other.getArticleCover()))
            && (this.getIsAppoint() == null ? other.getIsAppoint() == null : this.getIsAppoint().equals(other.getIsAppoint()))
            && (this.getArticleStatus() == null ? other.getArticleStatus() == null : this.getArticleStatus().equals(other.getArticleStatus()))
            && (this.getPublishUserId() == null ? other.getPublishUserId() == null : this.getPublishUserId().equals(other.getPublishUserId()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getReadCounts() == null ? other.getReadCounts() == null : this.getReadCounts().equals(other.getReadCounts()))
            && (this.getCommentCounts() == null ? other.getCommentCounts() == null : this.getCommentCounts().equals(other.getCommentCounts()))
            && (this.getMongoFileId() == null ? other.getMongoFileId() == null : this.getMongoFileId().equals(other.getMongoFileId()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getArticleType() == null) ? 0 : getArticleType().hashCode());
        result = prime * result + ((getArticleCover() == null) ? 0 : getArticleCover().hashCode());
        result = prime * result + ((getIsAppoint() == null) ? 0 : getIsAppoint().hashCode());
        result = prime * result + ((getArticleStatus() == null) ? 0 : getArticleStatus().hashCode());
        result = prime * result + ((getPublishUserId() == null) ? 0 : getPublishUserId().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getReadCounts() == null) ? 0 : getReadCounts().hashCode());
        result = prime * result + ((getCommentCounts() == null) ? 0 : getCommentCounts().hashCode());
        result = prime * result + ((getMongoFileId() == null) ? 0 : getMongoFileId().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", articleType=").append(articleType);
        sb.append(", articleCover=").append(articleCover);
        sb.append(", isAppoint=").append(isAppoint);
        sb.append(", articleStatus=").append(articleStatus);
        sb.append(", publishUserId=").append(publishUserId);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", readCounts=").append(readCounts);
        sb.append(", commentCounts=").append(commentCounts);
        sb.append(", mongoFileId=").append(mongoFileId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}