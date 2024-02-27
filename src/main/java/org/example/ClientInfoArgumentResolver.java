package com.golfmore.morebox.server.config.api;

import com.golfmore.morebox.server.servicediscovery.api.dto.ClientInfo;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ClientInfoArgumentResolver implements HandlerMethodArgumentResolver {

    private static final List<String> POSSIBLE_IP_HEADERS = List.of(
            "X-Forwarded-For",
            "HTTP_FORWARDED",
            "HTTP_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_CLIENT_IP",
            "HTTP_VIA",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "REMOTE_ADDR"
    );

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(ClientInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String ipAddressFromHeader = getIpAddressFromHeader(webRequest);
        if (ipAddressFromHeader.contains(":")) {
            String[] ipAddressWithPort = ipAddressFromHeader.split(":");
            var ipAddress = ipAddressWithPort[0];
            var port = ipAddressWithPort[1];
            return new ClientInfo(ipAddress, Integer.valueOf(port));
        }
        return new ClientInfo(ipAddressFromHeader, 0);
    }

    private String getIpAddressFromHeader(NativeWebRequest request) {
        // TODO: get real Ip Address From Header
        return "ip address";
    }
}