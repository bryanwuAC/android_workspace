//UIUC CS125 FALL 2014 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2015-02-23T23:28:07-0600.557231791
/**
 * @author dpancha2,ywu101
 *@reviewed yiminge2,ruisong3
 */
public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, score = 0;
		String text = "";
		long startTime =System.currentTimeMillis();
		int level=1;
		int counter=10;
		Zen.setFont("Calibri-38");  //The original font size was too large.
		while (Zen.isRunning()) {

			if (text.length() == 0) {
				x = Zen.getZenHeight()/2;
				y = Zen.getZenHeight()/2;
				dx = 0;
				dy=2+level;      //Increase speed level by level.
				text = "" + (int) (Math.random() * 999+100*level);
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				if (score!=0){
					score += 3000 / elapsed;  // We relate score to the time between each input.
				}
			}
			Zen.setColor(255, 0, 255);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(0, 255, 0);
			Zen.drawText(text, x, y);
			
			Zen.drawText("Level: "+level,10,60);
			Zen.drawText("Score: "+score,10,120);
			Zen.drawText("Press Space to skip current level", 10, 180);
			
			x += dx;
			y += dy;
			Zen.flipBuffer();
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(c == 32){
					level++;                                //Press space to skip one level.
					break;
				}else if(c == text.charAt(0)){
					text = text.substring(1,text.length()); // all except first character
					score+=10;
					counter++;
				}else{
					score-=5;
					counter--;
				}
				if (counter<10)// To make the minimum value of counter equals 10.
					counter=10;
				if (score<0)  // We do not want score to become negative.
					score=0;
			}
			
			Zen.sleep(90);// sleep for 90 milliseconds

		}
	}

}
