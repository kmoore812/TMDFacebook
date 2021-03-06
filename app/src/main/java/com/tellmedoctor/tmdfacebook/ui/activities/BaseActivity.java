package com.tellmedoctor.tmdfacebook.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tellmedoctor.tmdfacebook.ui.fragments.NavigationDrawerFragment;
import com.tellmedoctor.tmdfacebook.utils.PrefsUtils;

/**
 * Created by kmoore on 5/2/15.
 */
public class BaseActivity extends ActionBarActivity {

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!PrefsUtils.getEulaAccepted(this) || !PrefsUtils.getFBAuth(this)) {
            // onNavigationDrawerItemSelected(EULA);

            if(!PrefsUtils.getEulaAccepted(this)) {
                Intent EulaIntent = new Intent(this, WelcomeActivity.class);
                //String keyIdentifier_data_entry = "EulaActivity";
                //EulaIntent.putExtra("fragment", keyIdentifier_data_entry);
                startActivity(EulaIntent);
            }else

            if(!PrefsUtils.getFBAuth(this)){
                Intent FBIntent = new Intent(this, LoginActivity.class);
                //String keyIdentifier_data_entry = "EulaActivity";
                //EulaIntent.putExtra("fragment", keyIdentifier_data_entry);
                startActivity(FBIntent);
            }

            finish();
        }
    }
}