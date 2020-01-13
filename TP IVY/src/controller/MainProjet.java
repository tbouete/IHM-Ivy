package controller;

import javax.swing.Timer;

import command.ACommand;
import command.CommandBuilder;
import command.CommandTesterPoint;
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
	private CommandToBeCreated commandBeingBuilt;

	public static void main(String[] args) {
		MainProjet main = new MainProjet();
		main.init();
		main.loopIvy();
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
		
		this.ivy = new Ivy("Programme Multimodalité", "Programme Multimodalité: init", new IvyApplicationListener() {
			
			@Override
			public void disconnect(IvyClient client) {
				System.out.println("Disconnected: " + client.getApplicationName());				
			}
			
			@Override
			public void directMessage(IvyClient client, int id, String msgarg) {
				System.out.println(client.getApplicationName() + "(" + id + "): " + msgarg);		
			}
			
			@Override
			public void die(IvyClient client, int id, String msgarg) {
				System.out.println("Died: " + client.getApplicationName());				
			}
			
			@Override
			public void connect(IvyClient client) {
				System.out.println("Connected:" + client.getApplicationName());
				
			}
		});
	}
		
	public void loopIvy() {
		
		try {
			this.ivy.start("127.255.255.255:2010");
			Thread.sleep(1000);		
			
			this.commandBeingBuilt = new CommandToBeCreated(ivy);
			
			while(true){ 
				
				switch (currentState) {
				case E0:					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_RECO_SUPPRIMER, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E0 : REGEX_RECO_SUPPRIMER");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_RECO_SUPPRIMER);
							commandBeingBuilt.setAction(AvailableActions.Supprimer);
							currentState = States.E1;
						}
					});
					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_RECO_DEPLACER, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E0 : REGEX_RECO_DEPLACER");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_RECO_DEPLACER);
							commandBeingBuilt.setAction(AvailableActions.Deplacer);
							currentState = States.E1;
						}
					});
					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_RECO_ELLIPSE, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E0 : REGEX_RECO_ELLIPSE");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_RECO_ELLIPSE);
							commandBeingBuilt.setAction(AvailableActions.Creer);
							commandBeingBuilt.setShape(AvailableShapes.ELLIPSE);
							currentState = States.E1;
						}
					});
					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_RECO_RECTANGLE, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E0 : REGEX_RECO_RECTANGLE");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_RECO_RECTANGLE);
							commandBeingBuilt.setAction(AvailableActions.Creer);
							commandBeingBuilt.setShape(AvailableShapes.RECTANGLE);
							currentState = States.E1;
						}
					});
					Thread.sleep(1000);	
					break;
				case E1:
					//déclencher timer 5s annulation commande si incomplète
					//TODO
					
					// si sra5 défini couleur
					// remplir commande
					// rester E1
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_ALEATOIRE, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E1 : REGEX_SRA5_ALEATOIRE");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_SRA5_ALEATOIRE);
							commandBeingBuilt.setColor(AvailableColors.RANDOM);
							currentState = States.E1;
						}
					});
					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_BLANC, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E1 : REGEX_SRA5_BLANC");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_SRA5_BLANC);
							commandBeingBuilt.setColor(AvailableColors.WHITE);
							currentState = States.E1;
						}
					});
					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_DORE, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E1 : REGEX_SRA5_DORE");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_SRA5_DORE);
							commandBeingBuilt.setColor(AvailableColors.GOLDEN);
							currentState = States.E1;
						}
					});
					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_NOIR, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E1 : REGEX_SRA5_NOIR");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_SRA5_NOIR);
							commandBeingBuilt.setColor(AvailableColors.BLACK);
							currentState = States.E1;
						}
					});
					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_ROUGE, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E1 : REGEX_SRA5_ROUGE");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_SRA5_ROUGE);
							commandBeingBuilt.setColor(AvailableColors.RED);
							currentState = States.E1;
						}
					});
					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_VERT, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E1 : REGEX_SRA5_VERT");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_SRA5_VERT);
							commandBeingBuilt.setColor(AvailableColors.GREEN);
							currentState = States.E1;
						}
					});
					
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_BLEU, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E1 : REGEX_SRA5_BLEU");
							ivy.unBindMsg(IvyRecognizedMessages.REGEX_SRA5_BLEU);
							commandBeingBuilt.setColor(AvailableColors.BLUE);
							currentState = States.E1;
						}
					});
					
					
					/*
					 * Si création : Enregistre la position du clic
					 * Si suppression : Enregistre la liste des objets sous le curseur
					 * Si déplacement : Enregistre la position du clic OU Enregistre la liste des objets sous le curseur
					 */
					this.ivy.bindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED, new IvyMessageListener() {
						@Override
						public void receive(IvyClient client, String[] args) {
							System.out.println("E1 : REGEX_MOUSE_CLICKED");
							
							switch(commandBeingBuilt.getAction()) {
								case Creer:
									// Enregistre position curseur
									System.out.println("--- Création");
									ivy.unBindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED);
									commandBeingBuilt.setPosX(Integer.parseInt(args[0]));
									commandBeingBuilt.setPosY(Integer.parseInt(args[1]));
									currentState = States.E3;
									break;
									
								case Supprimer:
									// Récupère le nom des objets sous le curseur									
									// TODO : timer pour gérer pas de réponse (= clic en dehors d'un objet, donc pas de retour à REGEX_TESTER_POINT)
									

									System.out.println("--- Suppression");
									ivy.unBindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED);
									CommandTesterPoint commandTesterPoint = new CommandTesterPoint(ivy);
									commandTesterPoint.setAllParameters(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
									try {
										ivy.bindMsg(IvyRecognizedMessages.REGEX_TESTER_POINT, new IvyMessageListener() {
											
											@Override
											public void receive(IvyClient client, String[] args) {
												commandBeingBuilt.getListNamesOfSelectedShapes().add(args[2]);
												
												// FIXME : quand implémenté dans E2, remplacer le statue dans E3 par E2
												// Si plusieurs résultats, on laisse l'opportunité de préciser avec la reconnaissaice vocale
												if(commandBeingBuilt.getListNamesOfSelectedShapes().size() > 1) {
													//currentState = States.E2;
													currentState = States.E3;
													ivy.unBindMsg(IvyRecognizedMessages.REGEX_TESTER_POINT);
												}
												else {
													currentState = States.E3;
													ivy.unBindMsg(IvyRecognizedMessages.REGEX_TESTER_POINT);
												}
											}
										});
										// commandTesterPoint.execute();
										ivy.sendMsg(commandTesterPoint.getCommand());					
										
									} catch (IvyException e) {
										e.printStackTrace();
									}
									break;
								case Deplacer:
									try {
										// Enregistre la position du clic OU Enregistre la liste des objets sous le curseur
										
										System.out.println("--- Déplacement");
										ivy.unBindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED);
										String[] argsOfMouseClicked = args;
										ivy.bindMsgOnce(IvyRecognizedMessages.REGEX_SRA5_ICI, new IvyMessageListener() {
											
											@Override
											public void receive(IvyClient client, String[] args) {
												System.out.println("------ REGEX_SRA5_ICI");
												ivy.unBindMsg(IvyRecognizedMessages.REGEX_SRA5_ICI);
												commandBeingBuilt.setTargetPosX(Integer.parseInt(argsOfMouseClicked[0]));
												commandBeingBuilt.setTargetPosY(Integer.parseInt(argsOfMouseClicked[1]));
												

												// Si aucun n'objet n'est sélectionné, alors on reste dans E1
												if(commandBeingBuilt.getListNamesOfSelectedShapes().isEmpty()) {
													currentState = States.E1;
												}
												else {
													currentState = States.E3;
												}
											}
										});
										
										// Si reco vocale forme, alors l'utilisateur indique qu'il sélectionne l'objet										
										ivy.bindMsgOnce(IvyRecognizedMessages.REGEX_SRA5_CET_OBJET, new IvyMessageListener() {
											
											@Override
											public void receive(IvyClient client, String[] args) {
												System.out.println("------ REGEX_SRA5_CET_OBJET");
												ivy.unBindMsg(IvyRecognizedMessages.REGEX_SRA5_CET_OBJET);
												CommandTesterPoint commandTesterPoint = new CommandTesterPoint(ivy);
												commandTesterPoint.setAllParameters(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
												
												try {
													ivy.bindMsg(IvyRecognizedMessages.REGEX_TESTER_POINT, new IvyMessageListener() {
														
														@Override
														public void receive(IvyClient client, String[] args) {
															commandBeingBuilt.getListNamesOfSelectedShapes().add(args[2]);
															
															// Si la destination n'a pas encore été renseignée OU la liste est vide (= l'utilisateur n'a pas cliqué sur un objet), alors on reste dans E1
															if(commandBeingBuilt.getTargetPosX() == null || commandBeingBuilt.getTargetPosY() == null || commandBeingBuilt.getListNamesOfSelectedShapes().isEmpty()) {
																currentState = States.E1;
																ivy.unBindMsg(IvyRecognizedMessages.REGEX_TESTER_POINT);
															}
															else {
																currentState = States.E3;
																ivy.unBindMsg(IvyRecognizedMessages.REGEX_TESTER_POINT);
															}
														}
													});
													commandTesterPoint.execute();
												} catch (IvyException e) {
													e.printStackTrace();
												}
												
											}
										});
										
										
									} catch (IvyException e) {
										e.printStackTrace();
									}
									break;
							}
							
						
						}
					});

					Thread.sleep(1000);	
					break;
				case E2:
					// TODO : DeleteShape : combiner avec reco vocale en cas de résultats multiples (plusieurs retour à REGEX_TESTER_POINT)
					
					// déclencher timer 2s si aucune informations données
					// TODO
					
				case E3:
					// déclencher timer 2s si aucune informations données
					// TODO
					
					
					// si commande complete
					// executer
					// reset currentCommand
					// go E0
					if(this.commandBeingBuilt.checkAnComplete()) {
						System.out.println("--------------------");
						System.out.println("E3 : execute command");
						System.out.println("--------------------");
						ACommand currentCommandToExecute = CommandBuilder.buildCommand(commandBeingBuilt);
						currentCommandToExecute.execute();
						this.commandBeingBuilt = new CommandToBeCreated(ivy);
						Thread.sleep(1000);
					}
					currentState = States.E0;
					Thread.sleep(1000);	
					break;

				default:
					break;
				}
			}
					
		} catch (IvyException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	private void testDeleteShape() {
		try {
			this.ivy.start("127.255.255.255:2010");
			Thread.sleep(1000);		
			
			for(int i = 0; i < 10; i++) {
				CommandCreateShape commandCreate = new CommandCreateShape(ivy, AvailableShapes.RECTANGLE);
				commandCreate.setAllParametersRandom();
				commandCreate.execute();
			}
			
			
			this.ivy.bindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED, new IvyMessageListener() {
				@Override
				public void receive(IvyClient client, String[] args) {
					String testerPoint = "Palette:TesterPoint x=" + Integer.parseInt(args[0]) + " y=" + Integer.parseInt(args[1]);
					try {
						Thread.sleep(1000);
						ivy.bindMsg(IvyRecognizedMessages.REGEX_TESTER_POINT, new IvyMessageListener() {
							
							@Override
							public void receive(IvyClient client, String[] args) {
								System.out.println("----------------");
								for(String arg : args) {
									System.out.println(arg);
								}
								CommandDeleteShape commandDelete = new CommandDeleteShape(ivy);
								commandDelete.setAllParamters(args[2]);
								try {
									ivy.sendMsg(commandDelete.getCommand());
								} catch (IvyException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
						ivy.sendMsg(testerPoint);
					} catch (IvyException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			
			for(int i = 1; i < 11; i++) {			
				CommandDeleteShape commandDelete = new CommandDeleteShape(ivy);
				commandDelete.setAllParamters("R" + i);
				commandDelete.execute();
				Thread.sleep(1000);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

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
