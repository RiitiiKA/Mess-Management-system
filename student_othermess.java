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
public class student_other_mess extends AppCompatActivity implements
View.OnClickListener{
private Button button5,button6,button7,button8;
private TextView Menu;
String itemvalue;
Spinner dropdownmenu;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_student_other_mess);
getSupportActionBar().setTitle("Other Mess");
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
button5 = (Button) findViewById(R.id.button18);
button6 = (Button) findViewById(R.id.button19);
button7 = (Button) findViewById(R.id.button20);
button8 = (Button) findViewById(R.id.button22);
Menu =(TextView) findViewById(R.id.textView7);
button5.setOnClickListener(this);
button6.setOnClickListener(this);
button7.setOnClickListener(this);
button8.setOnClickListener(this);
dropdownmenu = (Spinner) findViewById(R.id.spinner4);
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
public void onItemSelected(AdapterView<?> parent, View, int position, long id) {
itemvalue = parent.getItemAtPosition(position).toString();
Toast.makeText(student_other_mess.this,"Selected " + itemvalue,
Toast.LENGTH_SHORT).show();
}
@Override
public void onNothingSelected(AdapterView<?> parent) {
}
});
}
DataAccessManager a =new DataAccessManager();
@Override
public void onClick(View v){
switch(v.getId()){
case R.id.button18:
String breakfast=a.getbreakfast(itemvalue);
if(breakfast.equals("Not found")) {
Menu.setText("");
Menu.setText("BREAKFAST");
}
else
{
Menu.setText(breakfast);
}
break;
case R.id.button19:
String lunch = a.getlunch(itemvalue);
if(lunch.equals("Not found")) {
Menu.setText("");
Menu.setText("LUNCH");
}
else
{
Menu.setText(lunch);
}
break;
case R.id.button20:
String snacks = a.getsnacks(itemvalue);
if(snacks.equals("Not found")) {
Menu.setText("");
Menu.setText("SNACKS");
}
else
{
Menu.setText(snacks);
}
break;
case R.id.button22:
String dinner= a.getdinner(itemvalue);
if(dinner.equals("Not found")) {
Menu.setText("");
Menu.setText("DINNER");
}
else
{
Menu.setText(dinner);
}
break;
}
}
}
