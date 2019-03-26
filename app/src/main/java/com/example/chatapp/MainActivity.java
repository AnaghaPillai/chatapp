package com.example.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText userInput;
    RecyclerView recyclerView;
    List<ResponseMessage> responseMessagesList;
    MessageAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput=findViewById(R.id.userInput);
        recyclerView=findViewById(R.id.conversation);
        responseMessagesList= new ArrayList<>();
        messageAdapter = new MessageAdapter(responseMessagesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(messageAdapter);
        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEND){
                    Toast.makeText(MainActivity.this, "keri", Toast.LENGTH_SHORT).show();
                    ResponseMessage message = new ResponseMessage(userInput.getText().toString(), true);
                    responseMessagesList.add(message);
                    ResponseMessage message2 = new ResponseMessage(userInput.getText().toString(), false);
                    responseMessagesList.add(message2);
                     messageAdapter.notifyDataSetChanged();
                }
            return true;
            }
        });
    }
}
