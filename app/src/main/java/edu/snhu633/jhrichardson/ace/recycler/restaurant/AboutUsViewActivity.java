package edu.snhu633.jhrichardson.ace.recycler.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.snhu633.jhrichardson.ace.recycler.restaurant.list.adapters.RecyclerViewListAdapter;
import edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AppMainMenuModel;

public class AboutUsViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_view);
    }

    public void viewNotables(View view) {
        Intent notableIntent = new Intent(AboutUsViewActivity.this,
                NotablesViewActivity.class);
        startActivity(notableIntent);
    }
}