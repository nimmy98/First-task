import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nimmy.listview.R;

/**
 * Created by Nimmy on 19-12-2016.
 */

public class CustomArrayAdapter extends ArrayAdapter<String> {
    Context context;
    int layoutRes;
    String cities[];
    public CustomArrayAdapter(Context context,int resource,String[] objects){
        super(context,resource,objects);
        this.context = context;
        layoutRes = resource;
        cities = objects;
    }
    static class ViewHolder{
        TextView textView;
    }

    public View getViw(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(layoutRes,parent,false);
            holder.textView = (TextView) convertView.findViewById(R.id.single_row_text);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(cities[position]);
        return convertView;
    }


}
