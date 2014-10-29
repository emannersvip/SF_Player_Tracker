package com.empiregamesstudio.sfplayertracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Layout;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class DisplayAddedUserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the message from the intent
        Intent intent = getIntent();
        String message_name = intent.getStringExtra(AddNew.XBOX_NAME);
        String message_char = intent.getStringExtra(AddNew.XBOX_CHAR);
        String message_desc = intent.getStringExtra(AddNew.XBOX_DESC);



        //Create the text view
        TextView textView_name = new TextView(this);
        textView_name.setTextSize(40);
        textView_name.setText(message_name);
        textView_name.setId(100);

        TextView textView_char = new TextView(this);
        textView_char.setTextSize(40);
        textView_char.setText(message_char);
        textView_char.setId(101);

        TextView textView_desc = new TextView(this);
        textView_desc.setTextSize(40);
        textView_desc.setText(message_desc);
        textView_desc.setId(102);


        //Since this is dynamic I need to create a layout
        //As per http://stackoverflow.com/questions/4979212/programmatically-creating-a-relativelayout-in-android
        RelativeLayout relativeLayout = new RelativeLayout(this);

        //Defining thr RelaticeLayout layout parameters.
        //In this case I want to fill its parent
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);

        //Defining the layout parameters of the Textview
        RelativeLayout.LayoutParams lp_char = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_char.addRule(RelativeLayout.BELOW, textView_name.getId());

        RelativeLayout.LayoutParams lp_desc = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp_desc.addRule(RelativeLayout.BELOW, textView_char.getId());

        //Setting the parameters on the TextView
        //textView_name.setLayoutParams(lp);
        //textView_char.setLayoutParams(lp);

        //Adding the TextView to the RelativeLayout as a child
        relativeLayout.addView(textView_name);
        relativeLayout.addView(textView_char, lp_char);
        relativeLayout.addView(textView_desc, lp_desc);


        //Set the text view as the activity layout
        //setContentView(textView_name);
        //setContentView(R.layout.activity_display_added_user);
        setContentView(relativeLayout, rlp);
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


}
