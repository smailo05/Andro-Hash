package inf.biskra.application_hash;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import android.os.Bundle;

import android.app.ListActivity;
import android.content.Intent;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {
	private FileArrayAdapter adapter;
    private File currentDir;
   static String NameFile,PathFile;


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       
       
       

        currentDir = new File("/sdcard/");

        fill(currentDir);

    }
    private void fill(File f)
    
        {
    
            File[]dirs = f.listFiles();
    
             this.setTitle("Current Dir: "+f.getName());
    
             List<Option>dir = new ArrayList<Option>();
    
             List<Option>fls = new ArrayList<Option>();
    
             try{
    
                 for(File ff: dirs)
    
                 {
    /*La méthode retourne vrai si et seulement si le fichier désigné par ce chemin abstrait
                	 est un répertoire autre la méthode retourne false.*/
                    if(ff.isDirectory())
    
                        dir.add(new Option(ff.getName(),"Folder",ff.getAbsolutePath()));
    
                    else
    
                    {
    
                        fls.add(new Option(ff.getName(),"File Size: "+ff.length(),ff.getAbsolutePath()));
    
                    }
    
                 }
    
             }catch(Exception e)
    
             {
    
                  
    
             }
    
             Collections.sort(dir);
   
             Collections.sort(fls);
   
             dir.addAll(fls);
    
             if(!f.getName().equalsIgnoreCase("sdcard"))
    
                 dir.add(0,new Option("..","Parent Directory",f.getParent()));
             adapter = new FileArrayAdapter(MainActivity.this,R.layout.file_view,dir);
    		 this.setListAdapter(adapter);
   
        }

    protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Option o = adapter.getItem(position);
		if(o.getData().equalsIgnoreCase("folder")||o.getData().equalsIgnoreCase("parent directory")){
				currentDir = new File(o.getPath());
				fill(currentDir);
		}
		else
		{
			try {
				onFileClick(o);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    private void onFileClick(Option o) throws IOException
    {
    	
    	
		
    	Toast.makeText(this, "File Clicked: "+o.getName(), Toast.LENGTH_SHORT).show();
    	 NameFile =o.getName();
    	 PathFile=o.getPath();
    	 
			
    	startActivity(new Intent(MainActivity.this,file.class));
    }
    

}
