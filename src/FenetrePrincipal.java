import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class FenetrePrincipal extends JFrame implements ActionListener,MouseListener {
	private static final long serialVersionUID = 1L;
	
	ImageIcon background2;
	JLabel backlabel2;
	JPanel pan1;
	JButton enter,exit;
	Font font20;
	Color purple;
	Container c;
	
	public FenetrePrincipal() {
		
		this.setBounds(150, 1, 1000, 770);
		this.setTitle("Acceuil");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		this.setResizable(false);
		c=getContentPane();
		
		purple=new Color(28,156,242);
		background2=new ImageIcon(this.getClass().getResource("/images/greenbackground.png"));
		backlabel2=new JLabel(background2);
		pan1=new JPanel(null);
		enter=new JButton("ENTER");
		exit=new JButton("EXIT");
		font20=new Font("Arial", Font.BOLD, 20);
		
		enter.setFont(font20);enter.setBackground(Color.GREEN);enter.setForeground(Color.WHITE);
		exit.setFont(font20);exit.setBackground(Color.RED);exit.setForeground(Color.WHITE);
		
		pan1.setBounds(0, 0,1000,770);
		
		backlabel2.setBounds(0, -10, 1000, 770);
		
		exit.setBounds(50, 150, 200, 100);
		enter.setBounds(750, 150, 200, 100);
		
		enter.addActionListener(this);
		exit.addActionListener(this);
		
		enter.addMouseListener(this);
		
		pan1.add(enter);
		pan1.add(exit);
		pan1.add(backlabel2);
		
		c.add(pan1);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(exit)){
			 System.exit(0);
		}
		
		else if(e.getSource().equals(enter))
		{
			c.removeAll();
			c.validate();
			c.repaint();
			try{UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");}
			catch(Exception ee){JOptionPane.showMessageDialog(null, ee.getMessage());}
			Pan3 p3=new Pan3();
			Test tt=new Test();
			c.add(p3);
			c.add(tt);
		}
	}	
	public void mouseClicked(MouseEvent e) {
		
		
	}
	public void mouseEntered(MouseEvent e) {
		
		if(e.getSource().equals(enter))
		{
			
			enter.setText("<html>Know the prayer <br /><center>times</center></html>");
		}
		
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(enter))
		{
			
			enter.setText("ENTRER");
		}
		
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	
	
	public static void main(String[] args) {
		
		try{UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		}catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
		
		new FenetrePrincipal();
	}
}
