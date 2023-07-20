import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
public class Manager_complaints extends AppCompatActivity {
ListView;
FirebaseDatabase database;
DatabaseReference ref;
ArrayList<String> list;
ArrayAdapter <String> adapter;
Complaints;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_manager_complaints);
complaints= new Complaints();
getSupportActionBar().setTitle("Complaints List");
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
listView = (ListView) findViewById(R.id.list);
database = FirebaseDatabase.getInstance();
ref= database.getReference("complaints");
list = new ArrayList<>();
adapter = new ArrayAdapter<String>(this,R.layout.list_layout,R.id.textView5,list);
ref.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
for(DataSnapshot ds: dataSnapshot.getChildren())
{
complaints=ds.getValue(Complaints.class);
list.add(complaints.getFeedback().toString()+" \n " + "Rating : "+
complaints.getRating());
}
listView.setAdapter(adapter);
}
@Override
public void onCancelled(@NonNull DatabaseError databaseError) {
}
});
}
