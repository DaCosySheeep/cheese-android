package me.dacosysheeep.cheese;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView cheese;
    private MediaPlayer mp;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button myButton=findViewById(R.id.showcheese);
        cheese=findViewById(R.id.cheese1);


        myButton.setOnClickListener(v -> showCheese());
        View rootView=findViewById(android.R.id.content);
        rootView.setOnClickListener(v -> showCheese());

    }

    private void showCheese() {
        try {
            cheese.setVisibility(View.INVISIBLE);
            int r = random.nextInt(34) + 1;
            String imageName;
            String soundName;

            if (r == 34) {
                r = random.nextInt(34) + 1;
            }
            if (r == 34) {
                imageName = "potato";
                soundName = "imposter";
            } else {
                imageName = "cheese" + r;
                soundName = "cheese" + r;
            }
            int imageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
            cheese.setImageResource(imageId);
            cheese.setVisibility(View.VISIBLE);
            if (mp != null) {
                mp.release();
            }
            int soundId = getResources().getIdentifier(soundName, "raw", getPackageName());
            mp = MediaPlayer.create(MainActivity.this, soundId);
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}