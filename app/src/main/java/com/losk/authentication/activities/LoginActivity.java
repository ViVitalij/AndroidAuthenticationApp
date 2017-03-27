package com.losk.authentication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.losk.authentication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.email_EditText)
    protected EditText email_EditText;

    final String ACCOUNT_CREATED = "An account has been created";

    //TODO validation
    @OnClick(R.id.login_Button)
    protected void loginButtonClicked(){
//        if(validate()){
            Intent intent = new Intent(this, HelloWorld.class);
            startActivityForResult(intent, 1);
//        }
    }

    @OnClick(R.id.linkSignUp_TextView)
    protected void createAccountLinkClicked(){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    //TODO czy zamiast this nie powinno byc getBaseContext()?
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data.hasExtra("resultString")) {
            String returnedString = data.getStringExtra("resultString");
            email_EditText.setText(returnedString);
            Toast.makeText(this, ACCOUNT_CREATED, Toast.LENGTH_LONG).show();
        }
    }
}
