
package painter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

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
    
    //<editor-fold defaultstate="collapsed" desc="OpenPicture">
     public  void openFileAction() {
        JFileChooser chooser = new JFileChooser();
        chooser.setVisible(true);
        
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
        String path = chooser.getSelectedFile().getPath();
        //String newPath = path.replace("\\\\", "\\\\\\");
        Image image = null;
        try{
            File file = new File(path);
            image = ImageIO.read(file);
            JFrame frame = new JFrame();
            //JLabel label = new JLabel(new ImageIcon(image));
            JButton btn = new JButton(new ImageIcon(image));
            frame.getContentPane().add(btn,BorderLayout.CENTER);
            frame.setSize(500, 500);
            frame.pack();
            frame.setVisible(true);
            
        }
        catch(Exception e){e.printStackTrace();}}
        
        
       /* if (file == null)
            return;
            file = fd.getDirectory() + file;
        try {
            Runtime.getRuntime().exec(
                    "cmd.exe /c start rundll32 url.dll,FileProtocolHandler "
                            + file);
        } catch (IOException e) { 
            e.printStackTrace();
        }*/
    }//</editor-fold>
     
    
     
    //<editor-fold defaultstate="collapsed" desc="Main"> 
     public static void main(String arg[]){
         new Painter();
     }//</editor-fold>
}
