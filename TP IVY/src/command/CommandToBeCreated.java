package command;

import java.util.ArrayList;
import java.util.List;

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
	private List<String> listNamesOfSelectedShapes = new ArrayList<String>();
	private String nameSelectedShape;
	
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

	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	public Integer getPosY() {
		return posY;
	}

	public void setPosY(Integer posY) {
		this.posY = posY;
	}

	public Integer getTargetPosX() {
		return targetPosX;
	}

	public void setTargetPosX(Integer targetPosX) {
		this.targetPosX = targetPosX;
	}

	public Integer getTargetPosY() {
		return targetPosY;
	}

	public void setTargetPosY(Integer targetPosY) {
		this.targetPosY = targetPosY;
	}

	public AvailableColors getColor() {
		return color;
	}

	public void setColor(AvailableColors color) {
		this.color = color;
	}

	public List<String> getListNamesOfSelectedShapes() {
		return listNamesOfSelectedShapes;
	}

	public void setListNamesOfSelectedShapes(List<String> listNamesOfSelectedShapes) {
		this.listNamesOfSelectedShapes = listNamesOfSelectedShapes;
	}

	public String getNameSelectedShape() {
		return nameSelectedShape;
	}

	public void setNameSelectedShape(String nameSelectedShape) {
		this.nameSelectedShape = nameSelectedShape;
	}

	public boolean checkAnComplete() {
		switch(action) {
			case Creer:
				if(color == null) {
					color = AvailableColors.RANDOM;
				}
				if(shape != null 
					&& posX != null
					&& posY != null) {
						return true;
				}
				break;
				
			case Supprimer:
				if(this.listNamesOfSelectedShapes.size() > 0) {
					//FIXME : solution temporaire en attendant gestion cas multiples
					this.setNameSelectedShape(this.getListNamesOfSelectedShapes().get(0));
					return true;
				}
				break;
				
			case Deplacer:
				//FIXME : lorsque gestion cas multiples implémentée dans MainProject, tester avec
				// this.listNamesOfSelectedShapes.size() > 1;
				
				if(this.listNamesOfSelectedShapes.size() > 0
					&& targetPosX != null
					&& targetPosY != null) {
					//FIXME : solution temporaire en attendant gestion cas multiples
					this.setNameSelectedShape(this.getListNamesOfSelectedShapes().get(0));
					return true;
				}
				break;
			default:
				return false;
		}
		return false;
	}
	
	

}
