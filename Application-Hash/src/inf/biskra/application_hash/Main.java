package inf.biskra.application_hash;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	
	
	 //Onclik sur Button b1 pour calcul le hachage de la forme text
    
    Button b1=(Button)findViewById(R.id.button1);
    b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(Main.this,text.class));
			
		}
	});
    
    
  //Onclik sur Button b2 pour calcul le hachage de la forme fichier
    
    Button b2=(Button)findViewById(R.id.button2);
    b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg) {
			// TODO Auto-generated method stub
			
			
			startActivity(new Intent(Main.this,file.class));
		}
	});
    
    
//Onclik sur Button b3 pour plus d'information sur cette application
    
    Button b3=(Button)findViewById(R.id.button3);
    b3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg) {
			// TODO Auto-generated method stub
			
			
			startActivity(new Intent(Main.this,Home.class));
		}
	});
}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	
}
