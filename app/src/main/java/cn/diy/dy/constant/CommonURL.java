package cn.diy.dy.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by orange on 2016/6/22.
 */
public class CommonURL {

    public static final String MOVIE_LOG = "MOVIE";

    public static final String OSCAR_LOG = "oscar";

public static final String SEARCH_LOG = "SEARCH";//Log的TAG标志 ex Log.i(TAG,message);

    public final static Map<String, String> MOVIE = new HashMap<>();
    static{
        MOVIE.put("动作大片","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=3&area=1%2C2%2C3%2C4%2C5%2C6&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=8&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=7F972618A4CFD50E9E9506E0874954BC06E35E3C");
        MOVIE.put("科幻巨制","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=5&area=0&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=383CD54BA302F9D66834A71057CE518792C6DA2E");
        MOVIE.put("爆笑喜剧","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=7&area=1%2C2%2C3%2C4%2C5%2C6&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=32833C6029F7E85F6A318F8614E7ACB907620F7A");
        MOVIE.put("欧美大片","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=0&area=4&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=94EDA7ABC544058D22B069487714542385A8A15D");
        MOVIE.put("惊悚悬疑","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=4&area=1%2C2%2C3%2C4%2C5%2C6&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=D727E3E3C2F43A578EF7F35154F668A4F91969A8");
    }

    public final static List<String> MOVIE_TITLE = new ArrayList<>();
    static{
        MOVIE_TITLE.add("动作大片");
        MOVIE_TITLE.add("科幻巨制");
        MOVIE_TITLE.add("爆笑喜剧");
        MOVIE_TITLE.add("欧美大片");
        MOVIE_TITLE.add("惊悚悬疑");
    }

    public final static List<String> TV_TITLE = new ArrayList<>();
    static{
        TV_TITLE.add("爆笑喜剧");
        TV_TITLE.add("青春偶像");
        TV_TITLE.add("热血抗战");
        TV_TITLE.add("农村故事");
    }
    public final static Map<String, String> TV = new HashMap<>();
    static{
        TV.put("爆笑喜剧","http://search.shouji.baofeng.com/channel.php?type=2&sort=c&offset=0&limit=24&style=16&area=7%2C8%2C9%2C10%2C11%2C12&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=140F827B2C546B4F9073D6CDF745CF5FB2058A76");
        TV.put("青春偶像","http://search.shouji.baofeng.com/channel.php?type=2&sort=c&offset=0&limit=24&style=14&area=7%2C8%2C9%2C10%2C11%2C12&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=84810BA4390B9EC26366F0DF433E7A98ADAA3DC4");
        TV.put("热血抗战","http://search.shouji.baofeng.com/channel.php?type=2&sort=c&offset=0&limit=24&style=12&area=7%2C8%2C9%2C10%2C11%2C12&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=DD6C87D2600B4362202D2C49818A62C140810384");
        TV.put("农村故事","http://search.shouji.baofeng.com/channel.php?type=2&sort=c&offset=0&limit=24&style=442&area=7%2C8%2C9%2C10%2C11%2C12&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=412D83C6DA317EAD3C2BDF070A958552718EEB8B");
    }

    public static final List<String> ANIMA_TITLE = new ArrayList<>();
    static {
        ANIMA_TITLE.add("战斗热血");
        ANIMA_TITLE.add("科幻机战");
        ANIMA_TITLE.add("益智亲子");
        ANIMA_TITLE.add("暖心萌系");
    }

    public final static Map<String, String> ANIMA = new HashMap<>();
    static{
        ANIMA.put("战斗热血","http://search.shouji.baofeng.com/channel.php?type=3&sort=c&offset=0&limit=24&style=444&area=13%2C14%2C15%2C16&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=AFA9B8528DB5631EC980704C8C188D1C12C77E77");
        ANIMA.put("科幻机战","http://search.shouji.baofeng.com/channel.php?type=3&sort=c&offset=0&limit=24&style=68&area=13%2C14%2C15%2C16&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=D6248B71D1B9CDBE8C0BFC1F649024C8B6BC3B07");
        ANIMA.put("益智亲子","http://search.shouji.baofeng.com/channel.php?type=3&sort=c&offset=0&limit=24&style=443&area=13%2C14%2C15%2C16&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=4C43979061338D13500AC301C0405F711218A8AF");
        ANIMA.put("暖心萌系","http://search.shouji.baofeng.com/channel.php?type=3&sort=c&offset=0&limit=24&style=29&area=13%2C14%2C15%2C16&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=E2626D4FD51D3FA9A5A9F3D5B18BAC7BB4F22AF3");
    }

    public final static String PLAY_URL = "http://www.baofeng.com/play/208/play-";
    public final static String MOVIE_DETAIL_URL = "http://search.shouji.baofeng.com/mdetail.php?platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=5117C8871D4FF2E94B480E186B834C4FAF1908ED&aid=";


    public final static String SEARCH_URL = "http://so.shouji.baofeng.com/search.php?limit=20&offset=0&pay=1&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=7B8891887466DB8770042EB3508A85AB7E5B80D8&query=";

    public final static Map<String,List<String>> OSCAR_SET = new HashMap<>();

    public final static List<String> OSCAR_MOVIE_SET_2015 = new ArrayList<>();
    public final static List<String> OSCAR_MOVIE_SET_2014 = new ArrayList<>();
    public final static List<String> OSCAR_MOVIE_SET_2013 = new ArrayList<>();
    public final static List<String> OSCAR_MOVIE_SET_2012 = new ArrayList<>();
    public final static List<String> OSCAR_MOVIE_SET_2011 = new ArrayList<>();
    static{
        OSCAR_MOVIE_SET_2015.add("聚焦");
        OSCAR_MOVIE_SET_2015.add("大空头");
        OSCAR_MOVIE_SET_2015.add("间谍之桥");
        OSCAR_MOVIE_SET_2015.add("布鲁克林");
        OSCAR_MOVIE_SET_2015.add("疯狂的麦克斯：狂暴之路");
        OSCAR_MOVIE_SET_2015.add("火星救援");
        OSCAR_MOVIE_SET_2015.add("荒野猎人");
        OSCAR_MOVIE_SET_2015.add("房间");
        OSCAR_SET.put("2015",OSCAR_MOVIE_SET_2015);


        OSCAR_MOVIE_SET_2014.add("为奴十二年");
        OSCAR_MOVIE_SET_2014.add("美国骗局");
        OSCAR_MOVIE_SET_2014.add("菲利普船长");
        OSCAR_MOVIE_SET_2014.add("达拉斯买家俱乐部");
        OSCAR_MOVIE_SET_2014.add("地心引力");
        OSCAR_MOVIE_SET_2014.add("她");
        OSCAR_MOVIE_SET_2014.add("内布拉斯加");
        OSCAR_MOVIE_SET_2014.add("菲洛梅娜");
        OSCAR_MOVIE_SET_2014.add("华尔街之狼");
        OSCAR_SET.put("2014",OSCAR_MOVIE_SET_2014);

        OSCAR_MOVIE_SET_2013.clear();
        OSCAR_MOVIE_SET_2013.add("逃离德黑兰");
        OSCAR_MOVIE_SET_2013.add("爱");
        OSCAR_MOVIE_SET_2013.add("南国野兽");
        OSCAR_MOVIE_SET_2013.add("乌云背后的幸福线");
        OSCAR_MOVIE_SET_2013.add("少年派的奇幻漂流");
        OSCAR_MOVIE_SET_2013.add("猎杀本·拉登");
        OSCAR_MOVIE_SET_2013.add("林肯");
        OSCAR_MOVIE_SET_2013.add("被解放的姜戈");
        OSCAR_MOVIE_SET_2013.add("悲惨世界");
        OSCAR_SET.put("2013",OSCAR_MOVIE_SET_2013);

        OSCAR_MOVIE_SET_2012.clear();
        OSCAR_MOVIE_SET_2012.add("艺术家");
        OSCAR_MOVIE_SET_2012.add("后裔");
        OSCAR_MOVIE_SET_2012.add("咫尺浩劫");
        OSCAR_MOVIE_SET_2012.add("相助");
        OSCAR_MOVIE_SET_2012.add("雨果的秘密");
        OSCAR_MOVIE_SET_2012.add("午夜巴黎");
        OSCAR_MOVIE_SET_2012.add("点球成金");
        OSCAR_MOVIE_SET_2012.add("生命之树");
        OSCAR_MOVIE_SET_2012.add("战马");
        OSCAR_SET.put("2012",OSCAR_MOVIE_SET_2012);

        OSCAR_MOVIE_SET_2011.clear();
        OSCAR_MOVIE_SET_2011.add("国王的演讲");
        OSCAR_MOVIE_SET_2011.add("黑天鹅");
        OSCAR_MOVIE_SET_2011.add("斗士");
        OSCAR_MOVIE_SET_2011.add("玩具总动员3");
        OSCAR_MOVIE_SET_2011.add("更好的世界");
        OSCAR_MOVIE_SET_2011.add("狼人");
        OSCAR_MOVIE_SET_2011.add("盗梦空间");
        OSCAR_MOVIE_SET_2011.add("爱丽丝梦游仙境");
        OSCAR_SET.put("2011",OSCAR_MOVIE_SET_2011);
    }

}
