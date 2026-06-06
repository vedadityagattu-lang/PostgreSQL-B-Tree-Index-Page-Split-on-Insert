import java.util.Arrays;

public class BTreePageSplit {

    static final int MAX_KEYS = 127;

    public static void main(String[] args) {

        int[] leafPage = new int[MAX_KEYS];

        // Fill leaf page with 127 keys
        for (int i = 0; i < MAX_KEYS; i++) {
            leafPage[i] = i + 1;
        }

        int newKey = 128;

        // Create temporary array for 128 keys
        int[] temp = new int[MAX_KEYS + 1];

        for (int i = 0; i < MAX_KEYS; i++) {
            temp[i] = leafPage[i];
        }

        temp[MAX_KEYS] = newKey;

        Arrays.sort(temp);

        int mid = temp.length / 2;

        int[] leftPage = Arrays.copyOfRange(temp, 0, mid);
        int[] rightPage = Arrays.copyOfRange(temp, mid, temp.length);

        int separatorKey = rightPage[0];

        System.out.println("=== PAGE SPLIT OCCURRED ===");

        System.out.println("Left Page Keys: " + leftPage.length);
        System.out.println("Right Page Keys: " + rightPage.length);

        System.out.println("Separator Key Moved To Parent: "
                + separatorKey);

        System.out.println("\nEstimated Disk I/O:");
        System.out.println("Read Full Leaf Page = 1 I/O");
        System.out.println("Write Old Page      = 1 I/O");
        System.out.println("Write New Page      = 1 I/O");

        System.out.println("Total = 3 Page I/Os");
    }
}
