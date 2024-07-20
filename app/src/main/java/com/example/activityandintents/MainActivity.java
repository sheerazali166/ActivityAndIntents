package com.example.activityandintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private int dataID = 001;

    public final static String EXTRA_MESSAGE = "com.example.activityandintents.MESSAGE";
    public final static String EXTRA_POSITION_X = "com.example.activityandintents.X";
    public final static String EXTRA_POSITION_Y = "com.example.activityandintents.Y";


    // This keys must be different otherwise create problems
    public final static String EXTRA_MESSAGE2 = "com.example.activityandintents.MESSAGE2";
    public final static String EXTRA_POSITION_X2 = "com.example.activityandintents.X2";
    public final static String EXTRA_POSITION_Y2 = "com.example.activityandintents.Y2";

    // Implicit Intent Keys
    public static final int PHOTO_REQUEST = 1;
    public static final int PHOTO_PICK_REQUEST = 2;
    public static final int TEXT_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goToShowMessageActivity(View view) {

        Intent intentMessage = new Intent(MainActivity.this, ShowMessageActivity.class);

        // A web page URL
        intentMessage.setData(Uri.parse("https://www.google.com"));

        // a Sample file URI
        intentMessage.setData(Uri.fromFile(new File("https://media.licdn.com/dms/image/D5603AQEsZfedrqRQRQ/profile-displayphoto-shrink_800_800/0/1700223886228?e=1726704000&v=beta&t=8H5fgfeQKho7fhKdz145wlhyH48vvb24SCmlnWopY2s")));

        // A sample content: URI for your app's data model
        intentMessage.setData(Uri.parse("content://mysample.provider/data"));

        // Custom URI
        intentMessage.setData(Uri.parse("custom:" + dataID + findViewById(R.id.buttonGoToShowMessageActivity)));

        // First Method

        // Intent Extra Keys
        intentMessage.putExtra(EXTRA_MESSAGE, "This is my message");
        intentMessage.putExtra(EXTRA_POSITION_X, 100);
        intentMessage.putExtra(EXTRA_POSITION_Y, 500);

        // Second Method

        // Parcelable interface or Java's Serializable.
        Bundle bundleExtra = new Bundle();
        bundleExtra.putString(EXTRA_MESSAGE2, "This is my message");
        bundleExtra.putInt(EXTRA_POSITION_X2, (100 * 2));
        bundleExtra.putInt(EXTRA_POSITION_Y2, (500 * 3));

        intentMessage.putExtras(bundleExtra);

        startActivity(intentMessage);

    }

    public void closeActivity(View view) {

        finish();
    }

}