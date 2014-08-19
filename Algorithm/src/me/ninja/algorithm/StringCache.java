
public class StringCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(new Integer(1) == new Integer(1))
			System.out.println("new Integer(100) == new Integer(100)");
		else 
			System.out.println("new Integer(100) != new Integer(100)");
		if(new Integer(999) == new Integer(999))
			System.out.println("new Integer(999) == new Integer(999)");
		else
			System.out.println("new Integer(999) != new Integer(999)");
		
		if(Integer.valueOf(1) == Integer.valueOf(1))
			System.out.println("Integer.valueOf(1) == Integer.valueOf(1)");
		else 
			System.out.println("Integer.valueOf(1) != Integer.valueOf(1)");
		if(Integer.valueOf(999) == Integer.valueOf(999))
			System.out.println("Integer.valueOf(999) == Integer.valueOf(999)");
		else
			System.out.println("Integer.valueOf(999) == Integer.valueOf(999)");
	}

}
