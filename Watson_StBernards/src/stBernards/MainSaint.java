package stBernards;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class MainSaint extends JFrame {
	public  DogList saints;
	
	public  JFrame f;	

	private Font myFont = new Font("Serif", Font.BOLD, 16);
	private Font bigFont = new Font("Serif", Font.BOLD, 20);
	private JButton srch =new JButton("Search");;  
	private JTextField search = new JTextField(20);
	private JLabel id = new JLabel("Enter name or registration number");
	private JLabel regNumber = new JLabel("Registration Number");
	private JLabel regName = new JLabel("Registered Name");
	private JLabel gender = new JLabel("Sex");
	private JLabel wDate = new JLabel("Whelp Date");
//	private JLabel sire = new JLabel("Sire");
	private JButton sireB = new JButton("Click for info on Sire" );
//	private JLabel dam = new JLabel("Dam");
	private JButton damB = new JButton("Click for info on Dam");
	private JButton pups = new JButton("Click for list of pups");

	private JButton newSaint=new JButton("ADD");
	private JButton submit = new JButton("SUBMIT FOR APPROVAL");
	private JLabel dinfo =new JLabel("Dog Information");;  
	private JTextArea rnum = new JTextArea("Registration number displayed here");
	private JTextArea rnam = new JTextArea("Registered name displayed here");
	private JTextArea dsex = new JTextArea("Saint's gender at birth displayed here");
	private JTextArea bday = new JTextArea("Saint's day first breathing");
	private JLabel momma = new JLabel("Saint's natural birth mother");
	private JLabel daddy = new JLabel("Saint's Sire");
	private JLabel puppy = new JLabel("Not yet active, check back for updates.");

	private JPanel topSearch = new JPanel();
	private JPanel data = new JPanel();
	private JLabel blank = new JLabel();


	public MainSaint(){
		saints =  new DogList();
		
		DogInfo dogS = new DogInfo();
		dogS.setRegNumber("WP61508303");
		DogList WP61508303 = new DogList();
		dogS.setName("Star's Shenendoah");
		dogS.setGender("Male");
		dogS.setWhelpDate("03/12/1995");
		dogS.setPups(WP61508303);
		saints.add(dogS);


		
		DogInfo dogD = new DogInfo();
		dogD.setRegNumber("WP53987303");
		DogList WP53987303 = new DogList();
		dogD.setName("Star's Reina Terror");
		dogD.setGender("Female");
		dogD.setWhelpDate("03/21/1994");
		dogD.setPups(WP53987303);
		saints.add(dogD);

		
		DogInfo dog1 = new DogInfo();
		dog1.setRegNumber("WP8854244");
		dog1.setName("Riverview's BB Cleopatra");
		dog1.setGender("Female");
		dog1.setWhelpDate("11/20/1998");
		dog1.setSire(saints.get("WP61508303"));
		dog1.getSire().getPups().add(dog1);
		dog1.setDam(saints.get("WP53987303"));
		dog1.getDam().getPups().add(dog1);
		saints.add(dog1);

		
		File file = new File("text.txt");
		if(file.exists()){
			Scanner scan = null;
			try {
				scan = new Scanner(new File("text.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			while(scan.hasNextLine()){
				DogInfo fDog = new DogInfo();
				
				String rn = scan.nextLine();
				String dn = scan.nextLine();
				String sex = scan.nextLine();
				String bd = scan.nextLine();
				String sInfo = scan.nextLine();
				String mInfo = scan.nextLine();
				scan.nextLine();
				
				fDog.setRegNumber(rn);
				fDog.setName(dn);
				fDog.setGender(sex);
				fDog.setWhelpDate(bd);
				fDog.setSire(saints.get(sInfo));
  				if(fDog.getSire() != null){
  					fDog.getSire().getPups().add(fDog);
  				}
  				
				fDog.setDam(saints.get(mInfo));
				if(fDog.getSire() != null){
					fDog.getDam().getPups().add(fDog);
				}
  				
				saints.add(fDog);
				System.out.println("Added from file: "+rn+ " " +dn );

			}
			scan.close();
		}
		
		
	    
	    data.setLayout(new GridLayout(8,2));
	    
	    topSearch.add(id);
	    id.setFont(myFont);
	    topSearch.add(search);
	    
	    srch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {

				// TODO Auto-generated method stub
				
				String value = search.getText();
	    		if(value.isEmpty()){
	    			JOptionPane.showMessageDialog(
	    					null, 
	    					"You must enter a Name or Registration number before searching",
	    					 "Searching for Saints",
	    					 JOptionPane.INFORMATION_MESSAGE);
	    			search.requestFocusInWindow();
	    			return;
	    		}
	    		try{
	    			DogInfo doggy = saints.get(value);
	    			if(doggy == null){
	    				JOptionPane.showMessageDialog(
	    						null,
	    						"Saint with '" + value + "' was not found. You can use the add button at bottom to enter new dog information or search again.",
	    						"Searching for Saints",
	    						JOptionPane.INFORMATION_MESSAGE);
	    				search.requestFocusInWindow();
	    				newSaint.setVisible(true);
	    				newSaint.setEnabled(true);
	    			}else{
	    				rnum.setText(doggy.getRegNumber());
	    				rnam.setText(doggy.getName());
	    				dsex.setText(doggy.getGender());
	    				bday.setText(doggy.getWhelpDate());
	    				
	    				daddy.setText(doggy.getSire() != null ? doggy.getSire().toString() : "Not Provided ");
	    				if(doggy.getSire() != null){
	    					sireB.setEnabled(true);
	    					
	    				}else{
	    					sireB.setEnabled(false);
	    				}
	    				momma.setText(doggy.getDam() != null ? doggy.getDam().toString() : "Not Provided ");
	    				if(doggy.getDam() != null){
	    					damB.setEnabled(true);
	    					
	    				}else{
	    					damB.setEnabled(false);
	    				}
	    				puppy.setText(doggy.getPups().isEmpty() != true ? ("Children of " + doggy.getName()) : "No Decendants");
	    				if(doggy.getPups().isEmpty() != true){
	    					pups.setEnabled(true);
	    				}else{
	    					pups.setEnabled(false);
	    				}
	    				search.setEnabled(true);
	    				newSaint.setVisible(false);
	    			}
	    			
	    		
	    		}
	    		catch(NumberFormatException e) {
					search.setText("");
					JOptionPane.showMessageDialog(
							null, 
							"Saint information can be partial name or registration number, try again.", 
							"Searching for Saints", 
							JOptionPane.ERROR_MESSAGE);
					srch.requestFocusInWindow();
				}
	    	}
	    });
	  
	    topSearch.add(srch);
	    
	    data.add(dinfo);
	    dinfo.setFont(bigFont);
	    dinfo.setHorizontalAlignment(SwingConstants.RIGHT);
	    data.add(blank);
	    data.add(regNumber);
	    regNumber.setFont(myFont);
	    regNumber.setVerticalAlignment(SwingConstants.TOP);
	    regNumber.setHorizontalAlignment(SwingConstants.CENTER);
	    data.add(rnum);
	    rnum.setEditable(false);
	    data.add(regName);
	    regName.setFont(myFont);
	    regName.setVerticalAlignment(SwingConstants.TOP);
	    regName.setHorizontalAlignment(SwingConstants.CENTER);
	    data.add(rnam);
	    rnam.setEditable(false);
	    rnam.setLineWrap(true);
	    data.add(gender);
	    gender.setFont(myFont);
	    gender.setVerticalAlignment(SwingConstants.TOP);
	    gender.setHorizontalAlignment(SwingConstants.CENTER);
	    data.add(dsex);
	    dsex.setEditable(false);
	    data.add(wDate);
	    wDate.setFont(myFont);
	    wDate.setVerticalAlignment(SwingConstants.TOP);
	    wDate.setHorizontalAlignment(SwingConstants.CENTER);
	    data.add(bday);
	    bday.setEditable(false);
	    data.add(sireB);
	    sireB.setEnabled(false);
	    
	    sireB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {

							
				String value = daddy.getText();
				
	    		DogInfo doggy = saints.get(value);
	    		rnum.setText(doggy.getRegNumber());
	    		rnam.setText(doggy.getName());
	    		dsex.setText(doggy.getGender());
	    		bday.setText(doggy.getWhelpDate());
	    		momma.setText(doggy.getDam() != null ? doggy.getDam().toString() : "Not Provided ");
	 			if(doggy.getDam() != null){
					damB.setEnabled(true);
				}else{
					damB.setEnabled(false);
				}
				daddy.setText(doggy.getSire() != null ? doggy.getSire().toString() : "Not Provided ");
				if(doggy.getSire() != null){
					sireB.setEnabled(true);
				}else{
					sireB.setEnabled(false);
				}
//				if(doggy.getPups().isEmpty() != true){
//					pups.setEnabled(true);
//				}else{
//	                pups.setEnabled(false);
//				}
	    		search.setEnabled(true);
	    		newSaint.setVisible(false);
			}
	    });
	    			
	    
	    data.add(daddy);
	    data.add(damB);
	    damB.setEnabled(false);
	    
	    damB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {

							
				String value = momma.getText();
	    		DogInfo doggy = saints.get(value);
	    		rnum.setText(doggy.getRegNumber());
	    		rnam.setText(doggy.getName());
	    		dsex.setText(doggy.getGender());
	    		bday.setText(doggy.getWhelpDate());
	    		momma.setText(doggy.getDam() != null ? doggy.getDam().toString() : "Not Provided ");
				if(doggy.getDam() != null){
					damB.setEnabled(true);
				}else{
					damB.setEnabled(false);
				}
				daddy.setText(doggy.getSire() != null ? doggy.getSire().toString() : "Not Provided ");
				if(doggy.getSire() != null){
					sireB.setEnabled(true);
				}else{
					sireB.setEnabled(false);
				}
				if(doggy.getPups().isEmpty() != true){
					pups.setEnabled(true);
				}else{
	                pups.setEnabled(false);
				}
	    		search.setEnabled(true);
	    		newSaint.setVisible(false);
			}
	    });
	    			
	    		
	    		
	    
	    data.add(momma);
	    data.add(pups);
	    pups.setHorizontalAlignment(SwingConstants.CENTER);
	    pups.setEnabled(false);
	    
//	    pups.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent event) {
//
//							
//				String value = momma.getText();
//	    		DogInfo doggy = saints.get(value);
//	    		rnum.setText(doggy.getRegNumber());
//	    		rnam.setText(doggy.getName());
//	    		dsex.setText(doggy.getGender());
//	    		bday.setText(doggy.getWhelpDate());
//	    		momma.setText(doggy.getDam() != null ? doggy.getDam().toString() : "Not Provided ");
//				if(doggy.getDam() != null){
//					damB.setEnabled(true);
//				}else{
//					damB.setEnabled(false);
//				}
//				daddy.setText(doggy.getSire() != null ? doggy.getSire().toString() : "Not Provided ");
//				if(doggy.getSire() != null){
//					sireB.setEnabled(true);
//				}else{
//					sireB.setEnabled(false);
//				}
//	    		search.setEnabled(true);
//	    		newSaint.setVisible(false);
//			}
//		});
	    
	    data.add(puppy);



	    add(topSearch,BorderLayout.NORTH);  
	    add(newSaint,BorderLayout.SOUTH);  
	    
	    
	    newSaint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {

	    		try{
	    			DogInfo doggy = new DogInfo();
	    				String doggyNumber = JOptionPane.showInputDialog("What is the registration number of the dog you want to add? Do not use '/' mark.");
	    				rnum.setText(doggyNumber);
	    				rnum.setEditable(true);
	    				String doggyName = JOptionPane.showInputDialog("What is the registered name of the dog you want to add?");
	    				rnam.setText(doggyName);
	    				rnam.setEditable(true);
	    				String doggySex = JOptionPane.showInputDialog("What is the gender of the dog you want to add? Please type either Male or Female");
	    				dsex.setText(doggySex);
	    				dsex.setEditable(true);
	    				String doggyBday = JOptionPane.showInputDialog("Please enter the birthday of the dog you want to enter as MM/DD/YYYY.");
	    				bday.setText(doggyBday);
	    				bday.setEditable(true);
	    				JOptionPane.showMessageDialog(null, "Click 'Submit for Approval' button to add dog to file. Please send me an email at UTB4Me@gmail.com with breeding info to have "+doggyName+" added to tree. Feel free to also add parents and pups to this program.");

	    				doggy.setRegNumber(doggyNumber);
	    				doggy.setName(doggyName);
	    				doggy.setGender(doggySex);
	    				doggy.setWhelpDate(doggyBday);

	    				newSaint.setVisible(false);
	    				add(submit, BorderLayout.SOUTH);
	    				submit.setVisible(true);
	    				submit.setEnabled(true);
	    				submit.addActionListener(new ActionListener() {
	    					
	    					@Override
	    					public void actionPerformed(ActionEvent event) {
	    	    				saints.add(doggy);
	    	    				System.out.println("Added by user: "+doggy.getRegNumber() +" "+ doggy.getName() +" "+ doggy.getGender() +" "+ doggy.getWhelpDate() );
	    	    				submit.setVisible(false);
	    	    				newSaint.setVisible(false);
	    	    				search.setEnabled(true);

	    					}
	    				});
	    			
	    		}
	    		
//	    		}
	    		catch(NumberFormatException e) {
					search.setText("");
					JOptionPane.showMessageDialog(
							null, 
							"Saint information can be partial name or registration number, try again.", 
							"Searching for Saints", 
							JOptionPane.ERROR_MESSAGE);
					srch.requestFocusInWindow();
				}
	    	}
	    });
	    
	    newSaint.setEnabled(false);
	    add(data,BorderLayout.CENTER);  
	      
	    setSize(600,900);  
	    setTitle("Cleopatra's Search");
	    setVisible(true);  

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				printMemo();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void printMemo(){
		PrintWriter pw;
		try {
			
			 pw = new PrintWriter(new File("text.txt"));
	
			 
			 for(int i = 0; i < saints.getCount();  i++){
				 DogInfo dog = (DogInfo) saints.get(i);
				 pw.println(dog.getRegNumber());
				 pw.println(dog.getName());
				 pw.println(dog.getGender());
				 pw.println(dog.getWhelpDate());
				 if(dog.getSire() != null){
					 pw.println(dog.getSire().getRegNumber());
				 }else{
					 pw.println("null");
				 }
				 if(dog.getDam() != null){
					 pw.println(dog.getDam().getRegNumber());
				 }else{
					 pw.println("null");
				 }
				 pw.println();
				 System.out.println("Saved to file : "+ dog.getRegNumber() + " " +dog.getName());
			 }
			 
			 pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	   
	}

	public static void main(String[] args){

		new MainSaint();
		
	}
}


//add window listener on jfram and inside window listener, new window listener, window closing, then write to file.