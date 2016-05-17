package ua.olegsl.testzoom;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import ua.olegsl.testzoom.view.TouchExampleView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TouchExampleView touchExampleView = (TouchExampleView) findViewById(R.id.etView);

        assert touchExampleView != null;
        touchExampleView.setBackground(getResources().getDrawable(R.drawable.apricot));


    }



}
