package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {//implements Tab1.OnFragmentInteractionListener, Tab2.OnFragmentInteractionListener, Tab3.OnFragmentInteractionListener {

    String[] descToShow = {
            "Die elektrische Leinenwebmaschine (mit Schaft- und Jacquardmaschine) des Fabrikats G. A. Roscher aus den 1920er Jahren diente der Herstellung von Leinengeweben mit Mustern.",
            "Ursprünglich in der Weberei Gebrüder Büning in Borken im Einsatz befindet sie sich heute im LWL-Industriemuseum TextilWerk Bocholt und wird zu Vorführzwecken in Betrieb genommen.",
            "Der Klang der Maschine entspringt ihrer Mechanik: Zu hören sind hauptsächlich die Auf- und Abbewegungen der „Schäfte“, das hin und her schlagende „Schiffchen“, das Einschlagen des „Webkammes“ und das Wechseln der Jacquard-Lochkarten.",
            "Bei den „Schäften“ handelt es sich um Rahmen auf der Vorderseite der Webmaschine, mit denen jeweils ein Teil der Kettfäden (Fäden, die in der Weberei in einem Webstuhl in Längsrichtung aufgespannt werden) auf und ab bewegt werden.",
            "Dadurch entsteht eine Öffnung zwischen den Kettfäden, durch die der an einem „Schiffchen“ befestigte Schussfaden (der zu den im Webstuhl aufgespannten Kettfäden quer liegt) geschlagen wird.",
            "Damit das Gewebe nicht zu locker wird, schlägt ein Webkamm nach jedem Schusseintrag den Schussfaden an das Gewebe an.",
            "Eine Lochkarte ist ein mechanisches Speichermedium aus gestanztem Pappkarton und stellt ein binäres System dar: Loch und kein Loch.",
            "Trifft die Nadel auf Pappe (kein Loch), kommt es zur Fadenhebung, trifft sie auf ein Loch, wird der Faden gesenkt und das Gewebe durchgestochen.",
            "Die Lochkarten sind dabei analog zum Webmuster gestanzt.",
            "Mit diesem Prinzip der Lochkartensteuerung ist es möglich, immer gleich aussehende Muster zu weben."
    };

    int descInd = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView sound = (ImageView)findViewById(R.id.sound);
        ImageView video = (ImageView)findViewById(R.id.video);
        ImageView description = (ImageView)findViewById(R.id.description);

        ImageView arrowLeft = (ImageView)findViewById(R.id.arrowLeft);
        final ImageView arrowRight = (ImageView)findViewById(R.id.arrowRight);

        arrowLeft.setVisibility(View.INVISIBLE);
        arrowRight.setVisibility(View.INVISIBLE);

        // sound.setAlpha((float) 1.0);
        video.setAlpha((float) 0.5);
        description.setAlpha((float) 0.5);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.weavingmachine);

        sound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(mp.isPlaying()){
                    mp.pause();
                }
                else{
                    mp.start();
                }
            }

        });
        video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { /*
                System.out.println("Video clicked");
                ImageView video = (ImageView)findViewById(R.id.video);
                //Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                if(video.getAlpha() != 1.0) {
                    System.out.println("video fade IN");
                    //Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    //video.startAnimation(animFadeIn);
                    video.setAlpha((float) 1.0);
                    ImageView sound = (ImageView)findViewById(R.id.sound);
                    if(sound.getAlpha() > 0.5) {
                        System.out.println("Sound fade OUT");
                        //sound.startAnimation(animFadeOut);
                        sound.setAlpha((float) 0.5);
                    }
                    ImageView description = (ImageView)findViewById(R.id.description);
                    if(description.getAlpha() > 0.5) {
                        ImageView arrowLeft = (ImageView)findViewById(R.id.arrowLeft);
                        ImageView arrowRight = (ImageView)findViewById(R.id.arrowRight);
                        arrowLeft.setVisibility(View.INVISIBLE);
                        arrowRight.setVisibility(View.INVISIBLE);
                        description.setAlpha((float) 0.5);
                        TextSwitcher descriptionSwitcher = (TextSwitcher) findViewById(R.id.descriptionSwitcher);
                        descriptionSwitcher.setCurrentText("");


                    }
                } else {
                    System.out.println("Video fade OUT");
                    //video.startAnimation(animFadeOut);
                    video.setAlpha((float) 0.5);
                }*/
            }
        });
        description.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Desc clicked");
                ImageView description = (ImageView)findViewById(R.id.description);
                //Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                if(description.getAlpha() != 1.0) {
                    //Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    //description.startAnimation(animFadeIn);
                    description.setAlpha((float) 1.0);


                    ImageView arrowLeft = (ImageView)findViewById(R.id.arrowLeft);
                    ImageView arrowRight = (ImageView)findViewById(R.id.arrowRight);

                    //arrowLeft.setVisibility(View.VISIBLE);
                    arrowRight.setVisibility(View.VISIBLE);

                    System.out.println(arrowLeft.getAlpha());

                    TextSwitcher descriptionSwitcher = (TextSwitcher) findViewById(R.id.descriptionSwitcher);
                    descInd = 0;
                    descriptionSwitcher.setCurrentText(descToShow[descInd]);

                    ImageView video = (ImageView)findViewById(R.id.video);
                    if(video.getAlpha() > 0.5) {
                        //video.startAnimation(animFadeOut);
                        video.setAlpha((float) 0.5);
                    }
                } else {
                    //description.startAnimation(animFadeOut);
                    ImageView arrowLeft = (ImageView)findViewById(R.id.arrowLeft);
                    ImageView arrowRight = (ImageView)findViewById(R.id.arrowRight);
                    arrowLeft.setVisibility(View.INVISIBLE);
                    arrowRight.setVisibility(View.INVISIBLE);
                    description.setAlpha((float) 0.5);
                    TextSwitcher descriptionSwitcher = (TextSwitcher) findViewById(R.id.descriptionSwitcher);
                    descriptionSwitcher.setCurrentText("");
                }
            }
        });

        TextSwitcher descriptionSwitcher=(TextSwitcher)findViewById(R.id.descriptionSwitcher); // get reference of TextSwitcher

// Set the ViewFactory of the TextSwitcher that will create TextView object when asked
        descriptionSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create a TextView
                TextView t = new TextView(MainActivity.this);
                // set the gravity of text to top and center horizontal
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                // set displayed text size
                t.setMaxWidth(730);
                t.setTextSize(20);
                t.setTextColor(Color.parseColor("#FFFFFF"));
                t.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
                return t;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);


        descriptionSwitcher.setInAnimation(in); // set in Animation for TextSwitcher
        descriptionSwitcher.setOutAnimation(out);

        arrowLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageView arrowLeft = (ImageView)findViewById(R.id.arrowLeft);
                ImageView arrowRight = (ImageView)findViewById(R.id.arrowRight);
                if (descInd == descToShow.length - 1) {
                    arrowRight.setVisibility(View.VISIBLE);
                }
                if (descInd != 0) {
                    descInd -= 1;
                    if(descInd == 0) {
                        arrowLeft.setVisibility(View.INVISIBLE);
                    }
                    TextSwitcher descriptionSwitcher = (TextSwitcher) findViewById(R.id.descriptionSwitcher);
                    descriptionSwitcher.setText(descToShow[descInd]);
                }
            }
        });

        arrowRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageView arrowLeft = (ImageView)findViewById(R.id.arrowLeft);
                ImageView arrowRight = (ImageView)findViewById(R.id.arrowRight);
                if (descInd == 0) {
                    arrowLeft.setVisibility(View.VISIBLE);
                }
                if (descInd < descToShow.length - 1) {
                    descInd += 1;
                    if (descInd == descToShow.length - 1) {

                        arrowRight.setVisibility(View.INVISIBLE);
                    }
                    TextSwitcher simpleTextSwitcher = (TextSwitcher) findViewById(R.id.descriptionSwitcher);
                    simpleTextSwitcher.setText(descToShow[descInd]);
                }
            }
        });

        /*TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new com.example.myapplication.PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }
    /*
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/
}
