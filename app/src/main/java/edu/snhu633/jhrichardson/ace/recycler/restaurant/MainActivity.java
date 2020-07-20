package edu.snhu633.jhrichardson.ace.recycler.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import edu.snhu633.jhrichardson.ace.recycler.restaurant.list.adapters.RecyclerViewListAdapter;
import edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AppMainMenuModel;

public class MainActivity extends AppCompatActivity implements RecyclerViewListAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList<AppMainMenuModel> menuItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the menu contents and set the view
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.menuItemList = getMenuItems();

        RecyclerViewListAdapter adapter = new RecyclerViewListAdapter(menuItemList, this,
                this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onItemClick(AppMainMenuModel item) {


        switch(item.getText()) {
            case "Our Menu":
            case "Mobile Order":
            case "Reservations":
            case "Beverage Mixer":
            case "Calorie Counter":
            case "Catering":
            case "AboutUs":
                Toast.makeText(getApplicationContext(), item.getText() + " is clicked",
                        Toast.LENGTH_SHORT).show();
                break;
            case "Directions":
                try {
                    double restLat = Double.parseDouble(getResources().getString(R.string.main_location_lat));
                    double restLong = Double.parseDouble(getResources().getString(R.string.main_location_long));
                    Intent mapIntent = new Intent(MainActivity.this, AceMapsActivity.class);
                    mapIntent.putExtra(getResources().getString(R.string.const_lat_key), restLat);
                    mapIntent.putExtra(getResources().getString(R.string.const_long_key), restLong);
                    startActivity(mapIntent);
                }
                catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.error_latlong_parse_exception),
                            Toast.LENGTH_LONG).show();
                    nfe.printStackTrace();
                }
                //Intent mapIntent = new Intent(MainActivity.this, AceMapsActivity.class);
                //startActivity(mapIntent);
        }


    }

    private ArrayList<AppMainMenuModel> getMenuItems() {
        int index = 0;
        ArrayList<AppMainMenuModel> alist = new ArrayList<>();
        String[] menuItemsStrings = getResources().getStringArray(R.array.main_menu_items);
        for(String item : menuItemsStrings) {
           alist.add(index, new AppMainMenuModel(item,
                   getImageForItem(item),
                   getColorForItem(item)));
        }
        return alist;
    }

    private String getColorForItem(String menuItem) {
        if(menuItem.contains("Menu")){
            return getResources().getString(R.string.menu_item);
        }
        else if(menuItem.contains("Mobile")){
            return getResources().getString(R.string.mobile_item);
        }
        else if(menuItem.contains("Reservation")) {
            return getResources().getString(R.string.reservation_item);
        }
        else if(menuItem.contains("Beverage")){
            return getResources().getString(R.string.beverage_item);
        }
        else if(menuItem.contains("Calorie")) {
            return getResources().getString(R.string.calorie_item);
        }
        else if(menuItem.contains("Catering")) {
            return getResources().getString(R.string.catering_item);
        }
        else if(menuItem.contains("Directions")) {
            return getResources().getString(R.string.directions_item);
        }
        else if(menuItem.contains("AboutUs")) {
            return getResources().getString(R.string.aboutus_item);
        }
        else {
                return getResources().getString(R.string.aboutus_item);
            }
    }

    private int getImageForItem(String menuItem) {
        if(menuItem.contains("Menu")){
            return R.drawable.menu;
        }
        else if(menuItem.contains("Mobile")){
            return R.drawable.mobileorder;
        }
        else if(menuItem.contains("Reservation")) {
            return R.drawable.reservations;
        }
        else if(menuItem.contains("Beverage")){
            return R.drawable.berverage;
        }
        else if(menuItem.contains("Calorie")) {
            return R.drawable.calorie;
        }
        else if(menuItem.contains("Catering")) {
            return R.drawable.catering;
        }
        else if(menuItem.contains("Directions")) {
            return R.drawable.directions;
        }
        else if(menuItem.contains("AboutUs")) {
            return R.drawable.aboutus;
        }
        else
            return R.drawable.ace_logo;
    }
}