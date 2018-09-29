package l.com.ldk.duykhanh.b6_sqlite.DATA;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import l.com.ldk.duykhanh.b6_sqlite.MODEL.Student;

public class DBManager extends SQLiteOpenHelper {
    private final String TAG = "DBManager";

    private static final String DATABASE_NAME = "STUDENT_MANAGER";
    private static int VERSION = 1;

    private static final String TABLE_NAME = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PHONE_NUMBER = "phone";
    private static final String ADDRESS = "address";
    private static final String EMAIL = "email";

    private Context context;
    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT, " +
            PHONE_NUMBER + " TEXT, " +
            ADDRESS + " TEXT," +
            EMAIL + " TEXT)";


    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
        Log.d(TAG, "DBManager: ");
    }

    //Tạo bảng trong database ( chỉ gọi 1 lần)
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
    }


    public void addStudent(Student student) {

        //Taọ và mở database.
        SQLiteDatabase db = this.getWritableDatabase();

        //Thông qua ContentValues để truyền dữ liệu vào database
        ContentValues values = new ContentValues();
        values.put(NAME, student.getmName());
        values.put(PHONE_NUMBER, student.getmPhoneNumber());
        values.put(ADDRESS, student.getmAddress());
        values.put(EMAIL, student.getmEmail());
        db.insert(TABLE_NAME, null, values);

        //Đóng database để đảm bảo tính an toàn
        db.close();
        Log.d(TAG, "addStudent: ");
    }

    //Lấy tất cả danh sách student

    public List<Student> getAllStudent() {

        //Tạo List<Student> để chứa danh sách student

        List<Student> listStudent = new ArrayList<>();

        //Câu lênh truy vấn toàn bộ dữ liệu trong database
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();

        //Cursor : con trỏ chứa kết quả trả về
        Cursor cursor = db.rawQuery(selectQuery, null); //selectionArgs: Điều kiện để select
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setmID(cursor.getInt(0));
                student.setmName(cursor.getString(1));
                student.setmPhoneNumber(cursor.getString(2));
                student.setmAddress(cursor.getString(3));
                student.setmEmail(cursor.getString(4));

                listStudent.add(student);
            } while (cursor.moveToNext());
        }
        db.close();
        return listStudent;
    }
}
