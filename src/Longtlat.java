
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Longtlat extends JFrame{

	JLabel labelimage;
	public Longtlat()
	{
		this.setLayout(null);
		this.setResizable(false);
		this.setTitle("Latitude,Longtitude Help");
		 labelimage = new JLabel("New label");
		labelimage.setIcon(new ImageIcon(this.getClass().getResource("/images/long.png")));
		labelimage.setBounds(1, 0, 1000, 700);
		this.add(labelimage);
		this.setBounds(100, 20, 1020, 750);
		this.setVisible(true);
	}
	
	

}
