package aj.hw8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    /** Called when the user taps the Send button */
    public void Add2DatabaseButton(View view) {

        EditText editTextID = (EditText)findViewById(R.id.editTextEID);
        EditText editTextName = (EditText)findViewById(R.id.editTextLastName);
        EditText editTextTitleID = (EditText)findViewById(R.id.editTextTitleID);

        int ID = Integer.parseInt(editTextID.getText().toString());
        String name = editTextName.getText().toString();
        String titleID = editTextTitleID.getText().toString();

        // Create Employee object
        Employee employee = new Employee(ID, name, titleID);

        // Call Database Handler
        DBHandler dbhandler = new DBHandler(null);

        // Display a message
        TextView textView = findViewById(R.id.txtDoingStuff);
        textView.setText("Doing Stuff");
    }
}
