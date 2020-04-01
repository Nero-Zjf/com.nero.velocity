package com.nero.velocity;

/**
 * 测试使用工具类生成模板
 */
public class VelocityBuilderTest {
    public static void main(String[] args) {
        VelocityEngineBuilder.startWithDefault()
                .withTemplatePath(() -> "vm/domain.java.vm")
                .withContextBuild()
                .setKV("package", "com.example.lx.springbootdemo.Velocity")
                .setKV("className", "Test")
                .setKV("Object", "Value")
                .toFile("src/main/java/com/nero/velocity/TestDomain.java")
                .done();
    }
}

