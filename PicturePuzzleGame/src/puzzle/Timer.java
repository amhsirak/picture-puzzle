/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;


import javax.swing.JTextField;

/**
 *
 * @author Karishma Dell
 */
public class Timer extends Thread{
    boolean  pause;
    boolean  exit;
    JTextField tf;
    int min=0,sec=0;
    public Timer(JTextField tf){
        this.tf=tf;
    }
    
    @Override
    public void run(){
        min=0;sec=0;
        while (!exit) {
          if(!pause){
              timeLoop();
          }else{
              
          }
        }
    }

    public void timeLoop(){
                    try {
                tf.setText("" + min + ":" + sec);
                if (sec == 59) {
                    min += 1;
                    sec = 0;
                }
                Thread.sleep(1000);
                sec++;

            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
    }
   public synchronized void resumeT(){
       pause=false;
   } 
   public synchronized void pauseT(){
       pause=true;
   }
   public synchronized void stopT(){
       exit=true;
   }
}
