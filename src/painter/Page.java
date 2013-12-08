package painter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.ArrayList;

public class Page extends JPanel{   

    Point lp;
    
    ArrayList<Line> lines = null;  //  <>  >> any_type
    
    Painter parent;
    
    Page(Painter p)
    {
        parent = p;     
        
        
        lines =  new  ArrayList<Line>();        
        lp = new Point(-1,-1);
        
        
        this.setBackground(Color.yellow);   
        this.setLayout(null);             
        
        
        this.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                if(parent.status == Status.free_draw)
                {
                    java.awt.Graphics g = Page.this.getGraphics();      
                    g.setPaintMode();                      
                    g.setColor(Color.RED);                  
                                    
                    g.drawLine(lp.x,lp.y,e.getX(),e.getY());
                    lines.add(new Line(lp,e.getPoint()));
                    lp = e.getPoint();
                }
            }
    
        });
        this.addMouseListener(
              new MouseAdapter ()   
              {
                        public void mouseReleased(MouseEvent e)
                        {
                               if(parent.status == Status.free_draw)
                                {
                                    //do nothing
                                }
                        }
                        public void mousePressed(MouseEvent e){
                        
                            if(parent.status == Status.free_draw)
                            {
                                lp = e.getPoint();
                            }
                                
                        }
                        public void mouseClicked(MouseEvent e)      
                        {
                            
                            if(parent.status == Status.draw_line){
                           
                            if(lp.x != -1)
                            {
                                java.awt.Graphics g = Page.this.getGraphics();      
                                g.setPaintMode();                      
                                g.setColor(Color.RED);                 
                                    
                                g.drawLine(lp.x,lp.y,e.getX(),e.getY());
                              
                                lines.add(new Line(lp,e.getPoint()));
                               
                                lp = e.getPoint();
                                
                            }
                            lp = e.getPoint();
                            }
                           
                               
                            }                                                
                        
              }
         );       
        
    }   
    
    
    public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);          
        pen.setPaintMode();                
        pen.setColor(Color.red);       
      //  pen.drawLine(0, 0, 200, 200);      
    
     Line temp;
     for(int i = 0; i<lines.size();i++)
      {
           temp = lines.get(i);
           pen.drawLine(temp.start.x,temp.start.y,temp.end.x,temp.end.y);
      }
       //pen.drawLine();
     
    
    }
    //java.util tool
    //Vector >> linklist
    //arraylist >>array linklist   //  Class ArrayList <E>  
    
}
