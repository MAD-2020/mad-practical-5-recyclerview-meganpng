package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import sg.edu.np.mad.mad_recyclerview.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    CheckBox checkBox;
    ConstraintLayout constraintLayout;

    public RecyclerViewHolder(View v){
        super(v);
        txt = v.findViewById(R.id.taskname);
        checkBox = v.findViewById(R.id.checkBox);
        constraintLayout = v.findViewById(R.id.tasklayout);
    }
}