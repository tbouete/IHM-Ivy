package command;

import fr.dgac.ivy.Ivy;
import fr.dgac.ivy.IvyException;

public abstract class ACommand {
	
	private String command;
	protected Ivy ivy;
	
	public ACommand(Ivy ivy) {
		this.ivy = ivy;
	}
	
	public void execute() {
		try {
			this.ivy.sendMsg(command);
		} catch (IvyException e) {
			e.printStackTrace();
		}
	}

	public String getCommand() {
		return command;
	}

	protected void setCommand(String command) {
		this.command = command;
	}

	
}
