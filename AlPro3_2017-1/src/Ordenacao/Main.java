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
		bubbleSort(v);
		System.out.println("Total de execuções BubbleSort 1: " + z);
		bubbleSort2(v);
		System.out.println("Total de execuções BubbleSort 2: " + z);
		insertionSort(v);
		System.out.println("Total de execuções InsertionSort: " + z);
		z = 0;
		quickSort(v);
		System.out.println("Total de execuções QuickSort: " + z);
	}

	public static void insertionSort(int v[]) {
		z = 0;
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
		z = 0;
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length - 1; j++) {
				z++;
				if (v[j] > v[j + 1])
					troca(v, j, j + 1);
			}
		}
	}

	public static void bubbleSort2(int v[]) {
		z = 0;
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
