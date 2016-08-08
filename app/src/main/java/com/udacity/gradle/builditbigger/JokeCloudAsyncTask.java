package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.mdd23.myapplication.joketellercloud.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by mdd23 on 8/8/2016.
 */
public class JokeCloudAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService==null){ //Singleton - do this only once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.1.14:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            // Turn off compression when running against local devappserver
                            request.setDisableGZipContent(true);
                        }
                    });
            //END options for devapp server

            myApiService = builder.build();
        }

        try{
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e ){
            return e.getMessage();
        }
    }
}
