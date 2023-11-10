package middle;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HJ74 参数解析
 * @author d3y1
 */
public class HJ74{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution1(in);
            solution2(in);
            solution3(in);
        }
    }


    /**
     * 模拟 按单个字符判断
     * @param in
     */
    private static void solution1(Scanner in){
        String command = in.nextLine().trim();

        StringBuilder sb = new StringBuilder();
        // 是否在双引号里
        boolean inQuotation = false;
        int count = 0;
        for(int i=0; i<command.length(); i++){
            char ch = command.charAt(i);

            if(ch == '"'){
                inQuotation = !inQuotation;
                continue;
            }

            if(ch==' ' && !inQuotation){
                count++;
                sb.append("\n");
                continue;
            }

            sb.append(ch);
        }

        System.out.println(++count);
        System.out.println(sb);
    }


    /**
     * 模拟 先按空格分段 再判断双引号字符'"'
     * @param in
     */
    private static void solution2(Scanner in){
        String command = in.nextLine().trim();

        String[] parts = command.split(" ");
        int count = 0;
        ArrayList<String> params = new ArrayList<>();
        // 是否在双引号里
        boolean inQuotation = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<parts.length; i++){
            if(parts[i].startsWith("\"")){
                if(parts[i].endsWith("\"")){
                    params.add(parts[i].substring(1, parts[i].length()-1));
                    count++;
                }else{
                    inQuotation = true;
                    sb = new StringBuilder();
                    sb.append(parts[i]);
                }
            }else if(parts[i].endsWith("\"")){
                inQuotation = false;
                sb.append(" ");
                sb.append(parts[i]);
                String param = sb.substring(1, sb.toString().length()-1);
                params.add(param);
                count++;
            }else{
                if(inQuotation){
                    sb.append(" ");
                    sb.append(parts[i]);
                }else{
                    params.add(parts[i]);
                    count++;
                }
            }
        }

        System.out.println(count);
        for(String param: params){
            System.out.println(param);
        }
    }


    /**
     * 正则
     * @param in
     */
    private static void solution3(Scanner in){
        String command = in.nextLine();

        // .*?非贪婪模式(懒惰模式), 即匹配尽可能少的字符 -> ".*?"匹配最短的 以字符"开始且以字符"结束的字符串
        String regex = "\".*?\"";
        // 占位符####
        String replaceStr = "####";

        // 将命令行字符串command中双引号参数"x...x" 替换为 "####"
        String[] params = command.replaceAll(regex, replaceStr).split("\\s");
        Matcher matcher = Pattern.compile(regex).matcher(command);

        // 依次找出命令行字符串command中未替换前的第i个真实双引号参数"x...x"以替换数组params中的第i个占位符####
        while(matcher.find()) {
            // 找到未替换前的真实双引号参数"x...x" 且去掉双引号
            String realParam = matcher.group().replaceAll("\"", "");
            for(int i=0; i<params.length; i++) {
                // 找到占位符####
                if(replaceStr.equals(params[i])) {
                    // 占位符####替换为去掉双引号的真实参数
                    params[i] = realParam;
                    break;
                }
            }
        }

        System.out.println(params.length);
        for(String str : params) {
            System.out.println(str);
        }
    }
}