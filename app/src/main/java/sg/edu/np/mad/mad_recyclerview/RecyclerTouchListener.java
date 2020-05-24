package sg.edu.np.mad.mad_recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import sg.edu.np.mad.mad_recyclerview.MainActivity;
import android.view.GestureDetector;
import android.view.View;
import android.content.Context;
import android.view.MotionEvent;



public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{
    private GestureDetector gestureDetector;
    private MainActivity.RecyclerViewClickListener clickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity.RecyclerViewClickListener clickListener) {
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
