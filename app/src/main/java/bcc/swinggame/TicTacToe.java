package bcc.swinggame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton restartButton = new JButton("Restart");
    boolean firstturn;


    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(255, 220, 220)); 
        frame.setLayout(new BorderLayout());
        
        textfield.setBackground(new Color(255, 220, 220));
        textfield.setForeground(new Color(255, 242, 235));
        textfield.setFont(new Font("Serif",Font.ITALIC, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(253, 251, 230));
        
       

        for(int i =0;i < 9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Serif",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        restartButton.setFont(new Font("Serif", Font.PLAIN, 30));
        restartButton.setFocusable(false);
        restartButton.setVisible(false);
        restartButton.addActionListener( e -> restartGame());
        frame.add(restartButton, BorderLayout.SOUTH);

        firstturn = true;
        frame.setVisible(true);
        



    }

    
    public void actionPerformed(ActionEvent e){
        for(int i = 0;i< 9;i++){
            if(e.getSource()==buttons[i]){
                if(firstturn){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(241, 103, 103));
                        buttons[i].setText("X");
                        firstturn = false;
                        textfield.setText("O turn");
                        checkWin();

                    }
                }
                else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(113, 192, 187));
                        buttons[i].setText("O");
                        firstturn = true;
                        textfield.setText("X turn");
                        checkWin();

                }
            }
        }

    }
}


    

    public void checkWin() {
        // X win conditions
        if ((buttons[0].getText().equals("X")) 
        && (buttons[1].getText().equals("X")) &&
         (buttons[2].getText().equals("X"))) {
            xWins(0,1,2);
            return;
        }
        if ((buttons[3].getText().equals("X")) 
        && (buttons[4].getText().equals("X")) && 
        (buttons[5].getText().equals("X"))) {
            xWins(3,4,5);
            return;
        }
        if ((buttons[6].getText().equals("X"))
         && (buttons[7].getText().equals("X")) &&
          (buttons[8].getText().equals("X"))) {
            xWins(6,7,8);
            return;
        }
        if ((buttons[0].getText().equals("X"))
         && (buttons[3].getText().equals("X")) &&
          (buttons[6].getText().equals("X"))) {
            xWins(0,3,6);
            return;
        }
        if ((buttons[1].getText().equals("X")) && 
        (buttons[4].getText().equals("X")) && 
        (buttons[7].getText().equals("X"))) {
            xWins(1,4,7);
            return;
        }
        if ((buttons[2].getText().equals("X"))
         && (buttons[5].getText().equals("X"))
          && (buttons[8].getText().equals("X"))) {
            xWins(2,5,8);
            return;
        }
        if ((buttons[2].getText().equals("X")) 
        && (buttons[4].getText().equals("X")) &&
        (buttons[6].getText().equals("X"))) {
            xWins(2,4,6);
            return;
        }
        if ((buttons[0].getText().equals("X")) &&
         (buttons[4].getText().equals("X")) &&
          (buttons[8].getText().equals("X"))) {
            xWins(0,4,8);
            return;
        }
        // O win conditions
        if ((buttons[0].getText().equals("O")) 
        && (buttons[1].getText().equals("O")) && 
        (buttons[2].getText().equals("O"))) {
            OWins(0,1,2);
            return;
        }
        if ((buttons[3].getText().equals("O")) 
        && (buttons[4].getText().equals("O")) && 
        (buttons[5].getText().equals("O"))) {
            OWins(3,4,5);
            return;
        }
        if ((buttons[6].getText().equals("O")) 
        && (buttons[7].getText().equals("O")) && 
        (buttons[8].getText().equals("O"))) {
            OWins(6,7,8);
            return;
        }
        if ((buttons[0].getText().equals("O")) 
        && (buttons[3].getText().equals("O")) && 
        (buttons[6].getText().equals("O"))) {
            OWins(0,3,6);
            return;
        }
        if ((buttons[1].getText().equals("O")) &&
         (buttons[4].getText().equals("O")) && 
         (buttons[7].getText().equals("O"))) {
            OWins(1,4,7);
            return;
        }
        if ((buttons[2].getText().equals("O")) &&
         (buttons[5].getText().equals("O")) && 
         (buttons[8].getText().equals("O"))) {
            OWins(2,5,8);
            return;
        }
        if ((buttons[2].getText().equals("O"))
         && (buttons[4].getText().equals("O")) && 
         (buttons[6].getText().equals("O"))) {
            OWins(2,4,6);
            return;
        }
        if ((buttons[0].getText().equals("O")) && 
        (buttons[4].getText().equals("O")) && 
        (buttons[8].getText().equals("O"))) {
            OWins(0,4,8);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                return; // Not a draw, so exit the method
            }
        }
       
        textfield.setText("Draw!");
        restartButton.setVisible(true);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(64, 165, 120));
        buttons[b].setBackground(new Color(64, 165, 120));
        buttons[c].setBackground(new Color(64, 165, 120));

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);

        }
        textfield.setText("X wins");
        restartButton.setVisible(true); // Show restart button
    }

    public void OWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(64, 165, 120));
        buttons[b].setBackground(new Color(64, 165, 120));
        buttons[c].setBackground(new Color(64, 165, 120));

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);

        }
        textfield.setText("O wins");
        restartButton.setVisible(true); 
    }

    private void restartGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(null);
        }
        textfield.setText("Tic-Tac-Toe");
        firstturn = true;
        restartButton.setVisible(false);
    }
}







