import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame ;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrimogemMain {
	
	JLabel counterLabel, perSecLabel;
	JButton button1, button2, button3, button4;
	int primogemCounter;
	Font font1, font2;
	PrimogemHandler pHandler = new PrimogemHandler();

    public static void main(String[] args) {
        new PrimogemMain();
    }
    
    public PrimogemMain(){
    	primogemCounter = 0;
    	
    	createFont();
        createUI(); 
        
    }
    
    public void createFont() {
    	font1 = new Font("Comic Sans MS", Font.PLAIN, 40);
    	font2 = new Font("Comic Sans MS", Font.PLAIN, 40);
    			
    }
    public void createUI(){
        JFrame window = new JFrame();
        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        JPanel primoPanel = new JPanel();
        primoPanel.setBounds(100, 200, 300, 600);
        primoPanel.setBackground(Color.black);
        window.add(primoPanel);
        window.setVisible(true);

        ImageIcon primogem = new ImageIcon(getClass().getResource("primogemimg.png"));
        
        JButton primogemButton = new JButton();
        primogemButton.setBackground(Color.black);
        primogemButton.setFocusPainted(false);
        primogemButton.setBorder(null);
        primogemButton.setIcon(primogem);
        primogemButton.addActionListener(pHandler);
        primoPanel.add(primogemButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100,50,300,150);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(2,1));
        window.add(counterPanel);
        
        counterLabel = new JLabel(primogemCounter + "  primogems");
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);
        
        perSecLabel = new JLabel();
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);
        
        JPanel itemPanel = new JPanel();
        itemPanel.setBounds(500, 170, 250, 250);
        itemPanel.setBackground(Color.blue);
        itemPanel.setLayout(new GridLayout(4,1));
        window.add(itemPanel);
        
        button1 = new JButton();
        button1.setFont(font1);
        button1.setFocusPainted(false);
        button1.addActionListener(pHandler);
       
        
        
        window.setVisible(true);

    }
    
    public class PrimogemHandler implements ActionListener {
    	public void actionPerformed(ActionEvent event) {
    		primogemCounter++;
    		counterLabel.setText(primogemCounter + "  primogems");
    	}
    }
}