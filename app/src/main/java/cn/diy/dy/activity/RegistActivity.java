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

import java.util.ArrayList;
import java.util.List;

import cn.diy.dy.R;
import cn.diy.dy.entity.User;
import cn.diy.dy.utils.StorageUtils;

public class RegistActivity extends AppCompatActivity {
    private Button button;
    private EditText count;
    private EditText psd;
    private EditText idenpsd;

    private static final int CORRECT = 1;
    private static final int PSW_WRONG = 2;
    private static final int ACCOUTN_WRONG = 3;
    private static final int PSD_AGAIN = 4;

    private StorageUtils storageUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);


        storageUtils = new StorageUtils(this);

        button = (Button) this.findViewById(R.id.button);
        count = (EditText) this.findViewById(R.id.editText1);
        psd = (EditText) this.findViewById(R.id.editText2);
        idenpsd = (EditText) this.findViewById(R.id.editText3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int typeIsCorrectFlag;
                typeIsCorrectFlag = judgeAccount();
                if (typeIsCorrectFlag == CORRECT) {
                    String readValue = new String(storageUtils.readFileFromInternal("use_info"));
                    User user = new User();//要注册的用户对象
                    user.setName(count.getText().toString());
                    user.setPassWord(psd.getText().toString());
                    user.setTitleList(new ArrayList<String>());//收藏列表
                    List<User> ps = new Gson().fromJson(readValue, new TypeToken<List<User>>(){}.getType());
                    boolean isNotExitUser = true;
                    try {
                        for (User bean :ps) {
                            if(bean.getName().equals(user.getName())){
                                isNotExitUser = false;
                                continue;
                            }
                        }
                    } catch (NullPointerException e) {
                        ps = new ArrayList<User>();
                    }
                    if(isNotExitUser){
                        ps.add(user);
                        String value = new Gson().toJson(ps);
                        Log.i("test5",value);
                        storageUtils.writeFileToInternal("use_info",value.getBytes());
                        Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Log.i("test5","count is exit");
                        Toast.makeText(RegistActivity.this, "count is exit", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (typeIsCorrectFlag == ACCOUTN_WRONG) {
                        Toast.makeText(RegistActivity.this, "count is wrong", Toast.LENGTH_SHORT).show();
                    }
                    if (typeIsCorrectFlag == PSW_WRONG) {
                        Toast.makeText(RegistActivity.this, "password of length must be six byte", Toast.LENGTH_SHORT).show();
                    }
                    if (typeIsCorrectFlag == PSD_AGAIN) {
                        Toast.makeText(RegistActivity.this, "please identify password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    /**
     * 判断用户名和密码格式
     * @return
     */
    public int judgeAccount() {
        //判断账号是否符合条件

        String username = count.getText().toString();

        boolean countFlag = true;//账号条件符合标志
        for (int i = 0; i < username.length(); i++) {
            if ((username.charAt(i) >= '0' && username.charAt(i) <= '9') || (username.charAt(i) >= 'a' && username.charAt(i) <= 'z') || (username.charAt(i) >= 'A' && username.charAt(i) <= 'Z')) {

            } else {
                countFlag = false;
                break;
            }

        }

        if (username.length() <= 11 && username.length() >= 6) {

        } else {
            countFlag = false;
        }



        //判断密码是否符合指定条件
        String password = psd.getText().toString();
        Boolean pswFlag = true;
        if (password.length() == 6) {
            pswFlag = true;
        } else {
            pswFlag = false;
        }

        if (!countFlag) return ACCOUTN_WRONG;
        if (!pswFlag) return PSW_WRONG;
        if (!password.equals(idenpsd.getText().toString()))
            return PSD_AGAIN;


        return CORRECT;
    }


}

