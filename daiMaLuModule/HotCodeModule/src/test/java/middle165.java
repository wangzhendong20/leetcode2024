public class middle165 {
    /**
     * 模拟
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
       String[] v1 = version1.split("\\.");
       String[] v2 = version2.split("\\.");
       int i = 0;
       int j = 0;

       while (i < v1.length && j < v2.length) {
           int num1 = Integer.parseInt(v1[i]);
           int num2 = Integer.parseInt(v2[j]);

           if (num1 > num2) {
               return 1;
           } else if (num1 < num2) {
               return -1;
           }
           i++;
           j++;
       }

       while (i < v1.length) {
           if (Integer.parseInt(v1[i]) != 0) {
               return 1;
           }
           i++;
       }

       while (j < v2.length) {
           if (Integer.parseInt(v2[j]) != 0) {
               return -1;
           }
           j++;
       }

       return 0;
    }

}
