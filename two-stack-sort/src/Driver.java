public class Driver {

  public static void main(String[] args) {					
    Words words  = new Words("data/knuthWords.dat");

    LeftRightSorter s = new LeftRightSorter();

    s.loadStacks(words.all_words);
    System.out.println("\n\nSorted stacks:\n");
    s.printStacks();
		
    int n = s.left.size() + s.right.size();
    for (int idx = 0; idx < n; idx++) {
      System.out.println("Word " + idx + ": " + s.wordAt(idx));
    }
		
  }
	
}
