package com.github.nightf0x2002.SISGESTAR2.service.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application.mail")
public class MailProperties {

    private String enderecoRemetente;
    private String nomeRemetente;

}
