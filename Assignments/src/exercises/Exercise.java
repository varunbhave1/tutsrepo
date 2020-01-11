package exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

interface LamdaDemo{
	
	public void demo();
	
}

class Data{
	
	private String stringVal;


	public Data(String val) {
		this.stringVal=val;
	}
	
	public String getStringVal() {
		return stringVal;
	}

	@Override
	public String toString() {
		return "Data [stringVal=" + stringVal + "]";
	}


}

public class Exercise {
	

	
public static void main(String[] args) {

	
		Exercise.LambdaSingleStatementExample();
		Exercise.lambdaMultiStatementExample();

		List<Data> list = new ArrayList<Data>();
		list.add(new Data("pullup"));
		list.add(new Data("pushup"));
		list.add(new Data("headstand"));
		list.add(new Data("hanstand"));
		list.add(new Data("planche"));
		list.add(new Data("muscleup"));
		
		Exercise.listSortingUsingLambda(list);
		Exercise.listIterUsingLambda(list);
		Exercise.predicateUsingLamda();
	

		
		/*Collections.sort(list,new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				// TODO Auto-generated method stub
				return o1.getStringVal().compareTo(o2.getStringVal());
			}

		});
		
		
		for(Data d : list) {
			System.out.println(d.getStringVal());
		}
		
		Collections.sort(list,(Data o1, Data o2)->o1.getStringVal().compareTo(o2.getStringVal()));
		
		for(Data d : list) {
			System.out.println(d.getStringVal());
		}*/
		
	
		
		
	}
	
	public static void LambdaSingleStatementExample() {
		
		System.out.println("Lamda Single Statement : ");
		LamdaDemo ld = ()->System.out.println("Lamda Statement 1");
		ld.demo();
	
	}
	
	public static void lambdaMultiStatementExample() {
		System.out.println("\nLamda Multiple Statment : ");
		LamdaDemo md = ()->{
			System.out.println("Lamda Statement 1");
			System.out.println("Lamda Statment 2");
		};
		md.demo();
	}
	
	public static void listSortingUsingLambda(List<Data> list) {
		
		Collections.sort(list,(Data o1, Data o2) -> {
			
			
			if(o1.getStringVal().length() < o2.getStringVal().length()) {
				return -1;
			}else if(o1.getStringVal().length() == o2.getStringVal().length()) {
				return 0;
			}else {
				return 1;
			}
			
		});
		
		for(Data d : list) {
			System.out.println(d.getStringVal());
		}
	}
	
	public static void listIterUsingLambda(List<Data> list) {
		
		/*enhanced foreach*/
		System.out.println("\nadvanced for each : ");
		list.forEach(temp->{
			System.out.println(temp.getStringVal());
		});
	}
	
	public static double calcAPlusBSquareDoubleRes(int a,float b) {
	
		double res = a*a + 2*a*b + b*b;
		
		return res;
	}
	
	public static int calcAPlusBSquareIntRes(int a,float b) {
		
		int res = (int)(a*a + 2*(a*b) + b*b);
		
		return res;
	}

	public static void predicateUsingLamda() {
		
		
		/*
		 * 
		 * 
		 * 
		
		IntPredicate lessThanEighteen = new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				if(value<18) {return true;}
				else {return false;
			}
		};
		
		 * 
		 * */
		
		//using lamda to shorten the above commented code.
		
		IntPredicate lessThan18 = i->i<18;
		IntPredicate moreThan10 = i->i>10;
		
		System.out.println(lessThan18.and(moreThan10).test(12));
		System.out.println(lessThan18.or(moreThan10).test(19));
		
	}
	
}
