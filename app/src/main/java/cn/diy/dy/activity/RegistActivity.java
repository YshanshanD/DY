package cn.diy.dy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.diy.dy.R;
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
                int flag = -1;
                if ((flag = judgeAccount()) == CORRECT) {

                    String string = count.getText().toString() + "@" + psd.getText().toString();

                    storageUtils.writeFileToInternal("user_info",string.getBytes());

                    Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    if (flag == ACCOUTN_WRONG) {
                        Toast.makeText(RegistActivity.this, "count is wrong", Toast.LENGTH_SHORT).show();
                    }
                    if (flag == PSW_WRONG) {
                        Toast.makeText(RegistActivity.this, "password of length must be six byte", Toast.LENGTH_SHORT).show();
                    }
                    if (flag == PSD_AGAIN) {
                        Toast.makeText(RegistActivity.this, "please identify password", Toast.LENGTH_SHORT).show();
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
        if (!psd.getText().toString().equals(idenpsd.getText().toString()))
            return PSD_AGAIN;


        return CORRECT;
    }


}

