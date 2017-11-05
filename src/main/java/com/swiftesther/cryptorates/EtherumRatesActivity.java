package com.swiftesther.cryptorates;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class EtherumRatesActivity extends AppCompatActivity {

    public int ETH;
    public int base;
    public String[] val;
    public Handler handler;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etherum_rates);
        Spinner spinner = (Spinner) findViewById(R.id.etherum_card_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.value, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        val = getResources().getStringArray(R.array.value);
        spinner.setAdapter(adapter);

        Button convert = (Button) findViewById(R.id.etherum_convert_button);
        convert.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                TextView textview = (TextView) findViewById(R.id.etherum_rate_textView);
                EditText edittext = (EditText) findViewById(R.id.edit_text);
                try {
                    URL url = new URL("https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=" + val[base]);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                    double input = Double.parseDouble(edittext.getText().toString());
                    String line = reader.readLine();
                    if (line.length() > 0) {
                        double result = Double.parseDouble(line) * input;
                        textview.setText("" + result);
                    }
                    reader.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public void addListenerOnSpinnerItemSelection() {
        Spinner spinner = (Spinner) findViewById(R.id.etherum_card_spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


}
