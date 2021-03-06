package painter;


import javax.swing.*;

import java.awt.*;
import java.io.*;
//import javax.imageio.*;
//import java.applet.*;
import java.util.*;
//import java.awt.geom.*;

//painter mode
enum Status {draw_line,stop,free_draw,idle,readytoDrawLine,drawLining,readytoCreatingOBj,creatingOBJ,clean}

public class Painter extends JFrame{
    
    public Status status= Status.idle;
    Dimension size ;
    ToolBar toolbar;
    Page page;
    Image image = null;
    FileDialog dialog ;
    FileDialog dialogS;
    Vector paintInfo = null;
    FileInputStream picIn = null;
    FileOutputStream picOut = null;
    ObjectInputStream oIn = null;
    ObjectOutputStream oOut = null;
    Button open ; 
    Point p1,p2;
    Menu menuBar;
    
    
    // <editor-fold defaultstate="collapsed" desc="Painter Code"> 
    Painter()
    {
        //status = Status.idle;
      
        //title    (choudo hen te su ???
        super("ANP");  
        
        p1 = new Point(-1,-1);
       paintInfo = new Vector();
        
        
        //frame size and set frame close 
        size = new Dimension(600,600);   
        this.setSize(size);    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLocationRelativeTo(null);
        
        
        //toolbar = new ToolBar(this);                   
        //this.getContentPane().add(toolbar, BorderLayout.NORTH);
        
        
        
        menuBar = new Menu(this);
        this.getContentPane().add(menuBar,BorderLayout.NORTH);
        
        page = new Page(this);
        this.getContentPane().add(page,BorderLayout.CENTER);
        
        //let we see the ANP yooo                        
        this.setVisible(true);
        //pack();
    } // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="OpenPicture">

    /*

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
            //JFrame frame = new JFrame();
            JLabel label = new JLabel(new ImageIcon(image));
            //JButton btn = new JButton(new ImageIcon(image));
            this.page.getContentPane().add(label,BorderLayout.CENTER);
            //frame.setSize(500, 500);
            this.page.pack();
            //frame.setVisible(true);
            
        }
        catch(Exception e){e.printStackTrace();}}
        */

         public void openFileAction() {
         dialog.setVisible(true);
         if(dialog.getFile() != null){
             repaint();
            try{
                //this.paintInfo.removeAllElements();
                File file = new  File (dialog.getDirectory(),dialog.getFile());
                picIn = new FileInputStream(file);
                oIn = new ObjectInputStream (picIn);
                paintInfo = (Vector)oIn.readObject();
                oIn.close();
                repaint();
            }
            catch(ClassNotFoundException x){repaint();}
            catch(IOException e){repaint();e.printStackTrace();}}
               
    }//</editor-fold>
     
    public void saveFileAction(){
        //dialogS = new FileDialog(this,"",FileDialog.LOAD);
        dialogS.setVisible(true);
   try{
     File fileout = new File(dialogS.getDirectory(),dialogS.getFile());
     picOut = new FileOutputStream(fileout);
     oOut = new ObjectOutputStream(picOut);
     oOut.writeObject(paintInfo);
     oOut.close();
    }
   catch(IOException IOe) 
    {
      System.out.println("can not write object");
    }
    }

    
    //<editor-fold defaultstate="collapsed" desc="Main">
    public static void  main(String arg[]){
        new Painter();
    }
    //</editor-fold>
}
