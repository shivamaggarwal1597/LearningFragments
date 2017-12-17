package com.example.shivam.learningfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shivam.learningfragments.utils.MyConfig;
import com.example.shivam.learningfragments.utils.TinyDB;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class SplashScreen extends AppCompatActivity {
    TwitterLoginButton loginButton;
    TinyDB tinyDB;
    MyConfig myConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        setContentView(R.layout.activity_splash_screen);
            tinyDB = new TinyDB(SplashScreen.this);
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                myConfig = new MyConfig(true);
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;
                    myConfig.setId_of_user(session.getUserId());
                    myConfig.setName_of_user(session.getUserName());
                     tinyDB.putObject("my_config_object",myConfig);
                login(session);



            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Toast.makeText(SplashScreen.this,"Failure",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void login(TwitterSession twitterSession){
        String username = twitterSession.getUserName();
        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
