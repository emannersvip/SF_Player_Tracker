package com.empiregamesstudio.sfplayertracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.EditText;


public class AddNew extends Activity {
    public final static String XBOX_NAME = "com.empiregamesstudio.MESSAGE1";
    public final static String XBOX_CHAR = "com.empiregamesstudio.MESSAGE2";
    public final static String XBOX_DESC = "com.empiregamesstudio.MESSAGE3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the AddNew button */
    public void addNew(View view) {
        //Do something in response to the button press
        Intent intent = new Intent(this, DisplayAddedUserActivity.class);

        EditText editText = (EditText) findViewById(R.id.editText_name);
        String message = editText.getText().toString();
        intent.putExtra(XBOX_NAME, message);

        editText = (EditText) findViewById(R.id.editText_char);
        message = editText.getText().toString();
        intent.putExtra(XBOX_CHAR, message);

        editText = (EditText) findViewById(R.id.editText_desc);
        message = editText.getText().toString();
        intent.putExtra(XBOX_DESC, message);

        startActivity(intent);

    }
}
