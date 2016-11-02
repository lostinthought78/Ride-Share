import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUICode {

	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JButton b = new JButton("Click me");
		b.addActionListener(  new ButtonActionListener() );
		
		JLabel l = new JLabel("A label");
		JTextField t = new JTextField(50);
		
		p.add(b);
		p.add(l);
		p.add(t);
		
		f.add(p);
		f.setSize(500,600);
		f.setTitle("CSCI 330 Superframe");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
