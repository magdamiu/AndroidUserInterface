package magdamiu.com.androiduserinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private TextView valueTextView;
    private Button getValueButton;
    private CheckBox androidCheckBox;
    private RadioButton goodRadioButton;
    private RadioButton greatRadioButton;
    private RadioButton awesomeRadioButton;
    private TextView statusTextView, valuesTextView;
    private Switch textSwitch;
    private SeekBar textSeekBar;
    private SearchView searchView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = (EditText) findViewById(R.id.et_email);
        valueTextView = (TextView) findViewById(R.id.tv_value);
        getValueButton = (Button) findViewById(R.id.btn_get_value);
        androidCheckBox = (CheckBox) findViewById(R.id.cb_name);
        goodRadioButton = (RadioButton) findViewById(R.id.rb_good);
        greatRadioButton = (RadioButton) findViewById(R.id.rb_great);
        awesomeRadioButton = (RadioButton) findViewById(R.id.rb_awesome);
        statusTextView = (TextView) findViewById(R.id.tv_status);
        textSwitch = (Switch) findViewById(R.id.sw_text);
        textSeekBar = (SeekBar) findViewById(R.id.sb_text);
        valuesTextView = (TextView) findViewById(R.id.tv_values);
        searchView = (SearchView) findViewById(R.id.search);

        //handle button on click listener
        getValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = emailEditText.getText().toString();
                if (emailAddress != null && emailAddress.length() > 0) {
                    valueTextView.setText(emailAddress);
                }
            }
        });

        //handle on ckecked change
        androidCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e(TAG, isChecked + "");
            }
        });
    }

    public void getStatus_onClick(View v) {
        statusTextView.setText("CheckBox status: " + androidCheckBox.isChecked() + "\n\n" +
                "Radio button 1 status: " + goodRadioButton.isChecked() + "\n\n" +
                "Radio button 2 status: " + greatRadioButton.isChecked() + "\n\n" +
                "Radio button 3 status: " + awesomeRadioButton.isChecked());
    }

    public void getValue_onClick(View v) {
        String emailAddress = emailEditText.getText().toString();
        if (emailAddress != null && emailAddress.length() > 0) {
            valueTextView.setText(emailAddress);
        }
    }

    public void getValues_onClick(View v) {
        valuesTextView.setText("Switch status: " + textSwitch.isChecked() + "\n\n" +
                "SeekBar value: " + textSeekBar.getProgress() + "\n\n" +
                "SearchView value: " + searchView.getQuery() + "\n\n");
    }
}
