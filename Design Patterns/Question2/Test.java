package Question2;

import java.util.ArrayList;

//public class Test {
	interface Visitable {
		void accept (Visitor v);
	}

	interface Visitor {
	    void visit (Circle b);
	    void visit (Rectangle c);
	    void visit (Square c);
	}

	class AreaVisitor implements Visitor {
		private double total=0;  //total area
		
		 @Override
		    public void visit(Circle b) {
			 	total += (Math.PI)*(Math.pow(b.getRadius(),2));
		    }
		@Override
		public void visit(Rectangle c) {
			total += c.getHeight() * c.getWidth();
			
		}


		@Override
		public void visit(Square c) {
			total += (Math.pow(c.getLengthOfSide(),2));
			
		}
		
		public double getTotal() {
			return total;
		}

	}

	class PerimeterVisitor implements Visitor {
		private double total=0; //total perimeter

		// TODO: (4) insert code for concrete class PerimeterVisitor
		
		public double getTotal() {
			return total;
		}
		
		 @Override
		    public void visit(Circle b) {
			 	total += (Math.PI)*(b.getRadius()*2);
		    }
		@Override
		public void visit(Rectangle c) {
			total += (c.getHeight() + c.getWidth()) * 2;
			
		}


		@Override
		public void visit(Square c) {
			total += c.getLengthOfSide()*4;
			
		}
	}

	// TODO: (5) modify Circle, Rectangle and Square classes to implement Visitable
	class Circle implements Visitable {
		private double radius;
		
		  public void accept(Visitor v) { //connects both parent interfaces; concrete accept
		        v.visit(this);
		    }
		
		Circle(double radius){
			this.radius = radius;
		}

		public double getRadius() {
			return radius;
		}
	}


	class Rectangle implements Visitable {
		private double width;
		private double height;

		Rectangle(double width, double height){
			this.width = width;
			this.height = height;
		}
		  public void accept(Visitor v) { //connects both parent interfaces; concrete accept
		        v.visit(this);
		    }

		public double getWidth() {
			return width;
		}

		public double getHeight() {
			return height;
		}
	}

	class Square implements Visitable {
		private double lengthOfSide;

		Square(double lengthOfSide){
			this.lengthOfSide = lengthOfSide;
		}
		  public void accept(Visitor v) { //connects both parent interfaces; concrete accept
		        v.visit(this);
		    }

		public double getLengthOfSide() {
			return lengthOfSide;
		}
	}
	
	
	public class Test{
		public static void main (String[] args){
			String ans = "";
			ArrayList<Visitable> items = new ArrayList<>();
			AreaVisitor areaVisitor = new AreaVisitor();
			PerimeterVisitor perimeterVisitor = new PerimeterVisitor();
			
			items.add(new Circle(1));
			items.add(new Square(2));
			items.add(new Rectangle(2,4));
			items.add(new Circle(2));
			
			for(Visitable item: items){
				item.accept(areaVisitor);
				item.accept(perimeterVisitor);
			}
			
			ans = ""+Math.ceil(areaVisitor.getTotal());
			System.out.println(ans);
			
			ans = ""+Math.ceil(perimeterVisitor.getTotal());
			System.out.println(ans);
			
		}
	}
//}
