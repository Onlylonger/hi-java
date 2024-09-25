# Json

这是个 JSON for Java 的练手项目.


使用 JsonGenerator 来序列化一个 Java 对象为 JSON 字符串：
```java
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonEncoding;

import java.io.StringWriter;

public class JacksonCoreExample {
    public static void main(String[] args) {
        try {
            // 创建 JsonFactory 实例
            JsonFactory factory = new JsonFactory();

            // 创建 StringWriter 用于接收 JSON 输出
            StringWriter writer = new StringWriter();

            // 创建 JsonGenerator 实例
            JsonGenerator generator = factory.createGenerator(writer);
            generator.useDefaultPrettyPrinter(); // 设置美化输出

            // 写入 JSON 数据
            generator.writeStartObject(); // 开始对象
            generator.writeStringField("name", "John Doe");
            generator.writeNumberField("age", 30);
            generator.writeEndObject(); // 结束对象

            generator.close(); // 关闭生成器

            // 输出 JSON 字符串
            System.out.println(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```


使用 JsonParser 来将 JSON 字符串解析成 Java 对象：

```java
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.StringReader;

public class JacksonCoreExample {
    public static void main(String[] args) {
        try {
            // 创建 JsonFactory 实例
            JsonFactory factory = new JsonFactory();

            // JSON 字符串
            String json = "{\"name\":\"John Doe\",\"age\":30}";

            // 创建 JsonParser 实例
            JsonParser parser = factory.createParser(new StringReader(json));

            // 循环读取 JSON 数据
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = parser.getCurrentName();
                parser.nextToken(); // 移动到字段值

                if ("name".equals(fieldName)) {
                    System.out.println("Name: " + parser.getValueAsString());
                } else if ("age".equals(fieldName)) {
                    System.out.println("Age: " + parser.getValueAsInt());
                }
            }

            parser.close(); // 关闭解析器
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```