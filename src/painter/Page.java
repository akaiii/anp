package painter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.util.ArrayList;

public class Page extends JPanel{   

    Point lp;
    
    ArrayList<Line> lines = null;  //  <>  >> any_type
    
    Painter parent;
    
    Status status;// = Status.idle;
    
    Page(Painter p)
    {
        parent = p;     
        
        Rectangle l;
        
        l = new java.awt.Rectangle(-1,-1,-1,-1);
        
       status = Status.idle;  
        lines =  new  ArrayList<Line>();        
        lp = new Point(-1,-1);
        
        
        
        
        
        this.setBackground(Color.yellow);   
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
                    lines.add(new Line(lp,e.getPoint()));
                    parent.p1 = e.getPoint();
                    parent.paintInfo.addElement(parent.p1);
                    repaint();
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
                    //要做四個象限去做判斷  目前以下是第四象限
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
                                    //do nothing
                                }
                        }
                        @Override
                        public void mousePressed(MouseEvent e){
                        
                            if(parent.status == Status.free_draw)
                            {
                                lp = e.getPoint();
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
                            if(Page.this.status == Status.readytoDrawLine)
                            {
                                lp = e.getPoint(); //抓滑鼠現在的位置check currentMouse
                                Page.this.status = Status.drawLining;
                            
                            }
                            else if(Page.this.status == Status.drawLining){
                                    java.awt.Graphics g = Page.this.getGraphics();      
                                    g.setPaintMode();                      
                                    g.setColor(Color.RED);                 
                                    
                                    g.drawLine(lp.x,lp.y,e.getX(),e.getY());
                              
                                    lines.add(new Line(lp,e.getPoint()));
                                   
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
    /*
     Line temp;
     for(int i = 0; i<lines.size();i++)
      {
           temp = lines.get(i);
           pen.drawLine(temp.start.x,temp.start.y,temp.end.x,temp.end.y);
      }
       //pen.drawLine();
      
      */
      //pen.drawImage(parent.image, 100, 100, parent.page);
       Graphics2D g2d = (Graphics2D)pen;

        Point p1,p2;

        parent.n = parent.paintInfo.size();
  
  

    for(int i=0; i<parent.n-1; i++)
    {
         p1 = (Point)parent.paintInfo.elementAt(i);
         p2 = (Point)parent.paintInfo.elementAt(i+1);
   //size = new BasicStroke(p1.boarder,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
         pen.drawLine(p1.x, p1.y, p2.x, p2.y);
      //Line2D line1 = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
      //g2d.draw(line1); 
   //g2d.setColor(p1.col);
   //g2d.setStroke(size);
     
    
    }
    //java.util tool
    //Vector >> linklist
    //arraylist >>array linklist   //  Class ArrayList <E>  
    
    }}
