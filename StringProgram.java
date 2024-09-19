public class StringProgram {
    public static void main(String[] args) {
        
        String s = "Omkar is good boy";
        StringBuilder sb = new StringBuilder();

        String[] strArr = s.split(" ");

        for(int i = 0; i < strArr.length; i++){
          sb.append(strArr[i].substring(0, 1).toUpperCase());
          sb.append(strArr[i].substring(1));
          sb.append(" ");
        }

        System.out.println(sb);
    }
}
