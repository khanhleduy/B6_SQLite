package l.com.ldk.duykhanh.b6_sqlite.ADAPTER;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import l.com.ldk.duykhanh.b6_sqlite.MODEL.Student;
import l.com.ldk.duykhanh.b6_sqlite.R;

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    private int resoure;
    private List<Student> listStudent;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resoure = resource;
        this.listStudent = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_student,parent,false);
            holder = new ViewHolder();
            holder.tvId = convertView.findViewById(R.id.tvID);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvPhone = convertView.findViewById(R.id.tvPhone);
            holder.tvAddress = convertView.findViewById(R.id.tvAddress);
            holder.tvEmail = convertView.findViewById(R.id.tvEmail);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        Student student = listStudent.get(position);
        holder.tvId.setText(String.valueOf(student.getmID()));
        holder.tvName.setText(student.getmName());
        holder.tvPhone.setText(student.getmPhoneNumber());
        holder.tvAddress.setText(student.getmAddress());
        holder.tvEmail.setText(student.getmEmail());


        return convertView;
    }

    public class ViewHolder{

        private TextView tvId;
        private TextView tvName;
        private TextView tvPhone;
        private TextView tvAddress;
        private TextView tvEmail;
    }
}
