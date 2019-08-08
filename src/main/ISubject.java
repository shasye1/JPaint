package main;

public interface ISubject {
	void registerObserver(IObserver observer);
	void removeObserver(IObserver observer);
}
