package com.example.prog4.service.utils;

import com.example.prog4.config.CompanyConf;
import com.example.prog4.model.Employee;
import com.example.prog4.model.exception.InternalServerErrorException;
import com.lowagie.text.DocumentException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

public class PdfUtils {
    private static String parseThymeleafTemplate(Employee employee) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/pdf/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("employee", employee);
        context.setVariable("companyConf", new CompanyConf());

        return templateEngine.process("employee_form", context);
    }

    public static byte[] generatePdfFromHtml(Employee employee) {
        String html = parseThymeleafTemplate(employee);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();

        try {
            renderer.createPDF(outputStream);
        } catch (DocumentException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        return outputStream.toByteArray();
    }
}
