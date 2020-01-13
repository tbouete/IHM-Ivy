package command;

import utility.AvailableShapes;

public class CommandBuilder {

	private static final int DEFAULT_LONGUEUR = 300;
	private static final int DEFAULT_HAUTEUR = 100;

	public static ACommand buildCommand(CommandToBeCreated commandToBeCreated) {
		switch (commandToBeCreated.getAction()) {
			case Creer:
				CommandCreateShape commandCreate = new CommandCreateShape(commandToBeCreated.getIvy(), commandToBeCreated.getShape());
				commandCreate.setAllParametersColor(commandToBeCreated.getPosX(), commandToBeCreated.getPosY(), DEFAULT_LONGUEUR, DEFAULT_HAUTEUR, commandToBeCreated.getColor());
				return commandCreate;
	
			case Supprimer:
				CommandDeleteShape commandDelete = new CommandDeleteShape(commandToBeCreated.getIvy());				
				commandDelete.setAllParamters(commandToBeCreated.getNameSelectedShape());
				return commandDelete;
	
			case Deplacer:
				CommandMoveShape commandMove = new CommandMoveShape(commandToBeCreated.getIvy());				
				commandMove.setAllParameters(commandToBeCreated.getNameSelectedShape(), commandToBeCreated.getTargetPosX(), commandToBeCreated.getTargetPosY());				
				return commandMove;			
			default:
				CommandCreateShape commandDefault = new CommandCreateShape(commandToBeCreated.getIvy(), AvailableShapes.RECTANGLE);
				commandDefault.setAllParametersRandom();
				return commandDefault;
			}
	}

}
