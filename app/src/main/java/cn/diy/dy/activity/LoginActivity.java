package cn.diy.dy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import cn.diy.dy.R;
import cn.diy.dy.entity.CurrentUser;
import cn.diy.dy.entity.User;
import cn.diy.dy.utils.StorageUtils;

public class LoginActivity extends AppCompatActivity {
    private Button button;
    private EditText count;
    private EditText psd;
    private static final int CORRECT = 1;
    private static final int PSW_WRONG = 2;
    private static final int ACCOUTN_WRONG = 3;
    private static final int PSD_AGAIN = 4;

    private StorageUtils storageUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        storageUtils = new StorageUtils(this);


        button = (Button) this.findViewById(R.id.button);
        count = (EditText) this.findViewById(R.id.editText1);
        psd = (EditText) this.findViewById(R.id.editText2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag;//整体格式判断
                if ((flag = judgeAccount()) == CORRECT) {

                    String value = new String(storageUtils.readFileFromInternal("use_info"));
                    Log.i("test5", "read json == " + value);
                    List<User> ps = new Gson().fromJson(value, new TypeToken<List<User>>() {
                    }.getType());
                    Log.i("test5", "json size == " + ps.size());
                    String username = count.getText().toString();
                    String password = psd.getText().toString();
                    boolean isExitUser = false;
                    boolean isCorrectPsw = false;
                    for (User bean : ps) {
                        if (bean.getName().equals(username)) {
                            isExitUser = true;
                            if(bean.getPassWord().equals(password)){
                                isCorrectPsw = true;
                                CurrentUser.user = bean;//全局用户变量，
                                CurrentUser.LoginFlag = true;//全局用户变量
                            }
                        }
                    }
                    if (!isExitUser) {
                        Toast.makeText(LoginActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();
                    } else if (!isCorrectPsw) {
                        Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, DyMainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    if (flag == ACCOUTN_WRONG) {
                        Toast.makeText(LoginActivity.this, "count is wrong", Toast.LENGTH_SHORT).show();
                    }
                    if (flag == PSW_WRONG) {
                        Toast.makeText(LoginActivity.this, "password is wrong", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


    }


    public int judgeAccount() {

        String value = count.getText().toString();

        boolean flag = true;
        for (int i = 0; i < value.length(); i++) {
            if ((value.charAt(i) >= '0' && value.charAt(i) <= '9') || (value.charAt(i) >= 'a' && value.charAt(i) <= 'z') || (value.charAt(i) >= 'A' && value.charAt(i) <= 'Z')) {


            } else {
                flag = false;
            }

        }

        if (value.length() <= 11 && value.length() >= 6) {

        } else {
            flag = false;
        }


        String password = psd.getText().toString();
        Boolean pswFlag = true;
        if (password.length() == 6) {
            pswFlag = true;
        } else {
            pswFlag = false;
        }

        if (!flag) return ACCOUTN_WRONG;
        if (!pswFlag) return PSW_WRONG;


        return CORRECT;
    }

}
