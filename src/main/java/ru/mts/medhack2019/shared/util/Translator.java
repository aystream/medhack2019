package ru.mts.medhack2019.shared.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Translator {

    private static ResourceBundleMessageSource source;

    @Autowired
    private Translator(ResourceBundleMessageSource source) {
        Translator.source = source;
    }

    public static String translate(String code) {
        return translate(code, (String[]) null);
    }

    public static String translate(String code, String... args) {
        Locale locale = Locale.US;
        return source.getMessage(code, args, locale);
    }
}