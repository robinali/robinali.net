package callback;
interface CallBack {
	public void methodToCallBack();
}
class CallMe implements CallBack
{
	private EventNotifier en;
	public CallMe() {
		en = new EventNotifier (this);
	}
	public void methodToCallBack() {
		System.out.println("Wow! Something fun here, enjoy!");
	}
}
class EventNotifier {
	private CallBack callback;
	private boolean somethingHappened;
	public EventNotifier(CallBack callback) {
		this.callback = callback;
		somethingHappened = false;
	}
	
	public void setEvent(boolean somethingHappened) {
		this.somethingHappened = somethingHappened;
	}

	public void doWork() {
		if(somethingHappened) {
			callback.methodToCallBack();
		}
	}
}
public class Test{
	public static void main(String[] args) {
		CallBack callback = new CallMe();
		EventNotifier en = new EventNotifier(callback);
		en.doWork();
		en.setEvent(true);
		en.doWork();
		en.setEvent(false);
		en.doWork();
		en.setEvent(true);
		en.doWork();
	}
}

