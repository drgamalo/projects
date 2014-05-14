package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R.string;
import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;


@SuppressLint("UseValueOf") public class MainActivity extends ActionBarActivity implements OnClickListener, OnFocusChangeListener{
	
	private TableLayout tableLayout;
	private Button resetButton;
	private TextView tipAmount;
	private TextView totalPayment;
	private EditText billAmount;
	private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
	private double tipamount, totalpayment;
	private double tip1=0.10;
	private double tip2=0.15;
	private double tip3=0.20;
	private double tip4=0.25;
	private double tip;
	private int buttonNumber;
	private boolean check = false;

	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        resetButton = (Button) findViewById(R.id.resetButton);
        tipAmount = (TextView) findViewById(R.id.tipAmount);
        totalPayment = (TextView) findViewById(R.id.totalPayment);
        billAmount = (EditText) findViewById(R.id.billAmount);
        resetButton.setOnClickListener(this);
        billAmount.setOnFocusChangeListener(this);
       
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.tableLayout, new PlaceholderFragment())
                    .commit();
        }
    }

    public void Updater(double totalpayment){
    	
    	tipAmount = (TextView) findViewById(R.id.tipAmount);
        totalPayment = (TextView) findViewById(R.id.totalPayment);
        billAmount = (EditText) findViewById(R.id.billAmount);
        DecimalFormat df=new DecimalFormat("0.00");
        String totalPayment1 = df.format(totalpayment);
        String tip1 = df.format(tip);
        String tipamount1 = df.format(tipamount);
    	tipAmount.setText("$" + tipamount1);
    	billAmount.setText("$" + tip1);
    	totalPayment.setText("$" + totalPayment1);
    }
    
    	
		
    public void Compute(int buttonNumber){
    	
    	
    	switch(buttonNumber){
    		case 1:
    			tip = Double.parseDouble(billAmount.getText().toString().replace("$", ""));
    			tipamount = tip*tip1;
    			totalpayment = tip + tipamount;
    			Updater(totalpayment);
    			break;
    		case 2:
    			tip = Double.parseDouble(billAmount.getText().toString().replace("$", ""));
    			tipamount = tip*tip2;
    			totalpayment = tip + tipamount;
    			Updater(totalpayment);
    			break;
    		case 3:
    			tip = Double.parseDouble(billAmount.getText().toString().replace("$", ""));
    			tipamount = tip*tip3;
    			totalpayment = tip + tipamount;
    			Updater(totalpayment);
    			break;
    		case 4:
    			tip = Double.parseDouble(billAmount.getText().toString().replace("$", ""));
    			tipamount = tip*tip4;
    			totalpayment = tip + tipamount;
    			Updater(totalpayment);
    			break;
    		
    		}return; 
    	}
    
   	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    
	@Override
	public void onClick(View v) {
		if(v==resetButton){
			tipAmount.setText("$0.00");
	    	billAmount.setText("$0.00");
	    	totalPayment.setText("$0.00");
	    	RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
	    	radioGroup1.check(R.id.radioButton1);
		}else if(v==billAmount){
			tipAmount.setText("$0.00");
	    	billAmount.getText().clear();
	    	totalPayment.setText("$0.00");
	    	
	    	
		}
	    	
		
		
	}

	private boolean isEmpty(EditText billAmount) {
		
	    if (billAmount.getText().toString().trim().length() > 0) {
	        check = false;
	    	return check;
	    } else {
	    	check = true;
	        return check;
	    }
	    
	}
	

	public void onRadioButtonClicked(View v) {
		
	    boolean checked = ((RadioButton) v).isChecked();
	    
	    	switch(v.getId()) {
	    
	        case R.id.radioButton1:
	            if (checked){
	               buttonNumber = 1;
	               Compute(buttonNumber);
	            }
	            break;
	        case R.id.radioButton2:
	            if (checked){
	                buttonNumber = 2;
	                Compute(buttonNumber);
	            }
	            break;
	            
	        case R.id.radioButton3:
	            if (checked){
	               buttonNumber = 3;
	               Compute(buttonNumber);
	            }
	            break;
	        case R.id.radioButton4:
	            if (checked){
	                buttonNumber = 4;
	                Compute(buttonNumber);
	            }
	            break;
	    }
	}
	
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if(v==billAmount && hasFocus==false){
			billAmount.setText("$"+billAmount.getText());
		}
		else if(v==billAmount && hasFocus==true){
			tipAmount.setText("$0.00");
	    	billAmount.getText().clear();
	    	totalPayment.setText("$0.00");    
		}
		
	
	}
}