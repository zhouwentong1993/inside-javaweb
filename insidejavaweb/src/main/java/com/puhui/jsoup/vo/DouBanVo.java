package main.java.com.puhui.jsoup.vo;

import java.util.Date;

/**
 * Created by wentong on 2016/4/4.
 * 豆瓣电影映射的 VO 类。
 */
public class DouBanVo {
    private Long id;
    private String movieName; // 电影名
    private String description; // 评价
    private String score; //评分
    private Date createTime;

    public DouBanVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "DouBanVo{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", description='" + description + '\'' +
                ", score='" + score + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
