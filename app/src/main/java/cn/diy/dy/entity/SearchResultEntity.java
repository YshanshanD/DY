package cn.diy.dy.entity;

import java.util.List;

/**
 * Created by orange on 2016/6/27.
 */
public class SearchResultEntity {

    private int count;
    private int status;
    private int begin;
    private int end;
    private int movie_count;
    private int episode_count;
    private int cartoon_count;
    private int variety_count;
    private int sports_count;
    private int class_count;
    private int music_count;
    private int news_count;
    private int ent_count;
    private int other_count;
    private int all_count;
    private int result_type_code;
    private List<ResultBean> result;
    private List<?> series;
    private List<?> result_type;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getMovie_count() {
        return movie_count;
    }

    public void setMovie_count(int movie_count) {
        this.movie_count = movie_count;
    }

    public int getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public int getCartoon_count() {
        return cartoon_count;
    }

    public void setCartoon_count(int cartoon_count) {
        this.cartoon_count = cartoon_count;
    }

    public int getVariety_count() {
        return variety_count;
    }

    public void setVariety_count(int variety_count) {
        this.variety_count = variety_count;
    }

    public int getSports_count() {
        return sports_count;
    }

    public void setSports_count(int sports_count) {
        this.sports_count = sports_count;
    }

    public int getClass_count() {
        return class_count;
    }

    public void setClass_count(int class_count) {
        this.class_count = class_count;
    }

    public int getMusic_count() {
        return music_count;
    }

    public void setMusic_count(int music_count) {
        this.music_count = music_count;
    }

    public int getNews_count() {
        return news_count;
    }

    public void setNews_count(int news_count) {
        this.news_count = news_count;
    }

    public int getEnt_count() {
        return ent_count;
    }

    public void setEnt_count(int ent_count) {
        this.ent_count = ent_count;
    }

    public int getOther_count() {
        return other_count;
    }

    public void setOther_count(int other_count) {
        this.other_count = other_count;
    }

    public int getAll_count() {
        return all_count;
    }

    public void setAll_count(int all_count) {
        this.all_count = all_count;
    }

    public int getResult_type_code() {
        return result_type_code;
    }

    public void setResult_type_code(int result_type_code) {
        this.result_type_code = result_type_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public List<?> getSeries() {
        return series;
    }

    public void setSeries(List<?> series) {
        this.series = series;
    }

    public List<?> getResult_type() {
        return result_type;
    }

    public void setResult_type(List<?> result_type) {
        this.result_type = result_type;
    }

    public static class ResultBean {
        private int id;
        private int total;
        private int clicks;
        private int finish;
        private int year;
        private String update_time;
        private int mid;
        private int is_pay;
        private String duration;
        private int status;
        private int seqs_count_a;
        private int seqs_count_i;
        private float score;
        private String type_l;
        private String style_l;
        private String area_l;
        private String title;
        private int type;
        private String directors;
        private String actors;
        private String desc;
        private String cover_url;
        private String cover_sqr;
        private String last_seq;
        private List<Integer> style_f;
        private List<String> directors_name;
        private List<String> actors_name;
        private List<Integer> has;
        private List<String> sites;
        private List<?> trailers;
        private List<SitesModeBean> sites_mode;
        private List<Integer> sites_seqs;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getClicks() {
            return clicks;
        }

        public void setClicks(int clicks) {
            this.clicks = clicks;
        }

        public int getFinish() {
            return finish;
        }

        public void setFinish(int finish) {
            this.finish = finish;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getSeqs_count_a() {
            return seqs_count_a;
        }

        public void setSeqs_count_a(int seqs_count_a) {
            this.seqs_count_a = seqs_count_a;
        }

        public int getSeqs_count_i() {
            return seqs_count_i;
        }

        public void setSeqs_count_i(int seqs_count_i) {
            this.seqs_count_i = seqs_count_i;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }

        public String getType_l() {
            return type_l;
        }

        public void setType_l(String type_l) {
            this.type_l = type_l;
        }

        public String getStyle_l() {
            return style_l;
        }

        public void setStyle_l(String style_l) {
            this.style_l = style_l;
        }

        public String getArea_l() {
            return area_l;
        }

        public void setArea_l(String area_l) {
            this.area_l = area_l;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public String getLast_seq() {
            return last_seq;
        }

        public void setLast_seq(String last_seq) {
            this.last_seq = last_seq;
        }

        public List<Integer> getStyle_f() {
            return style_f;
        }

        public void setStyle_f(List<Integer> style_f) {
            this.style_f = style_f;
        }

        public List<String> getDirectors_name() {
            return directors_name;
        }

        public void setDirectors_name(List<String> directors_name) {
            this.directors_name = directors_name;
        }

        public List<String> getActors_name() {
            return actors_name;
        }

        public void setActors_name(List<String> actors_name) {
            this.actors_name = actors_name;
        }

        public List<Integer> getHas() {
            return has;
        }

        public void setHas(List<Integer> has) {
            this.has = has;
        }

        public List<String> getSites() {
            return sites;
        }

        public void setSites(List<String> sites) {
            this.sites = sites;
        }

        public List<?> getTrailers() {
            return trailers;
        }

        public void setTrailers(List<?> trailers) {
            this.trailers = trailers;
        }

        public List<SitesModeBean> getSites_mode() {
            return sites_mode;
        }

        public void setSites_mode(List<SitesModeBean> sites_mode) {
            this.sites_mode = sites_mode;
        }

        public List<Integer> getSites_seqs() {
            return sites_seqs;
        }

        public void setSites_seqs(List<Integer> sites_seqs) {
            this.sites_seqs = sites_seqs;
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
}
