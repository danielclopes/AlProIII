package Trabalho1c;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int indexOf(int[] v, int i, int c) {
		int p = pesquisaDireta(v, c);
		int pi = p + i - 1;
		if (pi >= v.length)
			return -1;
		if (v[pi] == c)
			return pi;
		return -1;
	}

	private static int pesquisaDireta(int[] v, int c) {
		// TODO Auto-generated method stub
		return 0;
	}
}
