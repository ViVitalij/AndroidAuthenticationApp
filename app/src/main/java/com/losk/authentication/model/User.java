package com.losk.authentication.model;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;

import com.losk.authentication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by m.losK on 2017-03-27.
 */

public class User extends AppCompatActivity {

    @BindView(R.id.name_EditText)
    protected EditText name_EditText;
    @BindView(R.id.surname_EditText)
    protected EditText surname_EditText;
    @BindView(R.id.female_RadioButton)
    protected RadioButton female_RadioButton;
    @BindView(R.id.male_RadioButton)
    protected RadioButton male_RadioButton;
    //TODO @BindView(R.id. BirthdateSpinners


    public boolean validateUser() {
        ButterKnife.bind(this);
        boolean returnFlag = false;
        String name = name_EditText.getText().toString();
        String surname = surname_EditText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            name_EditText.setError("at least 3 characters");
        } else {
            name_EditText.setError(null);
            returnFlag = true;
        }

        if (surname.isEmpty() || surname.length() < 2) {
            surname_EditText.setError("at least 2 characters");
        } else {
            surname_EditText.setError(null);
            returnFlag = true;
        }


        return returnFlag;
    }

    //TODO to change - set listener
    private String checkGender() {
        String returnGender;
        if (female_RadioButton.isChecked()) {
            returnGender = "female";
        } else {
            returnGender = "male";
        }
        return returnGender;
    }
}
