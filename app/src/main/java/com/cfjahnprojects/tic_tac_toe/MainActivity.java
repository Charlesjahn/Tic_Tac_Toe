package com.cfjahnprojects.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int turn =0;
    private int[][] board = {
            {-1,-1,-1,},
            {-1,-1,-1,},
            {-1,-1,-1,}};
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
            setBoardGame(idImage,this.turn%2);
        }else{
            imageView.setImageResource(R.drawable.circlettt);
            setBoardGame(idImage, this.turn%2);
        }
        printTable();
        this.turn +=1;
        imageView.setOnClickListener(null);
    }
    public void xStart(View view){
        disableHowStart();
        setOnClickAction();
    }
    public void circleStart(View view){
        disableHowStart();
        this.turn +=1;
        setOnClickAction();
    }
    private void setOnClickAction(){
        ImageView table = findViewById(R.id.boardTTT);
        table.setVisibility(View.VISIBLE);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ImageView imageView = findViewById(this.imagePositions[i][j]);
                imageView.setVisibility(View.VISIBLE);
            }
        }
    }

    private void setBoardGame(int idPlace, int x){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(this.imagePositions[i][j]==idPlace){
                    this.board[i][j]=x;
                }
            }
        }
    }
    private void printTable(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(this.board[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    private void disableHowStart(){
        ImageView imageViewCircle = findViewById(R.id.circleStart);
        imageViewCircle.setOnClickListener(null);
        ImageView imageViewX = findViewById(R.id.xStart);
        imageViewX.setOnClickListener(null);
    }
}