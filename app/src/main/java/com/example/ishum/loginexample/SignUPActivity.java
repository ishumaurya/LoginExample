package com.example.ishum.loginexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

public class SignUPActivity extends AppCompatActivity {
Button submit;
    LoginDataBaseAdapter loginDataBaseAdapter;
    EditText sname,spassword,rspassword;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sname=(EditText)findViewById(R.id.name);
        spassword=(EditText)findViewById(R.id.password);
        rspassword=(EditText)findViewById(R.id.repass);
        submit=(Button) findViewById(R.id.submit_form);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(SignUPActivity.this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);

       // awesomeValidation.addValidation(this, R.id., Patterns.EMAIL_ADDRESS, R.string.nameerror);
        //awesomeValidation.addValidation(this, R.id.editTextMobile, "^[2-9]{2}[0-9]{8}$", R.string.nameerror);
        //awesomeValidation.addValidation(this, R.id.editTextDob, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.nameerror);
      //  awesomeValidation.addValidation(this, R.id.password, Range.closed(1, 6), R.string.ageerror);
        

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = sname.getText().toString();
                    String pass = spassword.getText().toString();
                    String rpass = rspassword.getText().toString();

                    submitform();
                    if (name.equals("") || pass.equals("") || rpass.equals("")) {

                        Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (!pass.equals(rpass)) {
                        Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                        return;
                    } else {
                        // Save the Data in Database
                        // loginDataBaseAdapter.insertEntry(name, pass);
                          Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    private void submitform() {
        if (awesomeValidation.validate()) {
           Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();}
    }


    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        //loginDataBaseAdapter.close();
    }

}
