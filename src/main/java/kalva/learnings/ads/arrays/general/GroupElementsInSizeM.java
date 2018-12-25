package kalva.learnings.ads.arrays.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * http://www.careercup.com/question?id=6026101998485504
 * This answer two questions.
 * Group elements in size m such that in every group only unique elements are possible.
 * It also answers question where rearrange array such that same elements are exactly m
 * distance from each other
 */
public class GroupElementsInSizeM {

  public static void main(String[] args) {
    printGroup(new Integer[]{1, 1, 1, 1, 2, 2}, 2);
    printGroup(new Integer[]{2, 1, 1, 1, 3, 4, 4, 4, 5}, 2);
  }

  private static void printGroup(Integer[] array, int grouped) {
    List<Integer> output = new ArrayList<>();
    List<Integer> duplicate = new ArrayList<>();

    groupData(array, output, duplicate, grouped);
    while (duplicate.size() > 0) {
      array = duplicate.toArray(new Integer[duplicate.size()]);
      duplicate.clear();
      groupData(array, output, duplicate, grouped);
    }
    System.out.println(output);
  }

  private static void groupData(Integer[] array, List<Integer> output, List<Integer> duplicate, int grouped) {

    int prevElement = array[0];
    int occurance = 1;
    output.add(array[0]);
    for (int i = 1; i < array.length; i++) {
      if (prevElement == array[i]) {
        occurance++;
      } else {
        occurance = 1;
      }
      Integer removed = getAndRemoveDifferent(duplicate, array[i]);
      if (grouped >= occurance) {
        if (null != removed && prevElement != removed) {
          occurance = 1;
          output.add(removed);
          i--;
        } else {
          output.add(array[i]);
          if (null != removed) {
            duplicate.add(removed);
          }
        }
      } else {
        occurance--;
        duplicate.add(array[i]);
        if (null != removed) {
          output.add(removed);
        }
      }
      prevElement = array[i];
    }
  }

  private static Integer getAndRemoveDifferent(List<Integer> data, int key) {
    Iterator<Integer> iterator = data.iterator();
    while (iterator.hasNext()) {
      Integer next = iterator.next();
      if (key != next) {
        iterator.remove();
        return next;
      }
    }
    return null;
  }
}
