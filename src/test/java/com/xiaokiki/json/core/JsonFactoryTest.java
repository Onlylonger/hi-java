package com.xiaokiki.json.core;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonFactoryTest {

    @Test
    void test() {
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
            assertEquals(1, writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
