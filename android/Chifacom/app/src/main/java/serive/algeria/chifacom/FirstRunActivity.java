package serive.algeria.chifacom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FirstRunActivity extends AppCompatActivity {
    TextView textView ;
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);

// forward to login form after submitting
        submit = findViewById(R.id.submitLang);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(FirstRunActivity.this, LoginActivity.class);// delete this and uncomment the code obove to make first run work
              startActivity(intent);
            }
        });


//design welcome
        textView = findViewById(R.id.welcome);
        String text = getResources().getString(R.string.bienvenu_en_chifacom_app);
        SpannableString spannableString = new SpannableString(text);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(boldSpan,11,text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);

//spinner
        Spinner spinner = findViewById(R.id.languages);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_lang_spinner,
                getResources().getStringArray(R.array.langs)
        );
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(adapter);

//Here to change language
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = spinner.getItemAtPosition(position).toString();
//selectedItem = selected language
              //  Toast.makeText(getApplicationContext(),selectedItem,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
  //nothing here
            }
        });

    }
}