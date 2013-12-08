
package painter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

//painter mode
enum Status {draw_line,stop,free_draw,idle}

public class Painter extends JFrame{
    
    public Status status = Status.idle;
    Dimension size ;
    ToolBar toolbar;
    Page page;
    
     
     // <editor-fold defaultstate="collapsed" desc="Painter Code"> 
    Painter()
    {
      
        //title    (choudo hen te su ???
        super("ANP");  
       
        
        //frame size and set frame close 
        size = new Dimension(600,600);   
        this.setSize(size);    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLocationRelativeTo(null);
        
        
        toolbar = new ToolBar(this);                   
        this.getContentPane().add(toolbar, BorderLayout.NORTH);
        
        page = new Page(this);
        this.getContentPane().add(page,BorderLayout.CENTER);
        
        //let we see the ANP yooo                        
        this.setVisible(true);
    } // </editor-fold>
    
     //<editor-fold defaultstate="collapsed" desc="OpenFile">
     public  void openFileAction() {
        FileDialog fd = new FileDialog(this, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        String file = fd.getFile();
        if (file == null)
            return;
        file = fd.getDirectory() + file;
        try {
            Runtime.getRuntime().exec(
                    "cmd.exe /c start rundll32 url.dll,FileProtocolHandler "
                            + file);
        } catch (IOException e) { 
            e.printStackTrace();
        }
    }//</editor-fold>
    
     public void saveFileAction(){
     
     }
     
     //<editor-fold defaultstate="collapsed" desc="Main"> 
     public static void main(String arg[]){
         new Painter();
     }//</editor-fold>
}
