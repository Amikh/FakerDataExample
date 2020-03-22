package com.am.utils;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameView {

	/* Field for output data */

	private JTextArea ta;

	/* Field fro enter number */

	private JTextField textfield;

	/* Field input */

	private String inputNumber;

	private List<String> listForCheck = new ArrayList<String>();

	public FrameView() {

		/* Main Frame */
		JFrame f = new JFrame("Person data");
		ta = new JTextArea();

		f.setLayout(null);
		f.setVisible(true);
		f.setSize(900, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// enter name label
		/* Label for text */
		JLabel label = new JLabel();
		label.setText("Enter number:");
		label.setBounds(10, 10, 100, 100);
		// textfield to enter number
		textfield = new JTextField();
		textfield.setBounds(100, 50, 130, 30);
		// Button
		/* Button for running function */

		JButton b = new JButton("Submit");
		b.setBounds(300, 50, 150, 30);
		ta.setBounds(5, 5, 100, 200);
		/* For scroll data in output */
		JScrollPane scrolltxt = new JScrollPane(ta);
		scrolltxt.setBounds(100, 100, 500, 100);
		f.add(scrolltxt);
		f.add(label);
		f.add(textfield);
		f.add(b);
		/* Click on button */
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				e.getActionCommand();
				// number from enter
				inputNumber = textfield.getText();
				boolean indexPresent = isNumberPresent(inputNumber);
				if (indexPresent) {
					boolean index = isNumeric(inputNumber);
					if (index) {
						GenerateData.isdataPerson(inputNumber);
						ta.append(GenerateData.result + "\n");
						textfield.setText("");
					} else {
						String msg = "Error!!!\n"
								+ "Please enter only numbers";
						textfield.setText("");
						JOptionPane.showMessageDialog(new Frame(), msg, "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String msg = "Error!!!\n"
							+ "The number is present\n"
							+ "Please enter another numbers";
					textfield.setText("");
					JOptionPane.showMessageDialog(new Frame(), msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 
	 * Method for check enter only numbers
	 * 
	 * param str
	 * 
	 * return
	 * 
	 */

	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}

	}

	/**
	 * 
	 * Function for check if first number is present
	 * 
	 * this is for using uniq number in the feature
	 * 
	 * when we need to work with DB
	 * 
	 * param str
	 * 
	 * return
	 * 
	 */

	private boolean isNumberPresent(String str) {
		for (String s : listForCheck) {
			if (str.equals(s)) {
				listForCheck.add(str);
				return false;
			}
		}

		listForCheck.add(str);
		return true;

	}
}
