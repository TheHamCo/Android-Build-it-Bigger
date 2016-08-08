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
        (new JokeCloudAsyncTask(){
            @Override
            protected void onPostExecute(String jokeResult) {
                assertEquals("A skeleton walks into a bar and orders a beer and a mop.",jokeResult);
            }
        }).execute();
    }
}
