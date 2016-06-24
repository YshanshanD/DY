package cn.diy.dy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import cn.diy.dy.R;

public class PlayActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        webView = (WebView)findViewById(R.id.web_view);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        System.out.println("url === " + url);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("http://www.baofeng.com/play/209/play-798209.html");
//        webView.loadUrl("http://www.baofeng.com/paly/209/play-798209.html");
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
    }
}
