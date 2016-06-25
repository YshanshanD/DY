package cn.diy.dy.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by orange on 2016/6/22.
 */
public class MovieEntity {

    private int status;
    private String msg;
    private int count;
    private int begin;
    private int end;
    private List<ResultBean> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Parcelable {
        private int id;
        private int total;
        private int clicks;
        private int finish;
        private int year;
        private String update_time;
        private int mid;
        private int is_pay;
        private int status;
        private int seqs_count_a;
        private int seqs_count_i;
        private int seqs_count_w;
        private double score;
        private String title;
        private String type;
        private String actors;
        private String cover_url;
        private String cover_sqr;
        private String cover_h_url;
        private String has;
        private String duration;
        private String last_seq;
        private RelevantBean relevant;
        private List<String> directors_name;
        private List<String> actors_name;
        private List<String> styles_name;
        private List<String> areas_name;
        private List<String> sites;

        protected ResultBean(Parcel in) {
            id = in.readInt();
            total = in.readInt();
            clicks = in.readInt();
            finish = in.readInt();
            year = in.readInt();
            update_time = in.readString();
            mid = in.readInt();
            is_pay = in.readInt();
            status = in.readInt();
            seqs_count_a = in.readInt();
            seqs_count_i = in.readInt();
            seqs_count_w = in.readInt();
            score = in.readDouble();
            title = in.readString();
            type = in.readString();
            actors = in.readString();
            cover_url = in.readString();
            cover_sqr = in.readString();
            cover_h_url = in.readString();
            has = in.readString();
            duration = in.readString();
            last_seq = in.readString();
            directors_name = in.createStringArrayList();
            actors_name = in.createStringArrayList();
            styles_name = in.createStringArrayList();
            areas_name = in.createStringArrayList();
            sites = in.createStringArrayList();
        }

        public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel in) {
                return new ResultBean(in);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };

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

        public int getSeqs_count_w() {
            return seqs_count_w;
        }

        public void setSeqs_count_w(int seqs_count_w) {
            this.seqs_count_w = seqs_count_w;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
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

        public String getActors() {
            return actors;
        }

        public void setActors(String actors) {
            this.actors = actors;
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

        public String getHas() {
            return has;
        }

        public void setHas(String has) {
            this.has = has;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLast_seq() {
            return last_seq;
        }

        public void setLast_seq(String last_seq) {
            this.last_seq = last_seq;
        }

        public RelevantBean getRelevant() {
            return relevant;
        }

        public void setRelevant(RelevantBean relevant) {
            this.relevant = relevant;
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

        public List<String> getStyles_name() {
            return styles_name;
        }

        public void setStyles_name(List<String> styles_name) {
            this.styles_name = styles_name;
        }

        public List<String> getAreas_name() {
            return areas_name;
        }

        public void setAreas_name(List<String> areas_name) {
            this.areas_name = areas_name;
        }

        public List<String> getSites() {
            return sites;
        }

        public void setSites(List<String> sites) {
            this.sites = sites;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeInt(total);
            dest.writeInt(clicks);
            dest.writeInt(finish);
            dest.writeInt(year);
            dest.writeString(update_time);
            dest.writeInt(mid);
            dest.writeInt(is_pay);
            dest.writeInt(status);
            dest.writeInt(seqs_count_a);
            dest.writeInt(seqs_count_i);
            dest.writeInt(seqs_count_w);
            dest.writeDouble(score);
            dest.writeString(title);
            dest.writeString(type);
            dest.writeString(actors);
            dest.writeString(cover_url);
            dest.writeString(cover_sqr);
            dest.writeString(cover_h_url);
            dest.writeString(has);
            dest.writeString(duration);
            dest.writeString(last_seq);
            dest.writeStringList(directors_name);
            dest.writeStringList(actors_name);
            dest.writeStringList(styles_name);
            dest.writeStringList(areas_name);
            dest.writeStringList(sites);
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
    }
}
