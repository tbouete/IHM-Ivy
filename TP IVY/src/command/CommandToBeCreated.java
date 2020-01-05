package command;

import fr.dgac.ivy.Ivy;
import utility.AvailableActions;
import utility.AvailableColors;
import utility.AvailableShapes;

public class CommandToBeCreated {
	
	private Ivy ivy;
	private AvailableActions action;
	private AvailableShapes shape;
	private Integer posX;
	private Integer posY;
	private Integer targetPosX;
	private Integer targetPosY;
	private AvailableColors color;
	
	public CommandToBeCreated(Ivy ivy) {
		this.ivy = ivy;
	}
	
	public Ivy getIvy() {
		return ivy;
	}

	public void setIvy(Ivy ivy) {
		this.ivy = ivy;
	}

	public AvailableActions getAction() {
		return action;
	}
	public void setAction(AvailableActions action) {
		this.action = action;
	}
	public AvailableShapes getShape() {
		return shape;
	}
	public void setShape(AvailableShapes shape) {
		this.shape = shape;
	}
	public Integer getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public Integer getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Integer getTargetPosX() {
		return targetPosX;
	}

	public void setTargetPosX(int targetPosX) {
		this.targetPosX = targetPosX;
	}

	public Integer getTargetPosY() {
		return targetPosY;
	}

	public void setTargetPosY(int targetPosY) {
		this.targetPosY = targetPosY;
	}

	public AvailableColors getColor() {
		return color;
	}
	public void setColor(AvailableColors color) {
		this.color = color;
	}

	public boolean isComplete() {
		switch(action) {
			case Creer:
				if(shape != null 
					&& posX != null
					&& posY != null
					&& color != null) {
						return true;
				}
				break;
			case Deplacer:
				if(posX != null
					&& posY != null
					&& targetPosX != null
					&& targetPosY != null) {
						return true;
				}
				break;
			case Supprimer:
				if(posX != null
					&& posY != null) {
						return true;
				}
				break;
			default:
				return false;
		}
		return false;
	}
	
	

}
