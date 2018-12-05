
package stBernards;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  
  
public class SearchFrame extends JFrame {  
JFrame f;
private Font myFont = new Font("Serif", Font.BOLD, 16);
private Font bigFont = new Font("Serif", Font.BOLD, 20);
private JButton srch =new JButton("Search");;  
private JTextField search = new JTextField(20);
private JLabel id = new JLabel("Enter name or registration number");
private JLabel regNumber = new JLabel("Registration Number");
private JLabel regName = new JLabel("Registered Name");
private JLabel gender = new JLabel("Sex");
private JLabel wDate = new JLabel("Whelp Date");
private JLabel sire = new JLabel("Sire");
private JButton sireB = new JButton("Click for info on Sire" );
private JLabel dam = new JLabel("Dam");
private JButton damB = new JButton("Click for info on Dam");
private JButton pups = new JButton("Click for list of pups");

private JButton newSaint=new JButton("ADD");;  
private JLabel dinfo =new JLabel("Dog Information");;  
private JTextArea rnum = new JTextArea("Registration number displayed here");
private JTextArea rnam = new JTextArea("Registered name displayed here");
private JTextArea dsex = new JTextArea("Saint's gender at birth displayed here");
private JTextArea bday = new JTextArea("Saint's day first breathing");
private JLabel momma = new JLabel("Saint's natural birth mother");
private JLabel daddy = new JLabel("Saint's Sire");
private JLabel puppy = new JLabel("Descendants of Saint");

private JPanel topSearch = new JPanel();
private JPanel data = new JPanel();
private JLabel blank = new JLabel();


SearchFrame(){  
    f=new JFrame();  
    
    
   
    
    data.setLayout(new GridLayout(8,2));
    
    topSearch.add(id);
    id.setFont(myFont);
    topSearch.add(search);
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
    data.add(daddy);
    data.add(damB);
    damB.setEnabled(false);
    data.add(momma);
    data.add(pups);
    pups.setHorizontalAlignment(SwingConstants.CENTER);
    pups.setEnabled(false);
    data.add(puppy);


    
    f.add(topSearch,BorderLayout.NORTH);  
    f.add(newSaint,BorderLayout.SOUTH);  
    newSaint.setEnabled(false);
    f.add(data,BorderLayout.CENTER);  
      
    f.setSize(600,900);  
    f.setTitle("Cleopatra's Search");
    f.setVisible(true);  
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    


    
//    srch.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent event) {
//			String value = search.getText();
//			if(value.isEmpty()) {
//				JOptionPane.showMessageDialog(
//						null, 
//						"You must enter a Name or Registration number before searching", 
//						"Searching for Saints", 
//						JOptionPane.WARNING_MESSAGE);
//				search.requestFocusInWindow();
//				return;
//			}
//			int id = 0;
//			try{
//				id = Integer.valueOf(value);
//				int index = -1;
//				for(int i = 0; i < )
//						
//					}
//				}
//			}
//		}
//    });
//}
//
//
//
//public static void main(String[] args){
//	new SearchFrame();
}
}
			