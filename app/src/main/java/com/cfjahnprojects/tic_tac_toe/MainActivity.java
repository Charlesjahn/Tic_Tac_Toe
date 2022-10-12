package com.cfjahnprojects.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int turn =0;
    private int[][] board;
    private int player = 0;
    private int[][] imagePositions = {
            {R.id.place00,R.id.place01,R.id.place02,},
            {R.id.place10,R.id.place11,R.id.place12,},
            {R.id.place20,R.id.place21,R.id.place22,}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void choosePosition(View view){
        int idImage = view.getId();
        ImageView imageView = findViewById(idImage);

        if((this.turn%2) == 0){
            imageView.setImageResource(R.drawable.xttt);
            setBoardGame(idImage);
        }else{
            imageView.setImageResource(R.drawable.circlettt);
            setBoardGame(idImage);
        }
        this.turn +=1;
        imageView.setOnClickListener(null);
    }

    private void setBoardGame(int idPlace){
        for(int i=0;i>3;i++){
            for(int j=0;j>3;j++){
                if(this.imagePositions[i][j]==idPlace){
                    this.board[i][j]=this.turn%2;
                }
            }
        }
    }

}