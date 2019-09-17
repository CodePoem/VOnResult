package com.vdreamers.vonresult.support.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.vdreamers.vonresult.sample.R;

/**
 * FirstActivity
 * <p>
 * date 2019/02/12 15:44:02
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Mr.D</a>
 */
public class FirstActivity extends AppCompatActivity {

    private String mName;
    private int mType;

    public static final String PARAM_KEY_NAME = "PARAM_KEY_NAME";
    public static final String PARAM_KEY_TYPE = "PARAM_KEY_TYPE";

    @NonNull
    public static Intent actionStartIntent(Context context, String name, int type) {
        Intent intent = new Intent(context, FirstActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_KEY_NAME, name);
        bundle.putInt(PARAM_KEY_TYPE, type);
        intent.putExtras(bundle);
        return intent;
    }

    private void getIntentData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        mName = bundle.getString(PARAM_KEY_NAME, "");
        mType = bundle.getInt(PARAM_KEY_TYPE, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        getIntentData();

        TextView nameTextView = findViewById(R.id.tv_name);
        nameTextView.setText(mName);

        TextView typeTextView = findViewById(R.id.tv_type);
        typeTextView.setText(String.valueOf(mType));

        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });
    }
}
