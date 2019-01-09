package com.example.maichel.livecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();

    MainContract.Presenter mPresenter;

    EditText mNumber1Et;
    EditText mNumber2Et;
    TextView mResultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate called");
        configureViews();
    }

    private void configureViews() {
        mNumber1Et = findViewById(R.id.number1_et);
        mNumber2Et = findViewById(R.id.number2_et);
        mResultTv = findViewById(R.id.result_tv);

        mPresenter = new MainPresenter(this);

        mNumber1Et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i(TAG, "Text 1 changed");
                inputUpdated();
            }
        });


        mNumber2Et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                inputUpdated();
                Log.i(TAG, "Text 2 changed");
            }
        });
    }

    private void inputUpdated() {

        String number1 = mNumber1Et.getText().toString();
        String number2 = mNumber2Et.getText().toString();

        int val1 = TextUtils.isEmpty(number1) ? 0 : Integer.valueOf(number1);
        int val2 = TextUtils.isEmpty(number2) ? 0 : Integer.valueOf(number2);

        if (mPresenter != null) {
            mPresenter.onInputUpdate(val1, val2);
        }
    }

    @Override
    public void updateResult(int result) {
        mResultTv.setText(String.valueOf(result));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter = null;
    }
}
