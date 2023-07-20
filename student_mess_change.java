import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class Student_mess_change extends AppCompatActivity {
String itemvalue;
Spinner dropdownmenu;
TextView t1;
Button b1;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_student_mess_change);
getSupportActionBar().setTitle("Mess Change");
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
t1=(TextView)(findViewById(R.id.textView4));
b1=(Button)(findViewById(R.id.button9));
dropdownmenu = (Spinner) findViewById(R.id.spinner);
List<String> list=new ArrayList<>();
list.add("PR 1 - VEG MESS (B-ANNEX)");
list.add("PR 2 - SPECIAL MESS (B-ANNEX)");
list.add("SKC 1 - NON VEG MESS (OPP TO F-BLOCK)");
list.add("SKC 2 - SPECIAL MESS (OPP TO F-BLOCK)");
list.add("RSM 1 - VEG MESS (G-BLOCK)");
list.add("RSM 2 - SPECIAL MESS (G-BLOCK)");
list.add("CRC 1 - VEG MESS (H-BLOCK)");
list.add("CRC 2 - NON VEG MESS (H-BLOCK)");
list.add("CRC 3 - SPECIAL MESS (J-BLOCK)");
list.add("CRC 4 - FOOD PARKK (J-BLOCK)");
list.add("RRC 1 - VEG MESS (L-BLOCK)");
list.add("RRC 2 - NON VEG MESS (L-BLOCK)");
list.add("RRC 3 - SPECIAL MESS (L-BLOCK)");
list.add("RRC 4 - SPECIAL MESS (D- ANNEX)");
list.add("RRC 5 - FOOD MALL (L-BLOCK)");
list.add("MHPL 1 - VEG MESS (F-BLOCK)");
list.add("MHPL 2 - SPECIAL MESS (F-BLOCK)");
list.add("AAC 1 - NON VEG MESS (F-BLOCK)");
list.add("AAC 2 - SPECIAL MESS (F-BLOCK)");
list.add("ZEN 1 - VEG MESS (K-BLOCK)");
list.add("ZEN 2 - NON VEG (K-BLOCK)");
list.add("ZEN 3 - SPECIAL (K-BLOCK)");
list.add("ZEN 4 - FOODCY (K-BLOCK)");
list.add("PR 3 - VEG MESS (P-BLOCK)");
list.add("PR 4 - SPECIAL MESS (P-BLOCK)");
list.add("DR 1 - NON VEG (P-BLOCK)");
list.add("DR 2 - SPECIAL MESS (P-BLOCK)");
list.add("PRD 1- VEG MESS (Q-block)");
list.add("PRD 2- Buddies & Bites (Q-block)");
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
android.R.layout.simple_spinner_item, list);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
dropdownmenu.setAdapter(adapter);
dropdownmenu.setOnItemSelectedListener(new
AdapterView.OnItemSelectedListener() {
@Override
id){
public void onItemSelected(AdapterView<?> parent, View view, int position, long
itemvalue = parent.getItemAtPosition(position).toString();
Toast.makeText(Student_mess_change.this,"Selected " + itemvalue,
Toast.LENGTH_SHORT).show();
t1.setText(itemvalue);
}
@Override
public void onNothingSelected(AdapterView<?> parent) {
}
});
b1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
DatabaseAccess g= new DatabaseAccess();
String p=g.mess_name("19BCB0015");
g.changemess(itemvalue,p);
Toast.makeText(Student_mess_change.this, "MESS SUCCESSFULLY CHANGED",
Toast.LENGTH_SHORT).show();
}
});
}
}