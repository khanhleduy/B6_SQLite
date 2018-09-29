package l.com.ldk.duykhanh.b6_sqlite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import l.com.ldk.duykhanh.b6_sqlite.ADAPTER.StudentAdapter;
import l.com.ldk.duykhanh.b6_sqlite.DATA.DBManager;
import l.com.ldk.duykhanh.b6_sqlite.MODEL.Student;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtPhone, edtAddress, edtEmail;
    private Button btnSave;
    private ListView lvListView;
    private DBManager dbManager;
    private StudentAdapter adapter;
    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager = new DBManager(this);
        initWidget();
        students = dbManager.getAllStudent();
        setAdapter();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = createStudent();
                if (student != null) {
                    dbManager.addStudent(student);
                }

                students.clear();
                students.addAll(dbManager.getAllStudent());
                setAdapter();
            }
        });
    }

    private Student createStudent() {
        String name = edtName.getText().toString();
        String phone = String.valueOf(edtPhone.getText());
        String address = edtAddress.getText() + "";
        String email = edtEmail.getText().toString();

        Student student = new Student(name, phone, address, email);

        return student;
    }

    public void initWidget(){
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);
        edtEmail = findViewById(R.id.edtEmail);
        btnSave = findViewById(R.id.btnSave);
        lvListView = findViewById(R.id.lvListView);
    }

    public void setAdapter(){
        if(adapter == null){
            adapter = new StudentAdapter(this,R.layout.item_list_student,students);
        }
        else{
        adapter.notifyDataSetChanged();
        lvListView.setSelection(adapter.getCount()-1);
        }
        lvListView.setAdapter(adapter);
     }
}
