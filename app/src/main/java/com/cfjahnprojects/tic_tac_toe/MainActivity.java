package com.cfjahnprojects.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int player =0;
    private int turn = 0;
    private int[][] board = {
            {-1,-1,-1,},
            {-1,-1,-1,},
            {-1,-1,-1,}};
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
    public void reloadPageScreen(View view){
        finish();
        startActivity(getIntent());
    }
    public void choosePosition(View view){
        int idImage = view.getId();
        ImageView imageView = findViewById(idImage);

        if((this.player%2) == 0){
            imageView.setImageResource(R.drawable.xttt);
        }else{
            imageView.setImageResource(R.drawable.circlettt);
        }
        setBoardGame(idImage,this.player%2);
        removeOnClick(idImage);
        this.turn +=1;
        winnerFinal(isWon());
        this.player +=1;
        System.out.println(player);
    }
    public void xStart(View view){
        removeOnClick(R.id.circleStart);
        removeOnClick(R.id.xStart);
        setVisibility(R.id.boardTTT);
    }
    public void circleStart(View view){
        removeOnClick(R.id.circleStart);
        removeOnClick(R.id.xStart);
        this.player +=1;
        setVisibility(R.id.boardTTT);
    }

    private void setVisibility(int idImage){
        ImageView table = findViewById(idImage);
        table.findViewById(idImage).setVisibility(View.VISIBLE);
    }

    private void setBoardGame(int idPlace, int x){
        for(int i=0;i<this.imagePositions.length;i++){
            for(int j=0;j<this.imagePositions.length;j++){
                if(this.imagePositions[i][j]==idPlace){
                    this.board[i][j]=x;
                }
            }
        }
    }
    private void winnerFinal(boolean tf){
        TextView textWin = findViewById(R.id.textWinner);
        if(tf){
            textWin.setText("WON");
            textWin.setTextColor(Color.BLUE);
            int winner = this.player%2;
            ImageView imagewinner;
            if(winner == 0){
                imagewinner = findViewById(R.id.circleStart);
            }else{
                imagewinner = findViewById(R.id.xStart);
            }
            for(int i=0;i<this.imagePositions.length;i++){
                for(int j=0;j<this.imagePositions.length;j++){
                    removeOnClick(this.imagePositions[i][j]);
                }
            }
            imagewinner.setVisibility(View.INVISIBLE);
        }else if(this.turn >=9){
            textWin.setText("DRAW");
            textWin.setTextColor(Color.RED);
        }
    }

    private void removeOnClick(int idImage){
        ImageView imageView = findViewById(idImage);
        imageView.setOnClickListener(null);
    }

    private boolean isWon(){
        for(int row=0; row<board.length; row++){
            //check all the rows
            if (((board[row][0] == board[row][1]) && (board[row][0]==board[row][2])) && (board[row][0] != -1)) {
                return true;
            }
        }
        for(int col=0; col<board.length; col++){
            //check all the columns
            if (((board[0][col] == board[1][col]) && (board[0][col]==board[2][col])) && (board[0][col] != -1)) {
                return true;
            }
        }
        if( (board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) && (board[0][0] != -1)){
            //diagonal winner 1
            return true;
        }
        else if ((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]) && (board[0][2] != -1)){
            //diagonal winner 2
            return true;
        }
        else{
            //no winner
            return false;
        }
    }
}