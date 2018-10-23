package mb.assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnterInfo(View view) {
        Intent I = new Intent(this, EnterInformation.class);
        startActivity(I);
        //Jump to Enter Info
    }

    public void View(View view){
        Intent I1 = new Intent(this, ViewInformation.class);
        startActivity(I1);
        //Jumps to View.
    }

    public void Exit(View view){
        SharedPreferences sp = this.getSharedPreferences("mb.assignment1" , Context.MODE_PRIVATE);
        sp.edit().remove("Info").apply();
        //Removed all data in sp
        finish();
        //Exits Application
    }
}
