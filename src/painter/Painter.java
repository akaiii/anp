
package painter;

import javax.swing.*;
import java.awt.*;

//painter mode
enum Status {draw_line,stop,free_draw,idle}

public class Painter extends JFrame{
    
    public Status status = Status.idle;
    Dimension size ;
    ToolBar toolbar;
    Page page;
    
    
    Painter()
    {
      
        //title    (choudo hen te su ???
        super("ANP");  
       
        
        //frame size and set frame close 
        size = new Dimension(600,600);   
        this.setSize(size);    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //painter's location on the screen    
        Point screen_size = new Point(Toolkit.getDefaultToolkit().getScreenSize().height,
                                      Toolkit.getDefaultToolkit().getScreenSize().width);
        this.setLocation(screen_size.y/2-size.height/2,screen_size.x/2-size.width/2);        
        this.getContentPane().setLayout(new BorderLayout());
        
        
        toolbar = new ToolBar(this);                   
        this.getContentPane().add(toolbar, BorderLayout.NORTH);
        
        page = new Page(this);
        this.getContentPane().add(page,BorderLayout.CENTER);
        
        //let we see the ANP yooo                        
        this.setVisible(true);
    }
    
    
}
