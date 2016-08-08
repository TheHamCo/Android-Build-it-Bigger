package co.dijam.michael.joketellerandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static String JOKE_EXTRA = "je";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra(JOKE_EXTRA);
        TextView jokeTextView = (TextView) findViewById(R.id.joke_text_view);

        if (joke!=null && !joke.equals("")) {
            jokeTextView.setText(joke);
        }
    }
}
