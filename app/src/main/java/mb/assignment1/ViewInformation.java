package mb.assignment1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewInformation extends AppCompatActivity {

   LinearLayout LL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_information);
        LL = findViewById(R.id.lL);
        getData();
    }

    public void getData(){
        SharedPreferences sp = this.getSharedPreferences("mb.assignment1" , Context.MODE_PRIVATE);
        String All = sp.getString("Info", "");
        String[] temp = All.split("-");
        //Splits the entered data by line

        boolean isFirst = true;
        for(String S: temp){
            if(!isFirst) {
                TextView TV = new TextView(getApplicationContext());
                TV.setTextSize(30);
                TV.setText(S);
                LL.addView(TV);
            }
            else{
                isFirst = false;
            }
        }
    }
}
