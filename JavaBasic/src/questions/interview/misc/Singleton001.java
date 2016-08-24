package questions.interview.misc;

// Trying out different ways of singleton object

public class Singleton001 {
	private static volatile Singleton001 instance = null;
	private Singleton001() {}
	public static Singleton001 getInstance() {
		if(instance == null) {
			synchronized(Singleton001.class) {
				if(instance == null) {
					instance = new Singleton001();
				}
			}
		}
		return instance;
	}
}
