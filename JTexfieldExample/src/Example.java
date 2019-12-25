import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Example implements ActionListener {

	JPanel panel1, panel2, panel3, mainPanel;
	GridLayout gridLayout;
	JButton btn1, btn2;

	JTextField tf1, tf2, tf3;
	JLabel lb1, lb2, lb3;

	public Example() {

		gridLayout = new GridLayout(3, 1);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();

		lb1 = new JLabel("1");
		lb2 = new JLabel("2");
		lb3 = new JLabel("3");

		tf1 = new JTextField(20);
		tf2 = new JTextField(20);
		tf3 = new JTextField(20);
		tf3.addActionListener(this);

		btn1 = new JButton("Normal");
		btn1.addActionListener(this);
		btn2 = new JButton("Focusable&Add");
		btn2.addActionListener(this);

		panel1.add(btn1);
		panel1.add(tf1);
		panel1.add(lb1);

		panel2.add(btn2);
		panel2.add(tf2);
		panel2.add(lb2);

		panel3.add(tf3);
		panel3.add(lb3);

		mainPanel = new JPanel(gridLayout);
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Example example = new Example();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(example.mainPanel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600, 600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "Normal") {
			lb1.setText(tf1.getText());

		} else if (e.getActionCommand() == "Focusable&Add") {
			lb2.setText(lb2.getText() + tf2.getText());
			tf2.requestFocus();

		} else {
			tf3.requestFocus();
			lb3.setText(lb3.getText() + " " + tf3.getText());
			tf3.setText("");

		}

	}

}
