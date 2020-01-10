package command;

import fr.dgac.ivy.Ivy;

public class CommandTesterPoint extends ACommand{

	public CommandTesterPoint(Ivy ivy) {
		super(ivy);
	}
	
	public void setAllParameters(int x, int y) {
		this.setCommand("Palette:TesterPoint x=" + x + " y=" + y);
	}
}
