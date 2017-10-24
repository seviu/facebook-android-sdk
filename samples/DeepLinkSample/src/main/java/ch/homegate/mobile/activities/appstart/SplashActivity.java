package ch.homegate.mobile.activities.appstart;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.applinks.AppLinkData;

/**
 * Created by vis on 10/3/17.
 */
public class SplashActivity extends Activity {
    private static final String TAG = SplashActivity.class.getCanonicalName();

    /**
     * Test with deep links like android-app://www.homegate.ch/app_campaign/android/search?aqt=RENT&loc=Zürich
     *
     * The URL for the ads helper is: https://developers.facebook.com/tools/app-ads-helper/?id=695234790618907
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppLinkData data =  AppLinkData.createFromActivity(this);
        if (data != null) {
            Log.d(TAG, data.toString());
        }
    }
}
