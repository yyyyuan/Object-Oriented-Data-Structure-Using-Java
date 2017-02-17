package ch06;

import ch06.lists.*;

public class UseLists
{
   public static void main(String[] args)
   {
      ListInterface<String> list1 = new ArrayUnsortedList<String>(3);
      list1.add("Wirth");
      list1.add("Dykstra");
      list1.add("DePasquale");
      list1.add("Dahl");
      list1.add("Nygaard");
      list1.remove("DePasquale");

      ListInterface<String> list2 = new ArraySortedList<String>(3);
      list2.add("Wirth");
      list2.add("Dykstra");
      list2.add("DePasquale");
      list2.add("Dahl");
      list2.add("Nygaard");
      list2.remove("DePasquale");

      IndexedListInterface<String> list3 = new ArrayIndexedList<String>(3);
      list3.add(0, "Wirth");
      list3.add(0, "Dykstra");
      list3.add(0, "DePasquale");
      list3.add(3, "Dahl");
      list3.add(2, "Nygaard");
      list3.remove("DePasquale");

      System.out.print("Unsorted ");
      System.out.println(list1);
      System.out.print("Sorted ");
      System.out.println(list2);
      System.out.print("Indexed ");
      System.out.println(list3);
   }
}