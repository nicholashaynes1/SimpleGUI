package simple.gui.view;

import javax.swing.JFrame;
import simple.gui.controller.GUIController;

public class GUIFrame extends JFrame
{
	private GUIController baseController;
	private GUIPanel basePanel;
	
	public GUIFrame(GUIController baseController)
	{
		this.baseController = baseController;
		basePanel = new GUIPanel(baseController);
		setupFrame();
		
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(800,800);
		this.setVisible(true);
		
		
	}
	
	public GUIController getBaseController()
	{
		return baseController;
	}
	
}
