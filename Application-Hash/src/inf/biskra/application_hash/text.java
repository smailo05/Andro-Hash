package inf.biskra.application_hash;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class text extends Activity {
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //lancé l'activity layout.text
        setContentView(R.layout.text);
        
        // On récupère toutes les vues dont on a besoin
        final Button b1=(Button)findViewById(R.id.button1);
        final Button b2=(Button)findViewById(R.id.button2);
        final EditText e1=(EditText)findViewById(R.id.editText1);
        final TextView t1=(TextView)findViewById(R.id.textView1);
        final TextView t5=(TextView)findViewById(R.id.textView5);
        final TextView t6=(TextView)findViewById(R.id.textView6);
        final TextView t7=(TextView)findViewById(R.id.textView7);
        
       
        //onclik sur Button b2 pour effacer le text de EditText1 et Textview 5 et 7
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				e1.setText("");
				t5.setText("");
				t7.setText("");
				//b2.setBackgroundResource(R.drawable.clik);
				
			}
		});
        

    	
		//Remplir le Spinner par les méthodes de hachage
		
		  Spinner liste = (Spinner) findViewById(R.id.spinner1);
	        List<String> exemple = new ArrayList<String>();
	        
	        exemple.add("Hash MD5");
	        exemple.add("Hash SHA1");
	        exemple.add("Hash SHA-256");
	        exemple.add("Hash SHA-384");
	      
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple);
	        
	        //Le layout par défaut est android.R.layout.simple_spinner_dropdown_item
	        
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        liste.setAdapter(adapter);
	        
	       
	        
	        //les operation qui s'excuter a chaque méthode (Item)
	        liste.setOnItemSelectedListener(new OnItemSelectedListener() {
	        	  
				@Override
				public void onItemSelected  (AdapterView<?> parent, View view,
						int pos, long id) {
					// TODO Auto-generated method stub
					
				switch(pos)
				
					{case 0://la méthode 0 est MD5
						
						{	t1.setText("MD5 Hash-Text");
							b1.setText("Calculate MD5");
							t6.setText("MD5 Hash:");
							t5.setText("");
							t7.setText("");
							
							 //onclik sur Button b1 pour calcule le hacahge de EditText e1 puis afficher le resultat
							
							b1.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									if(!e1.getText().toString().equals(""))
									{
									t5.setText(e1.getText().toString());
									t7.setText(method.getEncodedMD5(e1.getText().toString()));
									}
								}
							});
						
							
					
						
						}break;
					case 1://la méthode 1 est SHA1
						
					{
						
						t1.setText("SHA1 Hash-Text");
						b1.setText("Calculate SHA1");
						t6.setText("SHA1 Hash:");
						t5.setText("");
						t7.setText("");
						
						 //onclik sur Button b1 pour calcule le hacahge de EditText e1 puis afficher le resultat
						
						b1.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								if(!e1.getText().toString().equals(""))
								{
								t5.setText(e1.getText().toString());
								t7.setText(method.getEncodedSHA1(e1.getText().toString()));
								}
							}
						});
						
					
					
					
					
					
					}break;
					
					case 2://la méthode 2 est SHA-256
						
					{
						
						t1.setText("SHA-256 Hash-Text");
						b1.setText("Calculate SHA-256");
						t6.setText("SHA-256 Hash:");
						t5.setText("");
						t7.setText("");
						
						 //onclik sur Button b1 pour calcule le hacahge de EditText e1 puis afficher le resultat
						
						b1.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								if(!e1.getText().toString().equals(""))
								{
								t5.setText(e1.getText().toString());
								t7.setText(method.getEncodedSHA256(e1.getText().toString()));
								}
							}
						});
						
					
					
					
					}break;
					case 3://la méthode 3 est SHA-384
						
					{
						
						t1.setText("SHA-384 Hash-Text");
						b1.setText("Calculate SHA-384");
						t6.setText("SHA-384 Hash:");
						t5.setText("");
						t7.setText("");
						
						 //onclik sur Button b1 pour calcule le hacahge de EditText e1 puis afficher le resultat
						
						b1.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								
								if(!e1.getText().toString().equals(""))
								{
								t5.setText(e1.getText().toString());
								t7.setText(method.getEncodedSHA384(e1.getText().toString()));
								}
							}
						});
						
				
			
				
				}break;
				
				
					        
					}
				
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
	        	
			});

	}
}
