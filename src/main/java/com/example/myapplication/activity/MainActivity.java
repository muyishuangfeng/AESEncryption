package com.example.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.utils.AESUtils;

public class MainActivity extends AppCompatActivity {
    // 提供要加密的数据
    private final String data = "Android研发工程师之路《第一行代码》" +
            "《JAVA编程思想》《Android编程指南》";
    EditText mEdtData;
    TextView mTxtEncrypt;
    TextView mTxtDecrypt;
    Button mBtnEncryption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mEdtData = (EditText) findViewById(R.id.edt_data);
        mEdtData.setText(data);

        mTxtEncrypt = (TextView) findViewById(R.id.txt_encrypt);
        mTxtDecrypt = (TextView) findViewById(R.id.txt_decrypted);

        mBtnEncryption = (Button) findViewById(R.id.btn_encryption);

        mBtnEncryption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String encrypted = AESUtils.Encryption(mEdtData.getText()
                            .toString());
                    mTxtEncrypt.setText(encrypted);
                    // 解密
                    String decrypted = AESUtils.Decrypt(encrypted);
                    mTxtDecrypt.setText("对加密后的结果，进行解密：\n" + decrypted);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
