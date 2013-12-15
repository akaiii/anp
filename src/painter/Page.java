package painter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.util.ArrayList;

public class Page extends JPanel{   

    Point lp;
    
    //ArrayList<Line> lines = null;  //  <>  >> any_type
    
    Painter parent;
    
    Status status;// = Status.idle;
    
    Page(Painter p)
    {
        parent = p;     
        
        Rectangle l;
        
        l = new java.awt.Rectangle(-1,-1,-1,-1);
        
       status = Status.idle;  
        //lines =  new  ArrayList<Line>();        
        lp = new Point(-1,-1);
        
        
        
        
        
        //this.setBackground(Color.yellow);   
        this.setLayout(null);             
        
        
        this.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                
                if(parent.status == Status.free_draw)
                {
                    java.awt.Graphics g = Page.this.getGraphics();      
                    g.setPaintMode();                      
                    g.setColor(Color.RED);                  
                    parent.p2 = new Point(e.getPoint());                
                    g.drawLine(parent.p1.x,parent.p1.y,parent.p2.x,parent.p2.y);
                    
                    parent.p1 = e.getPoint();
                    parent.paintInfo.addElement(parent.p1);
                   
                }
                //---new 
               /* if(Page.this.status == status.creatingOBJ){
                    java.awt.Graphics g = Page.this.getGraphics();
                    
                    
                    //-----new
                    g.setXORMode(Color.red);
                    
                    
                    
                    g.setPaintMode();
                    g.setColor(Color.red);
                    
                    
                    g.setColor(Color.YELLOW);
                   // g.drawRect(l.x,l.y, l.width, l.height);
                    if(lp.x > e.getX())
                        g.drawRect(lp.x, lp.y, e.getX()-lp.x, e.getY()-lp.y);
                
                }*/
            }
    
        });
        this.addMouseListener(
              new MouseAdapter ()   
              {
                        @Override
                        public void mouseReleased(MouseEvent e)
                        {
                           /* if(Page.this.status == status.creatingOBJ){
                                Page.this.status = status.idle;
                            }
                            */
                               if(parent.status == Status.free_draw)
                                {
                                   // parent.p1 = new Point(-1,-1);
                                    //do nothing
                                }
                        }
                        @Override
                        public void mousePressed(MouseEvent e){
                        
                            if(parent.status == Status.free_draw)
                            {
                                parent.p1 = e.getPoint();
                            }
                            
                            //---new
                             if(Page.this.status == status.readytoCreatingOBj){
                                    lp = e.getPoint();
                                    Page.this.status = status.creatingOBJ;                                
                                }
                                
                        }
                        @Override
                        public void mouseClicked(MouseEvent e)      
                        {
                            //------new
                            if(parent.status == Status.readytoDrawLine)
                            {
                                parent.p1 = e.getPoint(); //check currentMouse
                                Page.this.status = Status.drawLining;
                            
                            }
                            else if(parent.status == Status.drawLining){
                                    if(parent.p1.x == -1)
                                        parent.p1 = e.getPoint();
                                    java.awt.Graphics g = Page.this.getGraphics();      
                                    g.setPaintMode();                      
                                    g.setColor(Color.RED);    
                                    parent.p2 = new Point(e.getPoint());
                                    g.drawLine(parent.p1.x,parent.p1.y,parent.p2.x,parent.p2.y);
                                    parent.paintInfo.addElement(parent.p1);
                                    parent.p1 = new Point(e.getPoint());
                                   
                                }
                                
                                    
                            
                            }
                            
                            //------old
                            /*
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
                           
                              */ 
                            //}                                                
                        
              }
         );       
        
    }   
    
    @Override
    public void paint(Graphics pen)
    {
        super.paintComponent(pen);          
        pen.setPaintMode();                
        pen.setColor(Color.red);       
      //  pen.drawLine(0, 0, 200, 200);      
      
        Point p1,p2;    

    for(int i=0; i<parent.paintInfo.size()-1; i++)
    {
         p1 = (Point)parent.paintInfo.elementAt(i);
         p2 = (Point)parent.paintInfo.elementAt(i+1);
         pen.drawLine(p1.x, p1.y, p2.x, p2.y);  
    }
    //java.util tool
    //Vector >> linklist
    //arraylist >>array linklist   //  Class ArrayList <E>  
    
    }}
