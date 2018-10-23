package mb.assignment1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EnterInformation extends AppCompatActivity {

    EditText editText;
    EditText editText1;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_information);

        editText = findViewById(R.id.PhotographerNameET);
        editText1 = findViewById(R.id.PhotoNameET);
        spinner = findViewById(R.id.spinner1);

        String[] years = new String[50];
        int year = 1970;
        for(int i = 0; i < 50; i++, year++){
            years[i] = (year + "");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years);
        spinner.setAdapter(adapter);
        //Displays years
    }

    public void Done(View view){
        if(CheckifFilled()) {
            //Saving with Shared Preferences
            SharedPreferences sp = this.getSharedPreferences("mb.assignment1" , Context.MODE_PRIVATE);
            String toAdd = editText.getText().toString() + " " + editText1.getText().toString() + " " + spinner.getSelectedItem().toString();
            String OldText = sp.getString("Info", "");
            String Both = OldText + "-" + toAdd;
            //adds to Overall String stored in SP
            sp.edit().putString("Info", Both).apply();
            finish();
            //Goes back to Main Activity
        }
    }

    public boolean CheckifFilled(){
        String name = editText.getText().toString();
        String name1 = editText1.getText().toString();

        //Checks for valid input
        if(name.isEmpty() || name1.isEmpty()){
            Toast.makeText(this, "Fill out All Fields Please", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
