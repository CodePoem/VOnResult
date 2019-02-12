package com.vdreamers.vonresult.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * SecondActivity
 * <p>
 * date 2019/02/12 15:43:42
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Mr.D</a>
 */
public class SecondActivity extends AppCompatActivity {

    private String mName;
    private String mPwd;

    public static final String PARAM_KEY_NAME = "PARAM_KEY_NAME";
    public static final String PARAM_KEY_PWD = "PARAM_KEY_PWD";

    @NonNull
    public static Intent actionStartIntent(Context context, String name, String pwd){
        Intent intent = new Intent(context, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_KEY_NAME, name);
        bundle.putString(PARAM_KEY_PWD, pwd);
        intent.putExtras(bundle);
        return intent;
    }

    private void getIntentData(){
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        mName = bundle.getString(PARAM_KEY_NAME, "");
        mPwd = bundle.getString(PARAM_KEY_PWD, "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getIntentData();

        TextView nameTextView = findViewById(R.id.tv_name);
        nameTextView.setText(mName);

        TextView pwdTextView = findViewById(R.id.tv_pwd);
        pwdTextView.setText(mPwd);

        final EditText customResultCodeEditText = findViewById(R.id.et_custom_result_code);

        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultCode = Integer.valueOf(customResultCodeEditText.getText().toString());
                setResult(resultCode);
                finish();
            }
        });
    }
}
