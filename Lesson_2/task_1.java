package Lesson_2;


public class task_1 {
    public static void main(String[] args) {
        String dataString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        dataString = dataString.replace("{", "");
        dataString = dataString.replace("}", "");
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM students");
        Boolean isFirst = true;
        for (String element : dataString.split(",")) {
            String[] arrElement = element.split(":");
            if (arrElement.length == 2 && arrElement[1].indexOf("null") == -1) {
                if (isFirst) {
                    stringBuilder.append(" WHERE ");
                } else{
                    stringBuilder.append(" AND ");
                }

                stringBuilder
                .append(arrElement[0].trim().replace("\"", ""))
                .append("=")
                .append(arrElement[1].trim().replace("\"", ""));

                isFirst = false;
            }
        }
        
        System.out.println(stringBuilder.toString());
    }
}
