import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
public class Student_my_mess extends AppCompatActivity implements
View.OnClickListener,CompoundButton.OnCheckedChangeListener {
private Button button5,button6,button7,button8;
private EditText Menu;
private TextView t1,t2;
String l,m,mn,p;
DatabaseAccess k= new DatabaseAccess();
private Switch s1,s2,s3,s4;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_student_my_mess);
getSupportActionBar().setTitle("My Mess");
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
s1 = (Switch) findViewById(R.id.switch1);
s2 = (Switch) findViewById(R.id.switch2);
s3 = (Switch) findViewById(R.id.switch3);
s4 = (Switch) findViewById(R.id.switch4);
t1=(TextView)findViewById(R.id.get_name);
t2=(TextView)findViewById(R.id.mess_name1);
Intent jk= getIntent();
l=jk.getStringExtra("Value1");
p=jk.getStringExtra("Value2");
m=k.student_name("20BCE2321");
mn=k.mess_name("20BCE2321");
t1.setText(m);
t2.setText(mn);
button5 = (Button) findViewById(R.id.button5);
button6 = (Button) findViewById(R.id.button6);
button7 = (Button) findViewById(R.id.button7);
button8 = (Button) findViewById(R.id.button8);
Menu =(EditText) findViewById(R.id.fooditem);
button5.setOnClickListener(this);
button6.setOnClickListener(this);
button7.setOnClickListener(this);
button8.setOnClickListener(this);
s1.setOnCheckedChangeListener(this);
s2.setOnCheckedChangeListener(this);
s3.setOnCheckedChangeListener(this);
s4.setOnCheckedChangeListener(this);
}
DataAccessManager a= new DataAccessManager();
@Override
public void onClick(View v){
switch(v.getId()){
case R.id.button5:
String breakfast=a.getbreakfast(mn);
if(breakfast.equals("Not found")) {
Menu.setText("");
Menu.setText("BREAKFAST");
}
else
{
Menu.setText(breakfast);
}
break;
case R.id.button6:
String lunch = a.getlunch(mn);
if(lunch.equals("Not found")) {
Menu.setText("");
Menu.setText("LUNCH");
}
else
{
Menu.setText(lunch);
}
break;
case R.id.button7:
String snacks = a.getsnacks(mn);
if(snacks.equals("Not found")) {
Menu.setText("");
Menu.setText("SNACKS");
}
else
{
Menu.setText(snacks);
}
break;
case R.id.button8:
String dinner= a.getdinner(mn);
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
@Override
public void onCheckedChanged(CompoundButton bv, boolean isChecked) {
switch(bv.getId())
{
case R.id.switch1:
if(isChecked){
Toast.makeText(this,"BreakFast Notification ON",
Toast.LENGTH_SHORT).show();
}
else{
Toast.makeText(this, "BreakFast Notification OFF",
Toast.LENGTH_SHORT).show();
}
break;
case R.id.switch2:
if(isChecked){
Toast.makeText(this,"Lunch Notification ON", Toast.LENGTH_SHORT).show();
}
else{
Toast.makeText(this,"LunchNotificationOFF", Toast.LENGTH_SHORT).show();
}
break;
case R.id.switch3:
if(isChecked){
Toast.makeText(this,"SnacksNotification ON", Toast.LENGTH_SHORT).show();
}
else{
Toast.makeText(this, "Snacks Notification OFF",
Toast.LENGTH_SHORT).show();
}
break;
case R.id.switch4:
if(isChecked){
Toast.makeText(this,"DinnerNotification ON", Toast.LENGTH_SHORT).show();
}
else{
Toast.makeText(this, "Dinner Notification OFF",
Toast.LENGTH_SHORT).show();
}
break;
}
}
}
