
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TimezoneHelp extends JFrame{

	JLabel labelimage;
	public TimezoneHelp()
	{
		this.setLayout(null);
		this.setResizable(false);
		this.setTitle("TimeZone Help");
		 labelimage = new JLabel("New label");
		labelimage.setIcon(new ImageIcon(this.getClass().getResource("/images/timezone.png")));
		labelimage.setBounds(1, 0, 1000, 700);
		this.add(labelimage);
		this.setBounds(100, 5, 1020, 750);
		this.setVisible(true);
	}
	
	

}
