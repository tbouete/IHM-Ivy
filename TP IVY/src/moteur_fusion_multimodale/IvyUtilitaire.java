package moteur_fusion_multimodale;

public class IvyUtilitaire {

	public final static String IVY_PALETTE_MOUSEMOVED = "^Palette:MouseMoved x=(.*) y=(.*)$";

	public static String getPaletteCreerRectangleRandom() {
		return "Palette:CreerRectangle" +
				" x="+ (int)(Math.random()*200) + 
				" y=" + (int)(Math.random()*200) +
				" longueur=" + (int)(Math.random()*200) + 
				" hauteur=" + (int)(Math.random()*200) + 
				" couleurFond=" + (int)(Math.random()*255) + ":" + (int)(Math.random()*255) + ":" + (int)(Math.random()*255) + 
				" couleurContour=" + (int)(Math.random()*255) + ":" + (int)(Math.random()*255) + ":" + (int)(Math.random()*255);
	}

}
