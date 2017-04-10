package Ordenacao;

import java.util.Random;

public class Main {
	private static int v[];
	private static int MAX = 1000;
	private static int z;

	public static void main(String[] args) {
		v = new int[MAX];
		Random rnd = new Random();
		for (int i = 0; i < MAX; i++) {
			v[i] = rnd.nextInt(MAX);
		}
		z = 0;
		bubbleSort(v);
		System.out.println("Total de execucoes BubbleSort 1: " + z);
		z = 0;
		bubbleSort2(v);
		System.out.println("Total de execucoes BubbleSort 2: " + z);
		z = 0;
		insertionSort(v);
		System.out.println("Total de execucoes InsertionSort: " + z);
		z = 0;
		quickSort(v);
		System.out.println("Total de execucoes QuickSort: " + z);
		z = 0;
		mergeSort(v);
		System.out.println("Total de execucoes MergeSort: " + z);
	}

	public static void mergeSort(int v[]) {
		mergesort(v, 0, v.length - 1);
	}

	public static void mergesort(int[] v, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergesort(v, inicio, meio);
			mergesort(v, meio + 1, fim);
			merge(v, inicio, meio, fim);
		}
	}

	private static void merge(int[] v, int inicio, int meio, int fim) {
		int nL = meio - inicio + 1;
		int nR = fim - meio;
		int[] L = new int[nL];
		int[] R = new int[nR];
		System.arraycopy(v, inicio, L, 0, nL);
		System.arraycopy(v, meio + 1, R, 0, nR);
		int iL = 0;
		int iR = 0;
		for (int k = inicio; k <= fim; k++) {
			z++;
			if (iR < nR) {
				if (iL < nL) {
					if (L[iL] < R[iR])
						v[k] = L[iL++];
					else
						v[k] = R[iR++];
				} else
					v[k] = R[iR++];
			} else
				v[k] = L[iL++];
		}
	}

	public static void insertionSort(int v[]) {
		int i, j, chave;
		for (j = 1; j < v.length; j++) {
			chave = v[j];
			i = j - 1;
			z++;
			while ((i >= 0) && (v[i] > chave)) {
				v[i + 1] = v[i];
				i = i - 1;
			}
			v[i + 1] = chave;
		}
	}

	public static void bubbleSort(int v[]) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length - 1; j++) {
				z++;
				if (v[j] > v[j + 1])
					troca(v, j, j + 1);
			}
		}
	}

	public static void bubbleSort2(int v[]) {
		boolean trocou = true;
		while (trocou) {
			trocou = false;
			for (int i = 0; i < v.length - 1; i++) {
				z++;
				if (v[i] > v[i + 1]) {
					troca(v, i, i + 1);
					trocou = true;
				}
			}
		}
	}

	public static void troca(int v[], int j, int j1) {
		int tmp = v[j];
		v[j] = v[j1];
		v[j1] = tmp;
	}

	public static void quickSort(int v[]) {
		quicksort(v, 0, v.length - 1);
	}

	public static void quicksort(int[] v, int low, int high) {
		int pivot;
		if ((high - low) > 0) {
			pivot = partition(v, low, high);
			quicksort(v, low, pivot - 1);
			quicksort(v, pivot + 1, high);
		}
	}

	public static int partition(int[] v, int low, int high) {
		int i, p, firsthigh;
		firsthigh = low;
		p = high;
		for (i = low; i < high; i++)
			z++;
		if (v[i] < v[p]) {
			troca(v, i, firsthigh);
			firsthigh = firsthigh + 1;
		}
		troca(v, p, firsthigh);
		return firsthigh;
	}
}
