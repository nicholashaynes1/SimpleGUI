package simple.gui.view;

import javax.swing.*;

import simple.gui.controller.GUIController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.*;


public class GUIPanel extends JPanel
{
	private JButton simpleButton;
	private JTextField simpleTextField;
	private SpringLayout baseLayout;

	private GUIController baseController;

	public GUIPanel(GUIController baseController)
	{
		this.baseController = baseController;

		baseLayout = new SpringLayout();
		simpleButton = new JButton("I am Simple");

		simpleTextField = new JTextField("Ypu can type whatevs in here");

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(simpleButton);
		this.add(simpleTextField);
		this.setBackground(Color.YELLOW);
		
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, simpleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, simpleButton, 13, SpringLayout.SOUTH, simpleTextField);

	}

	private void setupListeners()
	{
		simpleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}

		});
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent clicked)
			{
				if(SwingUtilities.isLeftMouseButton(clicked))
				{
					simpleTextField.setText("You have left clicked");
				}
				else if(SwingUtilities.isRightMouseButton(clicked))
				{
					simpleTextField.setText("you have right clicked");
				}
			}
			
			public void mouseReleased(MouseEvent released)
			{
				changeRandomColor();
				
			}
			
			public void mousePressed(MouseEvent pressed)
			{
				
			}
			
			public void mouseEntered(MouseEvent entered)
			{
				changeRandomColor();
			}
			
			public void mouseExited(MouseEvent exited)
			{
				changeRandomColor();
			}
			
			
		});
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent moved)
			{
				if((moved.getX() > 25 && moved.getX() < 40) && (moved.getY() > 50 && moved.getY() < 70))
				{
					changeRandomColor();
				}
			}
			
			public void mouseDragged(MouseEvent dragged)
			{
				if(dragged.isAltDown())
				{
					simpleTextField.setText("you held the alt down");
				}
			}
		});	
		
			
	}
	

	private void changeRandomColor()
	{
		int red, green,blue;
		
		red = (int) (Math.random() * 256);
		
		green = (int) (Math.random() * 256);
		
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}
}
