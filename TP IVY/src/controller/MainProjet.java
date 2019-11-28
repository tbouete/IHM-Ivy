package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import command.CommandCreateShape;
import fr.dgac.ivy.Ivy;
import fr.dgac.ivy.IvyApplicationListener;
import fr.dgac.ivy.IvyClient;
import fr.dgac.ivy.IvyException;
import fr.dgac.ivy.IvyMessageListener;
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
			
			this.drawRedRectangleOnRedSRA5();
			
		} catch (IvyException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private void drawRedRectangleOnRedSRA5() throws IvyException {
		this.ivy.bindMsg(IvyRecognizedMessages.REGEX_SRA5_ROUGE, new IvyMessageListener() {
			
			@Override
			public void receive(IvyClient client, String[] args) {
				CommandCreateShape command = new CommandCreateShape(ivy, AvailableShapes.RECTANGLE);
				command.setAllParametersRandom();
				command.execute();					
			}
		});
	}
	
	private void drawRandomEllipseOnMouseClicked() throws IvyException {
		this.ivy.bindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED, new IvyMessageListener() {
			
			@Override
			public void receive(IvyClient client, String[] args) {
				CommandCreateShape command = new CommandCreateShape(ivy, AvailableShapes.ELLIPSE);
				command.setAllParametersRandom();
				command.execute();					
			}
		});
	}
	
	private void drawRandomRectangleOnMouseClicked() throws IvyException {
		this.ivy.bindMsg(IvyRecognizedMessages.REGEX_MOUSE_CLICKED, new IvyMessageListener() {
			
			@Override
			public void receive(IvyClient client, String[] args) {
				CommandCreateShape command = new CommandCreateShape(ivy, AvailableShapes.RECTANGLE);
				command.setAllParametersRandom();
				command.execute();					
			}
		});
	}
}
