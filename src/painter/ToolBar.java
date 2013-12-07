
package painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolBar extends JPanel{
    
    JButton open_btn;
    JButton draw_btn;
    JButton free_draw_btn;
    JButton stop_btn;
    JButton exit_btn;
    Painter parent ;
    
    ToolBar(Painter p)
    {
        parent = p;
          
        setBackground(Color.red);
        
        //new many many buttons  and set mouseClick event
        open_btn = new JButton("Open");
        draw_btn = new JButton("Line");
        free_draw_btn = new JButton("FreeDraw");
        stop_btn = new JButton("Stop");
        exit_btn = new JButton("Exit");
        
         
            
            draw_btn.addMouseListener (    
                    new MouseAdapter ()    
                    {
                        public void mouseClicked(MouseEvent e)     
                        {
                            parent.status = Status.draw_line;    
                            ToolBar.this.stop_btn.setEnabled(true); 
                            ToolBar.this.draw_btn.setEnabled(false);
                            ToolBar.this.free_draw_btn.setEnabled(true);
                        }
                    }           
             );
            
            free_draw_btn.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    parent.status = Status.free_draw;
                    ToolBar.this.draw_btn.setEnabled(true);
                    ToolBar.this.free_draw_btn.setEnabled(false);
                    ToolBar.this.stop_btn.setEnabled(true);
                }
            
            }
            );
            
            stop_btn.addMouseListener (     
                    new MouseAdapter ()    
                    {
                        public void mouseClicked(MouseEvent e)     
                        {                            
                            parent.status = Status.idle;    
                            parent.page.lp  =  new Point(-1,-1);
                            ToolBar.this.stop_btn.setEnabled(false);    
                            ToolBar.this.draw_btn.setEnabled(true);   
                            ToolBar.this.free_draw_btn.setEnabled(true);
                            
                        }
                    }           
             );
            
             exit_btn.addMouseListener (     
                    new MouseAdapter ()    
                    {
                        public void mouseClicked(MouseEvent e)     
                        {
                            System.exit(0);     
                        }
                    }           
             );
        
        add(open_btn);
        add(draw_btn);
        add(free_draw_btn);
        add(stop_btn);
        add(exit_btn);
        stop_btn.setEnabled(false);
               
    }
}
