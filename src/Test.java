import java.awt.Color;
import java.awt.Font;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test  extends JPanel{
	private static final long serialVersionUID = 1L;
	
	JLabel date;
	 Format formatter ;
	 String today ;
	public Test()
	{
		this.setBounds(0, 0, 1000, 40);
		this.setLayout(null);
		this.setBackground(new Color(0,0,139));
		
		formatter = new SimpleDateFormat("EEEE,MMMM/dd/yyy");
		today = formatter.format(new Date());
		date=new JLabel("Current Day : "+today);
	
			
		date.setBounds(310, 0, 400, 40);date.setFont(new Font("Comic Sans MS",Font.BOLD, 20));
		date.setForeground(new Color(0,250,64));

		
		this.add(date);
		this.setVisible(true);
		
	}
	
}
