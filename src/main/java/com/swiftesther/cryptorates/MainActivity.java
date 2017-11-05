package com.swiftesther.cryptorates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the view that shows the bitcoin card
        ImageButton bitcoin = (ImageButton) findViewById(R.id.bitcoin);

        //Find the view that shows the etherum card
        ImageButton etherum = (ImageButton) findViewById(R.id.etherum);

        //Set Clicklisteners on the respective views
        bitcoin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link BitcoinRatesActivity}
                Intent bitcoinRatesIntent = new Intent(MainActivity.this,BitcoinRatesActivity.class);

            //Start the new activity
                startActivity(bitcoinRatesIntent);
            }
        });
        etherum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                    //Create a new intent to open the {@link EtherumRatesActivity}
                    Intent etherumRatesIntent = new Intent(MainActivity.this,EtherumRatesActivity.class);

                //Start the new activity
                startActivity(etherumRatesIntent);
            }
            });
}}