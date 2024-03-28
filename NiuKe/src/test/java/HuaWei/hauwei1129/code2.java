package HuaWei.hauwei1129;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();

        List<String> fileList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            fileList.add(line);
        }

        String[] sources = source.substring(1).split("/");
        String tab = "    ";
        int pre = -1; // 记录已经上一个遍历的tab的长度
        List<String> currentPath = new ArrayList<>();
        for (String file : fileList) {
            int cnt = file.split(tab).length - 1; //判断有几个tab，代表第几层
            if (cnt <= pre && !currentPath.isEmpty()) { //应该是处理*的时候
                System.out.println("/" + String.join("/", currentPath)); // 输出找到的文件
                currentPath = currentPath.subList(0, cnt);  //回退到上一级目录
                currentPath.add(file.trim());
            } else {
                //保持不超过最大层
                if (cnt < sources.length && (sources[cnt].equals(file.trim()) || sources[cnt].equals("*"))) {
                    currentPath.add(file.trim());
                }
            }
            pre = cnt;
        }

        //找到了文件
        System.out.println("/" + String.join("/", currentPath));
    }
}
