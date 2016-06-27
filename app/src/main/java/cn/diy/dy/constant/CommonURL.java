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

public static final String SEARCH_LOG = "SEARCH";//Log的TAG标志 ex Log.i(TAG,message);

    public final static Map<String, String> MOVIE = new HashMap<>();
    static{
        MOVIE.put("爱情伦理","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=8&area=1%2C2%2C3%2C4%2C5%2C6&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=BAAE4BC40D8F2A6D060DED5DC86ADFA476ECBF2A");
        MOVIE.put("动作大片","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=3&area=1%2C2%2C3%2C4%2C5%2C6&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=8&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=7F972618A4CFD50E9E9506E0874954BC06E35E3C");
        MOVIE.put("科幻巨制","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=5&area=0&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=383CD54BA302F9D66834A71057CE518792C6DA2E");
        MOVIE.put("爆笑喜剧","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=7&area=1%2C2%2C3%2C4%2C5%2C6&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=32833C6029F7E85F6A318F8614E7ACB907620F7A");
        MOVIE.put("欧美大片","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=0&area=4&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=94EDA7ABC544058D22B069487714542385A8A15D");
        MOVIE.put("惊悚悬疑","http://search.shouji.baofeng.com/channel.php?type=1&sort=c&offset=0&limit=100&style=4&area=1%2C2%2C3%2C4%2C5%2C6&year=2016%2C2015%2C2014%2C2013%2C2012%2C2011%2C2010%2C2009%2C2008%2C2007%2C2006%2C2005%2C2004%2C2003%2C2002%2C2001%2C2000&pay=1&dtg=0&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=D727E3E3C2F43A578EF7F35154F668A4F91969A8");
    }

    public final static List<String> MOVIE_TITLE = new ArrayList<>();
    public final static List<String> MOVIE_URL = new ArrayList<>();
    static{
        MOVIE_TITLE.add("爱情伦理");
        MOVIE_TITLE.add("动作大片");
        MOVIE_TITLE.add("科幻巨制");
        MOVIE_TITLE.add("爆笑喜剧");
        MOVIE_TITLE.add("欧美大片");
        MOVIE_TITLE.add("惊悚悬疑");
    }

    public final static String PLAY_URL = "http://www.baofeng.com/play/209/play-";
    public final static String MOVIE_DETAIL_URL = "http://search.shouji.baofeng.com/mdetail.php?platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=5117C8871D4FF2E94B480E186B834C4FAF1908ED&aid=";


    public final static String SEARCH_URL = "http://so.shouji.baofeng.com/search.php?limit=20&offset=0&pay=1&platf=android&mtype=normal&g=37&ver=6.2.01&td=0&s=7B8891887466DB8770042EB3508A85AB7E5B80D8&query=";
}
