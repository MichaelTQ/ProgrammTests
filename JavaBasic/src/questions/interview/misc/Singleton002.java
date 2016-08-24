package questions.interview.misc;

public class Singleton002 {
	private static final Singleton002 instance = new Singleton002();

	private Singleton002() {}
	
	public static Singleton002 getInstance() {
		return instance;
	}
}
