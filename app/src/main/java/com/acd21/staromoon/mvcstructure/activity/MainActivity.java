package com.acd21.staromoon.mvcstructure.activity;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.acd21.staromoon.mvcstructure.R;
import com.acd21.staromoon.mvcstructure.fragment.MainFragment;
import com.acd21.staromoon.mvcstructure.fragment.SecondFragment;
import com.acd21.staromoon.mvcstructure.utils.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        //Toast.makeText(MainActivity.this,screenWidth + "   " + screenHeight,Toast.LENGTH_SHORT).show();

        if(savedInstanceState == null){
            //First time Created
            getSupportFragmentManager().beginTransaction()      //เตรียมแปะ fragment
                    .add(R.id.contentContainer, MainFragment.newInstance(123), "MainFragment")
                    .commit();
            /*MainFragment fragment = (MainFragment) getSupportFragmentManager()
                    .findFragmentByTag("MainFragment");
             fragment.setNameText("WOOHOO");      เช็ตไม่ได้เพราะยังไม่ได้แปะ fragment  */
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {        //เรียกหลัง onCreate
        super.onPostCreate(savedInstanceState);

        if(savedInstanceState == null){
            MainFragment fragment = (MainFragment) getSupportFragmentManager()
                    .findFragmentByTag("MainFragment");
            fragment.setNameText("WOOHOO");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_switch:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer, SecondFragment.newInstance())
                        .addToBackStack(null)       //ทำให้เป็น BackStack
                        .commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
