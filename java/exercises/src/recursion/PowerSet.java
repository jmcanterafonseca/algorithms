package recursion;

import java.util.ArrayList;
import java.util.List;

// Learning: Manage properly the base case
// Learning: Use a proper data structure
// Learning: Use a proper interface for your recursive function
public class PowerSet {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();

        set.add(12); set.add(34); set.add(55);

        List<List<Integer>> result = powerSet(set,0);

        for(List<Integer> sr:result) {
            for(int item:sr) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> powerSet(List<Integer> set, int index) {
        List<List<Integer>> allSubsets = new ArrayList<>();

        if(index == set.size()) {
            // Empty subset
            allSubsets.add(new ArrayList<>());
            return allSubsets;
        }

        int pivot = set.get(index);

        List<List<Integer>> subsets = powerSet(set, index +  1);

        for(List<Integer> subset:subsets) {
            allSubsets.add(subset);

            ArrayList<Integer> newSubset = new ArrayList<>();
            newSubset.addAll(subset);
            newSubset.add(pivot);

            allSubsets.add(newSubset);
        }

        return allSubsets;
    }
}
