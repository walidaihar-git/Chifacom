package serive.algeria.chifacom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import serive.algeria.chifacom.doctor.DoctorHomeActivity;
import serive.algeria.chifacom.doctor.DoctorMainActivity;
import serive.algeria.chifacom.forgetPass.ForgetPassActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private  long backPressedTime;
    AppCompatButton register ,forgetPass,login;
    EditText email,password;
    View decorView;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        progressDialog = new ProgressDialog(this);
        decorView = getWindow().getDecorView();

        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                decorView.setSystemUiVisibility(hideSystemBars());
            }
        });


        //get information from view
        email= findViewById(R.id.email);
        password=findViewById(R.id.password);

        register = findViewById(R.id.registerNav);
        forgetPass = findViewById(R.id.forgetPass);
        login = findViewById(R.id.login);

        register.setOnClickListener(this);
        forgetPass.setOnClickListener(this);
        login.setOnClickListener(this);
    }
    private TextView.OnEditorActionListener actionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId){
                case EditorInfo.IME_ACTION_GO:
                    Toast.makeText(LoginActivity.this, "Login !..", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    };
    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }



    @Override
    public void onClick(View v) {

        if (v==register) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);

        }
        if (v == forgetPass){
            Intent intent = new Intent(LoginActivity.this, ForgetPassActivity.class);
            startActivity(intent);
        }
        if (v==login){
            Intent intent = new Intent(LoginActivity.this, DoctorMainActivity.class);
            startActivity(intent);

            // userLogin();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    public int  hideSystemBars(){

        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                ;
    }


    private void userLogin(){
        final String username = email.getText().toString().trim();
        final String pass = password.getText().toString().trim();
        //final String password = editTextPassword.getText().toString().trim();

        progressDialog.show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")){

                                DoctorPrefManager.getInstance(getApplicationContext())
                                        .userLogin(
                                                obj.getInt("id"),
                                                obj.getString("username"),
                                                obj.getString("firstname"),
                                                obj.getString("lastname"),
                                                obj.getString("created_at")



                                        );

                                startActivity(new Intent(getApplicationContext(),DoctorMainActivity.class));
                                finish();

                            }else{
//                                Toast.makeText(
//                                        getApplicationContext(),
//                                        obj.getString("message"),
//                                        Toast.LENGTH_LONG
//                                ).show();

                                if (obj.getString("message") != null) {

                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
//                        Toast.makeText(
//                                getApplicationContext(),
//                                error.getMessage(),
//                                Toast.LENGTH_LONG
//                        ).show();
                        if (error.getMessage() != null) {
                        }
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("office_mail",username);
                params.put("office_pass",pass);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

}