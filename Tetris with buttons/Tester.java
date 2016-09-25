
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.awt.Point;
import java.util.ArrayList;
import java.lang.Thread;
import java.lang.InterruptedException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.IndexOutOfBoundsException;
import java.lang.Double;
import java.io.*;
/**
 * Class Tester - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class Tester extends JPanel implements KeyListener, ActionListener, Runnable 
{
    // instance variables - replace the example below with your own
        
     Rectangle B0 = new Rectangle();
     Rectangle B1 = new Rectangle();
     Rectangle B2 = new Rectangle();
     Rectangle B3 = new Rectangle();
     Rectangle B4 = new Rectangle();
     Rectangle B5 = new Rectangle();
     Rectangle BZ = new Rectangle();
     Rectangle BS = new Rectangle();
     Rectangle BI = new Rectangle();
     
     Rectangle N0 = new Rectangle();
     Rectangle N1 = new Rectangle();
     Rectangle N2 = new Rectangle();
     Rectangle N3 = new Rectangle();
     
     
     ArrayList<Rectangle> curPiece = new ArrayList<Rectangle>(4);
     Thread t = null;
     boolean GameOver;
     Color[][] board = new Color[10][20];
    
     boolean hit;
     boolean rowFull;
     int indexR;
     int indexC;
     ArrayList<Rectangle> nextPiece = new ArrayList<Rectangle>(4);
     int nextPieceType;
     int curPieceType;
     int holdPieceType;
     double randNum;
     PrintWriter outFile;
     boolean endDrop;
     boolean gameStart;
     JButton level0, level1, level2, levelV, level3, level4, level5, goingToHellForThis;
     int level;
     boolean downPressed;
     boolean canSwap;
     double increment;
     double msToFall = 100.0;
     int deltaX = 0;
     boolean retry = true;
     int accelerator;
     boolean kill;
     int minDropTime;
     int pases;
     int delay;
     boolean edgeClearCase;
     int score;
     JTextField name;
     JTextArea nameArea;
    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */

    public void init() 
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do 
        // not allow access to the AWT system event queue which JApplets do 
        // on startup to check access. May not be necessary with your browser. 
        try{
        //JRootPane rootPane = this.getRootPane();    
        //rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);

	
						
        setFocusable(true);
        this.addKeyListener(this);
        
        B0 = new Rectangle(10,0,10,10);
        B1 = new Rectangle(20,0,10,10);
        B2 = new Rectangle(10,10,10,10);
        B3 = new Rectangle(20,10,10,10);
        B4 = new Rectangle(10,20,10,10);
        B5 = new Rectangle(20,20,10,10);
        
        BZ = new Rectangle(0,0,10,10);
        BS = new Rectangle(0,10,10,10);
        BI = new Rectangle(10,30,10,10);
        
        N0 = new Rectangle();
        N1 = new Rectangle();
        N2 = new Rectangle();
        N3 = new Rectangle();
     
        
        ArrayList<Rectangle> curPiece = new ArrayList<Rectangle>(4);
        curPiece.add(B0);
        curPiece.add(B1);
        curPiece.add(B2);
        curPiece.add(B3);

        ArrayList<Rectangle> nextPiece = new ArrayList<Rectangle>(4);
        nextPiece.add(N0);
        nextPiece.add(N2);
        nextPiece.add(N3);
        nextPiece.add(N1);
        for(int i = 0; i < 20; i++){for(int j = 0; j < 10; j++){board[j][i] = Color.white;}}
        
        GameOver = false;
        //boolean[][] board = new boolean[10][20];
        Color[][] board = {{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white}};
        hit = false;
        indexR = 0;
        indexC = 0;
        endDrop = true;
        gameStart = false;
        pases = 0; 
        delay = 0;
        edgeClearCase = false;
	score = 0;
     
    }catch(IndexOutOfBoundsException e){}
}
    public static void main(String [] args)
    {
        Tester game = new Tester();
        
        game.init();
        game.start();
        
    }
        
        // provide any initialisation necessary for your JApplet
    

    /**
     * Called by the browser or applet viewer to inform this JApplet that it 
     * should start its execution. It is called after the init method and 
     * each time the JApplet is revisited in a Web page. 
     */
    public void start()
    {
	
	
	JFrame frame = new JFrame("Tetris");
        frame.add(this);
	setLayout(new FlowLayout());
        frame.setSize(350,200);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       

        level0 = new JButton("Very Easy");
        

        level0.addActionListener(this);
        level1 = new JButton("Easy");

        

        level1.addActionListener(this);
        level2 = new JButton("Normal");
       

        level2.addActionListener(this);

        levelV = new JButton("Very Normal");
        

        levelV.addActionListener(this);

        level3 = new JButton("Hard");
      

        level3.addActionListener(this);
	level4 = new JButton("Very Hard");

       

        level4.addActionListener(this);

        level5 = new JButton("Impossible");
	level5.addActionListener(this);
	
	goingToHellForThis = new JButton("Bad Code");

        
        level0.setBounds(25,0,100,20);
	level1.setBounds(25,20,100,20);
	level2.setBounds(25,40,100,20);
	levelV.setBounds(25,60,100,20);
	level3.setBounds(25,80,100,20);
	level4.setBounds(25,100,100,20);
	level5.setBounds(25,120,100,20);
	


        frame.add(level0);
        frame.add(level1);
        frame.add(level2);
        frame.add(levelV);        
        frame.add(level3);
        frame.add(level4);
	frame.add(level5);
	frame.add(goingToHellForThis);
	goingToHellForThis.setVisible(false);
        
       
        
	/**name = new JTextField(3);
	nameArea = new JTextArea();
	name.setVisible(true);
	frame.add(name);
	frame.add(nameArea);*/
	
  	 frame.addKeyListener(this);


        // provide any code requred to run each time 
        // web page is visited
    
        curPiece.add(B0);
        curPiece.add(B1);
        curPiece.add(B2);        
        curPiece.add(B3);
         
        nextPiece.add(B0);
        nextPiece.add(B2);
        nextPiece.add(B4);
        nextPiece.add(BI);
        
        double randNum = Math.random();
        
        
        Color[][] board = {{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white},{Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white,Color.white}};
        for(Color[] rows : board)
        {
            for(Color cols : rows)
            {
                cols = Color.white;
            }
        }
       // for(int i = 0; i < 19; i++){for(int j = 0; j < 9; j++){board[i][j] = Color.white;}}
	
        repaint();
        t = new Thread(this);
        
        
         
    }

    /** 
     * Called by the browser or applet viewer to inform this JApplet that
     * it should stop its execution. It is called when the Web page that
     * contains this JApplet has been replaced by another page, and also
     * just before the JApplet is to be destroyed. 
     */
    public void UpdatePos()
    {
	boolean wall = false;
	boolean blocked = false;
	    for(Rectangle z : curPiece){
		if((z.x + deltaX < 0 && deltaX < 0) || (z.x + deltaX > 99 && deltaX > 0))
			{wall = true;}
		}

	
	if(!wall)
	{
	for(Rectangle z : curPiece)
		{
			if(deltaX > 0){
				if(Occupied(z.x + 10, z.y - 10)){
					blocked = true;
				}
			} else if(deltaX < 0){
				if(Occupied(z.x - 10, z.y - 10)){
					blocked = true;
				}
			}
			
		}
	}
	if(!wall && !blocked){for(Rectangle z : curPiece)
	{
		z.setLocation(z.x + deltaX, z.y);
	}
	}
	
    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object for this applet
     */
    @Override
    public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
        if(!gameStart){
        this.removeAll();
        }
	if(GameOver(curPiece, board)){
	g.setColor(Color.black);
	//g.fillRect(0,0,300,200);
	g.setColor(Color.red);
		for(int i = 0; i < 20; i++){
			//g.drawString("Game Over",40,i*10 + 10);	
		}
	}
	
        if(!GameOver(curPiece, board) && gameStart){
        try{
        g.setColor(Color.gray);
        g.fillRect(0,0,300,200);
        g.setColor(Color.black);
        
        Graphics2D g2 = (Graphics2D)g;
        g.drawString((String.valueOf((int)(10 / ((msToFall + minDropTime) / 1000))) + " pxl/sec"), 120, 80);
        g.drawString(String.valueOf(score), 120, 90);
       
        switch(nextPieceType){
            case 1:   g.drawString("Next: Q",100,60);		
                   break;
            case 2:   g.drawString("Next: L",100,60);
                   break;
            case 3:   g.drawString("Next: J",100,60);
                   break;
            case 4:   g.drawString("Next: Z",100,60);
                   break;
            case 5:   g.drawString("Next: S",100,60);
                   break;
            case 6:   g.drawString("Next: I",100,60);
                   break;
            case 7:   g.drawString("Next: T",100,60);
                   break;
            
        }
        switch(holdPieceType){
            case 0:   g.drawString("Press F", 100, 40);
            break;
            case 1:   g.drawString("Hold: Q",100,50);
                   break;
            case 2:   g.drawString("Hold: L",100,50);
                   break;
            case 3:   g.drawString("Hold: J",100,50);
                   break;
            case 4:   g.drawString("Hold: Z",100,50);
                   break;
            case 5:   g.drawString("Hold: S",100,50);
                   break;
            case 6:   g.drawString("Hold: I",100,50);
                   break;
            case 7:   g.drawString("Hold: T",100,50);
                    break;
        }
      
        
        for(int i = 0; i < 20; i++)
        {
            
            for(int j= 0; j < 10; j++)
            {
                //try{
               // if(cols == Color.black)
                {
                    //g.setColor(Color.white);
                    g.setColor(board[j][i]);
                    g.fillRect(j*10,i*10,10,10);
                  
                }//}catch(ArrayIndexOutOfBoundsException e){}
                indexC += 10;
            }
            indexC = 0;
            indexR += 10;
        }
        indexR = 0;
	g2.setColor(Color.black);
	float thickness = 2;
	Stroke oldStroke = g2.getStroke();
	g2.setStroke(new BasicStroke(thickness));
	for(Rectangle z : curPiece){
	g2.drawRect(z.x,z.y,10,10);
	}
          switch(curPieceType)
        {
            case 1: g2.setColor(Color.yellow);
                break;
            case 2: g2.setColor(Color.pink);
                break;
            case 3: g2.setColor(Color.blue);
                break;
            case 4: g2.setColor(Color.green);
                break;
            case 5: g2.setColor(Color.red);
                break;
            case 6: g2.setColor(Color.cyan);
                break;
            case 7: g2.setColor(Color.magenta);
                break;
        }
        for(Rectangle z : curPiece)
        {
		
		g2.fill(z);
		g2.setStroke(oldStroke);
           
        }
    }catch(ArrayIndexOutOfBoundsException e){}}
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
       
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
              downPressed = true;
              //fall(curPiece,board,nextPiece);
        } else if(e.getKeyCode() == KeyEvent.VK_D)
        { boolean wall = false;
          boolean blocked = false;
          for(Rectangle z : curPiece){try{if(Occupied(z.x + 10, z.y - 10)){blocked = true;}}catch(ArrayIndexOutOfBoundsException exc){wall = true;}}
            for(Rectangle z : curPiece){if(z.x  == 90){wall = true;}}
           
                if(wall == false && !blocked){
                deltaX = 10;}
             
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            boolean wall = false;
            boolean blocked = false;
            for(Rectangle z : curPiece){if(z.x == 0){wall = true;}}
            for(Rectangle z : curPiece){if(Occupied(z.x - 10, z.y - 10)){blocked = true;}}
           
                if(!wall && !blocked){
                deltaX = -10;}
            
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            downPressed = true;
            endDrop = false;
        } else if(e.getKeyCode() == KeyEvent.VK_W)
        {
            
        } else if(e.getKeyCode() == KeyEvent.VK_E)
        {
           boolean canFlip = true;
	   boolean canRight = true;
	   boolean canLeft = true;
	   boolean canDown = true;
	   boolean canDownRight = true;
	   boolean canDownLeft = true;
	   int SigmaX = 0;
	   int SigmaY = 0;
	   Integer[] thetaX = new Integer[4];
	   Integer[] thetaY = new Integer[4];
            if(curPieceType == 1){} else{
                for(Rectangle z : curPiece){if(Occupied(curPiece.get(1).x + curPiece.get(1).y - z.y, curPiece.get(1).y + z.x - curPiece.get(1).x - 10)){canFlip = false;}}
		if(!canFlip){
			for(Rectangle z2 : curPiece){
				int newX = curPiece.get(1).x + curPiece.get(1).y - z2.y;
				int newY = curPiece.get(1).y + z2.x - curPiece.get(1).x;
				if(Occupied(newX + 10,newY - 10) || newX + 10 < 0 || newX + 10 > 100 || newY > 190){
				canRight = false;
				}
				if(Occupied(newX - 10,newY - 10) || newX -10 < 0 || newX -10 > 100 || newY > 190){
				canLeft = false;
				}
				if(Occupied(newX,newY - 10 + 10) || newX < 0 || newX > 100 || newY +10 > 190){
				canDown = false;
				}
				if(Occupied(newX + 10,newY - 10 + 10) || newX + 10 < 0 || newX + 10 > 100 || newY +10 > 190){
				canDownRight = false;
				}
				if(Occupied(newX - 10,newY -10 + 10) || newX - 10 < 0 || newX - 10 > 100 || newY + 10 > 190){
				canDownLeft = false;
				}				
			}
			if(canRight){
				SigmaX = 10;
				canFlip = true;
			} else if(canLeft){
				SigmaX = -10;
				canFlip = true;
			} else if(canDown){
				SigmaY = 10;
				canFlip = true;
			} else if(canDownRight){
				SigmaX = 10;
				SigmaY = 10;
				canFlip = true;
			} else if(canDownLeft){
				SigmaX = -10;
				SigmaY = 10;
				canFlip = true;
			}
		System.out.println("x " + SigmaX);
		System.out.println("y " + SigmaY);
		System.out.println("Right? " + canRight);
		System.out.println("L? " + canLeft);
		System.out.println("DRight? " + canDownRight);
		System.out.println("DL? " + canDownLeft);
		System.out.println("Down " + canDown);
		}
                for(int z = 0; z < 4; z++)
                {
                    if(canFlip){ 
                    thetaX[z] = curPiece.get(1).x + curPiece.get(1).y - curPiece.get(z).y + SigmaX;
		    thetaY[z] = curPiece.get(1).y + curPiece.get(z).x - curPiece.get(1).x + SigmaY;
                }
		}
		if(canFlip){
		for(int z = 0; z < 4; z++){
			curPiece.get(z).x = thetaX[z];
			curPiece.get(z).y = thetaY[z];
		}}
            } 
        } else if(e.getKeyCode() == KeyEvent.VK_Q)
        {
            
           boolean canFlip = true;
	   boolean canRight = true;
	   boolean canLeft = true;
	   boolean canDown = true;
	   boolean canDownRight = true;
	   boolean canDownLeft = true;
	   int SigmaX = 0;
	   int SigmaY = 0;
	   Integer[] thetaX = new Integer[4];
	   Integer[] thetaY = new Integer[4];
            if(curPieceType == 1){} else{
                for(Rectangle z : curPiece){if(Occupied(curPiece.get(1).x - curPiece.get(1).y + z.y, curPiece.get(1).y - z.x + curPiece.get(1).x - 10)){canFlip = false;}}
		if(!canFlip){
			for(Rectangle z2 : curPiece){
				int newX = curPiece.get(1).x - curPiece.get(1).y + z2.y;
				int newY = curPiece.get(1).y - z2.x + curPiece.get(1).x;
				if(Occupied(newX + 10,newY - 10) || newX + 10 < 0 || newX + 10 > 100 || newY > 190){
				canRight = false;
				}
				if(Occupied(newX - 10,newY - 10) || newX -10 < 0 || newX -10 > 100 || newY > 190){
				canLeft = false;
				}
				if(Occupied(newX,newY) || newX < 0 || newX > 100 || newY + 10 > 190){
				canDown = false;
				}
				if(Occupied(newX + 10,newY) || newX + 10 < 0 || newX + 10 > 100 || newY + 10 > 190){
				canDownRight = false;
				}
				if(Occupied(newX - 10,newY) || newX - 10 < 0 || newX - 10 > 100 || newY + 10 > 190){
				canDownLeft = false;
				}				
			}
			if(canLeft){
				SigmaX = -10;
				canFlip = true;
			} else if(canRight){
				SigmaX = 10;
				canFlip = true;
			} else if(canDown){
				SigmaY = 10;
				canFlip = true;
			} else if(canDownLeft){
				SigmaX = -10;
				SigmaY = 10;
				canFlip = true;
			} else if(canDownRight){
				SigmaX = 10;
				SigmaY = 10;
				canFlip = true;
			}
		System.out.println("x " + SigmaX);
		System.out.println("y " + SigmaY);
		System.out.println("Right? " + canRight);
		}
                for(int z = 0; z < 4; z++)
                {
                    if(canFlip){ 
                    thetaX[z] = curPiece.get(1).x - curPiece.get(1).y + curPiece.get(z).y + SigmaX;
		    thetaY[z] = curPiece.get(1).y - curPiece.get(z).x + curPiece.get(1).x + SigmaY;
                }
		}
		if(canFlip){
		for(int z = 0; z < 4; z++){
			curPiece.get(z).x = thetaX[z];
			curPiece.get(z).y = thetaY[z];
		}}
            } 
        } else if(e.getKeyCode() == KeyEvent.VK_F)
        {
            swapHold();
        }
        repaint();
	if(GameOver(curPiece, board)){
	retry = true;}
    
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A)
	{
		deltaX = 0;
		//accelerator = 0;
	}
    }
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy. 
     */
    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }
    public void run()
    {
        int i = 0;
	boolean moving =false	;
	int j = 0;
	int killCounter = 0;
	double dropTime;
	int msToX = 250;
	boolean secondChance = false;
	int momentum = 0;
	
	newPiece(curPiece, nextPiece);
	newPiece(curPiece, nextPiece);
                try{
                    //while(true){
                    while(gameStart && !GameOver(curPiece, board))
                    {
			dropTime = msToFall + minDropTime;
                        if(downPressed || i >= dropTime){fall(curPiece,board,nextPiece); repaint(); if(endDrop){downPressed = false;}}
                        if(i >= dropTime){i = 0;}			
			
			if(deltaX == 0 || momentum != deltaX){
				moving = false;		
			}
			if(deltaX != 0 && moving == false){
			j = 0;
			moving = true;
			momentum = deltaX;
			}
			
			
			if(j % 250 == 0 && moving){
				UpdatePos();
			}
			/**if(!moving){
				updatePos();
				if(deltaX ! = 0){
					moving = true;
				}
			}
			if(!moving && j > 500;){
				UpdatePos();
				if(deltaX != 0){
					j = 0; moving = true;
				}
			} 
			
				if(j == 250 && moving)
				{
					UpdatePos();
					moving = false;
					//accelerator++;
					//if(accelerator >= 2){msToX -= 120;}
				}*/
			if(hit){hit = false;if(!secondChance){delay = 0;} secondChance = true;}
			if(delay == 800){secondChance = false; kill = true; delay = 0;}
			//if(hit){killCounter++;}
			//if(!hit){killCounter = 0;}
			//if(killCounter  == 750 || (level == 5 && killCounter == 250)){kill = true; killCounter = 0;}
                        repaint();
                        t.sleep(1);
                        i++;
			j++;
			delay++;
                    }
		if(GameOver(curPiece, board)){
		repaint();
		t.sleep(50);
		if(retry)
		{
		repaint();
		
		}
		}		
		}catch(InterruptedException e){}//}
        
        }

    /**
     * Returns information about this applet. 
     * An applet should override this method to return a String containing 
     * information about the author, version, and copyright of the JApplet.
     *
     * @return a String representation of information about this JApplet
     
    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }


    
     * Returns parameter information about this JApplet. 
     * Returns information about the parameters than are understood by this JApplet.
     * An applet should override this method to return an array of Strings 
     * describing these parameters. 
     * Each element of the array should be a set of three Strings containing 
     * the name, the type, and a description.
     *
     * @return a String[] representation of parameter information about this JApplet
     */
    public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                 {"firstParameter",    "1-10",    "description of first parameter"},
                 {"status", "boolean", "description of second parameter"},
                 {"images",   "url",     "description of third parameter"}
        };
        return paramInfo;
    }
    public void newPiece(ArrayList<Rectangle> piece, ArrayList<Rectangle> nextPiece)
    {
       // try{
       B0 = new Rectangle(40,0,10,10);
        B1 = new Rectangle(50,0,10,10);
        B2 = new Rectangle(40,10,10,10);
        B3 = new Rectangle(50,10,10,10);
        B4 = new Rectangle(40,20,10,10);
        B5 = new Rectangle(50,20,10,10);
        
        BZ = new Rectangle(30,0,10,10);
        BS = new Rectangle(30,10,10,10);
        BI = new Rectangle(40,30,10,10);
        
       
        if(randNum < (double).143) //square 1
        { curPieceType = 1;
            piece.set(0,B0);
            piece.set(1,B1);
            piece.set(2,B2);
            piece.set(3,B3);
        }else if(randNum < (double).286) //L 2
        { curPieceType = 2;
            piece.set(0,B0);
            piece.set(1,B2);
            piece.set(2,B4);
            piece.set(3,B5);
        } else if(randNum < (double).429) //J 3
        {
            curPieceType = 3;
            piece.set(0,B1);
            piece.set(1,B3);
            piece.set(2,B5);
            piece.set(3,B4);
        } else if(randNum < (double).571) //Z 4
        {
            curPieceType = 4;
            piece.set(0,BZ);
            piece.set(1,B0);
            piece.set(2,B2);
            piece.set(3,B3);
        } else if(randNum < (double).714) //S 5
        {
            curPieceType = 5;
            piece.set(0,B1);
            piece.set(1,B0);
            piece.set(2,B2);
            piece.set(3,BS);
        } else if(randNum < (double).857) // I 6
        {
            curPieceType = 6; 
            piece.set(0,B0);
            piece.set(1,B2);
            piece.set(2,B4);
            piece.set(3,BI);
        } else if(randNum > (double).857){
            curPieceType = 7;
            piece.set(0,BZ);
            piece.set(1,B0);
            piece.set(2,B1);
            piece.set(3,B2);
        }
        randNum = Math.random();
         if(randNum < 1.0/7.0) //square 1
        { nextPieceType = 1;
           
        }else if(randNum < 2.0/7.0) //L 2
        { nextPieceType = 2;
          
        } else if(randNum < 3.0/7.0) //J 3
        {
            nextPieceType = 3;
         
        } else if(randNum < 4.0/7.0) //Z 4
        {
            nextPieceType = 4;
            
        } else if(randNum < 5.0/7.0) //S 5
        {
            nextPieceType = 5;
            
        } else if(randNum < 6.0/7.0)  // I 6
        {
            nextPieceType = 6; 
            
        } else {
            nextPieceType = 7;
            
        }
      //}catch(ArrayIndexOutOfBoundsException e){}
      canSwap = true;
    }
    public void swapHold()
    {
        int typeHolder;
        if(canSwap == true){
        if(holdPieceType == 0)
        {
            holdPieceType = curPieceType;
            newPiece(curPiece,nextPiece);
        } else
        {
                 B0 = new Rectangle(40,0,10,10);
        B1 = new Rectangle(50,0,10,10);
        B2 = new Rectangle(40,10,10,10);
        B3 = new Rectangle(50,10,10,10);
        B4 = new Rectangle(40,20,10,10);
        B5 = new Rectangle(50,20,10,10);
        
        BZ = new Rectangle(30,0,10,10);
        BS = new Rectangle(30,10,10,10);
        BI = new Rectangle(40,30,10,10);
        
        switch(holdPieceType)
        {
            case 1: curPiece.set(0,B0);
                    curPiece.set(1,B1);
                    curPiece.set(2,B2);
                    curPiece.set(3,B3);

                    break;
            
            case 2: curPiece.set(0,B0);
                    curPiece.set(1,B2);
                    curPiece.set(2,B4);
                    curPiece.set(3,B5);

                    break;
            
            case 3: curPiece.set(0,B1);
                    curPiece.set(1,B3);
                    curPiece.set(2,B5);
                    curPiece.set(3,B4);

                    break;
            
            case 4: curPiece.set(0,BZ);
                    curPiece.set(1,B0);
                    curPiece.set(2,B2);
                    curPiece.set(3,B3);
                    break;
            
            case 5: curPiece.set(0,B1);
                    curPiece.set(1,B0);
                    curPiece.set(2,B2);
                    curPiece.set(3,BS);

                    break;
            
            case 6: curPiece.set(0,B0);
                    curPiece.set(1,B2);
                    curPiece.set(2,B4);
                    curPiece.set(3,BI);

                    break;
            case 7: curPiece.set(0,BZ);
                    curPiece.set(1,B0);
                    curPiece.set(2,B1);
                    curPiece.set(3,B2);
        }
        typeHolder = holdPieceType;
        holdPieceType = curPieceType;
        curPieceType = typeHolder;
        
        }
        canSwap = false;
    }
    }
    public void fall(ArrayList<Rectangle> curPiece, Color[][] board, ArrayList<Rectangle> nextPiece)
    {
	int h = 0;
         for(Rectangle z : curPiece)
                        {
                          //  try{
                                if(z.y == 190){
                                    hit = true;
                                } else if(Occupied(z.x,z.y))
                                {
                                    hit = true;
                                } else if (!Occupied(z.x,z.y)){
					h++;
				}
				if(h==4){hit = false;}
				
                        //}catch(ArrayIndexOutOfBoundsException e){}
                        }
                        if(!hit){
                        for(Rectangle z : curPiece)
                        {
                            z.setLocation(z.x,z.y + 10);
                        }
			delay = 0;
                        } else if(endDrop == false || kill)
                        {
			 edgeClearCase = true;
			kill = false;
                            for(Rectangle z : curPiece){
                            //    try{
                                switch(curPieceType)
                                {
                                    case 1: board[z.x / 10][z.y / 10] = Color.yellow;
                                            break;
                                    case 2: board[z.x / 10][z.y / 10] = Color.pink;
                                            break;
                                    case 3: board[z.x / 10][z.y / 10] = Color.blue;
                                            break;
                                    case 4: board[z.x / 10][z.y / 10] = Color.green;
                                            break;
                                    case 5: board[z.x / 10][z.y / 10] = Color.red;
                                            break;
                                    case 6: board[z.x / 10][z.y / 10] = Color.cyan;
                                            break;
                                    case 7: board[z.x / 10][z.y / 10] = Color.magenta;
                                    break;
                                        } 
                               
                            //}catch(ArrayIndexOutOfBoundsException e){}
                                
                            }
                            
                              int rowsCleared = 0;
                           
                              newPiece(curPiece, nextPiece);
                                for(int i = 0; i < 20; i++)
                                {
                                    rowFull = true;
                                    for(int j = 0; j < 10; j++)
                                    {
                                        if(!Occupied(j * 10,(i * 10) - 10)){rowFull = false;}
                                    }
                                    if(rowFull){clearRow(i); rowsCleared++;}
                                   
                                    
                                }
			        switch(rowsCleared)
				{
					case 1: score +=100;
						break;
					case 2: score +=300;
						break;
					case 3: score +=600;
						break;
					case 4: score +=1500;				
				}
				edgeClearCase = false;
                              
                                endDrop = true;
                                hit = false;
                        }
                   
    }
    public boolean GameOver(ArrayList<Rectangle> curPiece, Color[][] board)
    {
        boolean state = false;
        for(Rectangle z: curPiece){
            if((board[z.x / 10][z.y / 10] != Color.white)){if(!edgeClearCase){
             state = true;}}
           }
        return state;
    }
    public boolean Occupied(int x, int y)
    {	try{
        if(board[x / 10][(y+10) / 10] != Color.white)
        { 
            return true;}
        }catch(ArrayIndexOutOfBoundsException exc){return true;}
        return false;
    }
    public void clearRow(int y)
    {
        
        Color[] placeHolder = new Color[10];
        Color[] holderHolder = new Color[10];
        for(int i = 0; i < 10; i++)
        {
            board[i][y] = Color.white;
            try{t.sleep(100);}catch(InterruptedException e){}
            repaint();
        }
        repaint(); 
        for(int i = 0; i < y + 1; i++){for(int j = 0; j < 10; j++){
                    placeHolder[j] = board[j][i];
                    if(i==0){
                     board[j][i] = Color.white;
                    } else
                    {
                       board[j][i] = holderHolder[j];
                    }
                    holderHolder[j] = placeHolder[j];}}
	msToFall = msToFall * increment;
           repaint();
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == level0)
        {
            level = 0;
	 gameStart = true;
	msToFall = 200; increment = .99;
	minDropTime = 200;
        }if(e.getSource()==level1){
	level = 1;
	msToFall = 150; increment = .95;
	gameStart = true;
	minDropTime = 100;
	}if(e.getSource() == level2)
        {
            level = 2;
	msToFall = 80; increment = .9;
	gameStart = true;
	minDropTime = 70;
        }if(e.getSource() == levelV)
        {
            level = 10;
	msToFall = 60; increment = .85;
	gameStart = true;
	minDropTime = 30;
        }if(e.getSource() == level3)
        {
            level = 3;
	msToFall = 80; increment = .8;
	gameStart = true;
	minDropTime = 20;
        }if(e.getSource() == level4)
        {
            level = 4;
	msToFall = 75; increment = .7;
	gameStart = true;
	minDropTime = 10;
        }if(e.getSource()==level5){
	level = 5;
	msToFall = 75; increment = .65;
	gameStart = true;
	minDropTime = 0;
	}
	 	this.requestFocusInWindow();
       	level1.setVisible(false);
	level2.setVisible(false);
	level3.setVisible(false);
	level4.setVisible(false);
	level0.setVisible(false);
	levelV.setVisible(false);
	level5.setVisible(false);


       /** this.remove(levelV);
        this.remove(level0);
        this.remove(level1);
        this.remove(level2);
        this.remove(level3);
        this.remove(level4);
	this.remove(level5); */
	this.setSize(300,200);
	revalidate();
	repaint();
	t.start();
	
	
    }

}
