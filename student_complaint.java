import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hsalf.smilerating.SmileRating;
public class Student_complaints extends AppCompatActivity {
SmileRating sr;
EditText et;
Button bu;
DatabaseReference databaseComplaints;
int i;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
FirebaseApp.initializeApp(this);
setContentView(R.layout.activity_student_complaints);
databaseComplaints = FirebaseDatabase.getInstance().getReference("complaints");
et = (EditText) findViewById(R.id.editText4);
getSupportActionBar().setTitle("Student Complaints");
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
sr = (SmileRating) findViewById(R.id.smile_rating);
bu = (Button) findViewById(R.id.button12);
sr.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
@Override
public void onSmileySelected(int smiley, boolean reselected) {
switch (smiley) {
case SmileRating.BAD:
Toast.makeText(Student_complaints.this, "BAD",
Toast.LENGTH_SHORT).show();
break;
case SmileRating.GOOD:
Toast.makeText(Student_complaints.this, "GOOD",
Toast.LENGTH_SHORT).show();
break;
case SmileRating.GREAT:
Toast.makeText(Student_complaints.this, "GREAT",
Toast.LENGTH_SHORT).show();
break;
case SmileRating.OKAY:
Toast.makeText(Student_complaints.this, "OKAY",
Toast.LENGTH_SHORT).show();
break;
case SmileRating.TERRIBLE:
Toast.makeText(Student_complaints.this, "TERRIBLE",
Toast.LENGTH_SHORT).show();
break;
}
}
});
sr.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
@Override
public void onRatingSelected(int level, boolean reselected) {
i = level;
Toast.makeText(Student_complaints.this, "Selected rating " + level,
Toast.LENGTH_SHORT).show();
}
});
bu.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
addDetails();
}
});
}
public void addDetails()
{
String complaint = et.getText().toString().trim();
String id= databaseComplaints.push().getKey();
if(!TextUtils.isEmpty(complaint))
{
Complaints comp = new Complaints(id,complaint,i);
databaseComplaints.child(id).setValue(comp);
Toast.makeText(this,"Feedback Added",Toast.LENGTH_LONG).show();
}
else
{
Complaints comp = new Complaints(id,complaint,i);
databaseComplaints.child(id).setValue(comp);
Toast.makeText(this,"Feedback Added",Toast.LENGTH_LONG).show();
}
}
}
