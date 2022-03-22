package com.partick.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章评论表
 * @TableName comments
 */
@TableName(value ="comments")
public class Comments implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 评论的文章是哪个作者的关联id
     */
    private String writerId;

    /**
     * 如果是回复留言，则本条为子留言，需要关联查询
     */
    private String fatherId;

    /**
     * 回复的那个文章id
     */
    private String articleId;

    /**
     * 冗余文章标题，宽表处理，非规范化的sql思维，对于几百万文章和几百万评论的关联查询来讲，性能肯定不行，所以做宽表处理，从业务角度来说，文章发布以后不能随便修改标题和封面的
     */
    private String articleTitle;

    /**
     * 文章封面
     */
    private String articleCover;

    /**
     * 发布留言的用户id
     */
    private String commentUserId;

    /**
     * 冗余用户昵称，非一致性字段，用户修改昵称后可以不用同步
     */
    private String commentUserNickname;

    /**
     * 冗余的用户头像
     */
    private String commentUserFace;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 留言时间
     */
    private Date createTime;

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
     * 评论的文章是哪个作者的关联id
     */
    public String getWriterId() {
        return writerId;
    }

    /**
     * 评论的文章是哪个作者的关联id
     */
    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    /**
     * 如果是回复留言，则本条为子留言，需要关联查询
     */
    public String getFatherId() {
        return fatherId;
    }

    /**
     * 如果是回复留言，则本条为子留言，需要关联查询
     */
    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * 回复的那个文章id
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * 回复的那个文章id
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    /**
     * 冗余文章标题，宽表处理，非规范化的sql思维，对于几百万文章和几百万评论的关联查询来讲，性能肯定不行，所以做宽表处理，从业务角度来说，文章发布以后不能随便修改标题和封面的
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * 冗余文章标题，宽表处理，非规范化的sql思维，对于几百万文章和几百万评论的关联查询来讲，性能肯定不行，所以做宽表处理，从业务角度来说，文章发布以后不能随便修改标题和封面的
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * 文章封面
     */
    public String getArticleCover() {
        return articleCover;
    }

    /**
     * 文章封面
     */
    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    /**
     * 发布留言的用户id
     */
    public String getCommentUserId() {
        return commentUserId;
    }

    /**
     * 发布留言的用户id
     */
    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    /**
     * 冗余用户昵称，非一致性字段，用户修改昵称后可以不用同步
     */
    public String getCommentUserNickname() {
        return commentUserNickname;
    }

    /**
     * 冗余用户昵称，非一致性字段，用户修改昵称后可以不用同步
     */
    public void setCommentUserNickname(String commentUserNickname) {
        this.commentUserNickname = commentUserNickname;
    }

    /**
     * 冗余的用户头像
     */
    public String getCommentUserFace() {
        return commentUserFace;
    }

    /**
     * 冗余的用户头像
     */
    public void setCommentUserFace(String commentUserFace) {
        this.commentUserFace = commentUserFace;
    }

    /**
     * 留言内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 留言内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 留言时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 留言时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        Comments other = (Comments) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWriterId() == null ? other.getWriterId() == null : this.getWriterId().equals(other.getWriterId()))
            && (this.getFatherId() == null ? other.getFatherId() == null : this.getFatherId().equals(other.getFatherId()))
            && (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getArticleTitle() == null ? other.getArticleTitle() == null : this.getArticleTitle().equals(other.getArticleTitle()))
            && (this.getArticleCover() == null ? other.getArticleCover() == null : this.getArticleCover().equals(other.getArticleCover()))
            && (this.getCommentUserId() == null ? other.getCommentUserId() == null : this.getCommentUserId().equals(other.getCommentUserId()))
            && (this.getCommentUserNickname() == null ? other.getCommentUserNickname() == null : this.getCommentUserNickname().equals(other.getCommentUserNickname()))
            && (this.getCommentUserFace() == null ? other.getCommentUserFace() == null : this.getCommentUserFace().equals(other.getCommentUserFace()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWriterId() == null) ? 0 : getWriterId().hashCode());
        result = prime * result + ((getFatherId() == null) ? 0 : getFatherId().hashCode());
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getArticleTitle() == null) ? 0 : getArticleTitle().hashCode());
        result = prime * result + ((getArticleCover() == null) ? 0 : getArticleCover().hashCode());
        result = prime * result + ((getCommentUserId() == null) ? 0 : getCommentUserId().hashCode());
        result = prime * result + ((getCommentUserNickname() == null) ? 0 : getCommentUserNickname().hashCode());
        result = prime * result + ((getCommentUserFace() == null) ? 0 : getCommentUserFace().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", fatherId=").append(fatherId);
        sb.append(", articleId=").append(articleId);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", articleCover=").append(articleCover);
        sb.append(", commentUserId=").append(commentUserId);
        sb.append(", commentUserNickname=").append(commentUserNickname);
        sb.append(", commentUserFace=").append(commentUserFace);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}