package com.udacity.gradle.builditbigger;


import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class JokeCloudAsyncTaskTest {
    @Test
    public void jokeCloud_getsJoke(){
        final String[] joke = new String[1];
        (new JokeCloudAsyncTask(){
            @Override
            protected void onPostExecute(String jokeResult) {
                joke[0] = jokeResult;
            }
        }).execute();
        assertEquals(joke[0],"hey");
    }
}
