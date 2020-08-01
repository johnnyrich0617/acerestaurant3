package edu.snhu633.jhrichardson.ace.recycler.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.snhu633.jhrichardson.ace.recycler.restaurant.list.adapters.RecyclerCardViewAdapter;
import edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AboutUsCardViewModel;


public class NotablesViewActivity extends AppCompatActivity
        implements RecyclerCardViewAdapter.ItemListener {

    private RecyclerView mRecyclerView;
    private ArrayList <AboutUsCardViewModel> cards;
    private RecyclerCardViewAdapter cardAdapter;

    /**
     * Create the context view for this activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notables_view);

        //create and set the recycler view for this activity
        mRecyclerView = (RecyclerView) findViewById(R.id.notables_recyclerView);
        /*
            create and set the Layout Manager for the recycler
            in this case we are using a LinearLayoutManager
         */
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // create the model from resources
        this.cards = getLayoutModel();

        //create a new adapter for this activity and add it to the recycler
        this.cardAdapter = new RecyclerCardViewAdapter(cards, this, this);
        this.mRecyclerView.setAdapter(this.cardAdapter);

    }

    /**
     * Reads the JSON file containing the model data for this activity
     * @return madel data List
     */
    private ArrayList <AboutUsCardViewModel> getLayoutModel() {

        ArrayList <AboutUsCardViewModel> cardList = new ArrayList<>();
        String jsonString;

        jsonString = getJson();
        if (jsonString == null) {
            return cardList;
        }

        try {
            JSONObject jo = new JSONObject(jsonString);
            JSONArray rawCards = jo.getJSONArray("cards");
            for(int i = 0; i < rawCards.length(); i++ ) {
                JSONObject card = rawCards.getJSONObject(i);
                AboutUsCardViewModel aCard = new AboutUsCardViewModel(
                        this.getImageId(card.getString("cardIconName")),
                        card.getString("cardTitle"),
                        card.getString("cardName"),
                        card.getString("cardText"));
                cardList.add(i, aCard);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cardList;
    }

    /**
     * Get the Image for the corresponding Image name from model
     * @param request The image name for the requested image
     * @return Image id for resource
     */
    private int getImageId(String request) {
        switch(request) {
            case "generalmanager":
                return R.drawable.general_manager;
            case "asstmanager":
                return R.drawable.asst_manager;
            case "chef":
                return R.drawable.head_chef;
            case "mixologist":
                return R.drawable.mixologist_of_the_month;
            case "hostess":
                return R.drawable.hostess;
            case "eom":
                return R.drawable.employee_of_month;
        }
        return -1;
    }

    /**
     * Utility method to read the JSON resource file
     * @return the JSON string representation
     */
    private String getJson() {
        String returnString;
        InputStream is = getResources().openRawResource(R.raw.notables);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        returnString = writer.toString();
        if (returnString.isEmpty()) {
            return null;
        } else {
            return returnString;
        }
    }

    @Override
    public void onItemClick(AboutUsCardViewModel item) {

    }
}