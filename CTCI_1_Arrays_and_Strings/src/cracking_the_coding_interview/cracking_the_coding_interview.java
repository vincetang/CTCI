package cracking_the_coding_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cracking_the_coding_interview {

	//1.1 - checks to see if all characters in a string are unique
	public boolean recurseUniqueChars(String s) {
		if (s.length() == 0)
			return true;
		else {
			char ch = s.charAt(0);
			String rest = s.substring(1);
			return (rest.indexOf(ch) == -1) && recurseUniqueChars(rest);
		}
	}
	
	//1.3 - Given 2 strings, return true if they are permutations of each other
	public boolean isPermutation(String s1, String s2) {
		String[] sa1 = s1.split("");
		String[] sa2 = s2.split("");
		Arrays.sort(sa1);
		Arrays.sort(sa2);
		
		if (Arrays.equals(sa1, sa2))
			return true;
		return false;
	}
	
	// 1.4 Implement a method to replace all spaces in a string with '%20'
	// you may assume that the string has sufficient space to hold additional characters
	// and you are given the true length of the string. In Java, use char array to do
	// this in-place.
	public void replaceSpacesSolutions(char[] str, int length) {
		int spaceCount = 0, newLength, i;
		
		// First pass: count spaces
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i=length-1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}	
	}
	
	
	// 1.5 Implement a method to perform basic string compression using the counts
	// of repeated characters. For example, the string aabcccccaaa would become
	// a2b1c5a3. If the compressed string would not become smaller than the original
	// string, your method should return the original string. You can assume the string
	// has only upper/lower case letters (a-z).
	public String compressString(String s) {
		String new_str = "";
		int char_count = 1;
		char cur_char = s.charAt(0);
		
		for (int i = 1; i < s.length(); i++) {
			if (cur_char == s.charAt(i)) { // same character
				char_count = char_count + 1;
			} else { // Character has changed
				new_str = new_str + cur_char + Integer.toString(char_count);
				char_count = 1;
				cur_char = s.charAt(i);
			}
		}
		// append the last letter and count
		new_str = new_str + cur_char + Integer.toString(char_count);
		
		// check if the original string is compressed
		if (s.length() > new_str.length())
			return new_str;
		return s;
	}
	
	// 1.6 Given an image represented by an NxN matrix, where each pixel in the
	// image is 4 bytes, write a method to rotate the image by 90 degrees. Can
	// you do this in place?
	public void rotateMatrix (int matrix[][]) {
		int num_rows = matrix.length;
		int num_cols = matrix[0].length;
		int temp;
		int new_j;
		
		for (int i=0; i < num_rows; i++) {
			for (int j = 0; j<num_cols; j++) {
				temp = matrix[i][j];
				
				new_j = i + 1;
				if (new_j >= num_cols)
					new_j = 0;
				
				matrix[i][j] = matrix[j][new_j];
				matrix[j][new_j] = temp;
			}
		}
	}
	
	// 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its
	// entire row and column are set to 0
	public void zeroOutMatrix(int matrix[][]) {
		List<Integer> cols_with_zero = new ArrayList<Integer>();
		List<Integer> rows_with_zero = new ArrayList<Integer>();
		
		int num_rows = matrix.length;
		int num_cols = matrix[0].length;
		
		// build lists of indices for elements equal to 0
		for (int i = 0; i < num_rows; i++) {
			for (int j=0; j < num_cols; j++) {
				if (matrix[i][j] == 0) {
					cols_with_zero.add(j);
					rows_with_zero.add(i);
				}
			}
		}
		
		// zero out rows
		for (int s=0; s < rows_with_zero.size(); s++) {
			int row[] = matrix[rows_with_zero.get(s)];
			for (int n: row) {
				n = 0;
			}
		}
		
		// zero out columns
		// iterate through each row and zero-out the element at columns
		// indexed in cols_with_zero
		for (int i=0; i<matrix.length; i++) { // rows
			int row[] = matrix[i];
			for (int c : cols_with_zero) { // index of columns with 0
				row[c] = 0;
			}
		}
	}
	
	// 1.8 Assume you have a method isSubstring which checks if one word is a substring
	// of another. Given two strings, s1 and s2, write code to check if s2 is a rotation
	// of s1 using only one call to isSubstring (e.g. "waterbottle" is a rotation of
	// "erbottlewat")
	public boolean isRotation(String s1, String s2) {
		char[] s1_array = s1.toCharArray();
		char[] s2_array = s2.toCharArray();
		
		Arrays.sort(s1_array);
		Arrays.sort(s2_array);
		
		return Arrays.toString(s1_array).contains(Arrays.toString(s2_array));
	}
	
	public static void main(String[] args) {
		/* 1.1
		String s = "Hello";
		boolean b;
		b = new cracking_the_coding_interview().recurseUniqueChars(s);
		System.out.print(Boolean.toString(b));
		*/
		
		/* 1.3
		String s1 = "Hello";
		String s2 = "eHoll";
		boolean b = new cracking_the_coding_interview().isPermutation(s1, s2);
		System.out.println(Boolean.toString(b));
		*/
		
		/* 1.4 
		char[] str = "Mr John Smith         ".toCharArray();
		int length = 13;
		//new cracking_the_coding_interview().replaceSpacesSolutions(str, length);
		//System.out.println(str);
		 */
		
		/* 1.5
		String s = "aabcccccaaa";
		String compressed = new cracking_the_coding_interview().compressString(s);
		System.out.println("Compressed resut: " + compressed + "\n");
		*/
		
		/* 1.6 
		int matrix[][] = { {1, 2}, {3, 4}};
		System.out.println("original matrix: " + Arrays.deepToString(matrix));
		new cracking_the_coding_interview().rotateMatrix(matrix);
		System.out.println("rotated matrix: " + Arrays.deepToString(matrix));
		*/
		
		/* 1.7
		int matrix[][] = { {1, 0}, {2,3} };
		System.out.println("original matrix: " + Arrays.deepToString(matrix));
		new cracking_the_coding_interview().zeroOutMatrix(matrix);
		System.out.println("rotated matrix: " + Arrays.deepToString(matrix));
		*/
		
		/* 1.8 */
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		boolean result = new cracking_the_coding_interview().isRotation(s1, s2);
		System.out.println("Is " + s1 + " a rotation of " + s2 + "? " + result );
	}
}

