
public class Driver {
	public static void main(String[] args) {
		BetterArray ba = new BetterArray();
		
		for ( int i = 0 ; i < 10 ; i++ ) {
			ba.add(i*3);
		}
		
		System.out.println(ba);
		
		
		for ( int i = 0 ; i < 91 ; i++ ) {
			ba.add(i*3);
		}
		
		System.out.println(ba);
		
		ba.replace(22, 4);
		
		System.out.println(ba);
		
		ba.remove(10);
		
		System.out.println(ba);
		
		ba.add(16, 6);
		
		System.out.println(ba);
		
		ba.removeAll();
		
		System.out.println(ba);
	}

}


