package edu.snhu633.jhrichardson.ace.recycler.restaurant;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

/**
 * The @AceSplashScreeActivity serves as the splash screen for the application on startup
 * The activity uses a library from ViksaaSkool located on Github at
 * URL https://github.com/ViksaaSkool/AwesomeSplash to create and manage the application splash
 * screen.  This Library is under MIT License and is free of charge.
 *
 * @author jhrichardson
 */

public class AceSplashScreenActivity extends AwesomeSplash {


    /**
     * Initialization of the splash screen
     * @param configSplash Configuration object for this splash screen
     */
    @Override
    public void initSplash(ConfigSplash configSplash) {

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.color_light_splash); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(800); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.ace_med); //or any other drawable
        configSplash.setAnimLogoSplashDuration(2000); //int ms
        //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)
        configSplash.setAnimLogoSplashTechnique(Techniques.Landing);

        //Customize Title
        configSplash.setTitleSplash(getString(R.string.app_name));
        configSplash.setTitleTextColor(R.color.black);
        configSplash.setTitleTextSize(30f); //float value
        configSplash.setAnimTitleDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.SlideInLeft);
        //configSplash.setTitleFont("fonts/art_brewery.ttf");
    }

    /**
     * Callback for notification as to when the splash screen has completed
     * Used to start the next activity in the chain,  In this case it starts our main menu
     * for the application absent of any login screen.
     */
    @Override
    public void animationsFinished() {
        /*
        Start the application main menu which is located in the MainActivity class
         */
        startActivity(new Intent(AceSplashScreenActivity.this, MainActivity.class));
    }
}