package app;

import javax.swing.SwingWorker;

public class Dispatcher {
	private Command command;

	public Dispatcher() {

	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void execute() {
		try {
			new SwingWorker <Void, Void>() {
				@Override
				public Void doInBackground() {
					command.execute();
					return null;
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
