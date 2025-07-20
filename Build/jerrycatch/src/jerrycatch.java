 import java.awt.*;
    import java.awt.event.*;
    import java.util.Random;
    import javax.swing.*;
    
    public class jerrycatch
     {
        int boardWidth = 900;
        int boardHeight = 650; 
    
        JFrame frame = new JFrame(" HELP TOM ");
        JLabel textLabel = new JLabel();
        JPanel textPanel = new JPanel();
        JPanel boardPanel = new JPanel(); 
        
        JButton[] board = new JButton[16];
        ImageIcon jerryIcon;
        ImageIcon tomIcon;
    
        JButton currjerryTile;
        JButton currtomTile;
    
        Random random = new Random();
        Timer setjerryTimer;
        Timer settomTimer;
        int score = 0;
    
        jerrycatch() 
        {
            
        frame.setSize(boardWidth, boardHeight);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
    
        textLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Score: " + Integer.toString(score));
        textLabel.setOpaque(true);
    
            textPanel.setLayout(new BorderLayout());
            textPanel.add(textLabel);		
            frame.add(textPanel, BorderLayout.NORTH);
    
        boardPanel.setLayout(new GridLayout(4, 4));
            
            frame.add(boardPanel);
    
            
            Image tomImg = new ImageIcon(getClass().getResource("./tom.jpg")).getImage();
            tomIcon = new ImageIcon(tomImg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
    
            Image jerryImg = new ImageIcon(getClass().getResource("./jerry.jpg")).getImage();
            jerryIcon = new ImageIcon(jerryImg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
            
        for (int i = 0; i < 16; i++) 
        {
                JButton tile = new JButton();
                board[i] = tile;
                boardPanel.add(tile);
                tile.setFocusable(false);
                // tile.setIcon(plantIcon);
    
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton tile = (JButton) e.getSource();
                        if (tile == currjerryTile) {
                            score += 10;
                            textLabel.setText("this cat got some serious skills " + Integer.toString(score));
                        }
                        else if (tile == currtomTile) {
                            textLabel.setText("Oops! Looks like i need a new plan:" + Integer.toString(score));
                            setjerryTimer.stop();
                            settomTimer.stop();
                            for (int i = 0; i <16; i++) {
                                board[i].setEnabled(false);
                            }
                        }
                    }
                });
        }
    
            setjerryTimer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    if (currjerryTile != null) {
                        currjerryTile.setIcon(null);
                        currjerryTile = null;
                    }
    
                    
                    int num = random.nextInt(16); 
                    JButton tile = board[num];
    
                    
                    if (currtomTile == tile) return;
    
                    
                    currjerryTile = tile;
                    currjerryTile.setIcon(jerryIcon);
                }
             } );
    
            settomTimer = new Timer(1500, new ActionListener() {
                public void actionPerformed(ActionEvent e)
                 {
                    
                    if (currtomTile != null) {
                        currtomTile.setIcon(null);
                        currtomTile = null;
                    }
    
                    
                    int num = random.nextInt(16); 
                    JButton tile = board[num];
    
                    
                    if (currjerryTile == tile) return;
    
                
                    currtomTile = tile;
                    currtomTile.setIcon(tomIcon);
                }
            });
    
            setjerryTimer.start();
            settomTimer.start();
            frame.setVisible(true);
        }
    }
    
    
    
    

