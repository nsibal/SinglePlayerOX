import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SinglePlayerOX extends JFrame {

	private JPanel contentPane;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private String winner;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					SinglePlayerOX frame = new SinglePlayerOX();
					frame.setVisible(true);
				
			}
		});
	}
	
	public void useButton(JButton button) {
		button.setText("O");
	}
	
	public boolean isButtonFree(JButton button) {
		if(button.getText().trim().length()==0)
			return true;
		else
			return false;
	}
	
	public void takeInput(JButton btn) {
		if(btn.getText().trim().length()<1) {
			btn.setText("X");
			checkVictory();
			computerTurn();
		}
	}
	
	public boolean winningOrSaving(String input) {
		
		// 123
		if(b1.getText().trim()==input && b3.getText().trim()==input && b2.getText().trim().length()==0) {
			useButton(b2);
			return true;
		}
		else if(b1.getText().trim()==input && b2.getText().trim()==input && b3.getText().trim().length()==0) {
			useButton(b3);
			return true;
		}
		else if(b2.getText().trim()==input && b3.getText().trim()==input && b1.getText().trim().length()==0) {
			useButton(b1);
			return true;
		}
		
		// 456
		else if(b4.getText().trim()==input && b6.getText().trim()==input && b5.getText().trim().length()==0) {
			useButton(b5);
			return true;
		}
		else if(b4.getText().trim()==input && b5.getText().trim()==input && b6.getText().trim().length()==0) {
			useButton(b6);
			return true;
		}
		else if(b5.getText().trim()==input && b6.getText().trim()==input && b4.getText().trim().length()==0) {
			useButton(b4);
			return true;
		}
		
		// 789
		else if(b7.getText().trim()==input && b9.getText().trim()==input && b8.getText().trim().length()==0) {
			useButton(b8);
			return true;
		}
		else if(b7.getText().trim()==input && b8.getText().trim()==input && b9.getText().trim().length()==0) {
			useButton(b9);
			return true;
		}
		else if(b8.getText().trim()==input && b9.getText().trim()==input && b7.getText().trim().length()==0) {
			useButton(b7);
			return true;
		}
		
		// 147
		else if(b1.getText().trim()==input && b7.getText().trim()==input && b4.getText().trim().length()==0) {
			useButton(b4);
			return true;
		}
		else if(b1.getText().trim()==input && b4.getText().trim()==input && b7.getText().trim().length()==0) {
			useButton(b7);
			return true;
		}
		else if(b4.getText().trim()==input && b7.getText().trim()==input && b1.getText().trim().length()==0) {
			useButton(b1);
			return true;
		}
		
		// 258
		else if(b2.getText().trim()==input && b8.getText().trim()==input && b5.getText().trim().length()==0) {
			useButton(b5);
			return true;
		}
		else if(b2.getText().trim()==input && b5.getText().trim()==input && b8.getText().trim().length()==0) {
			useButton(b8);
			return true;
		}
		else if(b5.getText().trim()==input && b8.getText().trim()==input && b2.getText().trim().length()==0) {
			useButton(b2);
			return true;
		}
		
		// 369
		else if(b3.getText().trim()==input && b9.getText().trim()==input && b6.getText().trim().length()==0) {
			useButton(b6);
			return true;
		}
		else if(b3.getText().trim()==input && b6.getText().trim()==input && b9.getText().trim().length()==0) {
			useButton(b9);
			return true;
		}
		else if(b6.getText().trim()==input && b9.getText().trim()==input && b3.getText().trim().length()==0) {
			useButton(b3);
			return true;
		}
		
		// 159
		else if(b1.getText().trim()==input && b9.getText().trim()==input && b5.getText().trim().length()==0) {
			useButton(b5);
			return true;
		}
		else if(b1.getText().trim()==input && b5.getText().trim()==input && b9.getText().trim().length()==0) {
			useButton(b9);
			return true;
		}
		else if(b5.getText().trim()==input && b9.getText().trim()==input && b1.getText().trim().length()==0) {
			useButton(b1);
			return true;
		}
		
		// 357
		else if(b3.getText().trim()==input && b7.getText().trim()==input && b5.getText().trim().length()==0) {
			useButton(b5);
			return true;
		}
		else if(b3.getText().trim()==input && b5.getText().trim()==input && b7.getText().trim().length()==0) {
			useButton(b7);
			return true;
		}
		else if(b5.getText().trim()==input && b7.getText().trim()==input && b3.getText().trim().length()==0) {
			useButton(b3);
			return true;
		}
		else
			return false;
	}
	
	private void enableOrDisableButtons(Boolean option) {
		b1.setEnabled(option);
		b2.setEnabled(option);
		b3.setEnabled(option);
		b4.setEnabled(option);
		b5.setEnabled(option);
		b6.setEnabled(option);
		b7.setEnabled(option);
		b8.setEnabled(option);
		b9.setEnabled(option);
	}
	
	private void resetAll() {
		enableOrDisableButtons(true);
		b1.setText("");
		b2.setText("");
		b3.setText("");
		b4.setText("");
		b5.setText("");
		b6.setText("");
		b7.setText("");
		b8.setText("");
		b9.setText("");
	}
	
	private void announceResult(String winner) {
		int choice = JOptionPane.showConfirmDialog(this, winner+"\nGAME OVER!!!\nDo you want to play again?", "RESULT", JOptionPane.YES_NO_CANCEL_OPTION);
		if(choice==JOptionPane.YES_OPTION) {
			resetAll();
		}
		else if(choice==JOptionPane.NO_OPTION) {
			this.setVisible(false);
			this.dispose();
		}
	}
	
	private void victoryResult(JButton winningbtn1, JButton winningbtn2, JButton winningbtn3) {
		if(winningbtn1.getText().trim()=="X") {
			winner = "YOU WIN!!!";
		}
		else {
			winner = "YOU LOSE!!!";
		}
		enableOrDisableButtons(false);
		winningbtn1.setEnabled(true);
		winningbtn2.setEnabled(true);
		winningbtn3.setEnabled(true);
		announceResult(winner);
	}
	
	public void checkVictory() {
		if(b1.getText().trim().length()>0 && b2.getText().trim().length()>0 && b1.getText()==b2.getText()) {
			if(b2.getText().trim().length()>0 && b3.getText().trim().length()>0 && b2.getText()==b3.getText()) {
				victoryResult(b1, b2, b3);
			}
		}
		if(b1.getText().trim().length()>0 && b5.getText().trim().length()>0 && b1.getText()==b5.getText()) {
			if(b5.getText().trim().length()>0 && b9.getText().trim().length()>0 && b5.getText()==b9.getText()) {
				victoryResult(b1, b5, b9);
			}
		}
		if(b1.getText().trim().length()>0 && b4.getText().trim().length()>0 && b1.getText()==b4.getText()) {
			if(b4.getText().trim().length()>0 && b7.getText().trim().length()>0 && b4.getText()==b7.getText()) {
				victoryResult(b1, b4, b7);
			}
		}
		if(b2.getText().trim().length()>0 && b5.getText().trim().length()>0 && b2.getText()==b5.getText()) {
			if(b5.getText().trim().length()>0 && b8.getText().trim().length()>0 && b5.getText()==b8.getText()) {
				victoryResult(b2, b5, b8);
			}
		}
		if(b3.getText().trim().length()>0 && b6.getText().trim().length()>0 && b3.getText()==b6.getText()) {
			if(b6.getText().trim().length()>0 && b9.getText().trim().length()>0 && b6.getText()==b9.getText()) {
				victoryResult(b3, b6, b9);
			}
		}
		if(b3.getText().trim().length()>0 && b5.getText().trim().length()>0 && b3.getText()==b5.getText()) {
			if(b5.getText().trim().length()>0 && b7.getText().trim().length()>0 && b5.getText()==b7.getText()) {
				victoryResult(b3, b5, b7);
			}
		}
		if(b4.getText().trim().length()>0 && b5.getText().trim().length()>0 && b4.getText()==b5.getText()) {
			if(b5.getText().trim().length()>0 && b6.getText().trim().length()>0 && b5.getText()==b6.getText()) {
				victoryResult(b4, b5, b6);
			}
		}
		if(b7.getText().trim().length()>0 && b8.getText().trim().length()>0 && b7.getText()==b8.getText()) {
			if(b8.getText().trim().length()>0 && b9.getText().trim().length()>0 && b8.getText()==b9.getText()) {
				victoryResult(b7, b8, b9);
			}
		}
	}
	
	public boolean crucialStep() {
		if(!winningOrSaving("O") && !winningOrSaving("X")) {
			if(isButtonFree(b5)) {
				useButton(b5);
				return true;
			}
			else if (b5.getText().trim()=="X") {
				if((b1.getText().trim()=="X" && b9.getText().trim()=="O") || (b1.getText().trim()=="O" && b9.getText().trim()=="X")) {
					if(isButtonFree(b3)) {
						useButton(b3);
						return true;
					}
					else if(isButtonFree(b7)) {
						useButton(b7);
						return true;
					}
					else
						return false;
				}
				else if((b3.getText().trim()=="X" && b7.getText().trim()=="O") || (b3.getText().trim()=="O" && b7.getText().trim()=="X")) {
					if(isButtonFree(b1)) {
						useButton(b1);
						return true;
					}
					else if(isButtonFree(b9)) {
						useButton(b9);
						return true;
					}
					else
						return false;
				}
				else if(isButtonFree(b1)) {
					useButton(b1);
					return true;
				}
				else if(isButtonFree(b3)) {
					useButton(b3);
					return true;
				}
				else if(isButtonFree(b7)) {
					useButton(b7);
					return true;
				}
				else if(isButtonFree(b9)) {
					useButton(b9);
					return true;
				}
				else
					return false;
			}
			else if (b5.getText().trim()=="O") {
				if((b1.getText().trim()=="X" && b9.getText().trim()=="X") || (b3.getText().trim()=="X" && b7.getText().trim()=="X")) {
					if(isButtonFree(b2)) {
						useButton(b2);
						return true;
					}
					else if(isButtonFree(b4)) {
						useButton(b4);
						return true;
					}
					else if(isButtonFree(b6)) {
						useButton(b6);
						return true;
					}
					else if(isButtonFree(b8)) {
						useButton(b8);
						return true;
					}
					else
						return false;
				}
				else if((b1.getText().trim()=="X" && b8.getText().trim()=="X") || (b3.getText().trim()=="X" && b8.getText().trim()=="X")) {
					if(isButtonFree(b7)) {
						useButton(b7);
						return true;
					}
					else if(isButtonFree(b6)) {
						useButton(b6);
						return true;
					}
					else if(isButtonFree(b9)) {
						useButton(b9);
						return true;
					}
					else if(isButtonFree(b4)) {
						useButton(b4);
						return true;
					}
					else
						return false;
				}
				else if((b1.getText().trim()=="X" && b6.getText().trim()=="X") || (b6.getText().trim()=="X" && b7.getText().trim()=="X")) {
					if(isButtonFree(b3)) {
						useButton(b3);
						return true;
					}
					else if(isButtonFree(b8)) {
						useButton(b8);
						return true;
					}
					else if(isButtonFree(b9)) {
						useButton(b9);
						return true;
					}
					else if(isButtonFree(b2)) {
						useButton(b2);
						return true;
					}
					else
						return false;
				}
				else if((b3.getText().trim()=="X" && b4.getText().trim()=="X") || (b4.getText().trim()=="X" && b9.getText().trim()=="X")) {
					if(isButtonFree(b1)) {
						useButton(b1);
						return true;
					}
					else if(isButtonFree(b8)) {
						useButton(b8);
						return true;
					}
					else if(isButtonFree(b7)) {
						useButton(b7);
						return true;
					}
					else if(isButtonFree(b2)) {
						useButton(b2);
						return true;
					}
					else
						return false;
				}
				else if(b2.getText().trim()=="X" && b4.getText().trim()=="X") {
					if(isButtonFree(b1)) {
						useButton(b1);
						return true;
					}
					else if(isButtonFree(b3)) {
						useButton(b3);
						return true;
					}
					else if(isButtonFree(b7)) {
						useButton(b7);
						return true;
					}
					else
						return false;
				}
				else if(b2.getText().trim()=="X" && b6.getText().trim()=="X") {
					if(isButtonFree(b1)) {
						useButton(b1);
						return true;
					}
					else if(isButtonFree(b3)) {
						useButton(b3);
						return true;
					}
					else if(isButtonFree(b9)) {
						useButton(b9);
						return true;
					}
					else
						return false;
				}
				else if((b2.getText().trim()=="X" && b7.getText().trim()=="X") || (b2.getText().trim()=="X" && b9.getText().trim()=="X")) {
					if(isButtonFree(b1)) {
						useButton(b1);
						return true;
					}
					else if(isButtonFree(b3)) {
						useButton(b3);
						return true;
					}
					else if(isButtonFree(b4)) {
						useButton(b4);
						return true;
					}
					else if(isButtonFree(b6)) {
						useButton(b6);
						return true;
					}
					else
						return false;
				}
				else if(b2.getText().trim()=="X" && b8.getText().trim()=="X") {
					if(isButtonFree(b1)) {
						useButton(b1);
						return true;
					}
					else if(isButtonFree(b3)) {
						useButton(b3);
						return true;
					}
					else if(isButtonFree(b4)) {
						useButton(b4);
						return true;
					}
					else if(isButtonFree(b6)) {
						useButton(b6);
						return true;
					}
					else if(isButtonFree(b7)) {
						useButton(b7);
						return true;
					}
					else if(isButtonFree(b9)) {
						useButton(b9);
						return true;
					}
					else
						return false;
				}
				else if(b4.getText().trim()=="X" && b6.getText().trim()=="X") {
					if(isButtonFree(b1)) {
						useButton(b1);
						return true;
					}
					else if(isButtonFree(b2)) {
						useButton(b2);
						return true;
					}
					else if(isButtonFree(b3)) {
						useButton(b3);
						return true;
					}
					else if(isButtonFree(b7)) {
						useButton(b7);
						return true;
					}
					else if(isButtonFree(b8)) {
						useButton(b8);
						return true;
					}
					else if(isButtonFree(b9)) {
						useButton(b9);
						return true;
					}
					else
						return false;
				}
				else if(b4.getText().trim()=="X" && b8.getText().trim()=="X") {
					if(isButtonFree(b1)) {
						useButton(b1);
						return true;
					}
					else if(isButtonFree(b7)) {
						useButton(b7);
						return true;
					}
					else if(isButtonFree(b9)) {
						useButton(b9);
						return true;
					}
					else
						return false;
				}
				else if(b6.getText().trim()=="X" && b8.getText().trim()=="X") {
					if(isButtonFree(b3)) {
						useButton(b3);
						return true;
					}
					else if(isButtonFree(b7)) {
						useButton(b7);
						return true;
					}
					else if(isButtonFree(b9)) {
						useButton(b9);
						return true;
					}
					else
						return false;
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			return true;
	}
	
	public void computerTurn() {
		if(!crucialStep()){
			if(isButtonFree(b1)) {
				useButton(b1);
			}
			else if(isButtonFree(b2)) {
				useButton(b2);
			}
			else if(isButtonFree(b3)) {
				useButton(b3);
			}
			else if(isButtonFree(b4)) {
				useButton(b4);
			}
			else if(isButtonFree(b5)) {
				useButton(b5);
			}
			else if(isButtonFree(b6)) {
				useButton(b6);
			}
			else if(isButtonFree(b7)) {
				useButton(b7);
			}
			else if(isButtonFree(b8)) {
				useButton(b8);
			}
			else if(isButtonFree(b9)) {
				useButton(b9);
			}
			else
				announceResult("DRAW!!!");
		}
		checkVictory();				
	}

	/**
	 * Create the frame.
	 */
	public SinglePlayerOX() {
		setTitle("TicTacToe");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 1000);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 15, 15));
		
		b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeInput(b1);
			}
		});
		b1.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		contentPane.add(b1);
		
		b2 = new JButton("");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeInput(b2);
			}
		});
		b2.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		contentPane.add(b2);
		
		b3 = new JButton("");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeInput(b3);
			}
		});
		b3.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		contentPane.add(b3);
		
		b4 = new JButton("");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeInput(b4);
			}
		});
		b4.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		contentPane.add(b4);
		
		b5 = new JButton("");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeInput(b5);
			}
		});
		b5.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		contentPane.add(b5);
		
		b6 = new JButton("");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeInput(b6);
			}
		});
		b6.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		contentPane.add(b6);
		
		b7 = new JButton("");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeInput(b7);
			}
		});
		b7.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		contentPane.add(b7);
		
		b8 = new JButton("");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeInput(b8);
			}
		});
		b8.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		contentPane.add(b8);
		
		b9 = new JButton("");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeInput(b9);
			}
		});
		b9.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		contentPane.add(b9);
		
	}

}
