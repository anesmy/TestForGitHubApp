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

    private String getIpAddressFromHeader(NativeWebRequest request) {
        for (String ipHeader : POSSIBLE_IP_HEADERS) {
            String[] headerValues = request.getHeaderValues(ipHeader);
            if (Objects.isNull(headerValues)) {
                continue;
            }
            String headerValue = Arrays.stream(headerValues)
                                        .filter(StringUtils::hasLength)
                                        .findFirst()
                                        .orElse("");

            if (! headerValue.isBlank()) {
                return headerValue;
            }
        }
        return "";
    }