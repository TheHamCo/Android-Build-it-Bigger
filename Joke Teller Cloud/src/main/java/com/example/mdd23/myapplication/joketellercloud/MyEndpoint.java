/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.mdd23.myapplication.joketellercloud;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "joketellercloud.myapplication.mdd23.example.com",
    ownerName = "joketellercloud.myapplication.mdd23.example.com",
    packagePath=""
  )
)
public class MyEndpoint {
    @ApiMethod(name = "getJoke")
    public MyJoke getJoke(){
        return new MyJoke();
    }

}
