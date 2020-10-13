package com.utstar.adhandler.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommonConfig {
    @Value("${adplace.staffid}")
    private Integer staffid;

    @Value("${adplace.token.expireTime}")
    private Integer expireTime;
}
