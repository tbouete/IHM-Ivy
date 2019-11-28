package utility;


/**
 * Contains all the Ivy messages the recognized by this application
 * @author Titouan
 *
 */
public class IvyRecognizedMessages {
	
	public static final String REGEX_MOUSE_CLICKED = "^Palette:MouseClicked x=(.*) y=(.*)$\"";
	
	public static final String REGEX_SRA5_ICI = "^sra5 Text=ici.*$";
	public static final String REGEX_SRA5_ALEATOIRE = "^sra5 Text=aleatoire.*$";
	public static final String REGEX_SRA5_CET_OBJET = "^sra5 Text=cet_objet.*$";
	public static final String REGEX_SRA5_CE_RECTANGLE = "^sra5 Text=ce_rectangle.*$";
	public static final String REGEX_SRA5_CETTE_ELLIPSE = "^sra5 Text=cette_ellipse.*$";
	public static final String REGEX_SRA5_CETTE_COULEUR = "^sra5 Text=cette_couleur.*$";
	
	public static final String REGEX_SRA5_ROUGE = "^sra5 Text=rouge.*$";
	public static final String REGEX_SRA5_VERT = "^sra5 Text=vert.*$";
	public static final String REGEX_SRA5_BLEU = "^sra5 Text=bleu.*$";
	public static final String REGEX_SRA5_DORE = "^sra5 Text=dore.*$";
	public static final String REGEX_SRA5_NOIR = "^sra5 Text=noir.*$";
	public static final String REGEX_SRA5_BLANC = "^sra5 Text=blanc.*$";
	
	public static final String REGEX_RECO_SUPPRIMER = "^OneDollar Reco=supprimer$";
	public static final String REGEX_RECO_DEPLACER = "^OneDollar Reco=deplacer$";
	public static final String REGEX_RECO_RECTANGLE = "^OneDollar Reco=rectangle$";
	public static final String REGEX_RECO_ELLIPSE = "^OneDollar Reco=ellipse$";

}
