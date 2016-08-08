package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.mdd23.myapplication.joketellercloud.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import co.dijam.michael.joketellerandroid.JokeActivity;

/**
 * Created by mdd23 on 8/8/2016.
 */
public class JokeCloudAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
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

        context = params[0];

        try{
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e ){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String jokeResult) {
        Intent jokeIntent = new Intent(context, JokeActivity.class);
        jokeIntent.putExtra(JokeActivity.JOKE_EXTRA, jokeResult);
        context.startActivity(jokeIntent);
    }
}
