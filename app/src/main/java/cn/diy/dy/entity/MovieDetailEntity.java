package cn.diy.dy.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by orange on 2016/6/25.
 */
public class MovieDetailEntity {


    private String id;
    private String title;
    private String type;
    private String style;
    private String area;
    private String year;
    private String directors;
    private String actors;
    private String desc;
    private String total;
    private String has;
    private String sites;
    private String cover_v;
    private String cover_h;
    private String score;
    private int clicks;
    private String finish;
    @SerializedName("3d")
    private String value3d;
    private String status;

    private String total_score;
    private String update_time;
    private String merge_id;
    private int mid;
    private int is_pay;
    private String duration;
    private String video_count;
    private RelevantBean relevant;
    private String cover_url;
    private String cover_sqr;
    private String cover_h_url;
    private String poster_url;
    private String update_at;
    private String type_name;
    private String max_site;
    private String last_seq;
    private int ending;
    private String update_tip;
    private SeriesBean series;

    private String danmaku;
    private PayInfoBean pay_info;
    private List<String> style_name;
    private List<String> area_name;
    private List<String> actors_name;
    private List<String> directors_name;
    private List<SitesModeBean> sites_mode;
    private List<?> unsavable_seqs;
    private List<?> trailers;
    private List<?> new_seqs;
    private List<?> stars;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getHas() {
        return has;
    }

    public void setHas(String has) {
        this.has = has;
    }

    public String getSites() {
        return sites;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }

    public String getCover_v() {
        return cover_v;
    }

    public void setCover_v(String cover_v) {
        this.cover_v = cover_v;
    }

    public String getCover_h() {
        return cover_h;
    }

    public void setCover_h(String cover_h) {
        this.cover_h = cover_h;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getValue3d() {
        return value3d;
    }

    public void setValue3d(String value3d) {
        this.value3d = value3d;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal_score() {
        return total_score;
    }

    public void setTotal_score(String total_score) {
        this.total_score = total_score;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getMerge_id() {
        return merge_id;
    }

    public void setMerge_id(String merge_id) {
        this.merge_id = merge_id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getIs_pay() {
        return is_pay;
    }

    public void setIs_pay(int is_pay) {
        this.is_pay = is_pay;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getVideo_count() {
        return video_count;
    }

    public void setVideo_count(String video_count) {
        this.video_count = video_count;
    }

    public RelevantBean getRelevant() {
        return relevant;
    }

    public void setRelevant(RelevantBean relevant) {
        this.relevant = relevant;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getCover_sqr() {
        return cover_sqr;
    }

    public void setCover_sqr(String cover_sqr) {
        this.cover_sqr = cover_sqr;
    }

    public String getCover_h_url() {
        return cover_h_url;
    }

    public void setCover_h_url(String cover_h_url) {
        this.cover_h_url = cover_h_url;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getMax_site() {
        return max_site;
    }

    public void setMax_site(String max_site) {
        this.max_site = max_site;
    }

    public String getLast_seq() {
        return last_seq;
    }

    public void setLast_seq(String last_seq) {
        this.last_seq = last_seq;
    }

    public int getEnding() {
        return ending;
    }

    public void setEnding(int ending) {
        this.ending = ending;
    }

    public String getUpdate_tip() {
        return update_tip;
    }

    public void setUpdate_tip(String update_tip) {
        this.update_tip = update_tip;
    }

    public SeriesBean getSeries() {
        return series;
    }

    public void setSeries(SeriesBean series) {
        this.series = series;
    }

    public String getDanmaku() {
        return danmaku;
    }

    public void setDanmaku(String danmaku) {
        this.danmaku = danmaku;
    }

    public PayInfoBean getPay_info() {
        return pay_info;
    }

    public void setPay_info(PayInfoBean pay_info) {
        this.pay_info = pay_info;
    }

    public List<String> getStyle_name() {
        return style_name;
    }

    public void setStyle_name(List<String> style_name) {
        this.style_name = style_name;
    }

    public List<String> getArea_name() {
        return area_name;
    }

    public void setArea_name(List<String> area_name) {
        this.area_name = area_name;
    }

    public List<String> getActors_name() {
        return actors_name;
    }

    public void setActors_name(List<String> actors_name) {
        this.actors_name = actors_name;
    }

    public List<String> getDirectors_name() {
        return directors_name;
    }

    public void setDirectors_name(List<String> directors_name) {
        this.directors_name = directors_name;
    }

    public List<SitesModeBean> getSites_mode() {
        return sites_mode;
    }

    public void setSites_mode(List<SitesModeBean> sites_mode) {
        this.sites_mode = sites_mode;
    }

    public List<?> getUnsavable_seqs() {
        return unsavable_seqs;
    }

    public void setUnsavable_seqs(List<?> unsavable_seqs) {
        this.unsavable_seqs = unsavable_seqs;
    }

    public List<?> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<?> trailers) {
        this.trailers = trailers;
    }

    public List<?> getNew_seqs() {
        return new_seqs;
    }

    public void setNew_seqs(List<?> new_seqs) {
        this.new_seqs = new_seqs;
    }

    public List<?> getStars() {
        return stars;
    }

    public void setStars(List<?> stars) {
        this.stars = stars;
    }

    public static class RelevantBean {
        private String role;
        private List<Integer> trailers;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public List<Integer> getTrailers() {
            return trailers;
        }

        public void setTrailers(List<Integer> trailers) {
            this.trailers = trailers;
        }
    }

    public static class SeriesBean {
    }

    public static class PayInfoBean {
    }

    public static class SitesModeBean {
        private String site;
        private int switches;
        private int redirect_timeout;
        private String ua;

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public int getSwitches() {
            return switches;
        }

        public void setSwitches(int switches) {
            this.switches = switches;
        }

        public int getRedirect_timeout() {
            return redirect_timeout;
        }

        public void setRedirect_timeout(int redirect_timeout) {
            this.redirect_timeout = redirect_timeout;
        }

        public String getUa() {
            return ua;
        }

        public void setUa(String ua) {
            this.ua = ua;
        }
    }
}
