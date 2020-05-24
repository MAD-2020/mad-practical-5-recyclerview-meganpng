package sg.edu.np.mad.mad_recyclerview;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import java.util.ArrayList;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    ArrayList<String> taskList;
    public RecyclerViewAdapter(ArrayList<String> data){
        taskList = data;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View task = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_post, parent, false);
        Log.d("RV", "onCreate");

        return new RecyclerViewHolder(task);
    }

    public void onBindViewHolder(@NonNull
                                         RecyclerViewHolder holder,
                                 int position) {
        String information = taskList.get(position);
        holder.txt.setText(information);

        Log.d("RV", "onBind" + position );
    }

    public int getItemCount() {
        return taskList.size();
    }

}


