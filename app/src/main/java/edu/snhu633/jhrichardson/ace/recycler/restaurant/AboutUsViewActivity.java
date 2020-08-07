package edu.snhu633.jhrichardson.ace.recycler.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;


public class AboutUsViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * jhrichardson
         * keep this activity in Portrait Screen Orientation
         */
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_about_us_view);
    }

    /**
     * Image Button callback to execute the Notables View
     * @param view the calling view
     */
    public void viewNotables(View view) {
        Intent notableIntent = new Intent(AboutUsViewActivity.this,
                NotablesViewActivity.class);
        startActivity(notableIntent);
    }
}