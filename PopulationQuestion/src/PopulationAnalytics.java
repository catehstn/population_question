public class PopulationAnalytics {
	
	public static int getMaxValue(int[] array) {
		if (array.length < 1) {
			return -1;
		}
		
		int val = array[0];
		for (int i : array) {
			if (i > val) {
				val = i;
			}
		}
		
		return val;
	}
	
	public static int getMinValue(int[] array) {
		if (array.length < 1) {
			return -1;
		}
		
		int val = array[0];
		for (int i : array) {
			if (i < val) {
				val = i;
			}
		}
		
		return val;
	}
	
	public static int getMaxIndex(int[] array) {
		if (array.length < 1) {
			return -1;
		}
		
		int val = array[0];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			if (value > val) {
				val = value;
				index = i;
			}
		}
		
		return index;
	}

	public static int[] getAccumulativeValuesInRange(int[] array, int low, int high) {
		// Get numbers for each birth year.
		int[] output = new int[high - low + 1];
		for (int value : array) {
			if (value > high) {
				continue;
			}
			output[value - low]++;
		}
				
		// Produce accumulative histogram.
		int currentCount = 0;
		for (int i = 0; i < output.length; i++) {
			currentCount += output[i];
			output[i] = currentCount;
		}
		return output;
	}
	
	public static void subtractValuesWithOffset(int[] array1, int[] array2, int offset) {
		for (int i = offset; i < array1.length; i++) {
			array1[i] -= array2[i-offset];
		}
	}
	
	public static int getMaxPopulationYear(int[] birthYears, int[] deathYears) {
		if(birthYears.length < 1) {
			return 0;
		}
		
		int minBirthYear = getMinValue(birthYears);
		int maxBirthYear = getMaxValue(birthYears);
		
		// Get numbers for each birth year.
		int[] years = getAccumulativeValuesInRange(birthYears, minBirthYear, maxBirthYear);
		
		// Get death numbers for birth year.
		int[] deathYearsCount = getAccumulativeValuesInRange(deathYears, minBirthYear, maxBirthYear);

		// Subtract histograms.
		subtractValuesWithOffset(years, deathYearsCount, 1);
		return getMaxIndex(years) + minBirthYear;
	}
}
