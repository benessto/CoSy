package cognitionModel;

public class Clock {
	private int ticks=0;
	private int maxTime;

	public int getTicks() {
		return ticks;
	}

	public void addTicks() {
		ticks++;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	public boolean timeUp(){
		if (ticks>=maxTime){
			return true;
		}else{
			return false;
		}
	}

}
