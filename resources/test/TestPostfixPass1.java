
public class TestPostfixPass1 {
	public static void main(String[] args) {
		int y = 1;
		int z = 2;
		
		int x = y;
		int z = x.y;
	}
}