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
    /** Called when the user taps the Add to Database button */
    public void Add2DatabaseButton(View view) {

        // Create
        EditText editTextID = (EditText)findViewById(R.id.editTextEID);
        EditText editTextName = (EditText)findViewById(R.id.editTextLastName);
        EditText editTextTitleID = (EditText)findViewById(R.id.editTextTitleID);

        String ID = editTextID.getText().toString();
        String name = editTextName.getText().toString();
        String titleID = editTextTitleID.getText().toString();

        // Create Employee object
        Employee employee = new Employee(ID, name, titleID);

        // Create Database Handler
        DBHandler dbhandler = new DBHandler(null);

        // Call Database Handler to Add to Database
        dbhandler.AddToDatabase(employee);

        //Call Database Handler to Query Database
        Employee employeeView = new Employee();
        employeeView = dbhandler.QueryDatabase(employee.GetterID());

        // Display a message
        TextView textView = findViewById(R.id.txtDoingStuff);
        textView.setText("Done");

        String showID = employeeView.GetterID(), showName = employeeView.GetterName(), showTitleID = employee.GetterTitleID();

        TextView dbText = findViewById(R.id.txtDB);
        textView.setText("User ID: " + showID + "\n" + "Last Name: " + showName + "\n" + "Title ID: " + showTitleID);
    }
}
