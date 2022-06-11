
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

public class PrimogemMain {
	JFrame window = new JFrame();
	JPanel titleNamePanel, startButtonPanel, charPanel, paimonPanel;
	JLabel counterLabel, perSecLabel, charLabel, titleNameLabel, paimonLabel;
	JButton button1, button2, button3, button4, button5, button6, startButton;
	int primogemCounter, timerSpeed, amberNumber, amberPrice, barbaraNumber, barbaraPrice, monaNumber, monaPrice, fischlNumber, fischlPrice, qiqiNumber, qiqiPrice, ganyuNumber, ganyuPrice; 
	double perSecond;
	boolean timerOn, barbaraUnlocked, monaUnlocked, fischlUnlocked, qiqiUnlocked, ganyuUnlocked;
	Font font1, font2, font3, font4;
	PrimogemHandler pHandler = new PrimogemHandler();
	Timer timer;
	JTextArea messageText;
	MouseHandler mHandler = new MouseHandler();
	TitleScreenHandler TsHandler = new TitleScreenHandler();
	
	
	
    public static void main(String[] args) {
        new PrimogemMain();
    }
    
    public PrimogemMain(){
    	
    	timerOn = false;
		perSecond = 0;
		primogemCounter = 0;
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
	
		
		
		
    	primogemCounter = 0;
    	
    	createFont();
    	createMenuUI();
    }
    
    public void createFont() {
    	font1 = new Font("Comic Sans MS", Font.PLAIN, 40);
    	font2 = new Font("Comic Sans MS", Font.PLAIN, 30);
    	font3 = new Font("DialogInput", Font.PLAIN, 50);
    	font4 = new Font("Monospaced", Font.PLAIN, 50);
    }
    
    public void createMenuUI() {
    	
    	window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setTitle("PrimoClicker");
        window.setLayout(null);
        window.setResizable(false);
        window.getContentPane().setBackground(Color.black);
        
    	titleNamePanel = new JPanel();
        titleNamePanel.setBackground(Color.black);
        titleNamePanel.setBounds(340, 150, 600, 300);
        titleNameLabel = new JLabel("PrimoClicker");
        titleNameLabel.setFont(font3);
        titleNameLabel.setSize(700,700);
        titleNameLabel.setForeground(Color.white);
        titleNamePanel.add(titleNameLabel);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(240, 400, 800, 200);
        startButtonPanel.setBackground(Color.black);
        
        paimonPanel = new JPanel();
        paimonPanel.setBounds(535, 250, 200, 150);
        paimonPanel.setBackground(Color.black);
        paimonLabel = new JLabel();
        paimonPanel.add(paimonLabel);
        window.add(paimonPanel);
        ImageIcon paimonpixel = new ImageIcon(getClass().getResource("paimonpixel.png"));
        paimonLabel.setIcon(paimonpixel);
        
        
        startButton = new JButton("CLICK!");
        startButton.setSize(900, 500);
        startButton.setBackground(Color.red);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(font4);
        startButton.addActionListener(TsHandler);
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);
        window.add(startButtonPanel);
        window.add(titleNamePanel);
        
        window.setVisible(true);
    }
    
    public void createGameUI(){
    	titleNamePanel.setVisible(false);
    	startButtonPanel.setVisible(false);
    	paimonPanel.setVisible(false);
        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setTitle("PrimoClicker");
        window.setLayout(null);
        window.setResizable(false);
      
        
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
    
    public void setTimer(){
		
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
    
    public class MouseHandler implements MouseListener{
		
		@Override
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

    
