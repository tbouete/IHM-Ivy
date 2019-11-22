package command;

import fr.dgac.ivy.Ivy;
import fr.dgac.ivy.IvyException;

public abstract class ACommand {
	
	private String command;
	private Ivy ivy;
	
	public ACommand(Ivy ivy) {
		this.ivy = ivy;
	}
	
	public void execute(String... args) throws IvyException {
		this.ivy.sendMsg(command);
	}

	public String getCommand() {
		return command;
	}

	protected void setCommand(String command) {
		this.command = command;
	}

	
}
