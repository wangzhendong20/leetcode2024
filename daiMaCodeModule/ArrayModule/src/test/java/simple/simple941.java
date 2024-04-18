package simple;

public class simple941 {
    public boolean validMountainArray(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i+1]) return false;
            if (arr[i] > arr[i+1]) {
                index = i;
                break;
            }
        }

        if (index == 0) return false;

        for (int i = arr.length - 1; i > index + 1; i--) {
            if (arr[i] >= arr[i-1])  return false;
        }

        return true;
    }
}
