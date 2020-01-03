package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import command.ACommand;
import command.CommandBuilder;
import command.CommandCreateShape;
import command.CommandToBeCreated;
import fr.dgac.ivy.Ivy;
import fr.dgac.ivy.IvyApplicationListener;
import fr.dgac.ivy.IvyClient;
import fr.dgac.ivy.IvyException;
import fr.dgac.ivy.IvyMessageListener;
import utility.AvailableActions;
import utility.AvailableColors;
import utility.AvailableShapes;
import utility.IvyRecognizedMessages;

public class MainProjet {
	
	private Ivy ivy;
	private States currentState;

	public static void main(String[] args) {
		MainProjet main = new MainProjet();
		main.init();
	}
	
	private void init() {
		
		this.currentState = States.E0;
		
		/*		
		Timer t = new javax.swing.Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (currentState) {
			case E0:
				
				break;
			case E1:
				
				break;
			case E2:
				
				break;
			case E3:
				
				break;

			default:
				break;
			}
				
			}
		});
		
		t.start();
		t.stop();		
		*/
		
		this.ivy = new Ivy("myProject", "myProject init", new IvyApplicationListener() {
			
			@Override
			public void disconnect(IvyClient client) {
				System.out.println("Disconnect");				
			}
			
			@Override
			public void directMessage(IvyClient client, int id, String msgarg) {
				System.out.println(client.getApplicationName() + "(" + id + "): " + msgarg);		
			}
			
			@Override
			public void die(IvyClient client, int id, String msgarg) {
				System.out.println("die");				
			}
			
			@Override
			public void connect(IvyClient client) {
				System.out.println("connect");
				
			}
		});
		
		try {
			this.ivy.start("127.255.255.255:2010");
			Thread.sleep(1000);		

			CommandToBeCreated currentCommand = new CommandToBeCreated(ivy);
			
			switch (currentState) {
			case E0:
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_RECO_SUPPRIMER, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setAction(AvailableActions.Supprimer);
						currentState = States.E1;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_RECO_DEPLACER, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setAction(AvailableActions.Deplacer);
						currentState = States.E1;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_RECO_ELLIPSE, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setAction(AvailableActions.Creer);
						currentCommand.setShape(AvailableShapes.ELLIPSE);
						currentState = States.E1;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_RECO_RECTANGLE, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setAction(AvailableActions.Creer);
						currentCommand.setShape(AvailableShapes.RECTANGLE);
						currentState = States.E1;
					}
				});
				break;
			case E1:
				//déclencher timer 5s annulation commande si incomplète
				//TODO
				
				//si sra5 défini couleur
				//remplir commande
				//rester E1
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_ALEATOIRE, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setColor(AvailableColors.RANDOM);
						currentState = States.E1;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_BLANC, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setColor(AvailableColors.WHITE);
						currentState = States.E1;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_BLEU, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setColor(AvailableColors.BLUE);
						currentState = States.E1;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_DORE, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setColor(AvailableColors.GOLDEN);
						currentState = States.E1;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_NOIR, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setColor(AvailableColors.BLACK);
						currentState = States.E1;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_ROUGE, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setColor(AvailableColors.RED);
						currentState = States.E1;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_VERT, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setColor(AvailableColors.GREEN);
						currentState = States.E1;
					}
				});
				
				//si sra5 défini position ou couleur d'un objet
				//go E2
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_CET_OBJET, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentState = States.E2;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_CE_RECTANGLE, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentState = States.E2;
					}
				});
				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_CETTE_ELLIPSE, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentState = States.E2;
					}
				});

				
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_CETTE_COULEUR, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentState = States.E2;
					}
				});
				
				//si Palette 
				//TODO
				//remplir commande avec position
				//go E3
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setPosX(Integer.parseInt(args[0]));
						currentCommand.setPosY(Integer.parseInt(args[1]));
						currentState = States.E3;
					}
				});
				
				break;
			case E2:
				//déclencher timer 2s si aucune informations données
				//TODO
				
				//si Palette 
				//TODO
				//remplir commande avec position et couleur objet cliqué
				this.ivy.bindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED, new IvyMessageListener() {
					@Override
					public void receive(IvyClient client, String[] args) {
						currentCommand.setPosX(Integer.parseInt(args[0]));
						currentCommand.setPosY(Integer.parseInt(args[1]));
						if(currentCommand.getColor() == null) {//éviter écrire par dessus 
							/**
							 * récup objet
							 */
							try {
								ivy.sendMsg("Palette:TesterPoint x=" + args[0] + " y=" + args[1]);
								
								String regex = "^Palette:ResultatTesterPoint x=(.*) y=(.*) nom=(.*)$";
								ivy.bindMsg(regex, new IvyMessageListener() {
									@Override
									public void receive(IvyClient client, String[] args) {
										/**
										 * demander ses infos
										 */
										try {
											ivy.sendMsg("Palette:DemanderInfo nom="+ args[3]);
											
											String regex = "^Palette:Info nom= arg1 x=(.*) y=(.*) longueur=(.*) hauteur=(.*) couleurFond=(.*) couleurContour=(.*)$";
											ivy.bindMsg(regex, new IvyMessageListener() {
												@Override
												public void receive(IvyClient client, String[] args) {
													/**
													 * récup ses infos
													 */
													//comment est récup couleur ?
//													switch(args[5]) {
//													
//													}
//													currentCommand.setColor(color);
													 /** */
												}
											});
										} catch (IvyException e) {
											e.printStackTrace();
										}
										 /** */
									}
								});
							} catch (IvyException e) {
								e.printStackTrace();
							}
							 /** */
						}
						
					}
				});

				//si commande complete
				//executer commande
				//reset currentCommand TODO
				//go E0
				//sinon
				//go E1
				if(currentCommand.isComplete()) {
					ACommand currentCommandToExecute = CommandBuilder.buildCommand(currentCommand);
					currentCommandToExecute.execute();
					currentState = States.E0;
				}
				else {
					currentState = States.E1;
				}
				
				break;
			case E3:
				//déclencher timer 2s si aucune informations données
				//TODO
				
				//si sra5 
				//TODO
				//remplir commande avec position ou couleur objet ciblé
				
				//si commande complete
				//executer
				//reset currentCommand TODO
				//go E0
				//sinon
				//go E1
				if(currentCommand.isComplete()) {
					ACommand currentCommandToExecute = CommandBuilder.buildCommand(currentCommand);
					currentCommandToExecute.execute();
					currentState = States.E0;
				}
				else {
					currentState = States.E1;
				}
				break;

			default:
				break;
			}			
		} catch (IvyException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

//	private void drawRedRectangleOnRedSRA5() throws IvyException {
//		this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_ROUGE, new IvyMessageListener() {
//			
//			@Override
//			public void receive(IvyClient client, String[] args) {
//				CommandCreateShape command = new CommandCreateShape(ivy, AvailableShapes.RECTANGLE);
//				command.setAllParametersRandom();
//				command.execute();					
//			}
//		});
//	}
//	
//	private void drawRandomEllipseOnMouseClicked() throws IvyException {
//		this.ivy.bindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED, new IvyMessageListener() {
//			
//			@Override
//			public void receive(IvyClient client, String[] args) {
//				CommandCreateShape command = new CommandCreateShape(ivy, AvailableShapes.ELLIPSE);
//				command.setAllParametersRandom();
//				command.execute();					
//			}
//		});
//	}
//	
//	private void drawRandomRectangleOnMouseClicked() throws IvyException {
//		this.ivy.bindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED, new IvyMessageListener() {
//			
//			@Override
//			public void receive(IvyClient client, String[] args) {
//				CommandCreateShape command = new CommandCreateShape(ivy, AvailableShapes.RECTANGLE);
//				command.setAllParametersRandom();
//				command.execute();					
//			}
//		});
//	}
}
