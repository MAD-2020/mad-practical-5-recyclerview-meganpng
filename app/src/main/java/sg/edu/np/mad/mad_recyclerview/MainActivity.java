package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "To-Do List";
    EditText input;
    Button button;
    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        input = findViewById(R.id.editText);
        final ArrayList<String> todoList = new ArrayList<>();
        todoList.add("Buy milk");
        todoList.add("Send postage");
        todoList.add("Buy Android development book");

        final RecyclerView rv = findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(todoList);

        LinearLayoutManager layout = new LinearLayoutManager(this);

        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.addOnItemTouchListener(
            new RecyclerTouchListener(this, rv, new RecyclerViewClickListener() {
                @Override
                public void onClick(View v, final int position) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                    LayoutInflater inflater = getLayoutInflater();
                    String task = todoList.get(position);

                    builder.setTitle("Delete");
                    builder.setMessage("Are you sure you want to delete " + task + "?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                            Log.v(TAG, "User deletes item!");
                            todoList.remove(position);
                            adapter.notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Log.v(TAG, "User does not delete item!");

                        }
                    });
                    //builder.setView(layout);
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }){

            }

        );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = (EditText)findViewById(R.id.editText);
                String enteredText = input.getText().toString();
                adapter.notifyDataSetChanged();
                todoList.add(enteredText);
                showNewEntry(rv, todoList);
                input.setText("");



            }
        });
    }



    private void showNewEntry(RecyclerView rv, ArrayList todoList){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(todoList.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }



    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }





}
