package cn.diy.dy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.diy.dy.R;

public class GuigeActivity extends AppCompatActivity {
    private ImageView cover;
    private Button login;
    private  Button regist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_);
        login=(Button)this.findViewById(R.id.login);
        regist=(Button)this.findViewById(R.id.regist);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuigeActivity.this,LoginActivity .class);
                startActivity(intent);
                finish();

            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuigeActivity.this,RegistActivity.class);
                startActivity(intent);
                //finish();

            }
        });
    }
}
