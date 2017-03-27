package com.losk.authentication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.losk.authentication.R;
import com.losk.authentication.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateAccount extends AppCompatActivity {

    @BindView(R.id.streetName_EditText)
    protected EditText streetName;
    @BindView(R.id.houseNumber_EditText)
    protected EditText houseNumber_EditText;
    @BindView(R.id.flatNumber_EditText)
    protected EditText flatNumber_EditText;
    @BindView(R.id.postalCode_EditText)
    protected EditText postalCode_EditText;
    @BindView(R.id.countryName_EditText)
    protected EditText countryName_EditText;
    @BindView(R.id.emailCreateAccount_EditText)
    protected EditText emailCreateAccount_EditText;
    @BindView(R.id.mobileNumber_EditText)
    protected EditText mobileNumber_EditText;
    @BindView(R.id.passwordCreateAccount_EditText)
    protected EditText passwordCreateAccount_EditText;
    @BindView(R.id.reEnterPassword_EditText)
    protected EditText reEnterPassword_EditText;

    //TODO validation
    @OnClick(R.id.createAccount_Button)
    protected void createAccountButtonClicked() {
        if (validateEmail()) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("resultString", emailCreateAccount_EditText.getText().toString());
            setResult(RESULT_OK, returnIntent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
    }

    private boolean validateEmail() {
        String email = emailCreateAccount_EditText.getText().toString();
        boolean returnFlag = false;
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailCreateAccount_EditText.setError("enter a valid email address");
        } else {
            emailCreateAccount_EditText.setError(null);
            returnFlag = true;
        }
        return returnFlag;
    }


}
