package com.xiaokiki.json.core;

import java.io.StringReader;
import java.io.StringWriter;

public class JsonFactory {

    public JsonGenerator createGenerator(StringWriter writer) {
        return new JsonGenerator();
    }

    public JsonParser createParser(StringReader reader) {
        return new JsonParser();
    }

}
