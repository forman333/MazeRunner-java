package A1;
import A1.MazeRunner;
public class timer {

static long timeTaken;
static Thread thread;
	public static void main(String[] args) {
		timeTaken = 0;
        long startTime = System.currentTimeMillis();

        thread = new Thread(new Runnable() {
            public void run() {
            	MazeRunner mazeRunner = new MazeRunner(); //creates instance of class MazeRunner

            	if(mazeRunner.hasPlayerWon()) {
            		
	                long endTime = System.currentTimeMillis();
	                timeTaken = (endTime - startTime)/1000;

            	}
            }
        });

        thread.start();

        try {
            thread.join(90000); // Wait for up to 90 seconds for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (thread.isAlive()) {
            thread.interrupt();
            System.out.println("Time up. You lost!");
            System.exit(0);
        }
        
        
    }
	
	//Method: to stop timer
	public static void stopTimer() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
            
        }
	
}}
	

