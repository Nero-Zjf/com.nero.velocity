package com.nero.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.*;

/**
 * 演示生成模板
 */
public class VelocityTest {
    public static void main(String[] args) throws IOException {
        VelocityEngine ve = new VelocityEngine();

        ve.setProperty(org.apache.velocity.runtime.RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        // 初始化
        ve.init();

        //加载模板，设定模板编码
        Template template = ve.getTemplate("vm/domain.java.vm","utf-8");
        //设置初始化数据
        VelocityContext ctx = new VelocityContext();
        ctx.put("package", "com.nero.velocity");
        ctx.put("className", "Test");
        ctx.put("Object", "nero");

        PrintWriter pw = new PrintWriter("src/main/java/com/nero/velocity/TestDomain.java");
        //将模板转化输出
        template.merge(ctx, pw);
        pw.close();
    }
}
