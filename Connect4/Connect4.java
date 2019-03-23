import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JApplet;
/**
 * Connect4
 * 
 * @author Devante Saenger
 * @version 5/3/18
 */
public class Connect4 extends JApplet
{
    private String connect4[][] = new String[6][7];
    private Color color[][] = new Color[6][7];
    private int player = 1;
    private ArrayList<Integer> chipLocations1 = new ArrayList<Integer>();
    private ArrayList<Integer> chipLocations2 = new ArrayList<Integer>();
    private static final int row = 6;
    private int xCoord, yCoord;
    private static final int column = 7, BLOCKSIZE = 50;
    private int cLength = 6 , rLength = 7;
    public boolean valid = false;
    public void init()
    {
        for (int i= 0; i<row; i++)
        {
            for (int j = 0; j<column; j++)
            {
                connect4[i][j] = "White";
            }
        }
        addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    int x = e.getX();
                    int y = e.getY();
                    if(x<0 || y<0 || x>= BLOCKSIZE * column || y >= BLOCKSIZE * row)
                    {
                        showStatus ("Off the Board");
                        return;
                    }
                    x = x/50;
                    y = y/50;
                    int location = y* row + x;
                    if ((connect4[x][0] == "White") && (player ==1))
                    {
                        showStatus("Good Move!");
                        for(int i = cLength; i >= 0 ; i--)
                        {
                            if (connect4[x][i] == "White")
                            {
                                connect4[x][i] = ("Red");
                                chipLocations1.add(location);
                                showStatus ("Placed Red Chip");
                                xCoord = x;
                                yCoord = i;
                                player = 2;
                                repaint();
                                return;
                            }

                        }

                    }

                    else if ((connect4[x][0] == "White" ) && (player ==2))
                    {
                        showStatus("Good Move!");
                        for(int i = cLength;i >= 0 ; i--)
                        {
                            if (connect4[x][i] == "White")
                            {
                                connect4[x][i] = ("Yellow");
                                chipLocations2.add(location);
                                showStatus ("Placed Yellow Chip");
                                xCoord = x;
                                yCoord = i;
                                player = 1;
                                repaint();
                                return;
                            }
                        }

                    }
                    else {
                        showStatus("Column is full. Choose a different column to place chip");
                    }
                    
                }
            }
        );

    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,500,500);
        for (int i = 0; i < rLength; i++)
        {
            for (int j=0; j < cLength; j++)

            {  g.setColor(Color.BLACK);
                g.drawRect(i*50, j *50, BLOCKSIZE, BLOCKSIZE);
            }
        }

        for (int i =0; i < rLength; i++)
        {
            for (int j=0; j < cLength; j++)

            {
                if ((connect4[xCoord][yCoord] == "Red"))
                {

                    g.setColor(Color.RED);
                    g.fillRect(xCoord * BLOCKSIZE, yCoord* BLOCKSIZE,
                        BLOCKSIZE, BLOCKSIZE);
                }
                else if((connect4[xCoord][yCoord] == "Yellow"))
                {

                    g.setColor(Color.YELLOW);
                    g.fillRect(xCoord* BLOCKSIZE, yCoord* BLOCKSIZE,
                        BLOCKSIZE, BLOCKSIZE);
                }
                if ((connect4[i][j] == "Red"))
                {
                    g.setColor(Color.RED);
                    g.fillRect(i* BLOCKSIZE, j * BLOCKSIZE,
                        BLOCKSIZE, BLOCKSIZE);
                }
                else if((connect4[i][j] == "Yellow"))
                {
                    g.setColor(Color.YELLOW);
                    g.fillRect(i* BLOCKSIZE, j* BLOCKSIZE,
                        BLOCKSIZE, BLOCKSIZE);
                }

            }

        }

    }

}