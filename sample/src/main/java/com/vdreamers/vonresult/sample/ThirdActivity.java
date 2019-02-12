package com.vdreamers.vonresult.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * ThirdActivity
 * <p>
 * date 2019/02/12 15:43:50
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Mr.D</a>
 */
public class ThirdActivity extends AppCompatActivity {

    private String mName;
    private Boolean mIsOpen;

    public static final String PARAM_KEY_NAME = "PARAM_KEY_NAME";
    public static final String PARAM_KEY_IS_OPEN = "PARAM_KEY_IS_OPEN";

    public static final String PARAM_KEY_RESULT_DATA = "PARAM_KEY_RESULT_DATA";

    @NonNull
    public static Intent actionStartIntent(Context context, String name, Boolean isOpen) {
        Intent intent = new Intent(context, ThirdActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_KEY_NAME, name);
        bundle.putBoolean(PARAM_KEY_IS_OPEN, isOpen);
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
        mIsOpen = bundle.getBoolean(PARAM_KEY_IS_OPEN, false);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getIntentData();

        TextView nameTextView = findViewById(R.id.tv_name);
        nameTextView.setText(mName);

        TextView isOpenTextView = findViewById(R.id.tv_is_open);
        isOpenTextView.setText(String.valueOf(mIsOpen));

        final EditText customResultStringDataEditText =
                findViewById(R.id.et_custom_result_string_data);


        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultData = customResultStringDataEditText.getText().toString();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString(PARAM_KEY_RESULT_DATA, resultData);
                intent.putExtras(bundle);
                setResult(3, intent);
                finish();
            }
        });
    }
}
