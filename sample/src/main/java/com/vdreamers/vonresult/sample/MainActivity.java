package com.vdreamers.vonresult.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.vdreamers.vonresult.core.OnResult;
import com.vdreamers.vonresult.core.OnResultCallBack;
import com.vdreamers.vonresult.sample.constants.main.MainNameConstants;
import com.vdreamers.vonresult.sample.constants.main.MainRequestCodeConstants;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity
 * <p>
 * date 2019/02/12 15:43:30
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Mr.D</a>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_to_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = 1;
                Intent intent = FirstActivity.actionStartIntent(MainActivity.this,
                        MainNameConstants.NAME_FIRST, type);
                new OnResult(MainActivity.this).start(intent,
                        MainRequestCodeConstants.REQUEST_CODE_FIRST, new OnResultCallBack() {
                            @Override
                            public void onActivityResult(int resultCode, Intent data) {
                                Toast.makeText(MainActivity.this, String.valueOf(resultCode),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        findViewById(R.id.btn_to_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = "123";
                Intent intent = SecondActivity.actionStartIntent(MainActivity.this,
                        MainNameConstants.NAME_SECOND, pwd);
                new OnResult(MainActivity.this).start(intent,
                        MainRequestCodeConstants.REQUEST_CODE_SECOND, new OnResultCallBack() {
                            @Override
                            public void onActivityResult(int resultCode, Intent data) {
                                Toast.makeText(MainActivity.this, String.valueOf(resultCode),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        findViewById(R.id.btn_to_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isOpen = false;
                final Intent intent = ThirdActivity.actionStartIntent(MainActivity.this,
                        MainNameConstants.NAME_THIRD, isOpen);
                new OnResult(MainActivity.this).start(intent,
                        MainRequestCodeConstants.REQUEST_CODE_THIRD, new OnResultCallBack() {
                            @Override
                            public void onActivityResult(int resultCode, Intent data) {
                                if (data == null) {
                                    return;
                                }
                                Bundle bundle = data.getExtras();
                                if (bundle == null) {
                                    return;
                                }
                                String resultData =
                                        bundle.getString(ThirdActivity.PARAM_KEY_RESULT_DATA, "");
                                Toast.makeText(MainActivity.this, String.valueOf(resultCode) + " "
                                                + resultData,
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
