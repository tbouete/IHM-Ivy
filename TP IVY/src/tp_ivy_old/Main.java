package tp_ivy_old;

import fr.dgac.ivy.Ivy;
import fr.dgac.ivy.IvyApplicationListener;
import fr.dgac.ivy.IvyClient;
import fr.dgac.ivy.IvyException;
import fr.dgac.ivy.IvyMessageListener;

public class Main {
	
	private Ivy ivy;

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}
	
	private void init() {		
		this.ivy = new Ivy("myApp", "myApp init", new IvyApplicationListener() {
			
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
			//this.ivy.sendMsg(this.getStringCreerRectangleRandom());
			this.ivy.sendMsg("Palette:CreateRectangle x=0 y=0 longueur=50 hauteur=50");
			
			String regex = "^Palette:MouseMoved x=(.*) y=(.*)$";
			this.ivy.bindMsg(regex, new IvyMessageListener() {
				
				@Override
				public void receive(IvyClient client, String[] args) {
					System.out.println("Coordinates : x=" + args[0] + " y=" + args[1]);
					
				}
			});
		} catch (IvyException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void artContemporain() throws IvyException {
		while(true) {
			this.ivy.sendMsg(this.getStringCreerRectangleRandom());
		}
	}
	
	private String getStringCreerRectangleRandom() {
		return "Palette:CreerRectangle "
				+ "x="+ (int)(Math.random()*200) + 
				" y=" + (int)(Math.random()*200) +
				" longueur=" + (int)(Math.random()*200) + 
				" hauteur=" + (int)(Math.random()*200) + 
				" couleurFond=" + (int)(Math.random()*200) + ":" + (int)(Math.random()*200) + ":" + (int)(Math.random()*200) + 
				" couleurContour=" + (int)(Math.random()*200) + ":" + (int)(Math.random()*200) + ":" + (int)(Math.random()*200);
	}

}
