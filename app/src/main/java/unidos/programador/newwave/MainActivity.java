package unidos.programador.newwave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputEmail;
    private Button btnLogin;
    private LoggerPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoggerPreferences.init(true, true);
        preferences = LoggerPreferences.get(MainActivity.this).with(MainActivity.this);

        inputEmail = findViewById(R.id.inputEmail);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.edit().putString("usuario", inputEmail.getText().toString()).apply();
            }
        });

        inputEmail.setText(preferences.getString("usuario", null));
    }
}
