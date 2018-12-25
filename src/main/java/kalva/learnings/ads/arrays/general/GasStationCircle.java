package kalva.learnings.ads.arrays.general;

public class GasStationCircle {

  static class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
      this.petrol = petrol;
      this.distance = distance;
    }
  }

  static int printTour(PetrolPump arr[], int n) {

    int start = 0;
    do {
      int current = start;
      int pertolLeft = 0;
      do {
        pertolLeft += (arr[current].petrol - arr[current].distance);
        current = (current + 1) % arr.length;
      } while (pertolLeft > 0 && current != start);
      if (pertolLeft >= 0) {
        return start;
      }
      start = (start + 1) % arr.length;
    } while (start != 0);
    return -1;
  }

  public static void main(String[] args) {
    PetrolPump[] arr = {
        new PetrolPump(6, 4),
        new PetrolPump(3, 6),
        new PetrolPump(7, 3)};
    int start = printTour(arr, arr.length);
    System.out.println(start == -1 ? "No Solution" : "Start = " + start);
  }
}
