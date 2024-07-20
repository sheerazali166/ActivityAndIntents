package com.example.activityandintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowMessageActivity extends AppCompatActivity {

    TextView textViewMessageOne;
    TextView textViewMessageTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_message);

        textViewMessageOne = findViewById(R.id.textViewMessageOne);
        textViewMessageTwo = findViewById(R.id.textViewMessageTwo);

        Intent intent = getIntent();
        Uri uriLocation = intent.getData();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int positionX = intent.getIntExtra(MainActivity.EXTRA_POSITION_X, 0);
        int positionY = intent.getIntExtra(MainActivity.EXTRA_POSITION_Y, 0);

        String completeMessage = "Message: " + message +
                "\nPosition X value is: " + String.valueOf(positionX) +
                "\nPosition Y value is: " + String.valueOf(positionY) +
                "\nUri Location: " + uriLocation;

        textViewMessageOne.setText(completeMessage);


        // Second Method
        Bundle bundleExtra = intent.getExtras();
        String messageTwo = bundleExtra.getString(MainActivity.EXTRA_MESSAGE2);
        int positionX2 = bundleExtra.getInt(MainActivity.EXTRA_POSITION_X2);
        int positionY2 = bundleExtra.getInt(MainActivity.EXTRA_POSITION_Y2);

        String completeMessageTwo = "Message Two: " + messageTwo +
                       "\nPosition X2 value is: " + String.valueOf(positionX2) +
                        "\nPosition Y2 value is: " + String.valueOf(positionY2);

        textViewMessageTwo.setText(completeMessageTwo);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}