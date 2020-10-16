import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;



public class Help {

	public static void main (String arg[]) {
		try{UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		}catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
	
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 300, 400);
		frame.setTitle("Help");
		frame.setLayout(null);
		frame.setResizable(false);
		JButton btnFindLongtitudelatitude = new JButton("Find Longtitude ,Latitude");
		JButton btnFindTimezoneOffline = new JButton("Find TimeZone offline");
		JRadioButton rdbtnOnline = new JRadioButton("online");
		JRadioButton rdbtnOffline = new JRadioButton("offline");
		JPanel panel_1 = new JPanel();
		JPanel panel = new JPanel();
		
		ButtonGroup bgrp=new ButtonGroup();
		bgrp.add(rdbtnOffline);
		bgrp.add(rdbtnOnline);
		
		btnFindLongtitudelatitude.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnFindLongtitudelatitude.setForeground(new Color(0, 0, 0));
		btnFindLongtitudelatitude.setBackground(new Color(255, 255, 255));
		
		btnFindTimezoneOffline.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFindTimezoneOffline.setBackground(new Color(255, 255, 255));
		btnFindTimezoneOffline.setForeground(new Color(0, 0, 0));
		
		
		rdbtnOnline.setBackground(new Color(0, 206, 209));
		rdbtnOnline.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		rdbtnOffline.setBackground(new Color(0, 206, 209));
		rdbtnOffline.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		
		
		btnFindLongtitudelatitude.setBounds(44, 57, 193, 33);
		rdbtnOffline.setBounds(142, 92, 95, 33);
		rdbtnOnline.setBounds(54, 92, 86, 33);
		btnFindTimezoneOffline.setBounds(54, 159, 183, 33);
		
		panel.setBounds(33, 42, 215, 93);
		panel.setBackground(new Color(255, 215, 0));
		
		btnFindLongtitudelatitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnOnline.isSelected()==false && rdbtnOffline.isSelected()==false)
				{
					JOptionPane.showMessageDialog(null, "Choose online or offline");
				}
				else if (rdbtnOnline.isSelected()==true) {
					
					Desktop d=Desktop.getDesktop();
					try 
					{
						d.browse(new URI("https://epsg.io/map#"));
					}
					
					catch (IOException e) {e.printStackTrace();} 
					catch (URISyntaxException e) {e.printStackTrace();}
				}
				else if (rdbtnOffline.isSelected()==true) {
									
					new Longtlat();
								}
			}
		});
		
		btnFindTimezoneOffline.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TimezoneHelp();
				
			}
		});
		
		
		frame.add(btnFindLongtitudelatitude);				
		frame.add(rdbtnOnline);			
		frame.add(rdbtnOffline);
		
		
		
		
		frame.add(panel);
		
		
		frame.add(btnFindTimezoneOffline);
		
		
		
		
		
		panel_1.setBackground(new Color(186, 85, 211));
		panel_1.setBounds(33, 135, 215, 77);
		frame.add(panel_1);
		
		

		
		frame.setVisible(true);
	}
	}

