package command;

import fr.dgac.ivy.Ivy;
import utility.AvailableColors;
import utility.AvailableShapes;
import utility.IvyUtilitaire;

public class CommandCreateShape extends ACommand {
	
	private AvailableShapes shape;

	public CommandCreateShape(Ivy ivy, AvailableShapes shape) {
		super(ivy);
		this.shape = shape;
	}

	public void setAllParameters(int x, int y,
			int longeur, int hauteur,
			int couleurFondR, int couleurFondG, int couleurFondB,
			int couleurContourR, int couleurContourG, int couleurContourB) {
		
		
		//Select the shape to create
		String strShape;
		
		switch(this.shape) {
		case RECTANGLE:
			strShape = "Rectangle";
			break;
		case ELLIPSE:
			strShape = "Ellipse";
			break;
		default:
			strShape = "Rectangle";
			break;
		}
		
		//Build the Ivy message
		String newCommand = "Palette:Creer" + strShape +
				" x="+ x + 
				" y=" + y +
				" longueur=" + longeur + 
				" hauteur=" + hauteur + 
				" couleurFond=" + couleurFondR + ":" + couleurFondG + ":" + couleurFondB + 
				" couleurContour=" + couleurContourR + ":" + couleurContourG + ":" + couleurContourB;
		this.setCommand(newCommand);
	}
	
	public void setAllParametersColor(int x, int y,
			int longeur, int hauteur,
			AvailableColors color) {
		switch (color) {
		case RED:
			this.setAllParametersRed(x, y, longeur, hauteur);
			break;
		case GREEN:
			this.setAllParametersGreen(x, y, longeur, hauteur);
			break;
		case BLUE:
			this.setAllParametersBlue(x, y, longeur, hauteur);
			break;
		case WHITE:
			this.setAllParametersWhite(x, y, longeur, hauteur);
			break;
		case BLACK:
			this.setAllParametersBlack(x, y, longeur, hauteur);
			break;
		case GOLDEN:
			this.setAllParametersGolden(x, y, longeur, hauteur);
			break;
		default:
			this.setAllParametersRandom();
		}
	}
	
	private void setAllParametersRed(int x, int y,
			int longeur, int hauteur) {
		int[] red = IvyUtilitaire.COLOR_RED;
		int[] border = IvyUtilitaire.COLOR_DEFAULT_BORDER;
		this.setAllParameters(x, y,
				longeur, hauteur,
				red[0], red[1], red[2],
				border[0], border[1], border[2]);
	}
	
	private void setAllParametersGreen(int x, int y,
			int longeur, int hauteur) {
		int[] green = IvyUtilitaire.COLOR_GREEN;
		int[] border = IvyUtilitaire.COLOR_DEFAULT_BORDER;
		this.setAllParameters(x, y,
				longeur, hauteur,
				green[0], green[1], green[2],
				border[0], border[1], border[2]);
	}
	
	private void setAllParametersBlue(int x, int y,
			int longeur, int hauteur) {
		int[] blue = IvyUtilitaire.COLOR_BLUE;
		int[] border = IvyUtilitaire.COLOR_DEFAULT_BORDER;
		this.setAllParameters(x, y,
				longeur, hauteur,
				blue[0], blue[1], blue[2],
				border[0], border[1], border[2]);
	}
	
	private void setAllParametersWhite(int x, int y,
			int longeur, int hauteur) {
		int[] white = IvyUtilitaire.COLOR_WHITE;
		int[] border = IvyUtilitaire.COLOR_DEFAULT_BORDER;
		this.setAllParameters(x, y,
				longeur, hauteur,
				white[0], white[1], white[2],
				border[0], border[1], border[2]);
	}
	
	private void setAllParametersBlack(int x, int y,
			int longeur, int hauteur) {
		int[] black = IvyUtilitaire.COLOR_BLACK;
		int[] border = IvyUtilitaire.COLOR_DEFAULT_BORDER;
		this.setAllParameters(x, y,
				longeur, hauteur,
				black[0], black[1], black[2],
				border[0], border[1], border[2]);
	}
	
	private void setAllParametersGolden(int x, int y,
			int longeur, int hauteur) {
		int[] golden = IvyUtilitaire.COLOR_GOLDEN;
		int[] border = IvyUtilitaire.COLOR_DEFAULT_BORDER;
		this.setAllParameters(x, y,
				longeur, hauteur,
				golden[0], golden[1], golden[2],
				border[0], border[1], border[2]);
	}
	
	public void setAllParametersRandom() {
		this.setAllParameters((int)(Math.random()*200), (int)(Math.random()*200),
				(int)(Math.random()*200), (int)(Math.random()*200),
				(int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255),
				(int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
	}
}
