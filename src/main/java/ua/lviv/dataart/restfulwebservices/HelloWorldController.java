package ua.lviv.dataart.restfulwebservices;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final MessageSource messageSource;

    @GetMapping("/good-morning-internationalized")
    public String goodMorningInternationalized() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
        // We could also replace LocaleContextHolder.getLocale() with locale, taken from headers manually with
        // @RequestHeader("Accept-Language", required=false) Locale locale
    }
}
