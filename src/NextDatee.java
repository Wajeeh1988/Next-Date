/*
 * Student name: wajeeh ALMadhri
 * Student #: T00260251
 * course: Software Testing
 * Date: 8/2/2016
 */
import org.eclipse.jface.dialogs.MessageDialog; 
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class NextDatee {

	protected Shell shell;
	private Text textDay;
	private Text textMonth;
	private Text textYear;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NextDatee window = new NextDatee();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		
		textDay = new Text(shell, SWT.BORDER);
		textDay.setBounds(47, 107, 111, 30);
		
		Label lblEnterTheDate = new Label(shell, SWT.NONE);
		lblEnterTheDate.setFont(SWTResourceManager.getFont("Times New Roman", 14, SWT.BOLD));
		lblEnterTheDate.setBounds(94, 83, 50, 18);
		lblEnterTheDate.setText("Day");
		
		Label lblNextDateProgram = new Label(shell, SWT.NONE);
		lblNextDateProgram.setFont(SWTResourceManager.getFont("Times New Roman", 26, SWT.ITALIC));
		lblNextDateProgram.setAlignment(SWT.CENTER);
		lblNextDateProgram.setBounds(108, 10, 245, 36);
		lblNextDateProgram.setText("Next Date Program ");
		
		final Label output1 = new Label(shell, SWT.BORDER | SWT.SHADOW_IN);
		output1.setAlignment(SWT.CENTER);
		output1.setFont(SWTResourceManager.getFont("Times New Roman", 16, SWT.NORMAL));
		output1.setText("Next Date is ");
		output1.setBounds(108, 160, 261, 36);
		
		Button botton1 = new Button(shell, SWT.NONE);
		botton1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				try{
					//Initialization 
					
			    	int day= Integer.parseInt(textDay.getText());
			    	 int month= Integer.parseInt(textMonth.getText());
			    	 int year= Integer.parseInt(textYear.getText());
			   
			        
		
			        //Make a boolean
			        boolean validDate;
			        //Set the date to false
			        validDate = false;
			       
			      
			    
			       

			    	  if((month >= 1 && month <= 12) && (day >= 1 && day <= 31) && (year>= 1812 && year <=2012))
			    	  {
			            //For months with 30 days
			            if((month == 4 || month == 6 || month == 9 || month == 11) && (day <= 30))
			            {
			                validDate = true;
			            }

			            //For months with 31 days
			            if((month == 1 || month == 2 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day <= 31))
			            {
			                validDate = true;
			            }

			            //For February
			            if((month == 2) && (day < 30))
			            {
			                //Boolean for valid leap year
			                boolean validLeapYear = false;

			                //A leap year is any year that is divisible by 4 but not divisible by 100 unless it is also divisible by 400
			                if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
			                {
			                    validLeapYear = true;
			                    if (validLeapYear == true && day <= 29)
				                {
				                    validDate = true;
				                }

				                else if (validLeapYear == false && day <= 28)
				                {
				                    validDate = true;
				                }
			                }

			               
			            }
			    	  }
			        
			       
			        

			        String date1=month + "/" + day + "/" + year ;
			        //If the date is valid
			        if(validDate == true)
			        {
			        	
			           
			           
			            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			            
			            try
			            {
			              
			              java.util.Date date =  formatter.parse(date1);
			         
			              Calendar c = Calendar.getInstance();
			              c.setTime(date);
			              c.add(Calendar.DATE, 1);
			              java.util.Date newDate = c.getTime();
			              String Date123=  formatter.format(newDate);
			              output1.setText(Date123);
			              
			              
			              
			            }
			            catch (ParseException e1)
			            {
			              // execution will come here if the String that is given
			              // does not match the expected format.
			             MessageDialog.openError(shell,"Error","Invalid date!\n"+
				                   "the day shold be between 1 to 31\n"+
				            		"the months should be between 1 to 12\n"+
				                   "The year should be between 1812 to 2012");
			             
			            }
			        }

			        else
			        {
			        	MessageDialog.openError(shell,"Error","Invalid date!\n"+
				                   "the day shold be between 1 to 31\n"+
				            		"the months should be between 1 to 12\n"+
				                   "The year should be between 1812 to 2012/n");
			        	output1.setText("");
			        }
				}catch(Exception exc){
					MessageDialog.openError(shell,"Error","Invalid date!\n"+
			                   "the day shold be between 1 to 31\n"+
			            		"the months should be between 1 to 12\n"+
			                   "The year should be between 1812 to 2012/n");
				}
				
		   
		    	 
				
			}
		});
		botton1.setFont(SWTResourceManager.getFont("Times New Roman", 13, SWT.ITALIC));
		botton1.setBounds(109, 202, 244, 47);
		botton1.setText("SEE THE NEXT DATE ");
		
		
		
		Label lblMonth = new Label(shell, SWT.NONE);
		lblMonth.setText("Month");
		lblMonth.setFont(SWTResourceManager.getFont("Times New Roman", 14, SWT.BOLD));
		lblMonth.setBounds(204, 83, 50, 14);
		
		textMonth = new Text(shell, SWT.BORDER);
		textMonth.setBounds(179, 107, 111, 30);
		
		Label lblYear = new Label(shell, SWT.NONE);
		lblYear.setText("Year");
		lblYear.setFont(SWTResourceManager.getFont("Times New Roman", 14, SWT.BOLD));
		lblYear.setBounds(354, 83, 50, 18);
		
		textYear = new Text(shell, SWT.BORDER);
		textYear.setBounds(317, 107, 111, 30);

	}
}
