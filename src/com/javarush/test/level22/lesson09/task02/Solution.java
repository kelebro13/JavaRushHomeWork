package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> pair : params.entrySet()){
            String key = pair.getKey();
            String value = pair.getValue();
            if(value != null)
            {
                sb.append(String.format("%s = '%s' and ", key, value));
            }
        }
        if(sb.length() != 0)
        {
            sb.replace(sb.length() - 5, sb.length(), "");
        }
        return sb;
    }

    public static void main(String[] args)
    {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Ivanov");
        params.put("country", null);
        params.put("city", "Kiev");
        params.put("age", null);

        System.out.println(getCondition(params).toString());
    }
}
