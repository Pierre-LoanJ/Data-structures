package sort;

public class LSDRadixSort {
	/*
	 a = [ abc, def, ghi ]
	   <->
	   
	    [ a b c 
	      d e f
	      g h i ]
	
	so first we analyse cfi, then beh and finally adg as LSD goes along.
	 */
	
	
	
	
	public static void sort(String[] a, int w) {
		int R = 256;
		int N = a.length;
		String[] aux = new String[N];
		
		for (int j = w - 1; j >= 0; j--) {		 				// for each vertical array
			int[] freq = new int[R + 1];
			
			for (int i = 0; i < N; i++) { 				// count frequencies of each character at index w (e.g. starts at string's last character onto all words)
				freq[a[i].charAt(j) + 1]++;
			}
			for (int i = 0; i < R; i++) { 			// get the cumulates of frequencies so we get the character's offset starting indices in a global array 
				freq[i + 1] += freq[i];
			}
			for (int i = 0; i < N; i++) {				// fills up aux with values of a
				aux[freq[a[i].charAt(j)]++] = a[i];				// the ++ tells where next occurence of a character goes beacuse we started at the character offset
										 // = a[i].charAt(j);
			}
			for (int i = 0; i < N; i++) {				// copy back in original array
				a[i] = aux[i];
				//a[i] = a[i].replace(a[i].charAt(j) + "", String.valueOf(aux[i]));
				//a[i] = a[i].substring(0, j + 1) + String.valueOf(aux[i]) + a[i].substring(j + 1);
			}
		}
		int b = 0;
	}
	public static void main(String[] args) {
		String[] a = new String[10];
		/*
		a[0] = "azert"; 
		a[1] = "lodng";
		a[2] = "pekgh";
		a[3] = "mnfia";
		a[4] = "cjutb";
		a[5] = "wsqkr";
		a[6] = "pklov";
		a[7] = "sdnty";
		a[8] = "kunge";
		a[9] = "hfokx";
		*/
		a[0] = "1869"; 
		a[1] = "2367";
		a[2] = "4419";
		a[3] = "2765";
		a[4] = "4258";
		a[5] = "9513";
		a[6] = "3336";
		a[7] = "1142";
		a[8] = "7458";
		a[9] = "1259";
		sort(a, a[0].length());
		System.out.println("a sorted");
	}
}
