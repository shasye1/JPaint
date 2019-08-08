package main;

import java.util.ArrayList;
import java.util.List;

public class ShapeList implements ISubject {
	ArrayList<IShapes> shapelist = new ArrayList<IShapes>();
	private List<IObserver> observers = new ArrayList<>();
	
	public void add(IShapes shape) {
		shapelist.add(shape);
		notifyObservers();
	}
	
	public ArrayList<IShapes> getShapeList() {
		return shapelist;
	}
	
	public void remove(IShapes shape) {
		shapelist.remove(shape); 
		notifyObservers();
	}
	
	public boolean contains(IShapes shape) {
		return shapelist.contains(shape);
	}

	public int getsize() {
		return shapelist.size();
	}
	
	public void notifyObservers() {
		for (IObserver observer : observers) {
			observer.update();
		}
	}

	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
	 
	}

}
