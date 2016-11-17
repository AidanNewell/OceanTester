import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.*;

public abstract class AssignmentTester implements ActionListener
{
    
    private JLabel label;
    private JPasswordField pass;
    private JLabel rlabel;
    private JFrame f;
    private JPanel p;
    private AssignmentTestCase[] cases;
    private boolean accessible;
    
    private static final String trackPath 
    = "T:\\Turnin-408\\Track-Programs";
    
    public String testName(){return "General Test";}
    
    public AssignmentTester()
    {
        accessible=false;
        cases = getCases();
        f = new JFrame();
        p = new JPanel();
        pass = new JPasswordField(10);
        pass.addActionListener(this);
        label = new JLabel("Enter password:");
        rlabel = new JLabel("");
        p.add(label);
        p.add(pass);
        p.add(rlabel);
        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
    }
    
    
    protected abstract AssignmentTestCase[] getCases();
    
	private static boolean passwordRecord(String pathname, String testName, boolean success){
		////
		String username = System.getProperty("user.name");
		String date = (new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss")).format(new Date());
		String yesNo = (success) ? "Y":"N";
		String successful = (success) ? "successful":"unsuccessful";
		String fileName = "PR" + date + "-" + username + "-" + yesNo + ".txt";
		////
		File directory = new File(pathname); //this is so the ending slash isn't required
		File fileToCreate = new File(directory.getAbsolutePath() + "\\" + fileName);
		Writer writer = null;
		if(!directory.exists()){
			return false;
		}
		try {
			if(fileToCreate.createNewFile()){
				writer = new BufferedWriter(new FileWriter(fileToCreate));
				writer.write(username + "\r\n");
				writer.write(testName + "\r\n");
				writer.write(date + "\r\n");
				writer.write(successful + "\r\n");
			}
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch(IOException e){
				//e.printStackTrace();
			}
		}
		return true;
	}
	private boolean recordTestAttempt(boolean successful){
		return passwordRecord(trackPath,testName(),successful);
	}
	
   public void actionPerformed(ActionEvent e)
    {
        String entered = pass.getText().toLowerCase();
        boolean passwordCorrect=password().equals(entered);
        boolean inTheLab = recordTestAttempt(passwordCorrect);
        if(inTheLab && passwordCorrect)
        {
            rlabel.setText("Access Granted");
            recordTestAttempt(true);
            accessible=true;
            f.dispose();
        }
        else
        {
        	String message = inTheLab?"Access Denied":"System Error";
            rlabel.setText(message);
            recordTestAttempt(false);
            f.pack();
            f.repaint();
        }
    }
    
    public void runTestCases()
    {
        f.setVisible(true);
        do{}while(!accessible);
        if(accessible)
        {
            getCases();
            for(int count=0; count<cases.length; ++count)
            {
                cases[count].runTest();
                System.out.println(count+". "+cases[count].getResult());
            }
        }
    }
    
	public static String stringFromBitMatrix(int[][] bits){
		String s = "";
		for (int pos=0;pos<bits.length;pos++){
			int twoPower=1;
			char c=0;
			for (int ind=0;ind<bits[pos].length; ind++){
				c+=twoPower*bits[pos][ind];
				twoPower*=2;
			}
			s+=c;
		}
		return s;
	}
	
	private static String password(){return "password";}
}