package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

/**
 * Created by mdd23 on 8/8/2016.
 */
public class JokeCloudAsyncTaskTest extends AndroidTestCase{
    public void jokeCloud_getsJoke(){
        final String[] joke = new String[1];
        (new JokeCloudAsyncTask(){
            @Override
            protected void onPostExecute(String jokeResult) {
                joke[0] = jokeResult;
            }
        }).execute();
        assertEquals(joke[0],"Hey");
    }
}
