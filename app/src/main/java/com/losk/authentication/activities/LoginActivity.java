package com.losk.authentication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.losk.authentication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.email_EditText)
    protected EditText email_EditText;
    @BindView(R.id.password_EditText)
    protected EditText password_EditText;
    @BindView(R.id.passwordVisibility_CheckBox)
    protected CheckBox checkBox;

    //TODO validation
    @OnClick(R.id.login_Button)
    protected void loginButtonClicked() {
//        if(validate()){
        Intent intent = new Intent(this, HelloWorld.class);
        startActivityForResult(intent, 1);
//        }
    }

    private void setListeners() {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    password_EditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    password_EditText.setSelection(password_EditText.getText().length());
                } else {
                    password_EditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    password_EditText.setSelection(password_EditText.getText().length());
                }
            }
        });
    }


    @OnClick(R.id.linkSignUp_TextView)
    protected void createAccountLinkClicked() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setListeners();
    }

    //TODO check if instead of this shouldn't be getBaseContext()?
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data.hasExtra("resultString")) {
            String returnedString = data.getStringExtra("resultString");
            email_EditText.setText(returnedString);
            Toast.makeText(this, R.string.createAccount_toast, Toast.LENGTH_LONG).show();
        }
    }
}
