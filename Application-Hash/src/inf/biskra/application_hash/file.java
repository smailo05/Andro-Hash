package inf.biskra.application_hash;






import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;








import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class file extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//lancé l'activity layout.file
		setContentView(R.layout.file);
		
		//NomF contient le nom d'un fichier
		final ArrayList<String> NomF = new ArrayList<String>();
		
		//EXT contient extention d'un fichier
	    final ArrayList<String> EXT = new ArrayList<String>();
		
		//// On récupère toutes les vues dont on a besoin
		final Button b1=(Button)findViewById(R.id.button1);
		final Button b2=(Button)findViewById(R.id.button2);
		final Button b3=(Button)findViewById(R.id.button3);
		final TextView t1=(TextView)findViewById(R.id.textView1);
		final TextView t5=(TextView)findViewById(R.id.textView5);
		final TextView t6=(TextView)findViewById(R.id.textView6);
		final TextView t7=(TextView)findViewById(R.id.textView7);
		final TextView t8=(TextView)findViewById(R.id.textView8);
		final TextView t9=(TextView)findViewById(R.id.textView9);
		final EditText e1=(EditText)findViewById(R.id.editText1);
		
		
		
		 //crée un objet de classe Sfv pour ouvrir le fichier qui contient l'algorithme de fichier qui télechargé
		
		 final sfv B=new sfv();
		
		 
			
			for(int i=0;i<FileArrayAdapter.NameF.size();i++)
			{
				if(!FileArrayAdapter.DataF.get(i).equals("Folder"))
				{	
			 final StringTokenizer stToken = new StringTokenizer(FileArrayAdapter.NameF.get(i),".");
	    	    final String[] splitStr = new String[stToken.countTokens()];
	    	  
	    	    
	    	    int index = 0;
	    	    while(stToken.hasMoreElements()) {
	    	       splitStr[index] = stToken.nextToken();
	    	       
	    	    	
	    	       if(index==0)
	    	       NomF.add(splitStr[index]);
	    	      
	    	    	   if(index==1)
	    	    	    EXT.add(splitStr[index]);
	    	    	
	    	    	   
	    	    	
	    	    	
	    	    	   
	    	    	   
	    	    	   index++;
	    	    	  
	    	       }
				}
			}
			
			// ouvrir le fichier qui contient l'algorithme de fichier qui télechargé  
			try {
				for(int i=0;i<EXT.size();i++)
				{if(EXT.get(i).equals("sfv"))
				 sfv.getFile("/sdcard/"+NomF.get(i)+".sfv");
				}
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		
		
		//crée un objet de la classe MainActivity pour Récupérer le nom de fichier selectionné
		final MainActivity A=new MainActivity();
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				//aller au sdcard qui contient les fichies
				startActivity(new Intent(file.this,MainActivity.class));
				
				
				
			}
		});
		
		//Récupérer le nom de fichier selectionné et afficher sur EditText1
		e1.setText(A.PathFile);
	

		//Remplir le Spinner par des méthodes de hachage

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
				
				{
				t1.setText("MD5 Hash-File");
				
				b2.setText("Calculate MD5");
				
				t6.setText("MD5 Hash:");
				t5.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				
		
				
				//Onclik sur le Button b2 pour fiat le calcul puis afficher le resultat
				b2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						t5.setText(A.NameFile);
						try {
							t7.setText( FileCheckSum.getMD5Checksum(A.PathFile));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				
				for(int i = 0; i <B.Nom.size()&&i <B.Algo.size()&&i <B.Val.size(); i++)
				{
				
					if(B.Nom.get(i).equals(A.NameFile)&&B.Algo.get(i).equals("MD5"))
					{
						t8.setText("Compare To:");
						t9.setText(B.Val.get(i));
					}
				}
				// onclik sur Button b2 pour comparé la valeur de fichier sfv et le fichier qui télecharger
				b3.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						if(t7.getText().toString().equals(t9.getText().toString()))
						{
							Toast.makeText(file.this,"EQUALS", Toast.LENGTH_LONG).show();
						}else
							
							Toast.makeText(file.this,"NO EQUALS", Toast.LENGTH_LONG).show();
						
					}
				});
				  
				
				
				}break;
			case 1://la méthode 1 est SHA1
				
			{
				t1.setText("SHA1 Hash-File");
				
				b2.setText("Calculate SHA1");
				
				t6.setText("SHA1 Hash:");
				t5.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				
		
				
				//Onclik sur le Button b2 pour fiat le calcul puis afficher le resultat
				b2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						t5.setText(A.NameFile);
						try {
							t7.setText( FileCheckSum.getSHA1Checksum(A.PathFile));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				
				for(int i = 0; i <B.Nom.size()&&i <B.Algo.size()&&i <B.Val.size(); i++)
				{
				
					if(B.Nom.get(i).equals(A.NameFile)&&B.Algo.get(i).equals("SHA1"))
					{
						t8.setText("Compare To:");
						t9.setText(B.Val.get(i));
					}
				}
				
				b3.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						if(t7.getText().toString().equals(t9.getText().toString()))
						{
							Toast.makeText(file.this,"EQUALS", Toast.LENGTH_LONG).show();
						}else
							
							Toast.makeText(file.this,"NO EQUALS", Toast.LENGTH_LONG).show();
						
					}
				});
			}break;
			
			case 2://la méthode 2 est SHA-256
				
			{
				t1.setText("SHA-256 Hash-File");
				
				b2.setText("Calculate SHA-256");
				
				t6.setText("SHA-256 Hash:");
				t5.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				
		
				
				//Onclik sur le Button b2 pour fiat le calcul puis afficher le resultat
				b2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						t5.setText(A.NameFile);
						try {
							t7.setText( FileCheckSum.getSHA256Checksum(A.PathFile));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				
				for(int i = 0; i <B.Nom.size()&&i <B.Algo.size()&&i <B.Val.size(); i++)
				{
				
					if(B.Nom.get(i).equals(A.NameFile)&&B.Algo.get(i).equals("SHA-256"))
					{
						t8.setText("Compare To:");
						t9.setText(B.Val.get(i));
					}
				}
				
				b3.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						if(t7.getText().toString().equals(t9.getText().toString()))
						{
							Toast.makeText(file.this,"EQUALS", Toast.LENGTH_LONG).show();
						}else
							
							Toast.makeText(file.this,"NO EQUALS", Toast.LENGTH_LONG).show();
						
					}
				});
			}break;
			
			case 3://la méthode 3 est SHA-384
				
			{
				t1.setText("SHA-384 Hash-File");
				
				b2.setText("Calculate SHA-384");
				
				t6.setText("SHA-384 Hash:");
				t5.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				
		
				
				//Onclik sur le Button b3 pour fiat le calcul puis afficher le resultat
				b2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						t5.setText(A.NameFile);
						try {
							t7.setText( FileCheckSum.getSHA384Checksum(A.PathFile));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				
				for(int i = 0; i <B.Nom.size()&&i <B.Algo.size()&&i <B.Val.size(); i++)
				{
				
					if(B.Nom.get(i).equals(A.NameFile)&&B.Algo.get(i).equals("SHA-384"))
					{
						t8.setText("Compare To:");
						t9.setText(B.Val.get(i));
					}
				}
				
				b3.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						if(t7.getText().toString().equals(t9.getText().toString()))
						{
							Toast.makeText(file.this,"EQUALS", Toast.LENGTH_LONG).show();
						}else
							
							Toast.makeText(file.this,"NO EQUALS", Toast.LENGTH_LONG).show();
						
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
