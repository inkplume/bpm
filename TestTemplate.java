public class TestTemplate {
	public static int log(int N) {
		if (N == 1)
			return 1;
		return N * log(N-1);
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		StdOut.println(log(N));
	}
}