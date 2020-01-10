package command;

import fr.dgac.ivy.Ivy;

public class CommandDeleteShape extends ACommand{

	public CommandDeleteShape(Ivy ivy) {
		super(ivy);
	}
	
	public void setAllParamters(String nom) {
		this.setCommand("Palette:SupprimerObjet nom=" + nom);
	}

}
