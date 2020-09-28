package useful;
import collection.*;
import java.security.*;
import java.util.*;

public class Useful {
	
	private static SecureRandom secure;
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public static final int ELEVEN = 11;
	public static final int FOURTEEN = 14;
	public static final int FIVETEEN = 15;
	public static final int TWENTYFOUR = 24;
	public static final int TWENTYFIVE = 25;	
	public static final String SEPARATOR = ";";
	public static final String PATH = "src/data/allDraws.csv"; //ruta a archivos
	
	public Useful() {}
//-----------------------------------------------------------------------
	public static void viewCandidateInRows(int array[]) {
		
		System.out.println(".........................................OK");
		System.out.println("> RESULTADO:");
		for(int i=ONE;i<=TWENTYFIVE;i++) {
			if(existNumberInArray(i,array) == true) {
				System.out.print(formatStringWithBrackets(convertIntToString(i)));
			}else {
				System.out.print(formatStringWithBrackets(convertIntToString(ZERO)));
			}
			if(i % FIVE == ZERO) {
				System.out.println();
			}
		}
	}
//-----------------------------------------------------------------------
	public static boolean areEqualArrays(int arrayA[],int arrayB[]) {
		for(int i=ZERO;i<arrayA.length;i++) {
			if(arrayA[i] != arrayB[i]) {
				return false;
			}
		}
		return true;
	}
//-----------------------------------------------------------------------
	public static void initializateArray(int array[]) {
		for(int i=ZERO;i<array.length;i++) {
			array[i] = ZERO;
		}
	}
//-----------------------------------------------------------------------	
	public static int getRandom() {
		secure = new SecureRandom();
		int randomNumber = ONE + secure.nextInt(25);
		return randomNumber;
	}
//-----------------------------------------------------------------------
	public static int countPrime(int array[]) {
		int count = ZERO;
		for(int i=ZERO;i<array.length;i++) {
			if(isPrime(array[i]) == true) {
				count++;
			}
		}		
		return count;				
	}
	
	public static boolean isPrime(int number) {
		int count = ZERO;
		if(number > ONE) {
			for(int i=ONE;i<=number;i++) {
				if(number % i == ZERO) {
					count++;
				}
			}
		}
		if(count == TWO) {
			return true;
		}
		return false;
	}
//-----------------------------------------------------------------------
	public static int countPair(int array[]) {
		int count = ZERO;
		for(int i=ZERO;i<array.length;i++) {
			if(array[i] % TWO == ZERO) {
				count++;
			}
		}		
		return count;				
	}
//-----------------------------------------------------------------------
	public static int sumDraw(int array[]) {
		int sum = ZERO;
		for(int i=ZERO;i<array.length;i++) {
			sum = sum + array[i];
		}		
		return sum;				
	}
//-----------------------------------------------------------------------
	public static int countSeparated(int array[]) {
			int diference = ZERO;
			int maxDiference = ZERO;
			for(int i=ZERO;i<array.length-ONE;i++) {
				diference = array[i+ONE] - array[i];
				if(diference > maxDiference) {
					maxDiference = diference;
				}
			}
			return maxDiference;				
		}
//-----------------------------------------------------------------------
	public static int countConsecutives(int array[]) {
		int count = ZERO;
		for(int i=ZERO;i<array.length-ONE;i++) {
			if(array[i+ONE] == array[i]+ONE) {
				count++;
			}else {
				count = ZERO;
			}
		}
		return count;				
	}
//-----------------------------------------------------------------------
	public static int comparePrevius(int previusArray[],int nextArray[]) {
		int count = ZERO;
		for(int i=ZERO;i<previusArray.length;i++) {
			if(existNumberInArray(previusArray[i],nextArray) == true) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean existNumberInArray(int number,int array[]) {
		for(int i=ZERO;i<array.length;i++) {
			if(array[i] == number) {
				return true;
			}
		}
		return false;
	}
//-----------------------------------------------------------------------	
	public static int countDigit(int array[]) {
		int count = ZERO;
		for(int i=ZERO;i<array.length;i++) {
			if(array[i] < TEN) {
				count++;
			}
		}
		return count;
	}
//-----------------------------------------------------------------------
	public static int countTermination(int array[],int number) {
		int count;
		int countRepeat = ZERO;;
		for(int i=ZERO;i<TEN;i++) {
			count = ZERO;
			for(int j=ZERO;j<array.length;j++) {
				if(lastDigit(i) == lastDigit(array[j])) {
					count++;
				}
			}
			if(count >= number) {
				countRepeat++;
			}
		}
		return countRepeat;
	}
	
	public static int lastDigit(int number) {
		if(number > NINE) {
			return number % TEN;
		}
		return number;
	}
//-----------------------------------------------------------------------
	public static int countArray(int array[]) {
		int sum = ZERO;
		for(int i=ZERO;i<array.length;i++) {
			sum = sum + array[i];
		}
		return sum;
	}
//-----------------------------------------------------------------------
	public static int getNumberMoreRepeated(int array[]) {
		int count;
		int maxNumber = ZERO;
		int maxCount = ZERO;
		for(int i=ZERO;i<array.length;i++) {
			count = ZERO;
			for(int j=ZERO;j<array.length;j++) {
				if(array[i] == array[j]) {
					count++;
				}				
			}
			if(count > maxNumber) {
				maxNumber = count;
				maxCount = array[i];
			}
		}		
		return maxCount;
	}
//-----------------------------------------------------------------------	
	public static int getCountEnvolve(int array[]) {
		int count = ONE;
		for(int i=ONE;i<array.length;i++) {
			if(!existInLeft(array[i],array,i)) {
				count++;
			}
		}
		return count;		
	}	
	
	public static boolean existInLeft(int number,int array[],int index) {
		for(int i=ZERO;i<index;i++) {
			if(number == array[i]) {
				return true;
			}
		}		
		return false;
	}	
//-----------------------------------------------------------------------	
	public static int getMaxNumberfromArray(int array[]) {	
		sortArray(array);
		return array[array.length-ONE];
	}
	
	public static int getMinNumberfromArray(int array[]) {	
		sortArray(array);
		return array[ZERO];
	}
//-----------------------------------------------------------------------	
	public static int convertStringToInt(String field) {
		int number;
		number = Integer.parseInt(field);
		return number;
	}	
	
	public static String convertIntToString(int number) {
		String stringNumber = String.valueOf(number);	
		return stringNumber;
	}
	
	public static String formatStringWithBrackets(String stringNumber) {
		if(convertStringToInt(stringNumber) >= ZERO && convertStringToInt(stringNumber) < TEN) {
			String format = "%02d";
			String stringWithBrackets = String.format(format, convertStringToInt(stringNumber));
			stringWithBrackets = "["+stringWithBrackets+"]";
			return stringWithBrackets;	
		}
		stringNumber = "["+stringNumber+"]";
		return stringNumber;
	}
//-----------------------------------------------------------------------	
	public static void viewArray(int array[]) {
		for(int i=ZERO;i<array.length;i++) {
			System.out.print(formatStringWithBrackets(convertIntToString(array[i])));
		}	
		System.out.println();
	}
	
	public static void viewDrawList(ArrayList<Draw> list) {
		for(int i=ZERO;i<list.size();i++) {
			viewArray(list.get(i).getDrawArray());
		}
	}
//-----------------------------------------------------------------------	
	public static void sortArray(int intArray[]) {
		int swap;
		for(int i=ZERO;i<intArray.length;i++) {
			for(int j=ONE;j<intArray.length;j++) {
				if(intArray[j-ONE] > intArray[j]) {
					swap = intArray[j-ONE];
					intArray[j-ONE] = intArray[j];
					intArray[j] = swap;
				}
			}
		}
	}
//-----------------------------------------------------------------------
}//end class