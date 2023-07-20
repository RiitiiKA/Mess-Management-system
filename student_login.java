import android.content.Intent;
importandroid.support.v7.app.AppCompatActiviy;
import android.os.Bundle;
import android.view.View;
import
android.widget.Button;
import
android.widget.EditText;
import android.widget.Toast;
public class manager_login extends
AppCompatActivity { private Button;
private EditText
password,editText; @Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_manager_login);
getSupportActionBar().setTitle("Manager Login");
getSupportActionBar().setDisplayHomeAsUpEnabled(tr
ue); button = (Button) findViewById(R.id.button4);
editText = (EditText) findViewById(R.id.editText2);
password = (EditText) findViewById(R.id.editText3);
button.setOnClickListener(new
View.OnClickListener() {
@Override
public void onClick(View v)
{ if(validate()) {
openActivity1(
); finish();
}
else {
openDialog();
password.setText(""
);
editText.setText("");
}
}
});
}
public void openActivity1()
{
Intent intent1 = new
Intent(this,Main2Activity.class);
startActivity(intent1);
}
public void openDialog()
{
Ex2Dialog e = new Ex2Dialog();
e.show(getSupportFragmentManager(),"Dialo
g");
}
private Boolean validate()
{
Boolean result = false;
String
name=editText.getText().toString().trim();
String pass=password.getText().toString();
if(name.isEmpty() && pass.isEmpty())
Toast.makeText(this, "Please Enter All The
Details", Toast.LENGTH_SHORT).show();
}
else if((name.equals("Prmess")) && (pass.equals("hello")))
{
Toast.makeText(this, "LOGIN SUCCESSFUL",
Toast.LENGTH_SHORT).show();
result = true;
}
return result;
}
