package command;

import fr.dgac.ivy.Ivy;

public class CommandMoveShape extends ACommand{

	public CommandMoveShape(Ivy ivy) {
		super(ivy);
	}
	
	public void setAllParameters(String nom, int x, int y) {
		this.setCommand("Palette:DeplacerObjetAbsolu nom=" + nom + " x=" + x + " y=" + y);
	}

}
