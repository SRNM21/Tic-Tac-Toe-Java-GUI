import java.util.Random;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Tic_Tac_Toe {
	
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JFrame frmTicTacToe;
	private int playerScore = 0;
	private int computerScore = 0;
	private int occupiedSlots = 0;
	private JTextField playerStatus;
	private JTextField computerStatus;
	private String moves [] = {"Placeholder for index 0",
			"", "", "",
			"", "", "",
			"", "", ""};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tic_Tac_Toe window = new Tic_Tac_Toe();
					window.frmTicTacToe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tic_Tac_Toe() {
		initialize();
	}

	public void GetComputerMoves() {
		Random r = new Random();
		int rand = 0;
		
		do {
			rand = r.nextInt(9)+1;
		} while (moves[rand] != "");
		 
		if (rand == 1) {
			b1.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/GreenMove.png")));
			moves[1] = "o";
			occupiedSlots++;
		} else if (rand == 2) {
			b2.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/GreenMove.png")));
			moves[2] = "o";
			occupiedSlots++;
		} else if (rand == 3) {
			b3.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/GreenMove.png")));
			moves[3] = "o";
			occupiedSlots++;
		} else if (rand == 4) {
			b4.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/GreenMove.png")));
			moves[4] = "o";
			occupiedSlots++;
		} else if (rand == 5) {
			b5.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/GreenMove.png")));
			moves[5] = "o";
			occupiedSlots++;
		} else if (rand == 6) {
			b6.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/GreenMove.png")));
			moves[6] = "o";
			occupiedSlots++;
		} else if (rand == 7) {
			b7.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/GreenMove.png")));
			moves[7] = "o";
			occupiedSlots++;
		} else if (rand == 8) {
			b8.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/GreenMove.png")));
			moves[8] = "o";
			occupiedSlots++;
		} else {
			b9.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/GreenMove.png")));
			moves[9] = "o";
			occupiedSlots++;
		} 
	}
	public void Reset() {
		b1.setIcon(null);
		b2.setIcon(null);
		b3.setIcon(null);
		b4.setIcon(null);
		b5.setIcon(null);
		b6.setIcon(null);
		b7.setIcon(null);
		b8.setIcon(null); 
		b9.setIcon(null); 
		occupiedSlots = 0;
		for (int i = 1; i < moves.length; i++) {
			moves[i] = "";
	    }
	}
	public void CheckWinner() {
		
		for (int i = 0; i < 8; i++){
            String line = null;

            switch(i){
                case 0:
                    line = moves[1] + moves[2] + moves[3];
                    break;
                case 1:
                    line = moves[4] + moves[5] + moves[6];
                    break;
                case 2:
                    line = moves[7] + moves[8] + moves[9];
                    break;
                case 3:
                    line = moves[1] + moves[4] + moves[7];
                    break;
                case 4:
                    line = moves[2] + moves[5] + moves[8];
                    break;
                case 5:
                    line = moves[3] + moves[6] + moves[9];
                    break;
                case 6:
                    line = moves[1] + moves[5] + moves[9];
                    break;
                case 7:
                    line = moves[3] + moves[5] + moves[7];
                    break;
            }
            if (line.equals("xxx")){
            	JOptionPane.showMessageDialog(frmTicTacToe, "Player Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
    			Reset();
            	playerScore++;
    			playerStatus.setText("Player: " + playerScore);
            }
            else if (line.equals("ooo")){
            	JOptionPane.showMessageDialog(frmTicTacToe, "Computer Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            	Reset();
            	computerScore++;
    			computerStatus.setText("Computer: " + computerScore);
            }
            
            if (occupiedSlots == 9) {
            	JOptionPane.showMessageDialog(frmTicTacToe, "Draw!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            	Reset();
            }
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.getContentPane().setBackground(Color.GRAY);
		frmTicTacToe.setBounds(100, 100, 700, 700);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicTacToe.setResizable(false);
		frmTicTacToe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(133, 31, 420, 420);
		frmTicTacToe.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 3));
		
		b1 = new JButton("");
		b1.setBackground(Color.WHITE);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moves[1] == "") {
					b1.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/RedMove.png")));
					moves[1] = "x";
					occupiedSlots++;
					CheckWinner();
					
					if(occupiedSlots != 9 && occupiedSlots != 0) {
						GetComputerMoves();
						CheckWinner();
					}
				}
			}
		});
		b1.setBorder(new LineBorder(Color.BLACK, 1, true));
		panel.add(b1);
		
		b2 = new JButton("");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moves[2] == "") {
					b2.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/RedMove.png")));
					moves[2] = "x";
					occupiedSlots++;
					CheckWinner();
					
					if(occupiedSlots != 9 && occupiedSlots != 0) {
						GetComputerMoves();
						CheckWinner();
					}
				}
			}
		});
		b2.setBorder(new LineBorder(new Color(0, 0, 0)));
		b2.setBackground(Color.WHITE);
		panel.add(b2);
		
		b3 = new JButton("");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moves[3] == "") {
					b3.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/RedMove.png")));
					moves[3] = "x";
					occupiedSlots++;
					CheckWinner();
					
					if(occupiedSlots != 9 && occupiedSlots != 0) {
						GetComputerMoves();
						CheckWinner();
					}
				}
			}
		});
		b3.setBorder(new LineBorder(new Color(0, 0, 0)));
		b3.setBackground(Color.WHITE);
		panel.add(b3);
		
		b4 = new JButton("");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moves[4] == "") {
					b4.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/RedMove.png")));
					moves[4] = "x";
					occupiedSlots++;
					CheckWinner();
					
					if(occupiedSlots != 9 && occupiedSlots != 0) {
						GetComputerMoves();
						CheckWinner();
					}
				}
			}
		});
		b4.setBorder(new LineBorder(new Color(0, 0, 0)));
		b4.setBackground(Color.WHITE);
		panel.add(b4);
		
		b5 = new JButton("");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moves[5] == "") {
					b5.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/RedMove.png")));
					moves[5] = "x";
					occupiedSlots++;
					CheckWinner();
					
					if(occupiedSlots != 9 && occupiedSlots != 0) {
						GetComputerMoves();
						CheckWinner();
					}
				}
			}
		});
		b5.setBorder(new LineBorder(new Color(0, 0, 0)));
		b5.setBackground(Color.WHITE);
		panel.add(b5);
		
		b6 = new JButton("");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moves[6] == "") {
					b6.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/RedMove.png")));
					moves[6] = "x";
					occupiedSlots++;
					CheckWinner();
					
					if(occupiedSlots != 9 && occupiedSlots != 0) {
						GetComputerMoves();
						CheckWinner();
					}
				}
			}
		});
		b6.setBorder(new LineBorder(new Color(0, 0, 0)));
		b6.setBackground(Color.WHITE);
		panel.add(b6);
		
		b7 = new JButton("");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moves[7] == "") {
					b7.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/RedMove.png")));
					moves[7] = "x";
					occupiedSlots++;
					CheckWinner();
					
					if(occupiedSlots != 9 && occupiedSlots != 0) {
						GetComputerMoves();
						CheckWinner();
					}
				}
			}
		});
		b7.setBorder(new LineBorder(new Color(0, 0, 0)));
		b7.setBackground(Color.WHITE);
		panel.add(b7);
		
		b8 = new JButton("");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moves[8] == "") {
					b8.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/RedMove.png")));
					moves[8] = "x";
					occupiedSlots++;
					CheckWinner();
					
					if(occupiedSlots != 9 && occupiedSlots != 0) {
						GetComputerMoves();
						CheckWinner();
					}
				}
			}
		});
		b8.setBorder(new LineBorder(new Color(0, 0, 0)));
		b8.setBackground(Color.WHITE);
		panel.add(b8);
		
		b9 = new JButton("");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moves[9] == "") {
					b9.setIcon(new ImageIcon(Tic_Tac_Toe.class.getResource("/Images/RedMove.png")));
					moves[9] = "x";
					occupiedSlots++;
					CheckWinner();
					
					if(occupiedSlots != 9 && occupiedSlots != 0) {
						GetComputerMoves();
						CheckWinner();
					}
				}
			}
		});
		b9.setBorder(new LineBorder(new Color(0, 0, 0)));
		b9.setBackground(Color.WHITE);
		panel.add(b9);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setFont(new Font("Arial", Font.BOLD, 14));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reset = JOptionPane.showConfirmDialog(frmTicTacToe, "Are you sure you want to reset your progress?",
						"Reset?", JOptionPane.YES_NO_OPTION);

				if (reset == JOptionPane.YES_OPTION) {
					Reset();
					playerScore = 0;
					computerScore = 0;
					playerStatus.setText("Player: " + playerScore);
					computerStatus.setText("Computer: " + computerScore);
				} else {
					frmTicTacToe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		resetButton.setBounds(411, 491, 142, 43);
		frmTicTacToe.getContentPane().add(resetButton);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(frmTicTacToe, "Are you sure you want to exit?",
						"Exit Program?", JOptionPane.YES_NO_OPTION);

				if (exit == JOptionPane.YES_OPTION) {
					 System.exit(0);
				} else {
					frmTicTacToe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(411, 544, 142, 43);
		frmTicTacToe.getContentPane().add(btnNewButton);
		
		computerStatus = new JTextField();
		computerStatus.setText("Computer: " + computerScore);
		computerStatus.setBackground(Color.LIGHT_GRAY);
		computerStatus.setHorizontalAlignment(SwingConstants.LEFT);
		computerStatus.setFont(new Font("Arial", Font.BOLD, 14));
		computerStatus.setEditable(false);
		computerStatus.setBounds(133, 544, 268, 43);
		frmTicTacToe.getContentPane().add(computerStatus);
		computerStatus.setColumns(10);
		
		playerStatus = new JTextField();
		playerStatus.setText("Player: " + playerScore);
		playerStatus.setBackground(Color.LIGHT_GRAY);
		playerStatus.setHorizontalAlignment(SwingConstants.LEFT);
		playerStatus.setFont(new Font("Arial", Font.BOLD, 14));
		playerStatus.setEditable(false);
		playerStatus.setColumns(10);
		playerStatus.setBounds(133, 491, 268, 43);
		frmTicTacToe.getContentPane().add(playerStatus);
		
	}
}
