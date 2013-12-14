
package painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBar extends JPanel{
    
    
    JButton open_btn;
    JButton draw_btn;
    JButton free_draw_btn;
    JButton stop_btn;
    JButton exit_btn;
    Painter parent ;
    FileDialog dialog;
    JButton createObjectBtn;
    JButton save_btn ;
    
    
    //OpenFile open = new OpenFile(); 
    
    ToolBar(Painter p)
    {
        parent = p;
          
        setBackground(Color.red);
        
        //new many many buttons  and set mouseClick event
         open_btn = new JButton("Open");
         save_btn = new JButton("Save");
        draw_btn = new JButton("Line");
        free_draw_btn = new JButton("FreeDraw");
        stop_btn = new JButton("Stop");
        exit_btn = new JButton("Exit");
        //dialog = new FileDialog(this,"",FileDialog.LOAD) ;
        createObjectBtn = new JButton("Create");
        
        createObjectBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(parent.page.status == Status.idle){
                    parent.page.status = Status.readytoCreatingOBj;
                }
            }
        });
        
        //open the file
        open_btn.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parent.dialog = new FileDialog(parent,"",FileDialog.LOAD);
                    parent.dialog.setVisible(false);
                    parent.openFileAction();
                    //dialog.getFile();           
         }});
        save_btn.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        parent.dialogS = new FileDialog(parent,"",FileDialog.SAVE);
                        parent.dialogS.setVisible(false);
                        parent.saveFileAction();
                    }
                });
           //open_btn.addActionListener(new Adapter());
        
        
            draw_btn.addMouseListener (    
                    new MouseAdapter ()    
                    {
                        @Override
                        public void mouseClicked(MouseEvent e)     
                        {
                            parent.status = Status.draw_line;    
                            ToolBar.this.stop_btn.setEnabled(true); 
                            ToolBar.this.draw_btn.setEnabled(false);
                            ToolBar.this.free_draw_btn.setEnabled(true);
                            //----------new
                            if(parent.page.status == Status.idle){
                                parent.page.status = Status.readytoDrawLine;
                            }
                            
                        }
                    }           
             );
            
            free_draw_btn.addMouseListener(new MouseAdapter()
            {
                @Override
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
                        @Override
                        public void mouseClicked(MouseEvent e)     
                        {                            
                            //status = Status.idle;    
                            parent.page.lp  =  new Point(-1,-1);
                            ToolBar.this.stop_btn.setEnabled(false);    
                            ToolBar.this.draw_btn.setEnabled(true);   
                            ToolBar.this.free_draw_btn.setEnabled(true);
                            
                            
                            //-----new
                            if(parent.page.status == Status.drawLining)
                                parent.page.status = Status.stop;
                            
                        }
                    }           
             );
            
             exit_btn.addMouseListener (     
                    new MouseAdapter ()    
                    {
                        @Override
                        public void mouseClicked(MouseEvent e)     
                        {
                            System.exit(0);     
                        }
                    }           
             );
        
        add(open_btn);
        add(save_btn);
        add(draw_btn);
        add(free_draw_btn);
        add(stop_btn);
        add(exit_btn);
        stop_btn.setEnabled(false);
               
    }
}
