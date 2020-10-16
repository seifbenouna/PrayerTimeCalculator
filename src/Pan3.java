import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;





public class Pan3 extends JPanel implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private JComboBox timezone,day,month;
	private JTextField latitude,longitude,year;
	private Font f15;
	private JButton calculer,clear,affichemois,affichesemain,export,help;
	private JLabel tz,lat,lon,m,d,y,background,home;
	private final String itemstimzone[]={"-12","-11","-10" ,"-9" ,"-8","-7", "-6","-5","-4" ,"-3" ,"-2"
			,"-1","0","+1","+2","+3","+4","+5","+6","+7","+8","+9","+10","+11","+12","13","+14"}
				//	0   	    1		2		3		4	  5		  6  	7			8 		9			10		11	
,itemsmonth[]={"January","February","March","April","May","June","July","August","September","October","November","December",};
	
	private final String columns[]={"Month","Day","Fajr",	"Sunrise","Dhuhr","Asr","Sunset","Maghrib","Isha",};
	  DefaultTableModel model;
			JTable table;
			JScrollPane tableScroller;
			String nnn[]=new String[31];
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Pan3()
	{
	
		try{UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());}
		this.setLayout(null);
		this.setBounds(0,40,1000,710);
		
		
		f15=new Font("Arial",Font.BOLD, 17);
		
		
		timezone=new JComboBox(itemstimzone);	
		latitude=new JTextField("36.1898");
		longitude=new JTextField("5.4108");
		month=new JComboBox(itemsmonth);
		
		for(int i=0,c=1;i<=30;i++,c++)
		{
			
			nnn[i]=c+"";
		}
			
		day=new JComboBox(new DefaultComboBoxModel(nnn));
		year=new JTextField("2020");
		
		tz=new JLabel("Time Zone :");
		lat=new JLabel("Latitude :");
		lon=new JLabel("Longitude :");
		m=new JLabel("Month :");
		d=new JLabel("Day :");
		y=new JLabel("Year :");
		calculer=new JButton("Calculate");
		clear=new JButton("Clear Table");
		affichemois=new JButton("result of 30 Days");
		affichesemain=new JButton("result of semain");
		export=new JButton("Export As PDF");
		help=new JButton("Help");
		background=new JLabel(new ImageIcon(this.getClass().getResource("/images/bluebachground.png")));
		home=new JLabel(new ImageIcon(this.getClass().getResource("/images/homr.png")));
		model=new DefaultTableModel();
		table=new JTable(model);
		tableScroller=new JScrollPane(table);
		for(int i=0;i<columns.length;i++)model.addColumn(columns[i]);
		timezone.setFont(f15);// center-aligned items
	    DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
	    listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
	    timezone.setRenderer(listRenderer);
		timezone.setBounds(100, 50, 200, 40);
		
		latitude.setHorizontalAlignment(JTextField.CENTER);
		latitude.setFont(f15);
		latitude.setBounds(400, 50, 200, 40);
		
		
		longitude.setHorizontalAlignment(JTextField.CENTER);
		longitude.setFont(f15);
		longitude.setBounds(700, 50, 200, 40);
		
	 
		month.setRenderer(listRenderer);
		month.setFont(f15);
		month.setBounds(100, 150, 200, 40);
		
		
		day.setRenderer(listRenderer);
		day.setFont(f15);
		day.setBounds(400, 150, 200,40);
		
		
		year.setHorizontalAlignment(JTextField.CENTER);
		year.setFont(f15);
		year.setBounds(700, 150, 200, 40);
		
		
		
		tz.setBounds(100, 20, 100, 30);tz.setFont(f15);tz.setForeground(Color.YELLOW);
		lat.setBounds(400, 20,100 , 30);lat.setFont(f15);lat.setForeground(Color.YELLOW);
		lon.setBounds(700, 20,100 , 30);lon.setFont(f15);lon.setForeground(Color.YELLOW);
		
		m.setBounds(100, 130,80 , 20);m.setFont(f15);m.setForeground(Color.YELLOW);
		d.setBounds(400, 130,80 , 20);d.setFont(f15);d.setForeground(Color.YELLOW);
		y.setBounds(700, 130,80 , 20);y.setFont(f15);y.setForeground(Color.YELLOW);
		
	
		
		calculer.setBounds(200, 210,200 , 40);calculer.setFont(new Font("Comic Sans MS",Font.BOLD, 20));
		affichesemain.setBounds(400, 210, 200, 40);affichesemain.setFont(new Font("Comic Sans MS",Font.BOLD, 17));
		affichemois.setBounds(600, 210, 200, 40);affichemois.setFont(new Font("Comic Sans MS",Font.BOLD, 17));
		
		tableScroller.setBounds(150,250, 700, 400);
		
		export.setBounds(200, 650, 200, 40);export.setFont(new Font("Comic Sans MS",Font.BOLD, 17));
		help.setBounds(400,650, 200, 40);help.setFont(new Font("Comic Sans MS",Font.BOLD, 17));
		clear.setBounds(600, 650,200 , 40);clear.setFont(new Font("Comic Sans MS",Font.BOLD, 20));
		
		
		
		home.setBounds(-35, 640, 150, 60);
		
		background.setBounds(0,0,1000,750);
		
		month.addActionListener(this);		
		
		calculer.addActionListener(this);
		clear.addActionListener(this);
		affichemois.addActionListener(this);
		affichesemain.addActionListener(this);
		export.addActionListener(this);
		home.addMouseListener(this);
	
		help.addMouseListener(this);
		help.addActionListener(this);
		

		
		this.add(timezone);	this.add(latitude);		this.add(longitude);		this.add(month);
		this.add(day);	this.add(year);			this.add(tz);		
		this.add(lat);	this.add(lon);	this.add(m);this.add(d);	this.add(y);this.add(calculer);	this.add(clear);
		this.add(affichemois);this.add(affichesemain);
		this.add(export);this.add(help);
		
		this.add(tableScroller);
		this.add(home);
		this.add(background);
	}
	public void caclculer()
	{
	
		Double lon=Double.parseDouble(getLongitude());
		Double lat=Double.parseDouble(getLatitude());
		Double timzone=Double.parseDouble((String) timezone.getSelectedItem());
		
		int annee=getYear();		
		int moi=getMonth();		
		int jour=getDay();		
		
		
        // Test Prayer times here
		PrayTime prayers = new PrayTime();

        prayers.setTimeFormat(prayers.Time24);
        prayers.setCalcMethod(prayers.Jafari);
        prayers.setAsrJuristic(prayers.Shafii);
        prayers.setAdjustHighLats(prayers.AngleBased);
        int[] offsets = {0, 0, 0, 0, 0, 0, 0}; // {Fajr,Sunrise,Dhuhr,Asr,Sunset,Maghrib,Isha}
        prayers.tune(offsets);

        @SuppressWarnings("deprecation")
		Date now = new Date(annee,moi,jour);
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        ArrayList<String> prayerTimes = prayers.getPrayerTimes(cal,lon, lat, timzone);
        String timesalat[]=new String[prayerTimes.size()+2];
        timesalat[0]=""+month.getSelectedItem();
        timesalat[1]=""+jour;		
        for (int i = 0; i < prayerTimes.size(); i++) timesalat[i+2]= prayerTimes.get(i);
        
   
       String timeinfo[]=new String[timesalat.length];
       
       for(int i=0;i<timeinfo.length;i++) timeinfo[i]=timesalat[i];
    	   
		model.addRow(timeinfo);
		
	//	tableScroller.setBounds(150,300, 700, 400);
		
	//	this.add(tableScroller);
		
        
	}
	
	public void caclculerSemaine()
	{
	
		Double lon=Double.parseDouble(getLongitude());
		Double lat=Double.parseDouble(getLatitude());
		Double timzone=Double.parseDouble((String) timezone.getSelectedItem());
		
		int annee=getYear();		
		int moi=getMonth();		
		int jour=getDay();		
		
			
		
        // Test Prayer times here
		PrayTime prayers = new PrayTime();

        prayers.setTimeFormat(prayers.Time24);
        prayers.setCalcMethod(prayers.Jafari);
        prayers.setAsrJuristic(prayers.Shafii);
        prayers.setAdjustHighLats(prayers.AngleBased);
        int[] offsets = {0, 0, 0, 0, 0, 0, 0}; // {Fajr,Sunrise,Dhuhr,Asr,Sunset,Maghrib,Isha}
        prayers.tune(offsets);

        @SuppressWarnings("deprecation")
		Date now = new Date(annee,moi,jour);
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        String mm=""+month.getSelectedItem();
      
        for( int c=0;c<7;c++,jour++)
       {
        	if(jour == day.getItemCount())
    		{
    			jour=1;
    			mm=""+month.getItemAt(month.getSelectedIndex()+1);
    		}
        ArrayList<String> prayerTimes = prayers.getPrayerTimes(cal,
        		lon, lat, timzone);
        String timesalat[]=new String[prayerTimes.size()+2];
       
        timesalat[0]=mm; timesalat[1]=""+jour;		
        for (int i = 0; i < prayerTimes.size(); i++) timesalat[i+2]= prayerTimes.get(i);
        
     
		model.addRow(timesalat);
		
	//	tableScroller.setBounds(150,300, 700, 350);
		
	//	this.add(tableScroller);
		}
        }
	
	public void caclculerMonth()
	{
	
		Double lon=Double.parseDouble(getLongitude());
		Double lat=Double.parseDouble(getLatitude());
		Double timzone=Double.parseDouble((String) timezone.getSelectedItem());
		
		int annee=getYear();		
		int moi=getMonth();		
		int jour=getDay();		
		
			
		
        // Test Prayer times here
		PrayTime prayers = new PrayTime();

        prayers.setTimeFormat(prayers.Time24);
        prayers.setCalcMethod(prayers.Jafari);
        prayers.setAsrJuristic(prayers.Shafii);
        prayers.setAdjustHighLats(prayers.AngleBased);
        int[] offsets = {0, 0, 0, 0, 0, 0, 0}; // {Fajr,Sunrise,Dhuhr,Asr,Sunset,Maghrib,Isha}
        prayers.tune(offsets);

        @SuppressWarnings("deprecation")
		Date now = new Date(annee,moi,jour);
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        String mm=""+month.getSelectedItem();
        
        for( int c=0;c<30;c++,jour++)
       {
        	if(jour > day.getItemCount())
    		{
        		jour=1;
    			mm=""+month.getItemAt(month.getSelectedIndex()+1);
    		}
        ArrayList<String> prayerTimes = prayers.getPrayerTimes(cal,lon, lat, timzone);
        String timesalat[]=new String[prayerTimes.size()+2];
       
        timesalat[0]=mm;
        timesalat[1]=""+jour;		
        for (int i = 0; i < prayerTimes.size(); i++) timesalat[i+2]= prayerTimes.get(i);
        
   
       model.addRow(timesalat);
		
	//	tableScroller.setBounds(150,300, 700, 350);
		
	//	this.add(tableScroller);
		}
	
	}

	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
			   e.getMessage();
			  return false;  
		  }  
		}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(month))
		{
			if(month.getSelectedIndex()==1)
			{
				if(day.getItemCount() == 31)
				{
					day.removeItemAt(30);
					day.removeItemAt(29);
				}
				else if(day.getItemCount() == 30)
				{
					day.removeItemAt(29);
				}	
			}
			else if(month.getSelectedIndex()==3|month.getSelectedIndex()==5|month.getSelectedIndex()==8|month.getSelectedIndex()==10)
			{
			
				if(day.getItemCount() == 31)
				{
					day.removeItemAt(30);
				}
				else if(day.getItemCount() == 29)
				{
					extracted(29);
				}	
			}
			else 
			{
				if(day.getItemCount() == 29)
				{
					extracted(29);
					extracted(30);
				}
				else if(day.getItemCount() == 30)
				{
					extracted(30);
				}				
			}
		}
		
		 if(e.getSource().equals(calculer))
		{
		
			if(valid())
			{
				caclculer();
				
			}
		}
		else if(e.getSource().equals(clear))
		{
			model.setRowCount(0);
		}
		else if(e.getSource().equals(affichesemain))
		{
			if(valid())
			{
				caclculerSemaine();
			}
		}
		else if(e.getSource().equals(affichemois))
		{
			if(valid())
			{
				caclculerMonth();
				
			}
		}
		else if (e.getSource().equals(export))
		{
			export();
		}
		else if (e.getSource().equals(help)) {
			
			Help.main(null);
		}
		else if (e.getSource().equals(help)) {
			
		}
		
		
	}
	public void export()
	{
		
		
		Document doc = new Document();
		
		try {
			
		//	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			JFileChooser f = new JFileChooser();
	        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
	        f.showSaveDialog(null);

	      //  System.out.println(f.getCurrentDirectory());
	       String path=f.getSelectedFile()+"";
			
			PdfWriter.getInstance(doc, new FileOutputStream(path+"\\PrayTime.pdf"));
			
			doc.open();
			PdfPTable ptable=new PdfPTable(9);
			ptable.setWidthPercentage(100);
			
			PdfPCell cell;
			
			
			cell=new PdfPCell(new Phrase("Month",FontFactory.getFont("Comic Sans MS",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.ORANGE);
			ptable.addCell(cell);
			
			cell=new PdfPCell(new Phrase("Day",FontFactory.getFont("Comic Sans MS",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.ORANGE);
			ptable.addCell(cell);
			
			cell=new PdfPCell(new Phrase("Fajr",FontFactory.getFont("Comic Sans MS",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.ORANGE);
			ptable.addCell(cell);
			
			cell=new PdfPCell(new Phrase("Sunrise",FontFactory.getFont("Comic Sans MS",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.ORANGE);
			ptable.addCell(cell);
			
			cell=new PdfPCell(new Phrase("Dhuhr",FontFactory.getFont("Comic Sans MS",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.ORANGE);
			ptable.addCell(cell);
			
			cell=new PdfPCell(new Phrase("Asr",FontFactory.getFont("Comic Sans MS",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.ORANGE);
			ptable.addCell(cell);
			
			cell=new PdfPCell(new Phrase("Sunset",FontFactory.getFont("Comic Sans MS",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.ORANGE);
			ptable.addCell(cell);
			
			cell=new PdfPCell(new Phrase("Maghreb",FontFactory.getFont("Comic Sans MS",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.ORANGE);
			ptable.addCell(cell);
			
			cell=new PdfPCell(new Phrase("Isha",FontFactory.getFont("Comic Sans MS",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.ORANGE);
			ptable.addCell(cell);
		
			for (int i = 0; i <table.getRowCount(); i++) {
				for (int j = 0; j <table.getColumnCount() ; j++) {
					table.getValueAt(i, j);
					cell=new PdfPCell(new Phrase(table.getValueAt(i,j)+"",FontFactory.getFont("Comic Sans MS",12)));
					cell.setBackgroundColor(new BaseColor(204, 255, 255));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					ptable.addCell(cell);
				}
			}
							
			doc.add(ptable);
			doc.close();
			Desktop.getDesktop().open(new File(path+"\\PrayTime.pdf"));} 
		catch (Exception e) {	}}
		
    
	  
	public	boolean valid()
	{
		if(isNumeric(latitude.getText())==false)
		{
			JOptionPane.showMessageDialog(null, "Value of latitude must be number");return false;
		}
		else if(isNumeric(longitude.getText())==false)
		{
			JOptionPane.showMessageDialog(null, "Value of longitude must be number");return false;
		}
		else if(isNumeric(year.getText())==false)
		{
			JOptionPane.showMessageDialog(null, "Value of year must be number");return false;
		}/*
		else if((day.getSelectedItem().equals("0")))
		{
			JOptionPane.showMessageDialog(null, "Value of day must be number");return false;
		}
		else if(day.getItemCount()<2)
		{
			
			
			JOptionPane.showMessageDialog(null, "Value of day must be number");return false;
		}*/
		
			return true;
		
	
	}
	
	
	@SuppressWarnings("unchecked")
	private void extracted(int i) {
		day.insertItemAt(i+1, i);
	}
		public String getLatitude() {
		return latitude.getText();
	}
	public void setLatitude(JTextField latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude.getText();
	}
	public void setLongitude(JTextField longitude) {
		this.longitude = longitude;
	}
	public String getTimezone() {
		return (String) timezone.getSelectedItem();
	}
	public void setTimezone(JComboBox<?> timezone) {
		this.timezone = timezone;
	}
	
	public void setDay(JComboBox<String> day) {
		this.day = day;
	}
	public void setMonth(JComboBox<?> month) {
		this.month = month;
	}
	public int getMonth() {
		return	month.getSelectedIndex()+1;
	}
	public int getDay() {
		return	 day.getSelectedIndex()+1;
	}
	
	public int getYear() {
		return	Integer.parseInt((String) year.getText());
		 
	}
	public void setYear(JTextField year) {
		this.year = year;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(help))
		{
			help.setToolTipText("<html>Help you to find :<br>_Latitude,Longtitude.(online|offline)<br>_Timezone</html>");
		}
		else if (e.getSource().equals(home)) {
			home.setToolTipText("<html>Go to Home page</html>");
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		 if (e.getSource().equals(home)) { 
			 try{UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
				}catch(Exception ee){JOptionPane.showMessageDialog(null, ee.getMessage());}
			new FenetrePrincipal();
		
		}
		
	}
	
}