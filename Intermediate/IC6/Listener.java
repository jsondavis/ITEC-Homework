package mouseevents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// find out which action event was triggered
		// then perform the event associated with that trigger
		if (actionEvent.getSource() == MouseThing.getButton)
		{
			
		}
		else if(actionEvent.getSource() == MouseThing.clearButton)
		{
			MouseThing.field1.setText("");
			MouseThing.field2.setText("");
		}
		

		
	}

}
