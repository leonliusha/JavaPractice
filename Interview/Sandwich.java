package Practise;



public class Sandwich extends PortableLunch{
	private Bread b = new Bread();
	private Cheese c = new Cheese();
	private Lettuce l = new Lettuce();
	public Sandwich(){
		System.out.println("Sandwich");
	}
	public static void main(String args[]){
		new Sandwich();
	}
	}
	
	
		
	class Meal{
		Meal(){
			i++;
			System.out.println("Meal"+i);
		}
		public Bread b = new Bread();
		public Cheese c = new Cheese();
		private Lettuce l = new Lettuce();
		private int i=0;
	}
	
	class Bread{
		Bread(){
			System.out.println("Bread");
		}
	}
	
	class Cheese{
		Cheese(){
			System.out.println("Cheese");
		}
	}
	
	class Lettuce{
		Lettuce(){
			System.out.println("Lettuce");
		}
	}
	
	class Lunch extends Meal{
		public Bread b = new Bread();
		public Cheese c = new Cheese();
		private Lettuce l = new Lettuce();
		Lunch(){
			System.out.println("Lunch");
		}
	}
	
	class PortableLunch extends Lunch{
		public Bread b = new Bread();
		public Cheese c = new Cheese();
		private Lettuce l = new Lettuce();
		PortableLunch(){
			System.out.println("PortableLunch");
		}
	}
	

