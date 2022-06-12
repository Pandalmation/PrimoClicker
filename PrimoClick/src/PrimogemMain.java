import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame ;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class PrimogemMain { //class for main program
	JFrame window = new JFrame(); //using JFrame to set up window
	JPanel titleNamePanel, startButtonPanel, charPanel, paimonPanel; //Jpanels
	JLabel counterLabel, perSecLabel, charLabel, titleNameLabel, paimonLabel; //JLabels
	JButton button1, button2, button3, button4, button5, button6, startButton; //JButtons
	int primogemCounter, timerSpeed, amberNumber, amberPrice, barbaraNumber, barbaraPrice, monaNumber, monaPrice, fischlNumber, fischlPrice, qiqiNumber, qiqiPrice, ganyuNumber, ganyuPrice; 
	double perSecond;
	boolean timerOn, barbaraUnlocked, monaUnlocked, fischlUnlocked, qiqiUnlocked, ganyuUnlocked; //boolean type
	Font font1, font2, font3, font4; //fonts
	PrimogemHandler pHandler = new PrimogemHandler();
	Timer timer;
	JTextArea messageText; //JtextArea
	MouseHandler mHandler = new MouseHandler();
	TitleScreenHandler TsHandler = new TitleScreenHandler();

    public static void main(String[] args) {
        new PrimogemMain();
    }
    
    public PrimogemMain(){ //initializing variables
    	timerOn = false;
	perSecond = 0;
	primogemCounter = 0;
	//setting the characters initial values of (numbers of character bought, initial price for one, and setting it as locked)
	amberNumber = 0;
	amberPrice = 10;
	barbaraNumber = 0;
	barbaraPrice = 160;
	barbaraUnlocked = false;
	monaNumber = 0;
	monaPrice = 800;
	monaUnlocked = false;
	fischlNumber = 0;
	fischlPrice = 1600;
	fischlUnlocked = false;
	qiqiNumber = 0;
	qiqiPrice = 12000;
	qiqiUnlocked = false;
	ganyuNumber = 0;
	ganyuUnlocked = false;
	ganyuPrice = 28800;
	//calling the methods
    	createFont();
    	createMenuUI();
    }
    
    public void createFont() { //function to create different fonts
    	font1 = new Font("Comic Sans MS", Font.PLAIN, 40); //just different fonts to use 
    	font2 = new Font("Comic Sans MS", Font.PLAIN, 30);
    	font3 = new Font("DialogInput", Font.PLAIN, 50);
    	font4 = new Font("Monospaced", Font.PLAIN, 50);
    }
    
    public void createMenuUI() { //method to create menu user interface 
    	
    	window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to close the window properly
        window.getContentPane().setBackground(Color.black); //to set the window's background color
        window.setTitle("PrimoClicker"); //sets the window title
        window.setLayout(null); //to disable the default layout
        window.setResizable(false); //make sure window cannot be resized
        
    	titleNamePanel = new JPanel(); //Panel for the game title
        titleNamePanel.setBackground(Color.black);
        titleNamePanel.setBounds(340, 150, 600, 300); //setting x,y,width,height of the panel
        titleNameLabel = new JLabel("PrimoClicker"); // label for the game title
        titleNameLabel.setFont(font3); //applying the font already existing
        titleNameLabel.setSize(700,700); //to set size of the label
        titleNameLabel.setForeground(Color.white); //to set the foreground color of the label
        titleNamePanel.add(titleNameLabel); //adding the title to the label
        
        startButtonPanel = new JPanel(); //panel for the start button
        startButtonPanel.setBounds(240, 400, 800, 200); //setting x,y,width,height of the panel
        startButtonPanel.setBackground(Color.black); //setting background color of panel as black so it blends with the black window background 
        
        paimonPanel = new JPanel(); //create panel for Paimon
        paimonPanel.setBounds(535, 250, 200, 150); //setting x,y,width,height of the panel
        paimonPanel.setBackground(Color.black); //set background color for paimon panel
        paimonLabel = new JLabel(); //create label for paimon
        paimonPanel.add(paimonLabel); //adding the label to the panel
        window.add(paimonPanel); //adding the panel to the window
        ImageIcon paimonpixel = new ImageIcon(getClass().getResource("paimonpixel.png")); //to load image of the paimon sprite
        paimonLabel.setIcon(paimonpixel); //setting icon of paimon into the Label

        startButton = new JButton("CLICK!"); //the button to start the game that will direct to the cookie 
        startButton.setSize(900, 500); //setting width height size of button
        startButton.setBackground(Color.red); //set button background color
        startButton.setForeground(Color.WHITE); //set foreground button color
        startButton.setFont(font4); //applying the font for the text in start button
        startButton.addActionListener(TsHandler); 
        startButton.setFocusPainted(false); //setting it false so that there is no blue focus ring around
        startButtonPanel.add(startButton); //adding the start button into the start button panel
        window.add(startButtonPanel); //adding the panels into the window
        window.add(titleNamePanel);
        
        window.setVisible(true); //making the window appeal on the screen
    }
    //function to create the primoclicker UI
    public void createGameUI(){
    	titleNamePanel.setVisible(false); //making panels from the menu screen invisible
    	startButtonPanel.setVisible(false);
    	paimonPanel.setVisible(false);
        window.setSize(1280, 720); //Setting window size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setTitle("PrimoClicker"); //setting window title
        window.setLayout(null); 
        window.setResizable(false); //not allowing user to fullscreen the window
     
        JPanel primoPanel = new JPanel();
        primoPanel.setBounds(100, 200, 300, 600);
        primoPanel.setBackground(Color.black);
        window.add(primoPanel);
   
        JPanel charPanel = new JPanel();
        charPanel.setBounds(900, 300, 200, 150);
        charPanel.setBackground(Color.black);
        window.add(charPanel);

        ImageIcon primogem = new ImageIcon(getClass().getResource("primogemimg.png"));
        
        JButton primogemButton = new JButton();
        primogemButton.setBackground(Color.black);
        primogemButton.setFocusPainted(false);
        primogemButton.setBorder(null);
        primogemButton.setIcon(primogem);
        primogemButton.addActionListener(pHandler);
        primogemButton.setActionCommand("primogem");
        primogemButton.setContentAreaFilled(false);
        primoPanel.add(primogemButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100,50,400,150);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(2,1));
        window.add(counterPanel);
        
        charLabel = new JLabel();
        charPanel.add(charLabel);
        
        counterLabel = new JLabel(primogemCounter + "  primogems");
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);
        
        perSecLabel = new JLabel();
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);
        
        JPanel itemPanel = new JPanel();
        itemPanel.setBounds(500, 170, 300, 400);
        itemPanel.setBackground(Color.blue);
        itemPanel.setLayout(new GridLayout(6,1));
        window.add(itemPanel);
        
        button1 = new JButton("Amber");
        button1.setFont(font1);
        button1.setFocusPainted(false);
        button1.addActionListener(pHandler);
        button1.setActionCommand("amber");
        button1.addMouseListener(mHandler);
	itemPanel.add(button1);
		
	button2 = new JButton("?");
	button2.setFont(font1);
	button2.setFocusPainted(false);
	button2.addActionListener(pHandler);
	button2.setActionCommand("barbara");
	button2.addMouseListener(mHandler);
	itemPanel.add(button2);
		
	button3 = new JButton("?");
	button3.setFont(font1);
	button3.setFocusPainted(false);
	button3.addActionListener(pHandler);
	button3.setActionCommand("mona");
	button3.addMouseListener(mHandler);
	itemPanel.add(button3);
		
	button4 = new JButton("?");
	button4.setFont(font1);
	button4.setFocusPainted(false);
	button4.addActionListener(pHandler);
	button4.setActionCommand("fischl");
	button4.addMouseListener(mHandler);
	itemPanel.add(button4);
		
	button5 = new JButton("?");
	button5.setFont(font1);
	button5.setFocusPainted(false);
	button5.addActionListener(pHandler);
	button5.setActionCommand("qiqi");
	button5.addMouseListener(mHandler);
	itemPanel.add(button5);
		
	button6 = new JButton("?");
	button6.setFont(font1);
	button6.setFocusPainted(false);
	button6.addActionListener(pHandler);
	button6.setActionCommand("ganyu");
	button6.addMouseListener(mHandler);
	itemPanel.add(button6);
        
	JPanel messagePanel = new JPanel();
	messagePanel.setBounds(850, 70, 500, 200);
	messagePanel.setBackground(Color.black);
	window.add(messagePanel);
		
	messageText = new JTextArea();
	messageText.setBounds(700, 70, 500, 150);
	messageText.setForeground(Color.green);
	messageText.setBackground(Color.black);
	messageText.setFont(font2);
	messageText.setLineWrap(true);
	messageText.setWrapStyleWord(true);
	messageText.setEditable(false);
	messagePanel.add(messageText);
        
        window.setVisible(true);
    }
    
    public void setTimer(){ //function to set timer for when to show names of the characters available to be purchased + how much of it has been bought
		timer = new Timer(timerSpeed, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				primogemCounter++;
				counterLabel.setText(primogemCounter + " primogems");
				
				if(barbaraUnlocked==false){
					if(primogemCounter>=160){
						barbaraUnlocked=true;
						button2.setText("Barbara " + "(" + barbaraNumber + ")");		
					}
				}
				if(monaUnlocked==false){
					if(primogemCounter>=800){
						monaUnlocked=true;
						button3.setText("Mona" + "(" + monaNumber + ")");
					}
				}
				if(fischlUnlocked==false){
					if(primogemCounter>=1600){
						fischlUnlocked=true;
						button4.setText("Fischl" + "(" + fischlNumber + ")");
					}
				}
				if(qiqiUnlocked==false){
					if(primogemCounter>=12000){
						qiqiUnlocked=true;
						button5.setText("Qiqi" + "("+ qiqiNumber +")");
					}
				}
				if(ganyuUnlocked==false){
					if(primogemCounter>=28800){
						ganyuUnlocked=true;
						button6.setText("Ganyu" + "("+ ganyuNumber +")");
					}
				}
			}
		});
    }
    
    public void timerUpdate(){
		
		if(timerOn==false){
			timerOn=true;
		}
		else if(timerOn==true){
			timer.stop();
		}
		double speed = 1/perSecond*1000;
		timerSpeed = (int)Math.round(speed); 
		
		String s = String.format("%.1f", perSecond);
		perSecLabel.setText("per second: " + s);
		
		setTimer();
		timer.start();
	}
    
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            createGameUI();
        }
    }
    
    public class PrimogemHandler implements ActionListener {
    	public void actionPerformed(ActionEvent event) {
    		
    		String action = event.getActionCommand();
    		
    		switch(action){
    		case "primogem":
    			primogemCounter++;
    			counterLabel.setText(primogemCounter + " primogems");
    			break;
    			
    		case "amber":
    			if(primogemCounter>=amberPrice) {
    				primogemCounter = primogemCounter - amberPrice;
    				amberPrice= amberPrice + 5;
    				counterLabel.setText(primogemCounter + " primogems");
    				
    				amberNumber++;
					button1.setText("Amber " + "(" + amberNumber + ")");
					messageText.setText("Amber\n[price: " + amberPrice + "]\nEach Amber produces 0.1 primogem per second.");
					ImageIcon amberpixel = new ImageIcon(getClass().getResource("amberpixel.png"));
					charLabel.setIcon(amberpixel);
					
					perSecond = perSecond + 0.1;
					timerUpdate();
    			}
    			else {
    				messageText.setText("\n You need more primogems!");
    			}
    			break;
    			
    		case "barbara":
    			if(primogemCounter >= barbaraPrice) {
					primogemCounter = primogemCounter - barbaraPrice;
					barbaraPrice = barbaraPrice + 50;
					counterLabel.setText(primogemCounter + "primogems");
					
					barbaraNumber++;
					button2.setText("Barbara " + "(" + barbaraNumber + ")");
					messageText.setText("Barbara\n[price: " + barbaraPrice + "]\nEach Barbara produces 10 primogems per second.");
					ImageIcon barbarapixel = new ImageIcon(getClass().getResource("barbarapixel.png"));
					charLabel.setIcon(barbarapixel);
					
					perSecond = perSecond + 10;
					timerUpdate();	
    			}
    			else {
    				messageText.setText("\n You need more primogems!");
    			}
    			break;
    			
    		case "mona":
                if(primogemCounter >= monaPrice) {
                    primogemCounter = primogemCounter - monaPrice;
                    monaPrice = monaPrice + 100;
                    counterLabel.setText(primogemCounter + "primogems");

                    monaNumber++;
                    button3.setText("Mona " + "(" + monaNumber + ")");
                    messageText.setText("Mona\n[price: " + monaPrice + "]\nEach Mona produces\n40 primogems per second.");
                    ImageIcon monapixel = new ImageIcon(getClass().getResource("monapixel.png"));
                    charLabel.setIcon(monapixel);
                    
                    perSecond = perSecond + 40;
                    timerUpdate();	
                }
                else {
    				messageText.setText("\n You need more primogems!");
    			}
                break;
                
    		case "fischl":
                if(primogemCounter >= fischlPrice) {
                    primogemCounter = primogemCounter - fischlPrice;
                    fischlPrice = fischlPrice + 1000;
                    counterLabel.setText(primogemCounter + "primogems");

                    fischlNumber++;
                    button4.setText("Fischl " + "(" + fischlNumber + ")");
                    messageText.setText("Fischl\n[price: " + fischlPrice + "]\nEach Fischl produces\n160 primogems per second.");
                    ImageIcon fischlpixel = new ImageIcon(getClass().getResource("fischlpixel.png"));
                    charLabel.setIcon(fischlpixel);
                  
                    perSecond = perSecond + 160;
                    timerUpdate();	
                }
                else {
    				messageText.setText("\n You need more primogems!");
    			}
                break;
                
    		case "qiqi":
                if(primogemCounter >= qiqiPrice) {
                    primogemCounter = primogemCounter - qiqiPrice;
                    qiqiPrice = qiqiPrice + 2000;
                    counterLabel.setText(primogemCounter + "primogems");

                    qiqiNumber++;
                    button5.setText("Qiqi " + "(" + qiqiNumber + ")");
                    messageText.setText("Qiqi\n[price: " + qiqiPrice + "]\nEach Qiqi produces\n480 primogems per second.");
                    
                    ImageIcon qiqipixel = new ImageIcon(getClass().getResource("qiqipixel.png"));
                    charLabel.setIcon(qiqipixel);
                    
                    perSecond = perSecond + 480;
                    timerUpdate();	
                }
                else {
    				messageText.setText("\n You need more primogems!");
    			}
                break;
                
    		case "ganyu":
                if(primogemCounter >= ganyuPrice) {
                    primogemCounter = primogemCounter - ganyuPrice;
                    ganyuPrice = ganyuPrice + 5000;
                    counterLabel.setText(primogemCounter + "primogems");

                    ganyuNumber++;
                    button6.setText("Ganyu " + "(" + ganyuNumber + ")");
                    messageText.setText("Ganyu\n[price: " + ganyuPrice + "]\nEach Ganyu produces\n1600 primogems per second.");
                    
                    ImageIcon ganyupixel = new ImageIcon(getClass().getResource("ganyupixel.png"));
                    charLabel.setIcon(ganyupixel);
                    
                    perSecond = perSecond + 1600;
                    timerUpdate();	
                }
                else {
    				messageText.setText("\n You need more primogems!");
    			}
                break;
    		}
    	
    	}
    }
    //
    public class MouseHandler implements MouseListener{ //class of mousehandler
		
		@Override // helps prevent the case when you write a function that you think overrides another one
		public void mouseClicked(MouseEvent e){
			
		}
		@Override
		public void mousePressed(MouseEvent e){
			
		}
		@Override
		public void mouseReleased(MouseEvent e){
			
		}
		@Override
		public void mouseEntered(MouseEvent e){ 
			JButton button = (JButton)e.getSource();
			
			if(button == button1){
				messageText.setText("Amber\n[price: " + amberPrice + "]\nEach Amber produces 0.1 primogem every second.");
			}
			
			else if(button == button2){
				if(barbaraUnlocked==false){
					messageText.setText("\n\nThis item is\ncurrently locked!");
				}
				else{
					messageText.setText("Barbara\n[price: " + barbaraPrice + "]\nEach Barbara produces 10 primogems per second.");
				}	
			}
			
			else if(button == button3){
				if(monaUnlocked==false) {
				messageText.setText("\n\nThis item is\ncurrently locked!");
				}
				else{
                    messageText.setText("Mona\n[price: " + monaPrice + "]\nEach Mona produces\n40 primogems per second");
                }
			}
			
			else if(button == button4){
				if(fischlUnlocked==false) {
				messageText.setText("\n\nThis item is\ncurrently locked!");
				}
				else{
                    messageText.setText("Fischl\n[price: " + fischlPrice + "]\nEach Fischl produces\n160 primogems per second");
                }
			}
			
			else if(button == button5){
				if(qiqiUnlocked==false) {
				messageText.setText("\n\nThis item is\ncurrently locked!");
				}
				else{
                    messageText.setText("Qiqi\n[price: " + qiqiPrice + "]\nEach Qiqi produces\n480 primogems per second");
                }
			}
			
			else if(button == button6){
				if(ganyuUnlocked==false) {
				messageText.setText("\n\nThis item is\ncurrently locked!");
				}
				else{
                    messageText.setText("Ganyu\n[price: " + ganyuPrice + "]\nEach Ganyu produces\n1600 primogems per second");
                }
			}
		}
		@Override
		public void mouseExited(MouseEvent e){
			
			JButton button = (JButton)e.getSource();
			
			if(button == button1){
				messageText.setText(null);
			}
			else if(button == button2){
				messageText.setText(null);
			}
			else if(button == button3){
				messageText.setText(null);
			}
			else if(button == button4){
				messageText.setText(null);
			}
			else if(button == button5){
				messageText.setText(null);
			}
			else if(button == button6){
				messageText.setText(null);
			}
		}
	}	
}

    
